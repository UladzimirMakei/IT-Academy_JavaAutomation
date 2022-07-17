package com.it_academy.selenium.Tests;

import com.it_academy.onliner.pageobject.OnlinerHomePage;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OnlinerAccessoriesSectionTest extends BaseTest {
    private final OnlinerHomePage ONLINER_HOME_PAGE = new OnlinerHomePage();

    @Test
    public void testAccessorySectionHasCorrectNumberOfObjectsAndAllHaveTitles() {
        List<String> AccessoriesTitles = ONLINER_HOME_PAGE
                .clickOnHeaderLink("Каталог")
                .clickOnCatalogSectionLink("Компьютеры и\u00a0сети")
                .clickOnAccessoriesSectionLink()
                .getAccessoryItemsNames();
        assertThat(AccessoriesTitles.size()).as("").isEqualTo(NUMBER_OF_ACCESSORY_OBJECTS);
        assertThat(AccessoriesTitles.stream().allMatch(Objects::nonNull))
                .as("Product title is not displayed").isTrue();
    }

    @Test
    public void testAccessorySectionHasCorrectNumberOfObjects() {
        List<String> AccessoriesTitles = ONLINER_HOME_PAGE
                .clickOnHeaderLink("Каталог")
                .clickOnCatalogSectionLink("Компьютеры и\u00a0сети")
                .clickOnAccessoriesSectionLink()
                .getAccessoryItemsNames();
        assertThat(AccessoriesTitles.stream().allMatch(Objects::nonNull))
                .as("Product title is not displayed").isTrue();
        assertThat(AccessoriesTitles.stream().
                anyMatch(t -> t.contains("Видеокарты"))).withFailMessage("").isTrue();
    }

    @Test
    public void testAccessorySectionObjectsHaveAmountAndPrices() {
        List<String> AccessoriesSectionPriceAndNumberList = ONLINER_HOME_PAGE
                .clickOnHeaderLink("Каталог")
                .clickOnCatalogSectionLink("Компьютеры и\u00a0сети")
                .clickOnAccessoriesSectionLink()
                .getAccessoryNumberAndPrices();
        System.out.println(AccessoriesSectionPriceAndNumberList);
        assertThat(AccessoriesSectionPriceAndNumberList.stream().
                allMatch(t -> t.contains("товар"))).withFailMessage("").isTrue();
        assertThat(AccessoriesSectionPriceAndNumberList.stream().
                allMatch(t -> t.contains("от"))).withFailMessage("").isTrue();
        assertThat(AccessoriesSectionPriceAndNumberList.stream().
                allMatch(t -> t.contains("р."))).withFailMessage("").isTrue();
    }
}
