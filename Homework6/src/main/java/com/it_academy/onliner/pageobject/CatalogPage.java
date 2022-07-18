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

    public List<String> getListOfItemsFromWebElementByXPath(String XPath) {
        return getTextsFromWebElements(driver.findElements(By.xpath(XPath)));
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
