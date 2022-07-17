package com.it_academy.onliner.framework;

import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class BasePage {

    protected static final Logger LOG = LoggerFactory.getLogger(BasePage.class);

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
        try {
            driver.quit();
        } catch (Exception e) {
            LOG.error("CLOSE BROWSER ERROR: {}", e.getMessage(), e);
        }
    }
}
