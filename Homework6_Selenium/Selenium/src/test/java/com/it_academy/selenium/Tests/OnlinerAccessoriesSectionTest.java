package com.it_academy.selenium.Tests;

import org.junit.jupiter.api.*;
import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
        assertThat(AccessoriesTitles.stream().allMatch(Objects::nonNull))
                .as("Accessory products' titles are not displayed").isTrue();
    }

    @Test
    public void testAccessorySectionHasCorrectNumberOfObjects() {
        List<String> AccessoriesTitles = onlinerHomePage
                .clickOnHeaderLink("Каталог")
                .clickOnCatalogSectionLink("Компьютеры и\u00a0сети")
                .clickOnAccessoriesSectionLink("Комплектующие")
                .getProductTitleFromAccessorySectionList();
        assertThat(AccessoriesTitles.stream().allMatch(Objects::nonNull))
                .as("Accessory products' titles are not displayed").isTrue();
        assertThat(AccessoriesTitles.stream().
                anyMatch(t -> t.contains("Видеокарты"))).withFailMessage("").isTrue();
    }

    @Test
    public void testAccessorySectionObjectsHaveAmountAndPrices() {
        List<String> AccessoriesSectionPriceAndNumberList = onlinerHomePage
                .clickOnHeaderLink("Каталог")
                .clickOnCatalogSectionLink("Компьютеры и\u00a0сети")
                .clickOnAccessoriesSectionLink("Комплектующие")
                .getProductAmountAndPriceFromAccessorySectionList();
        assertThat(AccessoriesSectionPriceAndNumberList.stream().
                allMatch(t -> t.contains("товар"))).
                withFailMessage("Accessory section does not have section amount of product").isTrue();
       assertThat(AccessoriesSectionPriceAndNumberList.stream().
                allMatch(t -> t.contains("от"))).
                withFailMessage("Accessory section does not have section price").isTrue();
        assertThat(AccessoriesSectionPriceAndNumberList.stream().
                allMatch(t -> t.contains("р."))).
                withFailMessage("Accessory section does not have section price").isTrue();
    }
}
