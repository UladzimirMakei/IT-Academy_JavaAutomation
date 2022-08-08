package com.it_academy.tests.ui.parallel_browsers.remote.selenide;

import com.codeborne.selenide.junit5.SoftAssertsExtension;
import com.it_academy.tests.listeners.AllureListener;
import com.it_academy.onliner.pageobject.CatalogPage;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

@ExtendWith(AllureListener.class)
@ExtendWith(SoftAssertsExtension.class)
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
    @Step("Open Accessory section and verify that all products contain titles")
    @Description("Check all accessory section products contain titles")
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
    @Step("Open Accessory section and check that it contains required number of objects")
    @Description("Check accessory section contains required number of objects")
    public void testAccessorySectionHasCorrectNumberOfObjects() {
        catalogPage
                .checkNumberOfDisplayedAccessoryObjects(NUMBER_OF_ACCESSORY_OBJECTS);
    }

    @Test
    @Step("Open Accessory section and verify that all products contain amount and price description")
    @Description("Check all accessory section products contain amount and price description")
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
