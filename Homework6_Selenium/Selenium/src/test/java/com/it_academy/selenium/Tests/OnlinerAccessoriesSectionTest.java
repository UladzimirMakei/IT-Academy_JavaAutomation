package com.it_academy.selenium.Tests;

import com.it_academy.onliner.pageobject.OnlinerHomePage;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.*;
import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OnlinerAccessoriesSectionTest extends BaseTest {
    private final OnlinerHomePage onlinerHomePage = new OnlinerHomePage();
    private final int NUMBER_OF_ACCESSORY_OBJECTS = 14;
    private final SoftAssertions softAssertions = new SoftAssertions();

    @Test
    public void testAccessorySectionHasCorrectNumberOfObjectsAndAllHaveTitles() {
        List<String> AccessoriesTitles = onlinerHomePage
                .clickOnHeaderLink("Каталог")
                .clickOnCatalogSectionLink("Компьютеры и\u00a0сети")
                .clickOnAccessoriesSectionLink("Комплектующие")
                .getProductTitleFromAccessorySectionList();
        softAssertions.assertThat(AccessoriesTitles.size()).
                as("Accessory section has invalid number of products").isEqualTo(NUMBER_OF_ACCESSORY_OBJECTS);
        softAssertions.assertThat(AccessoriesTitles.stream().allMatch(Objects::nonNull))
                .as("Accessory products' titles are not displayed").isTrue();
        softAssertions.assertAll();
    }

    @Test
    public void testAccessorySectionHasCorrectNumberOfObjects() {
        List<String> AccessoriesTitles = onlinerHomePage
                .clickOnHeaderLink("Каталог")
                .clickOnCatalogSectionLink("Компьютеры и\u00a0сети")
                .clickOnAccessoriesSectionLink("Комплектующие")
                .getProductTitleFromAccessorySectionList();
        softAssertions.assertThat(AccessoriesTitles.stream().allMatch(Objects::nonNull))
                .as("Accessory products' titles are not displayed").isTrue();
        softAssertions.assertThat(AccessoriesTitles.stream().
                anyMatch(t -> t.contains("Видеокарты"))).withFailMessage("").isTrue();
        softAssertions.assertAll();
    }

    @Test
    public void testAccessorySectionObjectsHaveAmountAndPrices() {
        List<String> AccessoriesSectionPriceAndNumberList = onlinerHomePage
                .clickOnHeaderLink("Каталог")
                .clickOnCatalogSectionLink("Компьютеры и\u00a0сети")
                .clickOnAccessoriesSectionLink("Комплектующие")
                .getProductAmountAndPriceFromAccessorySectionList();
        softAssertions.assertThat(AccessoriesSectionPriceAndNumberList.stream().
                allMatch(t -> t.contains("товар"))).
                withFailMessage("Accessory section does not have section amount of product").isTrue();
        softAssertions.assertThat(AccessoriesSectionPriceAndNumberList.stream().
                allMatch(t -> t.contains("от"))).
                withFailMessage("Accessory section does not have section price").isTrue();
        softAssertions.assertThat(AccessoriesSectionPriceAndNumberList.stream().
                allMatch(t -> t.contains("р."))).
                withFailMessage("Accessory section does not have section price").isTrue();
        softAssertions.assertAll();
    }
}
