package com.it_academy.selenide;

import com.it_academy.onliner.pageobject.OnlinerHomePage;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;
import static com.it_academy.onliner.pageobject.OnlinerHomePage.getOnlinerWebsite;

public class BaseTest {
    private final OnlinerHomePage onlinerHomePage = new OnlinerHomePage();

    @BeforeEach
    public void navigateToOnliner() {
        open(getOnlinerWebsite());
        onlinerHomePage
                .clickOnHeaderLink("Каталог");
    }
}
