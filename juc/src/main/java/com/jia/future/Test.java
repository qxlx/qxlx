package com.jia.future;

import org.springframework.util.StringUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jiabaobao
 * @date 2023/9/16 9:45 AM
 */
public class Test {

    public static final String YEAR = "YEAR";
    public static final String MONTH = "MONTH";
    public static final String DAY = "DAY";

    public static void main(String[] args) {
        String birthDateStr = "-1030492800";
        if (!StringUtils.isEmpty(birthDateStr)){
            Long birthDateMillis = Long.valueOf(birthDateStr);

            //数据库日期时间差
            birthDateMillis = birthDateMillis + 7*60*60;

            Map<String, Integer> element = getDateElement(getDate(birthDateMillis));

            Integer rYear = element.get(YEAR);
            Integer rMonth = element.get(MONTH);
            Integer rDay = element.get(DAY);
            System.out.println(rYear + " " + rMonth + " " + rDay);
        }
    }

    public static Date getDate(long millis){

        String str = millis + "";
        int length = str.length();
        System.out.println(length);
        if (str.length() <= 10) {
            return new Date(millis*1000);
        }else if (str.length() == 13) {
            return new Date(millis);
        } else {
            return new Date(millis);
        }
    }



    public static Map<String, Integer> getDateElement(Date date) {

        Map<String, Integer> result = new HashMap<>();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int year = calendar.get(Calendar.YEAR);
        result.put(YEAR, year);

        int month = calendar.get(Calendar.MONTH);
        result.put(MONTH, month + 1); //从0开始

        int day = calendar.get(Calendar.DATE);
        result.put(DAY, day);

        return result;
    }
}
