/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author YOUNES
 */
public class NumberConverter {

    public static int convertToLongAsInt(String integerInput) {
        return convertToLongAsInt(integerInput, 0, false);
    }

    public static int convertToLongAsInt(String integerInput, int size, boolean exact) {
        return convertToBigInteger(integerInput, size, exact) != null ? 1 : -1;
    }

    public static boolean convertToLongAsBool(String integerInput, int size, boolean exact) {
        return convertToBigInteger(integerInput, size, exact) != null;
    }

    public static int convertToDecimalAsInt12Dot3(String decimalInput) {
        return convertToDecimal12Dot3(decimalInput) != null ? 1 : -1;
    }

    public static boolean convertToDecimalAsBool12Dot3(String decimalInput) {
        return convertToDecimal12Dot3(decimalInput) != null;
    }

    private static BigDecimal convertToDecimal12Dot3(String decimalInput) {
        return convertToDecimal(decimalInput, 12, 3);
    }
    
     public static boolean convertToDecimalAsBool(String decimalInput) {
        return convertToDecimal(decimalInput) != null;
    }

    private static BigDecimal convertToDecimal(String decimalInput) {
        String regex = "[0-9]+([,.][0-9]{1,2})?";
        return convertToDecimalAbstract(decimalInput, regex);
    }

    private static BigDecimal convertToDecimal(String decimalInput, int beforeVirgule, int afterVirgule) {
        String regex = "[0-9]{1," + beforeVirgule + "}\\.?[0-9]{1," + afterVirgule + "}";
        return convertToDecimalAbstract(decimalInput, regex);
    }

    private static BigDecimal convertToDecimalAbstract(String decimalInput, String regex) {
        if (decimalInput == null || decimalInput.isEmpty()) {
            return null;
        }
        Matcher matcher = Pattern.compile(regex).matcher(decimalInput);
        if (matcher.matches()) {
            return new BigDecimal(decimalInput);
        }
        return null;
    }

    public static BigInteger convertToBigInteger(String integerInput, int size, boolean exact) {
        if (integerInput == null || integerInput.isEmpty()) {
            return null;
        }
        int start = (exact) ? size : 1;
        String mySize = size > 0 ? "{" + start + "," + size + "}" : "+";
        String regex = "^[0-9]" + mySize + "$";
        Matcher matcher = Pattern.compile(regex).matcher(integerInput);
        if (matcher.matches()) {
            return new BigInteger(integerInput);
        }
        return null;
    }
}
