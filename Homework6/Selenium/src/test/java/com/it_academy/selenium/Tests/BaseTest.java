package com.it_academy.selenium.Tests;

import com.it_academy.onliner.navigation.OnlinerNavigation;
import com.it_academy.onliner.pageobject.CatalogPage;
import com.it_academy.onliner.pageobject.OnlinerHomePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    private final static OnlinerHomePage ONLINER_HOME_PAGE = new OnlinerHomePage();
    protected final CatalogPage CATALOG_PAGE = new CatalogPage();

    @BeforeEach
    public void navigateToOnliner() {
        OnlinerNavigation.navigateToOnlinerHomePage();
    }

    @AfterAll
    public static void closeDriver() {
        ONLINER_HOME_PAGE.closeBrowser();
    }
}
