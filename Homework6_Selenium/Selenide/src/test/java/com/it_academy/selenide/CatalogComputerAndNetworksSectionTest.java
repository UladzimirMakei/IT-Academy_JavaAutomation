package com.it_academy.selenide;


import com.it_academy.onliner.pageobject.OnlinerHomePage;

import org.junit.jupiter.api.Test;

public class CatalogComputerAndNetworksSectionTest extends BaseTest{
    private final OnlinerHomePage onlinerHomePage = new OnlinerHomePage();

    @Test
    public void testOnlinerCatalogContainsSpecificSection() {
        onlinerHomePage
                .clickOnHeaderLink("Каталог")
                .clickOnCatalogSectionLink("Компьютеры и\u00a0сети")
                .isCompAndNetSideMenuDisplayed();
    }

    @Test
    public void testOnlinerCatalogCompAndNetContainsSpecificSection() {
        onlinerHomePage
                .clickOnHeaderLink("Каталог")
                .clickOnCatalogSectionLink("Компьютеры и\u00a0сети")
                .doesComputerAndNetSideMenuContainListOfTitles();
    }
}
