package com.example.expressions;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

public final class DateTimeUtils {
    private static final Locale LOCALE_EC = new Locale("es", "EC");

    private DateTimeUtils() {
    }

    public static ZonedDateTime nowInZone(Clock clock, ZoneId zone) {
        Instant now = Instant.now(clock);
        return ZonedDateTime.ofInstant(now, zone);
    }

    public static LocalDate localDate(ZonedDateTime dateTime) {
        return dateTime.toLocalDate();
    }

    public static LocalDate lastDayOfMonth(LocalDate date) {
        return date.with(TemporalAdjusters.lastDayOfMonth());
    }

    public static String formatDate(LocalDate date, ZoneId zone, String sqlPattern) {
        return format(date.atStartOfDay(zone), sqlPattern);
    }

    public static String formatDateTime(ZonedDateTime dateTime, String sqlPattern) {
        return format(dateTime, sqlPattern);
    }

    private static String format(ZonedDateTime dateTime, String sqlPattern) {
        String javaPattern = toJavaPattern(sqlPattern);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(javaPattern, LOCALE_EC);
        return formatter.format(dateTime);
    }

    private static String toJavaPattern(String sqlPattern) {
        String pattern = sqlPattern;
        pattern = pattern.replace("YYYY", "yyyy");
        pattern = pattern.replace("YY", "yy");
        pattern = pattern.replace("DD", "dd");
        pattern = pattern.replace("HHMM", "HHmm");
        return pattern;
    }
}
