package com.it_academy.onliner.pageobject;

import com.it_academy.onliner.framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OnlinerHomePage extends BasePage {
    private static final String MAIN_NAVIGATION_ONLINER_HEADER_LINK =
            "//*[contains(@class, 'main-navigation__text') and contains(text(), '%s')]";

    public CatalogPage clickOnHeaderLink(String link) {
        WebElement element = driver.findElement(By.xpath(String.format(MAIN_NAVIGATION_ONLINER_HEADER_LINK, link)));
        element.click();
        return new CatalogPage();
    }
}
