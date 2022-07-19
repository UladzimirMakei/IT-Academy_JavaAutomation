package com.it_academy.onliner.pageobject;


import static com.codeborne.selenide.Selenide.$x;

public class OnlinerHomePage  {
    private static final String MAIN_NAVIGATION_ONLINER_HEADER_LINK =
            "//*[contains(@class, 'main-navigation__text') and contains(text(), '%s')]";

    public CatalogPage clickOnHeaderLink(String link) {
        $x(String.format(MAIN_NAVIGATION_ONLINER_HEADER_LINK, link)).click();
        return new CatalogPage();
    }
}
