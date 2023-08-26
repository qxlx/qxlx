package com.qxlx.behavioral.chain;

import java.util.Objects;

/**
 * @author jiabaobao
 * @date 2022/4/5 8:15 PM
 */
public class Leader {

    private Leader next;

    private String name;

    public void setNext(Leader next) {
        this.next = next;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void handle() {
        System.out.println(name+":->申请通过996");
        if (Objects.nonNull(next)) {
            next.handle();
        }
    }
}
