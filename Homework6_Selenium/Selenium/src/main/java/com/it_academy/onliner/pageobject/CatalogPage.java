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

    public List<String> getCatalogItemsList() {
        return getTextsFromWebElements(driver.findElements(By.xpath(CATALOG_MENU_ITEM_TITLE)));
    }

    public List<String> getComputerAndNetSideMenuItemsList() {
        return getTextsFromWebElements(driver.findElements(By.xpath(CATALOG_COMP_AND_NET_SIDE_MENU_LINK)));
    }

    public List<String> getProductTitleFromAccessorySectionList() {
        return getTextsFromWebElements(driver.findElements(
                By.xpath(CATALOG_ACCESSORY_TITLE_XPATH_LINK)));
    }

    public List<String> getProductAmountAndPriceFromAccessorySectionList() {
        return getTextsFromWebElements(driver.findElements(
                By.xpath(CATALOG_ACCESSORY_PRICES_NUM_XPATH_LINK)));
    }

    public List<String> getTextsFromWebElements(List<WebElement> elements) {
        return elements.stream().map(e -> e.getText()).collect(Collectors.toList());
    }

    public CatalogPage clickOnCatalogSectionLink(String link) {
        WebElement element = driver.findElement(By.xpath(String.format(CATALOG_CLASSIFIER_LINK_XPATH_PATTERN, link)));
        element.click();
        return new CatalogPage();
    }

    public CatalogPage clickOnAccessoriesSectionLink(String link) {
        WebElement element = driver.findElement
                (By.xpath(String.format(COMP_AND_NET_SIDE_MENU_LINK_XPATH_PATTERN, link)));
        element.click();
        return new CatalogPage();
    }

    public boolean isCompAndNetSideMenuDisplayed() {
        WebElement element = driver.findElement(
                By.xpath("//*[@id='container']/div/div/div/div/div[1]/div[4]/div/div[3]/div[1]/div"));
        return element.isDisplayed();
    }
}
