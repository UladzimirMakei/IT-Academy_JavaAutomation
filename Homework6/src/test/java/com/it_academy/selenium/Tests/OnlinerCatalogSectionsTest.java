package com.it_academy.selenium.Tests;

import com.it_academy.onliner.pageobject.CatalogPage;
import com.it_academy.onliner.pageobject.OnlinerHomePage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OnlinerCatalogSectionsTest extends BaseTest {
    private final OnlinerHomePage ONLINER_HOME_PAGE = new OnlinerHomePage();
    private final CatalogPage CATALOG_PAGE = new CatalogPage();

    @Test
    public void testOnlinerCatalogContainsSpecificSection() {
        List<String> onlinerCatalogElements = ONLINER_HOME_PAGE
                .clickOnHeaderLink("Каталог")
                .getCatalogItemTitle();
        System.out.println(onlinerCatalogElements);
        assertThat(onlinerCatalogElements
                .containsAll(CATALOG_PAGE.getCatalogItemTitlesCollection()))
                .as("Onliner catalog section does not contain required titles")
                .isTrue();
    }

    @Test
    public void testOnlinerCatalogContainsFoodSection() {
        List<String> onlinerCatalogElements = ONLINER_HOME_PAGE
                .clickOnHeaderLink("Каталог")
                .getCatalogItemTitle();
        assertThat(onlinerCatalogElements.contains("Eда"))
                .as("Onliner catalog section does not contain 'Еда'")
                .isFalse();
    }
}