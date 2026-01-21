package com.example.expressions;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ExpressionTemplate {
    private static final Pattern TOKEN_PATTERN = Pattern.compile("\\$\\{([^}]+)}");

    private final List<Segment> segments;

    public ExpressionTemplate(String template) {
        this.segments = parse(template);
    }

    public String render(ExpressionContext context) {
        StringBuilder builder = new StringBuilder();
        for (Segment segment : segments) {
            segment.appendTo(builder, context);
        }
        return builder.toString();
    }

    private static List<Segment> parse(String template) {
        Matcher matcher = TOKEN_PATTERN.matcher(template);
        int lastIndex = 0;
        List<Segment> parsed = new java.util.ArrayList<>();
        while (matcher.find()) {
            if (matcher.start() > lastIndex) {
                parsed.add(new TextSegment(template.substring(lastIndex, matcher.start())));
            }
            String token = matcher.group(1);
            parsed.add(new TokenSegment(token));
            lastIndex = matcher.end();
        }
        if (lastIndex < template.length()) {
            parsed.add(new TextSegment(template.substring(lastIndex)));
        }
        return List.copyOf(parsed);
    }

    private interface Segment {
        void appendTo(StringBuilder builder, ExpressionContext context);
    }

    private static final class TextSegment implements Segment {
        private final String text;

        private TextSegment(String text) {
            this.text = text;
        }

        @Override
        public void appendTo(StringBuilder builder, ExpressionContext context) {
            builder.append(text);
        }
    }

    private static final class TokenSegment implements Segment {
        private final String token;

        private TokenSegment(String token) {
            this.token = token;
        }

        @Override
        public void appendTo(StringBuilder builder, ExpressionContext context) {
            builder.append(resolveToken(context, token));
        }
    }

    private static String resolveToken(ExpressionContext context, String token) {
        String[] parts = token.split(":");
        String type = parts[0];
        Map<String, String> args = parseArgs(parts);

        return switch (type) {
            case "date" -> resolveDate(context, args);
            case "time" -> resolveTime(context, args);
            case "id" -> resolveId(context, args);
            case "hourMarker" -> resolveHourMarker(context);
            case "roundedTimeMinus" -> resolveRoundedTimeMinus(context, args);
            case "roundedMinute" -> resolveRoundedMinute(context, args);
            default -> throw new IllegalArgumentException("Unknown token type: " + type);
        };
    }

    private static Map<String, String> parseArgs(String[] parts) {
        Map<String, String> args = new HashMap<>();
        for (int i = 1; i < parts.length; i++) {
            String part = parts[i];
            int idx = part.indexOf('=');
            if (idx > 0) {
                args.put(part.substring(0, idx), part.substring(idx + 1));
            }
        }
        return args;
    }

    private static String resolveDate(ExpressionContext context, Map<String, String> args) {
        String format = require(args, "format");
        int days = parseInt(args.get("days"));
        int months = parseInt(args.get("months"));
        int years = parseInt(args.get("years"));
        boolean startOfYear = Boolean.parseBoolean(args.getOrDefault("startOfYear", "false"));
        boolean lastDayOfMonth = Boolean.parseBoolean(args.getOrDefault("lastDayOfMonth", "false"));

        LocalDate date = context.today();
        if (startOfYear) {
            date = date.withDayOfYear(1);
        }
        date = date.plusYears(years).plusMonths(months).plusDays(days);
        if (lastDayOfMonth) {
            date = DateTimeUtils.lastDayOfMonth(date);
        }
        return DateTimeUtils.formatDate(date, context.zone(), format);
    }

    private static String resolveTime(ExpressionContext context, Map<String, String> args) {
        String format = require(args, "format");
        int minutes = parseInt(args.get("minutes"));
        int hours = parseInt(args.get("hours"));
        ZonedDateTime time = context.now().plusHours(hours).plusMinutes(minutes);
        return DateTimeUtils.formatDateTime(time, format);
    }

    private static String resolveId(ExpressionContext context, Map<String, String> args) {
        int index = Integer.parseInt(require(args, "idx"));
        String part = TextUtils.safeSplit(context.idIngesta(), "_", index);
        String pad = args.get("pad");
        if (pad != null) {
            return TextUtils.lpad(part, Integer.parseInt(pad), "0");
        }
        return part;
    }

    private static String resolveHourMarker(ExpressionContext context) {
        return context.now().getHour() < 12 ? "1" : "2";
    }

    private static String resolveRoundedTimeMinus(ExpressionContext context, Map<String, String> args) {
        int interval = Integer.parseInt(require(args, "interval"));
        String format = require(args, "format");
        long minus = Long.parseLong(require(args, "minus"));
        ZonedDateTime now = context.now();
        ZonedDateTime rounded = now.minusMinutes(now.getMinute() % interval);
        String base = DateTimeUtils.formatDateTime(rounded, format);
        long value = Long.parseLong(base) - minus;
        return String.valueOf(value);
    }

    private static String resolveRoundedMinute(ExpressionContext context, Map<String, String> args) {
        int interval = Integer.parseInt(require(args, "interval"));
        int pad = Integer.parseInt(require(args, "pad"));
        int rounded = (context.now().getMinute() / interval) * interval;
        return TextUtils.lpad(String.valueOf(rounded), pad, "0");
    }

    private static int parseInt(String value) {
        return value == null ? 0 : Integer.parseInt(value);
    }

    private static String require(Map<String, String> args, String key) {
        String value = args.get(key);
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Missing required template argument: " + key);
        }
        return value;
    }
}
