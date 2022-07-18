package com.it_academy.selenium.Tests;

import com.it_academy.onliner.navigation.OnlinerNavigation;
import com.it_academy.onliner.pageobject.CatalogPage;
import com.it_academy.onliner.pageobject.OnlinerHomePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    private final static OnlinerHomePage ONLINER_HOME_PAGE = new OnlinerHomePage();
    protected final CatalogPage CATALOG_PAGE = new CatalogPage();
    protected final int NUMBER_OF_ACCESSORY_OBJECTS = 14;
    protected static final String CATALOG_COMP_AND_NET_SIDE_MENU_LINK =
            "//*[@class = 'catalog-navigation-list__category' and @data-id='2']"
                    + "//*[@class = 'catalog-navigation-list__aside-item']";
    protected static final String CATALOG_MENU_ITEM_TITLE =
            "//span[@class='catalog-navigation-classifier__item-title-wrapper']";
    protected static final String CATALOG_ACCESSORY_TITLE_XPATH_LINK =
            "//div[@class='catalog-navigation-list__aside-title' and contains(text(),"
                    + " 'Комплектующие') and not (contains(text(), 'Комплектующие для'))]"
                    + "//following-sibling::div[@class='catalog-navigation-list__dropdown']"
                    + "//a//*[contains(@class, 'title')]";
    protected static final String CATALOG_ACCESSORY_PRICES_NUM_XPATH_LINK =
            "//div[@class='catalog-navigation-list__aside-title' and contains(text(),"
                    + " 'Комплектующие') and not (contains(text(), 'Комплектующие для'))]"
                    + "//following-sibling::div[@class='catalog-navigation-list__dropdown']"
                    + "//a//*[contains(@class, 'description') and contains(text(), 'товар')]";

    @BeforeEach
    public void navigateToOnliner() {
        OnlinerNavigation.navigateToOnlinerHomePage();
    }

    @AfterAll
    public static void closeDriver() {
        ONLINER_HOME_PAGE.closeBrowser();
    }
}
