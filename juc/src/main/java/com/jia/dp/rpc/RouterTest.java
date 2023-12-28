package com.jia.dp.rpc;

/**
 * @author jiabaobao
 * @date 2023/12/25 10:21 PM
 */
public class RouterTest {

    public static void main(String[] args) {
        RouterTables.addRouter("api.order","192.1.1.1","8080","online");

        RouterTables.deleteRouterInfoByApiName("api.user");

        RouterTables.prinltnAllInfo();
    }

}
