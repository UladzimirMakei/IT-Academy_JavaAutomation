package com.it_academy.onliner.pageobject;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.*;

public class CatalogPage {

    private static final String CATALOG_CLASSIFIER_LINK_XPATH_PATTERN =
            "//span[@class='catalog-navigation-classifier__item-title-wrapper'][contains(.,'%s')]";
    private static final String COMP_AND_NET_SIDE_MENU_LINK_XPATH_PATTERN =
            "//div[@class='catalog-navigation-list__aside-title'][contains(.,'%s')]";
    private static final String CATALOG_MENU_ITEM_TITLE =
            "//span[@class='catalog-navigation-classifier__item-title-wrapper']";
    private static final String CATALOG_COMP_AND_NET_SIDE_MENU_LINK =
            "//*[@class = 'catalog-navigation-list__category' and @data-id='2']"
                    + "//*[@class = 'catalog-navigation-list__aside-item']";

    private static final String CATALOG_ACCESSORY_TITLE_XPATH_LINK =
            "//div[@class='catalog-navigation-list__aside-title' and contains(text(),"
                    + " 'Комплектующие') and not (contains(text(), 'Комплектующие для'))]"
                    + "//following-sibling::div[@class='catalog-navigation-list__dropdown']"
                    + "//a//*[contains(@class, 'title')]";

    private static final String CATALOG_ACCESSORY_PRICES_NUM_XPATH_LINK =
            "//div[@class='catalog-navigation-list__aside-title' and contains(text(),"
                    + " 'Комплектующие') and not (contains(text(), 'Комплектующие для'))]"
                    + "//following-sibling::div[@class='catalog-navigation-list__dropdown']"
                    + "//a//*[contains(@class, 'description') and contains(text(), 'товар')]";


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

    private static List<String> computersAndNetworksMenuItems() {
        List<String> collection = new ArrayList<>();
        collection.add("Ноутбуки, компьютеры, мониторы");
        collection.add("Комплектующие");
        collection.add("Хранение данных");
        collection.add("Сетевое оборудование");
        return collection;
    }

    public Collection<String> getCatalogItemTitlesCollection() {
        return catalogItemTitles();
    }

    public Collection<String> getComputersAndNetworkMenuItemsCollection() {
        return computersAndNetworksMenuItems();
    }

    public ElementsCollection doesCatalogItemsListContainListOfTitles() {
        return $$x(CATALOG_MENU_ITEM_TITLE).
                shouldHave(containExactTextsCaseSensitive(catalogItemTitles()));
    }

    public ElementsCollection doesCatalogItemsListContainSpecificTitle(String string) {
        return $$x(CATALOG_MENU_ITEM_TITLE).
                shouldHave(containExactTextsCaseSensitive(string));
    }

    public ElementsCollection doesComputerAndNetSideMenuContainListOfTitles() {
        return $$x(CATALOG_COMP_AND_NET_SIDE_MENU_LINK).
                shouldHave(containExactTextsCaseSensitive(computersAndNetworksMenuItems()));
    }

    public List<String> getProductTitleFromAccessorySectionList() {
        return $$x(CATALOG_ACCESSORY_TITLE_XPATH_LINK).texts();
    }

    public ElementsCollection checkNumberOfDisplayedAccessoryObjects(int number) {
        return $$x(CATALOG_ACCESSORY_TITLE_XPATH_LINK).shouldHave(size(number));
    }

    public ElementsCollection checkDisplayedAccessoryTitlesAreNotEmpty() {
        return $$x(CATALOG_ACCESSORY_TITLE_XPATH_LINK).shouldBe(CollectionCondition.empty);
    }


    public List<String> getProductAmountAndPriceFromAccessorySectionList() {
        return $$x(CATALOG_ACCESSORY_PRICES_NUM_XPATH_LINK).texts();
    }

    public CatalogPage clickOnCatalogSectionLink(String link) {
        $x(String.format(CATALOG_CLASSIFIER_LINK_XPATH_PATTERN, link)).click();
        return new CatalogPage();
    }

    public CatalogPage clickOnAccessoriesSectionLink(String link) {
        $x(String.format(COMP_AND_NET_SIDE_MENU_LINK_XPATH_PATTERN, link)).click();
        return new CatalogPage();
    }

    public SelenideElement isCompAndNetSideMenuDisplayed() {
        return $x("//*[@id='container']/div/div/div/div/div[1]/div[4]/div/div[3]/div[1]/div").
                shouldBe(visible, ofSeconds(10));
    }
}
