package com.it_academy.selenium.Tests;

import com.it_academy.onliner.pageobject.OnlinerHomePage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OnlinerComputerAndNetworksSectionTest extends BaseTest {
    private final OnlinerHomePage onlinerHomePage = new OnlinerHomePage();

    @Test
    public void testOnlinerCatalogContainsSpecificSection() {
        boolean isCompAndNetSideMenuDisplayed = onlinerHomePage
                .clickOnHeaderLink("Каталог")
                .clickOnCatalogSectionLink("Компьютеры и\u00a0сети")
                .isCompAndNetSideMenuDisplayed();
        assertThat(isCompAndNetSideMenuDisplayed)
                .as("Onliner 'Computers and Networks' side menu is not displayed")
                .isTrue();
    }

    @Test
    public void testOnlinerCatalogCompAndNetContainsSpecificSection() {
        List<String> onlinerCatalogCompAndNetElement = onlinerHomePage
                .clickOnHeaderLink("Каталог")
                .clickOnCatalogSectionLink("Компьютеры и\u00a0сети")
                .getComputerAndNetSideMenuItemsList();
        assertThat(onlinerCatalogCompAndNetElement
                .containsAll(CATALOG_PAGE.getComputersAndNetworkMenuItemsCollection()))
                .as("Onliner catalog 'Computers and Networks' does not contain required titles")
                .isTrue();
    }
}
