package com.it_academy.selenium.Tests;

import com.it_academy.onliner.navigation.OnlinerNavigation;
import com.it_academy.onliner.pageobject.CatalogPage;
import com.it_academy.onliner.pageobject.OnlinerHomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    protected final OnlinerHomePage onlinerHomePage = new OnlinerHomePage();
    protected final CatalogPage catalogPage = new CatalogPage();

    @BeforeEach
    public void navigateToOnliner() {
        OnlinerNavigation.navigateToOnlinerHomePage();
    }

    @AfterEach
    public void closeBrowser() {
        onlinerHomePage.closeBrowser();
    }
}
