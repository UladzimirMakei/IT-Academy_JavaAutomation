package com.it_academy.selenium.Tests;

import org.junit.jupiter.api.Test;
import java.util.Objects;

import static com.it_academy.onliner.pageobject.CatalogPage.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OnlinerAccessoriesSectionTest extends BaseTest {


    @Test
    public void testComponentsSectionTitleAndDescriptionIsVisible() {
        List <String>  = onlinerHomePage
                .clickOnHeaderLink("Каталог")
                .clickOnCatalogSectionLink("Компьютеры и\u00a0сети")
                .getProductTitles();
        softAssertions.assertThat(productTitles)
                .as("Product title is not displayed")
                .isNotEmpty();
        Collection<String> productDescriptions = catalogPage.getProductDescriptions();
        AssertionsForInterfaceTypes.assertThat(productDescriptions)
                .as("Product description is not displayed")
                .isNotEmpty();
    }
    /*@Test
    public void testNumberOfElementsAccessorySectionIsCorrect() {
        assertThat(AccessoriesObjectNameList.size()).
                withFailMessage("Onliner Accessory section contains incorrect number of objects")
                .isEqualTo(NUMBER_OF_ACCESSORY_OBJECTS);
    }

    @Test
    public void testNameOfElementsAccessorySectionIsNotNull() {
        assertThat(AccessoriesSectionElementsList.stream().allMatch(Objects::nonNull)).
                withFailMessage("Onliner Accessory section all elements name is not Null").isTrue();
    }

    @Test
    public void testPriceAndNumberOfElementsAccessorySectionIsNotNull() {
        assertThat(AccessoriesSectionPricesAndNumberOfElementsList.stream().allMatch(Objects::nonNull)).
                withFailMessage("Onliner Accessory section all elements prices and numbers of objects is not Null")
                .isTrue();
    }

    @Test
    public void testAccessoriesObjectsContainsSpecificInfo() {
        assertThat(AccessoriesSectionElementsList.stream().map(AccessoryObject::getObjectInfo).
                anyMatch(t -> t.contains("Видеокарты"))).withFailMessage("").isTrue();
        assertThat(AccessoriesSectionElementsList.stream().map(AccessoryObject::getObjectInfo).
                allMatch(t -> t.contains("товар"))).withFailMessage("").isTrue();
        assertThat(AccessoriesSectionElementsList.stream().map(AccessoryObject::getObjectInfo).
                allMatch(t -> t.contains("от"))).withFailMessage("").isTrue();
        assertThat(AccessoriesSectionElementsList.stream().map(AccessoryObject::getObjectInfo).
                allMatch(t -> t.contains("р."))).withFailMessage("").isTrue();
    }*/
}
