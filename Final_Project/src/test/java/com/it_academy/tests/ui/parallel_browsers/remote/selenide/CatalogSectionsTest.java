package com.it_academy.tests.ui.parallel_browsers.remote.selenide;

import com.codeborne.selenide.junit5.SoftAssertsExtension;
import com.it_academy.tests.listeners.AllureListener;
import com.it_academy.onliner.pageobject.CatalogPage;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(AllureListener.class)
@ExtendWith(SoftAssertsExtension.class)
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
    @Step("Header in Catalog section contains specific titles")
    @Description("Check catalog header contains required sections")
    public void testOnlinerCatalogContainsSpecificSection() {
        catalogPage
                .verifyCatalogItemsListContainListOfTitles(getExpectedCatalogItemTitles());
    }

    @Test
    @Step("Header in Catalog section contains title 'Еда'")
    @Description("Check catalog header contains required 'Еда' section")
    public void testOnlinerCatalogContainsFoodSection() {
        catalogPage
                .verifyCatalogItemsListContainSpecificTitle("Еда");
    }
}