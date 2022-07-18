package com.it_academy.onliner.framework;

import org.openqa.selenium.*;

public abstract class BasePage {

    public final WebDriver driver;
    public final WebDriverDiscovery webDriverDiscovery;

    public BasePage() {
        webDriverDiscovery = new WebDriverDiscovery();
        driver = webDriverDiscovery.getWebDriver();
    }

    public void navigate(String url) {
        driver.get(url);
    }

    public void closeBrowser() {
        driver.quit();
    }
}
