package com.it_academy.selenium.Tests;

import org.junit.jupiter.api.*;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class OnlinerAccessoriesSectionTest extends BaseTest {
    private final static int NUMBER_OF_ACCESSORY_OBJECTS = 14;

    @Test
    public void testAccessorySectionHasCorrectNumberOfObjectsAndAllHaveTitles() {
        List<String> AccessoriesTitles = onlinerHomePage
                .clickOnHeaderLink("Каталог")
                .clickOnCatalogSectionLink("Компьютеры и\u00a0сети")
                .clickOnAccessoriesSectionLink("Комплектующие")
                .getProductTitleFromAccessorySectionList();
        assertThat(AccessoriesTitles.size()).
                as("Accessory section has invalid number of products").isEqualTo(NUMBER_OF_ACCESSORY_OBJECTS);
        assertThat(AccessoriesTitles)
                .as("Accessory products' titles are not displayed")
                .allMatch(t -> !t.isEmpty());
    }

    @Test
    public void testAccessorySectionHasCorrectNumberOfObjects() {
        List<String> AccessoriesTitles = onlinerHomePage
                .clickOnHeaderLink("Каталог")
                .clickOnCatalogSectionLink("Компьютеры и\u00a0сети")
                .clickOnAccessoriesSectionLink("Комплектующие")
                .getProductTitleFromAccessorySectionList();
        assertThat(AccessoriesTitles)
                .as("Accessory products' titles are not displayed")
                .allMatch(t -> !t.isEmpty());
        assertThat(AccessoriesTitles)
                .as("Accessory products' titles contain 'Видеокарты' section")
                .anyMatch(t -> t.contains("Видеокарты"));
    }

    @Test
    public void testAccessorySectionObjectsHaveAmountAndPrices() {
        List<String> AccessoriesSectionPriceAndNumberList = onlinerHomePage
                .clickOnHeaderLink("Каталог")
                .clickOnCatalogSectionLink("Компьютеры и\u00a0сети")
                .clickOnAccessoriesSectionLink("Комплектующие")
                .getProductAmountAndPriceFromAccessorySectionList();
        assertThat(AccessoriesSectionPriceAndNumberList)
                .as("Accessory section does not have section amount of product")
                .allMatch(t -> t.contains("товар"));
        assertThat(AccessoriesSectionPriceAndNumberList)
                .as("Accessory section does not have section price")
                .allMatch(t -> t.contains("от"));
        assertThat(AccessoriesSectionPriceAndNumberList)
                .as("Accessory section does not have section price")
                .allMatch(t -> t.contains("р."));
    }
}
