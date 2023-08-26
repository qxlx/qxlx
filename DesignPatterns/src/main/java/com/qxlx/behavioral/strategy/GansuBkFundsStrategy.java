package com.qxlx.behavioral.strategy;

/**
 * @author jiabaobao
 * @date 2022/4/20 10:57 PM
 */
public class GansuBkFundsStrategy extends AbstractFundsStrategy{

    @Override
    public void fundLoan() {
        System.out.println("甘肃银行放款了....");
    }
}
