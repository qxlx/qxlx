package com.qxlx.behavioral.strategy;

/**
 * @author jiabaobao
 * @date 2022/4/20 10:58 PM
 */
public class XyxjFundsStrategy extends AbstractFundsStrategy{

    @Override
    public void fundLoan() {
        System.out.println("兴业银行放款了");
    }
}
