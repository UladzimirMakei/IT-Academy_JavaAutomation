package com.it_academy.onliner.pageobject;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class OnlinerHomePage {
    private static final String MAIN_NAVIGATION_ONLINER_HEADER_PATTERN =
            "//*[contains(@class, 'main-navigation__text') and contains(text(), '%s')]";
    private static final String MAIN_NAVIGATION_ONLINER_HEADER_AUTOMARKET_LINK =
            "//div[@class='b-main-navigation__dropdown-title'][contains(.,'Автобарахолка')]";
    private static final String MAIN_NAVIGATION_ONLINER_HEADER_AUTOMARKET_OBJECTS_LINK =
            "//li[contains(@class, 'b-main-navigation__dropdown-advert-item')]";
    private static final String MAIN_NAVIGATION_ONLINER_HEADER_HOUSE_FLAT_LINK =
            "//div[@class='b-main-navigation__dropdown-title'][contains(.,'Продажа')]";
    private static final String MAIN_NAVIGATION_ONLINER_HEADER_HOUSE_FLAT_OBJECTS_LINK =
            "//li[contains(@class, 'b-main-navigation__dropdown-advert-item')]";

    public OnlinerHomePage hoverOnHeaderLink(String link) {
        $x(String.format(MAIN_NAVIGATION_ONLINER_HEADER_PATTERN, link)).hover();
        return this;
    }

    public SelenideElement isAutoMarketDropdownMenuDisplayed() {
        return $x(MAIN_NAVIGATION_ONLINER_HEADER_AUTOMARKET_LINK).
                shouldBe(visible, Duration.ofSeconds(10));
    }

    public SelenideElement isHouseAndFlatDropdownMenuDisplayed() {
        return $x(MAIN_NAVIGATION_ONLINER_HEADER_HOUSE_FLAT_LINK).
                shouldBe(visible, Duration.ofSeconds(10));
    }

    public List<String> getListOfAutoMarketDropdownItems() {
        System.out.println($$x(MAIN_NAVIGATION_ONLINER_HEADER_AUTOMARKET_OBJECTS_LINK).
                texts());
        return $$x(MAIN_NAVIGATION_ONLINER_HEADER_AUTOMARKET_OBJECTS_LINK).
                texts();
    }

    public List<String> getListOfHouseAndFlatDropdownItems() {
        System.out.println($$x(MAIN_NAVIGATION_ONLINER_HEADER_HOUSE_FLAT_OBJECTS_LINK).
                texts());
        return $$x(MAIN_NAVIGATION_ONLINER_HEADER_HOUSE_FLAT_OBJECTS_LINK).
                texts();
    }
}
