package com.qa.utils;

public class GlobalParams {
    private static ThreadLocal<String> platformName = new ThreadLocal<>();
    private static ThreadLocal<String> browserName = new ThreadLocal<>();
    private static ThreadLocal<String> browserVersion = new ThreadLocal<>();
    private static ThreadLocal<String> baseUrl = new ThreadLocal<>();
    private static ThreadLocal<Integer> implicitWaitTimeout = new ThreadLocal<>();

    public void setPlatformName(String platformName1) {
        platformName.set(platformName1);
    }

    public String getPlatformName() {
        return platformName.get();
    }
    public String getDeviceName() {
        return platformName.get();
    }

    public String getBrowserName() {
        return browserName.get();
    }

    public void setBrowserName(String browserName1) {
        browserName.set(browserName1);
    }

    public String getBrowserVersion() {
        return browserVersion.get();
    }

    public void setBrowserVersion(String browserVersion1) {
        browserVersion.set(browserVersion1);
    }

    public String getBaseUrl() {
        return baseUrl.get();
    }

    public void setBaseUrl(String baseUrl1) {
        baseUrl.set(baseUrl1);
    }

    public Integer getImplicitWaitTimeout() {
        return implicitWaitTimeout.get();
    }

    public void setImplicitWaitTimeout(Integer timeout) {
        implicitWaitTimeout.set(timeout);
    }

    public void initializeGlobalParams() {
        GlobalParams params = new GlobalParams();
        params.setPlatformName(System.getProperty("platformName", "Web"));
        params.setBrowserName(System.getProperty("browserName", "chrome"));
        params.setBrowserVersion(System.getProperty("browserVersion", ""));
        params.setBaseUrl(System.getProperty("baseUrl", "https://www.example.com/"));
        params.setImplicitWaitTimeout(Integer.parseInt(System.getProperty("implicitWaitTimeout", "10")));
    }
}
