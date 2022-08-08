package com.it_academy.onliner.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverFactoryStaticThreadRemote {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static CapabilityFactory capabilityFactory = new CapabilityFactory();

    public static synchronized void setDriver(String browser) {
        try {
            driver.set(new RemoteWebDriver(new URL("http://192.168.100.6:4444/"),
                    capabilityFactory.getCapabilities(browser)));
        } catch (MalformedURLException e) {
            System.out.println("Cannot create connection with remote server");
            e.printStackTrace();
        }
    }

    public static synchronized WebDriver getDriver() {
        return driver.get();
    }

    public static synchronized void closeDriver() {
        driver.get().close();
        driver.remove();
    }
}
