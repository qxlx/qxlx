package com.jia.dp.rpc;

import java.util.Objects;

/**
 * @author jiabaobao
 * @date 2023/12/25 10:20 PM
 */
public class Router {

    private String ip;
    private String port;
    private String isOnline;

    public Router(String ip, String port, String isOnline) {
        this.ip = ip;
        this.port = port;
        this.isOnline = isOnline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Router router = (Router) o;
        return Objects.equals(ip, router.ip) && Objects.equals(port, router.port) && Objects.equals(isOnline, router.isOnline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip, port, isOnline);
    }

    @Override
    public String toString() {
        return "Router{" +
                "ip='" + ip + '\'' +
                ", port='" + port + '\'' +
                ", isOnline='" + isOnline + '\'' +
                '}';
    }
}
