package com.anotation;

/**
 * @author qxlx
 * @date 2024/1/26 22:03
 */
public class UserController {

    @RateLimit(apiName = "/user/info",limitCount = 1000,
            timeUnit = RateLimit.TimeUnit.SECOND)
    public void getUserInfo() {

    }

}
