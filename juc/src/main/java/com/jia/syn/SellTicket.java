package com.jia.syn;

/**
 * @author jiabaobao
 * @date 2023/8/26 8:04 PM
 */
public class SellTicket {

    private volatile int count = 100;

    private Object obj = new Object();

    public void sell () {
        synchronized (obj) {
            if (count > 0) {
                System.out.println(Thread.currentThread().getName()+" 卖出了"+count--);
            }
        }
    }

    public static void main(String[] args) {
        SellTicket sellTicket = new SellTicket();
        for (int i = 0; i < 100; i++) {
            new Thread(()-> {
                sellTicket.sell();
            },"thread"+i).start();
        }

    }

}
