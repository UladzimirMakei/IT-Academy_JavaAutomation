package com.it_academy.selenide;

import com.it_academy.onliner.pageobject.CatalogPage;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.*;

import java.util.List;

public class ComAndNetAccessoriesSectionTest extends BaseTest {
    private final CatalogPage catalogPage = new CatalogPage();
    private static final int NUMBER_OF_ACCESSORY_OBJECTS = 14;

    @BeforeEach
    public void navigateToAccessoriesSection() {
        catalogPage
                .clickOnCatalogSectionLink("Компьютеры и\u00a0сети")
                .clickOnAccessoriesSectionLink("Комплектующие");
    }

    @Test
    public void testAccessorySectionHasCorrectObjects() {
        List<String> AccessoriesTitles = catalogPage
                .getProductTitleFromAccessorySectionList();
        SoftAssertions softAssertions = new SoftAssertions();
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
        catalogPage
                .checkNumberOfDisplayedAccessoryObjects(NUMBER_OF_ACCESSORY_OBJECTS);
    }

    @Test
    public void testAccessorySectionHasCorrectNumberOfObjectsAndAllHaveTitles() {
        catalogPage
                .checkDisplayedAccessoryTitlesAreNotEmpty();
    }

    @Test
    public void testAccessorySectionObjectsHaveAmountAndPrices() {
        List<String> AccessoriesSectionPriceAndNumberList = catalogPage
                .getProductAmountAndPriceFromAccessorySectionList();
        SoftAssertions softAssertions = new SoftAssertions();
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
