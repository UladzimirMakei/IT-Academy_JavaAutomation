package com.it_academy.selenide;

import com.it_academy.onliner.pageobject.CatalogPage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
    public void testOnlinerCatalogContainsSpecificSection() {
        catalogPage
                .isCompAndNetSideMenuDisplayed("Комплектующие");
    }

    @Test
    public void testOnlinerCatalogCompAndNetContainsSpecificSection() {
        catalogPage
                .verifyComputerAndNetSideMenuContainListOfTitles(getExpectedCatalogItemTitles());
    }
}
