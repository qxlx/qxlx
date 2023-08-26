package com.qxlx.behavioral.template;

/**
 * @author jiabaobao
 * @date 2022/4/12 10:54 PM
 */
public class FileDownTest {

    public static void main(String[] args) {
        AbstractFileDown gansubkFileDown = new GansubkFileDown();
        gansubkFileDown.reconnlion();
        System.out.println();

        AbstractFileDown xyxjFileDown = new XyxjFileDown();
        xyxjFileDown.reconnlion();
    }

}
