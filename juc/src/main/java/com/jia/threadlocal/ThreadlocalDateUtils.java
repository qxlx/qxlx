package com.jia.threadlocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author jiabaobao
 * @date 2023/8/27 9:52 AM
 */
public class ThreadlocalDateUtils {

    public static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");

    public static  Date parse(String stringDate) throws ParseException {
        return simpleDateFormat.parse(stringDate);
    }

    public static final ThreadLocal<SimpleDateFormat> threadLocalDate = ThreadLocal.withInitial(()-> new SimpleDateFormat("yyyy-mm-dd HH:mm:ss"));

    public static Date threadLocalParse (String date) throws ParseException {
        return threadLocalDate.get().parse(date);
    }

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss");

    public static String format(LocalDateTime localDateTime) {
        return DATE_TIME_FORMATTER.format(localDateTime);
    }

    public static LocalDateTime parse2(String dateString) {
        return LocalDateTime.parse(dateString,DATE_TIME_FORMATTER);
    }

    public static void main(String[] args) throws ParseException {

//        for (int i = 0; i < 3; i++) {
//            new Thread(()->{
//                Date parse = null;
//                try {
//                    parse = threadLocalParse("2021-12-12 12:12:12");
//                    System.out.println(parse);
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                } finally {
//                    threadLocalDate.remove();
//                }
//            }).start();
//        }

        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                //format(LocalDateTime.now());
                LocalDateTime parse = null;
                parse = parse2("2021-12-12 12:12:12");
                System.out.println(parse);

            }).start();
        }
    }
}
