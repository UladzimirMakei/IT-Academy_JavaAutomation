package com.it_academy.onliner.pageobject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.*;
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

    private final ElementsCollection catalogAccessoryTitleLink =
            $$x("//div[@class='catalog-navigation-list__aside-title' and contains(text(),"
                    + " 'Комплектующие') and not (contains(text(), 'Комплектующие для'))]"
                    + "//following-sibling::div[@class='catalog-navigation-list__dropdown']"
                    + "//a//*[contains(@class, 'title')]");

    private final ElementsCollection catalogAccessoryPricesNumLink =
            $$x("//div[@class='catalog-navigation-list__aside-title' and contains(text(),"
                    + " 'Комплектующие') and not (contains(text(), 'Комплектующие для'))]"
                    + "//following-sibling::div[@class='catalog-navigation-list__dropdown']"
                    + "//a//*[contains(@class, 'description') and contains(text(), 'товар')]");

    public ElementsCollection verifyCatalogItemsListContainListOfTitles(List<String> collection) {
        return $$x(CATALOG_MENU_ITEM_TITLE).
                shouldHave(containExactTextsCaseSensitive(collection));
    }

    public ElementsCollection verifyCatalogItemsListContainSpecificTitle(String string) {
        return $$x(CATALOG_MENU_ITEM_TITLE).
                shouldHave(containExactTextsCaseSensitive(string));
    }

    public ElementsCollection verifyComputerAndNetSideMenuContainListOfTitles(List<String> collection) {
        return $$x(CATALOG_COMP_AND_NET_SIDE_MENU_LINK).
                shouldHave(containExactTextsCaseSensitive(collection));
    }

    public List<String> getProductTitleFromAccessorySectionList() {
        return catalogAccessoryTitleLink.texts();
    }

    public ElementsCollection checkNumberOfDisplayedAccessoryObjects(int number) {
        return catalogAccessoryTitleLink.shouldHave(size(number));
    }

    public ElementsCollection checkDisplayedAccessoryTitlesAreNotEmpty() {
        return catalogAccessoryTitleLink
                .should(noneMatch("", e -> e.getText().isEmpty()));
    }

    public List<String> getProductAmountAndPriceFromAccessorySectionList() {
        return catalogAccessoryPricesNumLink.texts();
    }

    public CatalogPage clickOnCatalogSectionLink(String link) {
        $x(format(CATALOG_CLASSIFIER_LINK_XPATH_PATTERN, link)).click();
        return new CatalogPage();
    }

    public CatalogPage clickOnAccessoriesSectionLink(String link) {
        $x(format(COMP_AND_NET_SIDE_MENU_LINK_XPATH_PATTERN, link)).click();
        return new CatalogPage();
    }

    public SelenideElement isCompAndNetSideMenuDisplayed(String link) {
        return $x(format(COMP_AND_NET_SIDE_MENU_LINK_XPATH_PATTERN, link)).
                shouldBe(visible, ofSeconds(15));
    }
}
