package com.anotation;

import java.lang.annotation.*;

/**
 * @author qxlx
 * @date 2024/1/26 21:39
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RateLimit {

    public enum TimeUnit {SECOND,MINUTE,HOUR,DAY,MONTH}

    String apiName();

    int limitCount();

    TimeUnit timeUnit() default TimeUnit.SECOND;

}
