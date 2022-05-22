package ru.shelest.util;

import java.util.HashMap;
import java.util.Map;

import static ru.shelest.util.Checker.require;

public final class ArabicRomanNumberConverter {

    private static final Map<Integer, String> ARABIC_TO_ROMAN;
    private static final Map<String, Integer> ROMAN_TO_ARABIC;

    static {
        ARABIC_TO_ROMAN = new HashMap<>();

        ARABIC_TO_ROMAN.put(1, "I");
        ARABIC_TO_ROMAN.put(2, "II");
        ARABIC_TO_ROMAN.put(3, "III");
        ARABIC_TO_ROMAN.put(4, "IV");
        ARABIC_TO_ROMAN.put(5, "V");
        ARABIC_TO_ROMAN.put(6, "VI");
        ARABIC_TO_ROMAN.put(7, "VII");
        ARABIC_TO_ROMAN.put(8, "VIII");
        ARABIC_TO_ROMAN.put(9, "IX");
        ARABIC_TO_ROMAN.put(10, "X");
        ARABIC_TO_ROMAN.put(11, "XI");
        ARABIC_TO_ROMAN.put(12, "XII");
        ARABIC_TO_ROMAN.put(13, "XIII");
        ARABIC_TO_ROMAN.put(14, "XIV");
        ARABIC_TO_ROMAN.put(15, "XV");
        ARABIC_TO_ROMAN.put(16, "XVI");
        ARABIC_TO_ROMAN.put(17, "XVII");
        ARABIC_TO_ROMAN.put(18, "XVIII");
        ARABIC_TO_ROMAN.put(19, "XIX");
        ARABIC_TO_ROMAN.put(20, "XX");

        ROMAN_TO_ARABIC = new HashMap<>();

        ROMAN_TO_ARABIC.put("I", 1);
        ROMAN_TO_ARABIC.put("II", 2);
        ROMAN_TO_ARABIC.put("III", 3);
        ROMAN_TO_ARABIC.put("IV", 4);
        ROMAN_TO_ARABIC.put("V", 5);
        ROMAN_TO_ARABIC.put("VI", 6);
        ROMAN_TO_ARABIC.put("VII", 7);
        ROMAN_TO_ARABIC.put("VIII", 8);
        ROMAN_TO_ARABIC.put("IX", 9);
        ROMAN_TO_ARABIC.put("X", 10);
    }

    private ArabicRomanNumberConverter() {
    }

    public static int romanToArabic(String value) throws Exception {
        require(value != null, Exception::new);

        final Integer result = ROMAN_TO_ARABIC.get(value);

        if (result != null) {
            return result;
        }

        throw new Exception();
    }

    public static String arabicToRoman(int value) throws Exception {
        final String result = ARABIC_TO_ROMAN.get(value);

        if (result != null) {
            return result;
        }

        throw new Exception();
    }
}
