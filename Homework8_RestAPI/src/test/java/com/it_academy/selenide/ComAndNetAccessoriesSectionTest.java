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
    public void testAccessorySectionHasCorrectNumberOfObjectsAndAllHaveTitles() {
        List<String> AccessoriesTitles = onlinerHomePage
                .clickOnHeaderLink("Каталог")
                .clickOnCatalogSectionLink("Компьютеры и\u00a0сети")
                .clickOnAccessoriesSectionLink("Комплектующие")
                .getProductTitleFromAccessorySectionList();
        assertThat(AccessoriesTitles.stream().allMatch(Objects::nonNull))
                .as("Accessory products' titles are not displayed").isTrue();
    }

    @Test
    public void testAccessorySectionHasCorrectNumberOfObjectsAndAllHaveTitles1() {
        onlinerHomePage
                .clickOnHeaderLink("Каталог")
                .clickOnCatalogSectionLink("Компьютеры и\u00a0сети")
                .clickOnAccessoriesSectionLink("Комплектующие")
                .checkNumberOfDisplayedAccessoryObjects(NUMBER_OF_ACCESSORY_OBJECTS);
    }

    @Test
    public void testAccessorySectionHasCorrectNumberOfObjectsAndAllHaveTitles2() {
        boolean isAccessoryProductsTitleNotEmpty = onlinerHomePage
                .clickOnHeaderLink("Каталог")
                .clickOnCatalogSectionLink("Компьютеры и\u00a0сети")
                .clickOnAccessoriesSectionLink("Комплектующие")
                .checkDisplayedAccessoryTitlesAreNotEmpty();
        assertThat(isAccessoryProductsTitleNotEmpty).as("Some of accessory products' titles are empty")
                .isTrue();
    }


    @Test
    public void testAccessorySectionHasCorrectNumberOfObjects() {
        SoftAssertions softAssertions = new SoftAssertions();
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
        SoftAssertions softAssertions = new SoftAssertions();
        List<String> AccessoriesSectionPriceAndNumberList = onlinerHomePage
                .clickOnHeaderLink("Каталог")
                .clickOnCatalogSectionLink("Компьютеры и\u00a0сети")
                .clickOnAccessoriesSectionLink("Комплектующие")
                .getProductAmountAndPriceFromAccessorySectionList();
        softAssertions.assertThat((AccessoriesSectionPriceAndNumberList.stream().
                        allMatch(t -> t.contains("товар")))).
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
