package org.epde.tfm.utils;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Date;

@SuppressWarnings("unused")
public class TFMUtils {
    private static final ZoneId BD_ZONE_ID = ZoneId.of("Asia/Dhaka");
    public static final DateTimeFormatter DEFAULT_FORMATTER = DateTimeFormatter.ofPattern("dd MMMM, yyyy hh:mm:ss a");

    private TFMUtils() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * Convert Date to LocalDateTime in the BD time zone.
     */
    public static LocalDateTime toLocalDateTime(Date date) {
        return date.toInstant().atZone(BD_ZONE_ID).toLocalDateTime();
    }

    /**
     * Convert LocalDateTime to Date in BD time zone.
     */
    public static Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(BD_ZONE_ID).toInstant());
    }

    /**
     * Get current LocalDateTime in BD time zone.
     */
    public static LocalDateTime now() {
        return LocalDateTime.now(BD_ZONE_ID);
    }

    /**
     * Format LocalDateTime in BD time zone.
     */
    public static String formatDateToActualFormat(LocalDateTime localDateTime) {
        return localDateTime == null ? null : localDateTime.format(DEFAULT_FORMATTER);
    }

    /**
     * Format Date in BD time zone.
     */
    public static String formatDateBDTime(Date date) {
        return formatDateToActualFormat(toLocalDateTime(date));
    }

    /**
     * Capitalize the first letter of a string and convert the rest to lowercase.
     */
    public static String stringCapitalize(String text) {
        if (text == null || text.isEmpty()) return text;
        return Character.toUpperCase(text.charAt(0)) + text.substring(1).toLowerCase();
    }

    /**
     * Encode a string to Base64 using UTF-8 charset.
     */
    public static String encodeBase64(String input) {
        if (input == null) return null;
        return Base64.getEncoder().encodeToString(input.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Decode a Base64-encoded string using UTF-8 charset.
     */
    public static String decodeBase64(String encoded) {
        if (encoded == null) return null;
        byte[] decodedBytes = Base64.getDecoder().decode(encoded);
        return new String(decodedBytes, StandardCharsets.UTF_8);
    }
}
