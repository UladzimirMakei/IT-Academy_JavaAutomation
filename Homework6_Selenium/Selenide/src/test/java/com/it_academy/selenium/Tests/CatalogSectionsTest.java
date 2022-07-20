package com.it_academy.selenium.Tests;

import com.it_academy.onliner.pageobject.OnlinerHomePage;

import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class CatalogSectionsTest extends BaseTest {
    private final OnlinerHomePage ONLINER_HOME_PAGE = new OnlinerHomePage();

    @Test
    public void testOnlinerCatalogContainsSpecificSection() {
        ONLINER_HOME_PAGE
                .clickOnHeaderLink("Каталог")
                .doesCatalogItemsListContainListOfTitles();
    }

    @Test
    public void testOnlinerCatalogContainsFoodSection() {
        ONLINER_HOME_PAGE
                .clickOnHeaderLink("Каталог")
                .doesCatalogItemsListContainSpecificTitle("Еда");
    }
}