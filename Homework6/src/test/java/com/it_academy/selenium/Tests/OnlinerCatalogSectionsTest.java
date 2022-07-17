package com.it_academy.selenium.Tests;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OnlinerCatalogSectionsTest extends BaseTest {

    @Test
    public void testOnlinerCatalogContainsSpecificSection() {
        List<String> onlinerCatalogElements = onlinerHomePage
                .clickOnHeaderLink("Каталог")
                .getCatalogItemTitle();
        assertThat(onlinerCatalogElements
                .containsAll(catalogPage.getCatalogItemTitlesCollection()))
                .as("Onliner catalog section does not contain required titles")
                .isTrue();
    }
}