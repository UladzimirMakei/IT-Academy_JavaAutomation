package com.it_academy.onliner.pageobject;

import com.it_academy.onliner.framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CatalogPage extends BasePage {

    private static final String CATALOG_CLASSIFIER_LINK_XPATH_PATTERN =
            "//span[@class='catalog-navigation-classifier__item-title-wrapper'][contains(.,'%s')]";

    private static final String ACCESSORIES_XPATH_LINK =
            "//div[@class='catalog-navigation-list__aside-title'][contains(.,'Комплектующие')]";

    private static final String CATALOG_ACCESSORY_TITLE_XPATH_LINK =
            "//*[@id='container']/div/div/div/div/div[1]/div[4]/div/div[3]/div[1]/div/div[2]/div[2]/div/a/span/span[2]";

    private static final String CATALOG_ACCESSORY_PRICES_NUM_XPATH_LINK =
            "//*[@id='container']/div/div/div/div/div[1]/div[4]/div/div[3]/div[1]/div/div[2]/div[2]/div/a/span/span[3]";

    private static final String CATALOG_MENU_ITEM_TITLE =
            // "//li[contains(@class,  'catalog-navigation-classifier__item')]";
            "//*[@id='container']/div/div/div/div/div[1]/ul/li/span[2]";

    private static final String CATALOG_COMP_AND_NET_ITEM_TITLE =
            // "//li[contains(@class,  'catalog-navigation-classifier__item')]";
            "//*[@id='container']/div/div/div/div/div[1]/div[4]/div/div[3]/div[1]/div/div";

    private static Collection<String> catalogItemTitles() {
        Collection<String> collection = new ArrayList<>();
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

    private static Collection<String> computersAndNetworksMenuItems() {
        Collection<String> collection = new ArrayList<>();
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

    public List<String> getCatalogItemTitle() {
        return getTextsFromWebElements(driver.findElements(By.xpath(CATALOG_MENU_ITEM_TITLE)));
    }

    public List<String> getCompAndNetItemTitle() {
        return getTextsFromWebElements(driver.findElements(By.xpath(CATALOG_COMP_AND_NET_ITEM_TITLE)));
    }

    public List<String> getAccessoryItemsNames() {
        return getTextsFromWebElements(driver.findElements(By.xpath(CATALOG_ACCESSORY_TITLE_XPATH_LINK)));
    }

    public List<String> getAccessoryNumberAndPrices() {
        return getTextsFromWebElements(driver.findElements(By.xpath(CATALOG_ACCESSORY_PRICES_NUM_XPATH_LINK)));
    }

    public List<String> getTextsFromWebElements(List<WebElement> elements) {
        return elements.stream().map(e -> e.getText()).collect(Collectors.toList());
    }

    public CatalogPage clickOnCatalogSectionLink(String link) {
        WebElement element = driver.findElement(By.xpath(String.format(CATALOG_CLASSIFIER_LINK_XPATH_PATTERN, link)));
        element.click();
        return new CatalogPage();
    }

    public CatalogPage clickOnAccessoriesSectionLink() {
        WebElement element = driver.findElement(By.xpath(ACCESSORIES_XPATH_LINK));
        element.click();
        return new CatalogPage();
    }


    public boolean isCompAndNetSideMenuDisplayed() {
        WebElement element = driver.findElement(
                By.xpath("//*[@id='container']/div/div/div/div/div[1]/div[4]/div/div[3]/div[1]/div"));
        return element.isDisplayed();
    }

}
