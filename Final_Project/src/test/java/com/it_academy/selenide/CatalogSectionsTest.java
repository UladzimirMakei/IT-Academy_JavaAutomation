package com.it_academy.selenide;

import com.it_academy.onliner.pageobject.CatalogPage;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CatalogSectionsTest extends BaseTest {
    private final CatalogPage catalogPage = new CatalogPage();

    private static List<String> catalogItemTitles() {
        List<String> collection = new ArrayList<>();
        collection.add("Электроника");
        collection.add("Компьютеры и сети");
        collection.add("Бытовая техника");
        collection.add("Стройка и ремонт");
        collection.add("Дом и сад");
        collection.add("Авто и мото");
        collection.add("Красота и спорт");
        collection.add("Детям и мамам");
        collection.add("Работа и офис");
        return collection;
    }

    private List<String> getExpectedCatalogItemTitles() {
        return catalogItemTitles();
    }

    @Test
    public void testOnlinerCatalogContainsSpecificSection() {
        catalogPage
                .verifyCatalogItemsListContainListOfTitles(getExpectedCatalogItemTitles());
    }

    @Test
    public void testOnlinerCatalogContainsFoodSection() {
        catalogPage
                .verifyCatalogItemsListContainSpecificTitle("Еда");
    }
}