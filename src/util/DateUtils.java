/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author
 */
public class DateUtils {

    private static String defaultPattern = "yyyy-MM-dd HH:mm:ss";

    public static String formateDate(Date date) {
        return formateDate(defaultPattern, date);
    }

    public static String formateDate(String pattern, Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        if (date != null) {
            return simpleDateFormat.format(date);
        } else {
            return "";
        }
    }

    public static Date parse(String date) {
        return parse(date, defaultPattern);
    }

    public static Date parse(String date, String pattern) {
        try {
            SimpleDateFormat simpleDateFormat;
            if (pattern == null) {
                simpleDateFormat = new SimpleDateFormat(defaultPattern);
            } else {
                simpleDateFormat = new SimpleDateFormat(pattern);
            }
            return simpleDateFormat.parse(date);
        } catch (ParseException ex) {
            return null;
        }
    }

}
