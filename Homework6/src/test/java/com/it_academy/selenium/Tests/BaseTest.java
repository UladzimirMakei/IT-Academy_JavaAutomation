package com.it_academy.selenium.Tests;

import com.it_academy.onliner.navigation.OnlinerNavigation;
import com.it_academy.onliner.pageobject.CatalogPage;
import com.it_academy.onliner.pageobject.OnlinerHomePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    private final OnlinerHomePage ONLINER_HOME_PAGE = new OnlinerHomePage();
    protected final int NUMBER_OF_ACCESSORY_OBJECTS = 14;

    @BeforeEach
    public void navigateToOnliner() {
        OnlinerNavigation.navigateToOnlinerHomePage();
    }

    @AfterEach
    public void closeBrowser() {
        ONLINER_HOME_PAGE.closeBrowser();
    }
}
