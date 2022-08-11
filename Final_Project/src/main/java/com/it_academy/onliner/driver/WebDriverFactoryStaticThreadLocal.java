package com.it_academy.onliner.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactoryStaticThreadLocal {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver(String browser) {
        switch (browser) {
            case ("firefox"): {
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
                break;
            }
            case ("edge"): {
                WebDriverManager.edgedriver().setup();
                driver.set(new EdgeDriver());
                break;
            }
            default: {
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
                break;
            }
        }
    }

    public static synchronized WebDriver getDriver() {
        return driver.get();
    }

    public static void closeDriver() {
        driver.get().close();
        driver.remove();
    }
}
