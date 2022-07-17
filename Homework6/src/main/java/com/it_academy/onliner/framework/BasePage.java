package com.it_academy.onliner.framework;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

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
