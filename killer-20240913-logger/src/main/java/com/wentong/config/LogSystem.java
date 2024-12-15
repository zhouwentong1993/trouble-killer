package com.wentong.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public enum LogSystem {

    HOST_A("admin.example1.com", "admin", "a", "admin_index", "0", "example1.com", "abc"),
    HOST_B("www.example1.com", "shop", "s", "shop_index", "0", "example1.com", "abc"),
    HOST_C("shop.example1.com", "shop", "s", "shop_index", "0", "example1.com", "abc"),
    HOST_D("agent.example1.com", "agent", "a", "agent_index", "0", "example1.com", "abc"),
    HOST_E("group.example1.com", "group", "g", "group_index", "0", "example1.com", "abc"),

    HOST_F("admin.example2.com", "admin", "a", "admin_index", "0", "example2.com", "abc"),
    HOST_G("shop.example2.com", "shop", "s", "shop_index", "0", "example2.com", "abc"),
    HOST_H("agent.example2.com", "agent", "a", "agent_index", "0", "example2.com", "abc"),
    HOST_I("group.example2.com", "group", "g", "group_index", "0", "example2.com", "abc"),

    HOST_J("admin.example3.com", "admin", "a", "admin_index", "0", "example3.com", "abc"),
    HOST_K("shop.example3.com", "shop", "s", "shop_index", "0", "example3.com", "abc"),
    HOST_L("agent.example3.com", "agent", "a", "agent_index", "0", "example3.com", "abc"),
    HOST_M("group.example3.com", "group", "g", "group_index", "0", "example3.com", "abc"),

    HOST_N("admin.example4.com", "admin", "a", "admin_index", "0", "example4.com", "abc"),
    HOST_O("shop.example4.com", "shop", "s", "shop_index", "0", "example4.com", "abc"),
    HOST_P("agent.example4.com", "agent", "a", "agent_index", "0", "example4.com", "abc"),
    HOST_Q("group.example4.com", "group", "g", "group_index", "0", "example4.com", "abc"),

    HOST_R("admin.example5.com", "admin", "a", "admin_index", "1", "example5.com", "xyz"),
    HOST_S("shop.example5.com", "shop", "s", "shop_index", "1", "example5.com", "xyz"),
    HOST_T("www.example5.com", "shop", "s", "shop_index", "1", "example5.com", "xyz"),
    HOST_U("agent.example5.com", "agent", "a", "agent_index", "1", "example5.com", "xyz"),
    HOST_V("group.example5.com", "group", "g", "group_index", "1", "example5.com", "xyz"),

    HOST_W("admin.example6.com", "admin", "a", "admin_index", "1", "example6.com", "xyz"),
    HOST_X("shop.example6.com", "shop", "s", "shop_index", "1", "example6.com", "xyz"),
    HOST_Y("www.example6.com", "shop", "s", "shop_index", "1", "example6.com", "xyz"),
    HOST_Z("agent.example6.com", "agent", "a", "agent_index", "1", "example6.com", "xyz"),
    HOST_AA("group.example6.com", "group", "g", "group_index", "1", "example6.com", "xyz"),

    HOST_AB("admin.example7.com", "admin", "a", "admin_index", "1", "example7.com", "xyz"),
    HOST_AC("shop.example7.com", "shop", "s", "shop_index", "1", "example7.com", "xyz"),
    HOST_AD("www.example7.com", "shop", "s", "shop_index", "1", "example7.com", "xyz"),
    HOST_AE("agent.example7.com", "agent", "a", "agent_index", "1", "example7.com", "xyz"),
    HOST_AF("group.example7.com", "group", "g", "group_index", "1", "example7.com", "xyz"),

    HOST_AG("shop.example8.com", "shop", "s", "shop_index", "2", "example8.com", "abc"),
    HOST_AH("www.example8.com", "shop", "s", "shop_index", "2", "example8.com", "abc"),
    HOST_AI("agent.example8.com", "agent", "a", "agent_index", "2", "example8.com", "abc"),
    HOST_AJ("group.example8.com", "group", "g", "group_index", "2", "example8.com", "abc"),

    HOST_AK("bookshop-api.example9.com", "shop", "s", "shop_index", "3", "example9.com", "abc"),
    HOST_AL("bookshop-web.example9.com", "shop", "s", "shop_index", "3", "example9.com", "abc"),
    HOST_AM("bookagent-web.example9.com", "agent", "a", "agent_index", "3", "example9.com", "abc"),
    HOST_AN("bookgroup-web.example9.com", "group", "g", "group_index", "3", "example9.com", "abc"),

    HOST_AO("www.example9.com", "shop", "s", "shop_index", "3", "example9.com", "abc"),
    HOST_AP("shop.example9.com", "shop", "s", "shop_index", "3", "example9.com", "abc"),
    HOST_AQ("agent.example9.com", "agent", "a", "agent_index", "3", "example9.com", "abc"),
    HOST_AR("group.example9.com", "group", "g", "group_index", "3", "example9.com", "abc");


    private static Logger logger = LoggerFactory.getLogger(LogSystem.class);
    private static final Map<String, LogSystem> host2Enum = new HashMap<String, LogSystem>();
    private static final Map<String, String> cookieDomain2Enum = new HashMap<String, String>();

    static {
        for (LogSystem logSystem : LogSystem.values()) {
            host2Enum.put(logSystem.getHost(), logSystem);
            cookieDomain2Enum.put(logSystem.getCookieDomain(), logSystem.getWebsite());
        }
    }

    private String host;
    private String system;
    private String tokenPrefix;
    private String loginPage;
    private String website;
    private String cookieDomain;
    private String service;

    private LogSystem(String host, String system, String tokenPrefix, String loginPage, String website, String cookieDomain, String service) {
        this.host = host;
        this.system = system;
        this.tokenPrefix = tokenPrefix;
        this.loginPage = loginPage;
        this.website = website;
        this.cookieDomain = cookieDomain;
        this.service = service;
    }

//    public static void main(String[] args) throws Exception {
////        testSingleThread();
//        testMultiThread();
//    }
//
//    private static void testMultiThread() throws InterruptedException {
//        long timeMillis = System.currentTimeMillis();
//        int threadCount = 100;
//        int cycleCount = 10000 / threadCount;
//        CountDownLatch latch = new CountDownLatch(threadCount);
//        for (int i = 0; i < threadCount; i++) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    for (int j = 0; j < cycleCount; j++) {
//
//                        getLogSystemFromHost("shop.loongpos.com.cn");
//                    }
//                    latch.countDown();
//                }
//            }).start();
//        }
//        latch.await();
//
//        System.out.println("cost:" + (System.currentTimeMillis() - timeMillis));
//    }
//
//    private static void testSingleThread() {
//        long timeMillis = System.currentTimeMillis();
//        for (int i = 0; i < 10000; i++) {
//            getLogSystemFromHost("shop.loongpos.com.cn");
//        }
//        System.out.println("cost:" + (System.currentTimeMillis() - timeMillis));
//    }


    public static LogSystem getLogSystemFromHost(String host) {
        LogSystem logSystem = null;

        for (String s : host2Enum.keySet()) {
            logger.info("请求host:{},枚举host:{},包含：{}", host, s, host.contains(s));
            if (host.contains(s)) {
                logSystem = host2Enum.get(s);
            }
        }

        if (logSystem == null) {
            throw new IllegalStateException("不是系统可以正确路由的host，host is " + host);
        }

        return logSystem;
    }

    public static final String getWebsiteFromHost(String host) {
        String website = null;
        for (String s : cookieDomain2Enum.keySet()) {
            if (host.contains(s)) {
                website = cookieDomain2Enum.get(s);
            }
        }
        if (website == null) {
            throw new IllegalStateException("不是系统可以正确匹配domain的host, host is" + host);
        }
        return website;
    }

    /*
    手机端请求地址一般为 login.dingdd.com 或 pre.login.dingdd.com ,这样的地址不能与LogSystem中的Host匹配,
    所以进行 system 和 requestHost 联合确定
    */
    public static final String getHostFromSystemAndRequestHost(String system, String requestHost) {
        String host = null;
        for (LogSystem ls : LogSystem.values()) {
            if (requestHost.contains(ls.getCookieDomain()) && ls.getSystem().equals(system)) {
                host = ls.getHost();
                break;
            }
        }
        if (host == null) {
            throw new IllegalStateException("无法确定请求所属的host，requestHost is " + requestHost + ",system is " + system);
        }
        return host;
    }

    public String getHost() {
        return host;
    }

    public String getSystem() {
        return system;
    }

    public String getTokenPrefix() {
        return tokenPrefix;
    }

    public String getLoginPage() {
        return loginPage;
    }

    public String getWebsite() {
        return website;
    }

    public String getCookieDomain() {
        return cookieDomain;
    }

    public String getService() {
        return service;
    }
}
