package com.it_academy.selenium.Tests;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OnlinerComputerAndNetworksSectionTest extends BaseTest {

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
                .getCompAndNetItemTitle();
        System.out.println(onlinerCatalogCompAndNetElement);
        assertThat(onlinerCatalogCompAndNetElement
                .containsAll(catalogPage.getComputersAndNetworkMenuItemsCollection()))
                .as("Onliner catalog 'Computers and Networks' do not contain required titles")
                .isTrue();
    }
}
