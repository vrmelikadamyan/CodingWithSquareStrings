package com.vadamyan;

public class CodingWithSquareStrings {

    public static void main(String[] args) {
        System.out.println(coding("I.was.going.fishing.that.morning.at.ten.o'clock"));
        System.out.println(decoding(coding("I.was.going.fishing.that.morning.at.ten.o'clock")));
    }

    public static String coding(String text) {
        int length = text.length();
        int n = (int) Math.ceil(Math.sqrt(length));

        StringBuilder result = new StringBuilder(text);
        while (result.length() < n * n) {
            result.append((char) 11);
        }

        return rot90Clock(result.toString(), n);
    }

    public static String rot90Clock(String text, int n) {
        StringBuilder result = new StringBuilder();
        for (int i = n; i > 0; --i) {
            for (int j = n; j > 0; --j) {
                result.append(text.charAt(j * n - i));
            }
            if (i > 1) result.append("\n");
        }

        return result.toString();
    }

    public static String decoding(String code) {
        String result = counterRot90Clock(code);

        return result.replaceAll(String.valueOf((char) 11), "");
    }

    public static String counterRot90Clock(String code) {
        int length = code.length();
        int n = (int) Math.sqrt(length);
        StringBuilder result = new StringBuilder();
        for (int i = n - 1; i >= 0; --i) {
            for (int j = 0; j < n; ++j) {
                result.append(code.charAt(i + j * (n + 1)));
            }
        }

        return result.toString();
    }
}
