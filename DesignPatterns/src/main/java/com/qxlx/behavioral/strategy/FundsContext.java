package com.qxlx.behavioral.strategy;

/**
 * @author jiabaobao
 * @date 2022/4/20 10:55 PM
 */
public class FundsContext {

    private AbstractFundsStrategy abstractFundsStrategy;

    public void setAbstractFundsStrategy(AbstractFundsStrategy abstractFundsStrategy) {
        this.abstractFundsStrategy = abstractFundsStrategy;
    }

    public void loan () {
        System.out.println("开始借款");

        abstractFundsStrategy.fundLoan();

        System.out.println("借款结束");
    }

}
