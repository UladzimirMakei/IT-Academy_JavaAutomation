package com.it_academy.tests.ui.selenide;

import com.codeborne.selenide.junit5.SoftAssertsExtension;
import com.it_academy.tests.listeners.AllureListener;
import com.it_academy.onliner.pageobject.CatalogPage;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(AllureListener.class)
@ExtendWith(SoftAssertsExtension.class)
public class CatalogComputerAndNetworksSectionTest extends BaseTest {
    private final CatalogPage catalogPage = new CatalogPage();

    private static List<String> computersAndNetworksMenuItems() {
        List<String> collection = new ArrayList<>();
        collection.add("Ноутбуки, компьютеры, мониторы");
        collection.add("Комплектующие");
        collection.add("Хранение данных");
        collection.add("Сетевое оборудование");
        return collection;
    }

    private List<String> getExpectedCatalogItemTitles() {
        return computersAndNetworksMenuItems();
    }

    @BeforeEach
    public void navigateToComputersAndNetwork() {
        catalogPage
                .clickOnCatalogSectionLink("Компьютеры и\u00a0сети");
    }

    @Test
    @Step("Catalog side-menu 'Computers and Networks' is diplayed when is section is clicked")
    @Description("Check catalog side-menu 'Computers and Networks' is visible when is clicked")
    public void testCatalogSideMenuComputersAndNetworksDisplayed() {
        catalogPage
                .isCompAndNetSideMenuDisplayed("Комплектующие");
    }

    @Test
    @Step("'Computers and Networks' in Catalog section contains specific titles")
    @Description("Check 'Computers and Networks' side-menu contains required sections")
    public void testOnlinerCatalogCompAndNetContainsSpecificSection() {
        catalogPage
                .verifyComputerAndNetSideMenuContainListOfTitles(getExpectedCatalogItemTitles());
    }
}
