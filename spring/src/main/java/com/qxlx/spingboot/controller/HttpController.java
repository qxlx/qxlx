package com.qxlx.spingboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.http.client.fluent.Request;

/**
 * @author jiabaobao
 * @date 2023/12/2 3:59 PM
 */
@RestController
@RequestMapping("/clientreadtimeout")
@Slf4j
public class HttpController {

    private String getResponse(String url, int connectTimeout, int readTimeout) throws IOException {
        return Request.Get("http://localhost:8088/clientreadtimeout" + url)
                .connectTimeout(connectTimeout) //连接时间1S
                .socketTimeout(readTimeout)//读取时间2S
                .execute()
                .returnContent()
                .asString();
    }


    @GetMapping("/client")
    public String client() throws IOException {
        log.info("client1 called");
        //服务端5s超时，客户端读取超时2秒
        return getResponse("/server?timeout=20000", 1000, 15000);
    }

    @GetMapping("/server")
    public void server(@RequestParam("timeout") int timeout) throws InterruptedException {

        log.info("server called");
        TimeUnit.MILLISECONDS.sleep(timeout);
        log.info("Done");
    }
}
