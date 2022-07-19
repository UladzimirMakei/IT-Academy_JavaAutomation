package com.it_academy.selenium.Tests;

import com.it_academy.onliner.pageobject.CatalogPage;
import com.it_academy.onliner.pageobject.OnlinerHomePage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OnlinerComputerAndNetworksSectionTest extends BaseTest {
    private final OnlinerHomePage ONLINER_HOME_PAGE = new OnlinerHomePage();
    private final CatalogPage CATALOG_PAGE = new CatalogPage();

    @Test
    public void testOnlinerCatalogContainsSpecificSection() {
        ONLINER_HOME_PAGE
                .clickOnHeaderLink("Каталог")
                .clickOnCatalogSectionLink("Компьютеры и\u00a0сети")
                .isCompAndNetSideMenuDisplayed();
    }

    @Test
    public void testOnlinerCatalogCompAndNetContainsSpecificSection() {
        List<String> onlinerCatalogCompAndNetElement = ONLINER_HOME_PAGE
                .clickOnHeaderLink("Каталог")
                .clickOnCatalogSectionLink("Компьютеры и\u00a0сети")
                .getComputerAndNetSideMenuItemsList();
        assertThat(onlinerCatalogCompAndNetElement
                .containsAll(CATALOG_PAGE.getComputersAndNetworkMenuItemsCollection()))
                .as("Onliner catalog 'Computers and Networks' does not contain required titles")
                .isTrue();
    }
}
