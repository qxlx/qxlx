package com.jia.dp.rpc;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author jiabaobao
 * @date 2023/12/25 10:22 PM
 */
public class RouterTables {

    private static HashMap<String,CopyOnWriteArraySet<Router>> cr = new HashMap<>();

    static {
        CopyOnWriteArraySet<Router> userApiRouters = new CopyOnWriteArraySet<>();
        userApiRouters.add(new Router("192.1.1.1","8080","online"));
        userApiRouters.add(new Router("192.1.1.2","8080","online"));
        userApiRouters.add(new Router("192.1.1.3","8080","faild"));

        CopyOnWriteArraySet<Router> accountApiRouters = new CopyOnWriteArraySet<>();
        accountApiRouters.add(new Router("192.1.1.1","8080","online"));
        accountApiRouters.add(new Router("192.1.1.2","8080","online"));
        accountApiRouters.add(new Router("192.1.1.3","8080","faild"));

        cr.put("api.user",userApiRouters);
        cr.put("api.account",accountApiRouters);
    }

    public static void addRouter(String apiServiceName,String ip,String port,String serverStatus) {
        if (!cr.containsKey(apiServiceName)) {
            CopyOnWriteArraySet<Router> accountApiRouters = new CopyOnWriteArraySet<>();
            accountApiRouters.add(new Router(ip,port,serverStatus));
            cr.put(apiServiceName,accountApiRouters);
        } else {
            CopyOnWriteArraySet<Router> routers = cr.get(apiServiceName);
            if (routers.contains(new Router(ip,port,serverStatus))) {
                return;
            } else {
                routers.add(new Router(ip,port,serverStatus));
            }
        }
    }

    public static Map<String,CopyOnWriteArraySet<Router>> findRouterInfoByApiName (String apiServiceName) {
        return (Map<String, CopyOnWriteArraySet<Router>>) cr.get(apiServiceName);
    }

    public static void deleteRouterInfoByApiName (String apiServiceName) {
        if (cr.containsKey(apiServiceName)) {
            cr.remove(apiServiceName);
        }
    }

    public static void prinltnAllInfo() {
        cr.forEach((s, routers) -> System.out.println(s +"\t"+ routers));
    }

}
