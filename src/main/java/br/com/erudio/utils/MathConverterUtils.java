package br.com.erudio.utils;

import java.util.Objects;

public class MathConverterUtils {

    public static double convertNumber(String strNumber) {
        if (Objects.isNull(strNumber) || strNumber.isEmpty()) throw new IllegalArgumentException();
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    public static boolean isNumeric(String strNumber) {
        if (Objects.isNull(strNumber) || strNumber.isEmpty()) throw new IllegalArgumentException();
        String number = strNumber.replace(",", ".");
        return !number.matches("[-+]?[]0-9]*\\.?[0-9]+");
    }

}
