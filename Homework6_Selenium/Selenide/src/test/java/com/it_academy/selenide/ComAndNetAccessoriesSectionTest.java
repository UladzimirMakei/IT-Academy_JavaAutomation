package com.it_academy.selenide;

import com.it_academy.onliner.pageobject.OnlinerHomePage;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class ComAndNetAccessoriesSectionTest extends BaseTest {
    private final OnlinerHomePage onlinerHomePage = new OnlinerHomePage();
    private static final int NUMBER_OF_ACCESSORY_OBJECTS = 14;

    @Test
    public void testAccessorySectionHasCorrectObjects() {
        SoftAssertions softAssertions = new SoftAssertions();
        List<String> AccessoriesTitles = onlinerHomePage
                .clickOnHeaderLink("Каталог")
                .clickOnCatalogSectionLink("Компьютеры и\u00a0сети")
                .clickOnAccessoriesSectionLink("Комплектующие")
                .getProductTitleFromAccessorySectionList();
        softAssertions.assertThat(AccessoriesTitles)
                .as("Accessory products' titles are not displayed")
                .allMatch(t -> !t.isEmpty());
        softAssertions.assertThat(AccessoriesTitles)
                .as("Accessory products' titles contain 'Видеокарты' section")
                .anyMatch(t -> t.contains("Видеокарты"));
        softAssertions.assertAll();
    }

    @Test
    public void testAccessorySectionHasCorrectNumberOfObjects() {
        onlinerHomePage
                .clickOnHeaderLink("Каталог")
                .clickOnCatalogSectionLink("Компьютеры и\u00a0сети")
                .clickOnAccessoriesSectionLink("Комплектующие")
                .checkNumberOfDisplayedAccessoryObjects(NUMBER_OF_ACCESSORY_OBJECTS);
    }

    @Test
    public void testAccessorySectionHasCorrectNumberOfObjectsAndAllHaveTitles() {
        boolean isAccessoryProductsTitleNotEmpty = onlinerHomePage
                .clickOnHeaderLink("Каталог")
                .clickOnCatalogSectionLink("Компьютеры и\u00a0сети")
                .clickOnAccessoriesSectionLink("Комплектующие")
                .checkDisplayedAccessoryTitlesAreNotEmpty();
        assertThat(isAccessoryProductsTitleNotEmpty).as("Some of accessory products' titles are empty")
                .isTrue();
    }

    @Test
    public void testAccessorySectionObjectsHaveAmountAndPrices() {
        SoftAssertions softAssertions = new SoftAssertions();
        List<String> AccessoriesSectionPriceAndNumberList = onlinerHomePage
                .clickOnHeaderLink("Каталог")
                .clickOnCatalogSectionLink("Компьютеры и\u00a0сети")
                .clickOnAccessoriesSectionLink("Комплектующие")
                .getProductAmountAndPriceFromAccessorySectionList();
        softAssertions.assertThat(AccessoriesSectionPriceAndNumberList)
                .as("Accessory section does not have section amount of product")
                .allMatch(element -> element.contains("товар"));
        softAssertions.assertThat(AccessoriesSectionPriceAndNumberList)
                .as("Accessory section does not have section price")
                .allMatch(element -> element.contains("от"));
        softAssertions.assertThat(AccessoriesSectionPriceAndNumberList)
                .as("Accessory section does not have section price")
                .allMatch(element -> element.contains("р."));
        softAssertions.assertAll();
    }
}
