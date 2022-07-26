package com.it_academy.onliner.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class WebDriverDiscovery {

    private static ThreadLocal<RemoteWebDriver> remoteWebDriver =
            new ThreadLocal();

    public WebDriverDiscovery() {
        if (remoteWebDriver.get() == null) {
            startBrowser();
        }
    }

    private void startBrowser() {
        setWebDriver(new ChromeDriver());
    }

    private static void setWebDriver(RemoteWebDriver driver) {
        remoteWebDriver.set(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
    }

    public WebDriver getWebDriver() {
        return remoteWebDriver.get();
    }

}
