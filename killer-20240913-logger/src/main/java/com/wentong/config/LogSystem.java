package com.wentong.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public enum LogSystem {

    ADMIN_HOST("admin.dingdd.com", "bookadmin", "b", "admin_ddd_index", "0", "dingdd.com", "ddd"),
    WWW_HOST("www.dingdd.com", "bookshop", "s", "shop_ddd_index", "0", "dingdd.com", "ddd"),
    SHOP_HOST("shop.dingdd.com", "bookshop", "s", "shop_ddd_index", "0", "dingdd.com", "ddd"),
    AGENT_HOST("agent.dingdd.com", "bookagent", "a", "agent_ddd_index", "0", "dingdd.com", "ddd"),
    GROUP_HOST("group.dingdd.com", "bookgroup", "g", "group_ddd_index", "0", "dingdd.com", "ddd"),


    TQL_ADMIN_HOST("admin-ddd.lingjuliwl.cn", "bookadmin", "b", "admin_ddd_index", "0", "lingjuliwl.cn", "ddd"),
    TQL_SHOP_HOST("shop-ddd.lingjuliwl.cn", "bookshop", "s", "shop_ddd_index", "0", "lingjuliwl.cn", "ddd"),
    TQL_AGENT_HOST("agent-ddd.lingjuliwl.cn", "bookagent", "a", "agent_ddd_index", "0", "lingjuliwl.cn", "ddd"),
    TQL_GROUP_HOST("group-ddd.lingjuliwl.cn", "bookgroup", "g", "group_ddd_index", "0", "lingjuliwl.cn", "ddd"),

    ADMIN_HOST_H("ddd-admin.hjiedan.com", "bookadmin", "b", "admin_ddd_index", "0", "hjiedan.com", "ddd"),
    SHOP_HOST_H("ddd-www.hjiedan.com", "bookshop", "s", "shop_ddd_index", "0", "hjiedan.com", "ddd"),
    AGENT_HOST_H("ddd-agent.hjiedan.com", "bookagent", "a", "agent_ddd_index", "0", "hjiedan.com", "ddd"),
    GROUP_HOST_H("ddd-group.hjiedan.com", "bookgroup", "g", "group_ddd_index", "0", "hjiedan.com", "ddd"),

    ADMIN_HOST_CN("admin.dingdd.cn", "bookadmin", "b", "admin_ddd_index", "0", "dingdd.cn", "ddd"),
    SHOP_HOST_CN("mendian.dingdd.cn", "bookshop", "s", "shop_ddd_index", "0", "dingdd.cn", "ddd"),
    WWW_HOST_CN("www.dingdd.cn", "bookshop", "s", "shop_ddd_index", "0", "dingdd.cn", "ddd"),
    AGENT_HOST_CN("daili.dingdd.cn", "bookagent", "a", "agent_ddd_index", "0", "dingdd.cn", "ddd"),
    GROUP_HOST_CN("jituan.dingdd.cn", "bookgroup", "g", "group_ddd_index", "0", "dingdd.cn", "ddd"),

    ADMIN_HOST_TEST("manage.ddd.canyin.com.cn", "bookadmin", "b", "admin_ddd_index", "0", "canyin.com.cn", "ddd"),
    SHOP_HOST_TEST("mendian.ddd.canyin.com.cn", "bookshop", "s", "shop_ddd_index", "0", "canyin.com.cn", "ddd"),
    AGENT_HOST_TEST("daili.ddd.canyin.com.cn", "bookagent", "a", "agent_ddd_index", "0", "canyin.com.cn", "ddd"),
    GROUP_HOST_TEST("jituan.ddd.canyin.com.cn", "bookgroup", "g", "group_ddd_index", "0", "canyin.com.cn", "ddd"),


    SSD_ADMIN_HOST("admin.sshangd.com", "bookadmin", "b", "admin_ddd_index", "1", "sshangd.com", "shishangd"),
    SSD_SHOP_HOST("shop.sshangd.com", "bookshop", "s", "shop_tc_index", "1", "sshangd.com", "shishangd"),
    SSD_WWW_HOST("www.sshangd.com", "bookshop", "s", "shop_tc_index", "1", "sshangd.com", "shishangd"),
    SSD_AGENT_HOST("agent.sshangd.com", "bookagent", "a", "agent_tc_index", "1", "sshangd.com", "shishangd"),
    SSD_GROUP_HOST("group.sshangd.com", "bookgroup", "g", "group_tc_index", "1", "sshangd.com", "shishangd"),


    SHISHANGD_ADMIN_HOST("admin.shishangd.com", "bookadmin", "b", "admin_ddd_index", "1", "shishangd.com", "shishangd"),
    SHISHANGD_SHOP_HOST("shop.shishangd.com", "bookshop", "s", "shop_tc_index", "1", "shishangd.com", "shishangd"),
    SHISHANGD_WWW_HOST("www.shishangd.com", "bookshop", "s", "shop_tc_index", "1", "shishangd.com", "shishangd"),
    SHISHANGD_AGENT_HOST("agent.shishangd.com", "bookagent", "a", "agent_tc_index", "1", "shishangd.com", "shishangd"),
    SHISHANGD_GROUP_HOST("group.shishangd.com", "bookgroup", "g", "group_tc_index", "1", "shishangd.com", "shishangd"),


    SSD_TEST_ADMIN_HOST("admin.loongpos.com.cn", "bookadmin", "b", "admin_ddd_index", "1", "loongpos.com.cn", "loongpos"),
    SSD_TEST_SHOP_HOST("shop.loongpos.com.cn", "bookshop", "s", "shop_tc_index", "1", "loongpos.com.cn", "loongpos"),
    SSD_TEST_WWW_HOST("www.loongpos.com.cn", "bookshop", "s", "shop_tc_index", "1", "loongpos.com.cn", "loongpos"),
    SSD_TEST_AGENT_HOST("agent.loongpos.com.cn", "bookagent", "a", "agent_tc_index", "1", "loongpos.com.cn", "loongpos"),
    SSD_TEST_GROUP_HOST("group.loongpos.com.cn", "bookgroup", "g", "group_tc_index", "1", "loongpos.com.cn", "loongpos"),


    ZCWYKD_SHOP_HOST("shop.zcwykd.com", "bookshop", "s", "shop_qde_index", "2", "zcwykd.com", "zcwykd"),
    ZCWYKD_WWW_HOST("www.zcwykd.com", "bookshop", "s", "shop_qde_index", "2", "zcwykd.com", "zcwykd"),
    ZCWYKD_AGENT_HOST("agent.zcwykd.com", "bookagent", "a", "agent_qde_index", "2", "zcwykd.com", "zcwykd"),
    ZCWYKD_GROUP_HOST("group.zcwykd.com", "bookgroup", "g", "group_qde_index", "2", "zcwykd.com", "zcwykd"),


    YX2_WWW_HOST_DOHKO("book3-shop-api-dingdd.dohko.yanxiao2.com", "bookshop", "s", "shop_yx2_index", "3", "dohko.yanxiao2.com", "yx2"),
    YX2_SHOP_HOST_DOHKO("book-shop-web-intest-dingdd.dohko.yanxiao2.com", "bookshop", "s", "shop_yx2_index", "3", "dohko.yanxiao2.com", "yx2"),
    YX2_AGENT_HOST_DOHKO("book-agent-web-intest-dingdd.dohko.yanxiao2.com", "bookagent", "a", "agent_yx2_index", "3", "dohko.yanxiao2.com", "yx2"),
    YX2_GROUP_HOST_DOHKO("book-group-web-intest-dingdd.dohko.yanxiao2.com", "bookgroup", "g", "group_yx2_index", "3", "dohko.yanxiao2.com", "yx2"),

    YX2_WWW_HOST("www.yanxiao2.com", "bookshop", "s", "shop_yx2_index", "3", "yanxiao2.com", "yx2"),
    YX2_SHOP_HOST("shop.yanxiao2.com", "bookshop", "s", "shop_yx2_index", "3", "yanxiao2.com", "yx2"),
    YX2_AGENT_HOST("agent.yanxiao2.com", "bookagent", "a", "agent_yx2_index", "3", "yanxiao2.com", "yx2"),
    YX2_GROUP_HOST("group.yanxiao2.com", "bookgroup", "g", "group_yx2_index", "3", "yanxiao2.com", "yx2");

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
    //系统识别  订多多: ddd ;天财: tiancai
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

    public static void main(String[] args) throws Exception {
//        testSingleThread();
        testMultiThread();
    }

    private static void testMultiThread() throws InterruptedException {
        long timeMillis = System.currentTimeMillis();
        int threadCount = 100;
        int cycleCount = 10000 / threadCount;
        CountDownLatch latch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < cycleCount; j++) {

                        getLogSystemFromHost("shop.loongpos.com.cn");
                    }
                    latch.countDown();
                }
            }).start();
        }
        latch.await();

        System.out.println("cost:" + (System.currentTimeMillis() - timeMillis));
    }

    private static void testSingleThread() {
        long timeMillis = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            getLogSystemFromHost("shop.loongpos.com.cn");
        }
        System.out.println("cost:" + (System.currentTimeMillis() - timeMillis));
    }


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
