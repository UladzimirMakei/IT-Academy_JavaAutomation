package com.it_academy.onliner.pageobject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.time.Duration.*;

public class OnlinerHomePage {
    private static final String MAIN_NAVIGATION_ONLINER_HEADER_PATTERN =
            "//*[contains(@class, 'main-navigation__text') and contains(text(), '%s')]";
    private static final String MAIN_NAVIGATION_ONLINER_HEADER_AUTOMARKET_LINK =
            "//div[@class='b-main-navigation__dropdown-title'][contains(.,'Автобарахолка')]";
    private static final String MAIN_NAVIGATION_ONLINER_HEADER_AUTOMARKET_OBJECTS_LINK =
            "//span[contains(@class, 'b-main-navigation__dropdown-advert-sign')]";
    private static final String MAIN_NAVIGATION_ONLINER_HEADER_HOUSE_FLAT_LINK =
            "//div[@class='b-main-navigation__dropdown-title'][contains(.,'Продажа')]";
    private static final String MAIN_NAVIGATION_ONLINER_HEADER_HOUSE_FLAT_OBJECTS_LINK =
            "//span[contains(@class, 'b-main-navigation__dropdown-advert-sign')]";

    public OnlinerHomePage hoverOnHeaderLink(String link) {
        $x(String.format(MAIN_NAVIGATION_ONLINER_HEADER_PATTERN, link)).hover();
        return this;
    }

    public SelenideElement isCarMarketDropdownMenuDisplayed() {
        return $x(MAIN_NAVIGATION_ONLINER_HEADER_AUTOMARKET_LINK).
                shouldBe(visible, ofSeconds(10));
    }

    public SelenideElement isHouseAndFlatDropdownMenuDisplayed() {
        return $x(MAIN_NAVIGATION_ONLINER_HEADER_HOUSE_FLAT_LINK).
                shouldBe(visible, ofSeconds(10));
    }

    public ElementsCollection getListOfAutoMarketDropdownItems(String string) {
        return $$x(MAIN_NAVIGATION_ONLINER_HEADER_AUTOMARKET_OBJECTS_LINK).
                shouldHave(containExactTextsCaseSensitive(string));
    }

    public ElementsCollection getListOfHouseAndFlatDropdownItems(String string) {
        return $$x(MAIN_NAVIGATION_ONLINER_HEADER_HOUSE_FLAT_OBJECTS_LINK).
                shouldHave(containExactTextsCaseSensitive(string));
    }
}
