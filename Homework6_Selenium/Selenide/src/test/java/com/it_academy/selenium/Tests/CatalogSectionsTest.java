package com.it_academy.selenium.Tests;

import com.it_academy.onliner.pageobject.OnlinerHomePage;

import org.junit.Test;


public class CatalogSectionsTest extends BaseTest {
    private final OnlinerHomePage onlinerHomePage = new OnlinerHomePage();

    @Test
    public void testOnlinerCatalogContainsSpecificSection() {
        onlinerHomePage
                .clickOnHeaderLink("Каталог")
                .doesCatalogItemsListContainListOfTitles();
    }

    @Test
    public void testOnlinerCatalogContainsFoodSection() {
        onlinerHomePage
                .clickOnHeaderLink("Каталог")
                .doesCatalogItemsListContainSpecificTitle("Еда");
    }
}