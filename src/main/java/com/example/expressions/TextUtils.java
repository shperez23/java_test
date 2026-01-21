package com.example.expressions;

public final class TextUtils {
    private TextUtils() {
    }

    public static String lpad(String value, int length, String padChar) {
        if (value == null) {
            value = "";
        }
        if (padChar == null || padChar.isEmpty()) {
            padChar = " ";
        }
        if (value.length() >= length) {
            return value;
        }
        StringBuilder builder = new StringBuilder();
        while (builder.length() + value.length() < length) {
            builder.append(padChar);
        }
        if (builder.length() + value.length() > length) {
            builder.setLength(length - value.length());
        }
        return builder.append(value).toString();
    }

    public static String safeSplit(String input, String delimiter, int index) {
        if (input == null) {
            return "";
        }
        String[] parts = input.split(delimiter, -1);
        if (index < 0 || index >= parts.length) {
            return "";
        }
        return parts[index];
    }
}
