package com.qxlx.creatation.singleton;

import java.util.Objects;

/**
 * @author jiabaobao
 * @date 2022/2/20 11:29 PM
 */
public class MacComputer {

    private String osName;

    private String computerName;

    private volatile static MacComputer instance;

    /**
     * 获取一个对象
     * @return
     */
    public static MacComputer getMac () {
        if (Objects.isNull(instance)) {
            synchronized (Objects.class) {
                if (Objects.isNull(instance)) {
                    instance = new MacComputer();
                }
            }
        }
        return instance;
    }

}
