package com.it_academy.selenium.Tests;

import com.it_academy.onliner.pageobject.OnlinerHomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class OnlinerAutoMarketTest extends BaseTest{

    private final OnlinerHomePage ONLINER_HOME_PAGE = new OnlinerHomePage();

    @BeforeEach
    public void navigateToOnliner() {
        open("https:www.onliner.by");
    }

    @Test
    public void testOnlinerHeaderAutomarketDropdownSectionIsDisplayedWhenSelected() {
        ONLINER_HOME_PAGE
                .hoverOnHeaderLink("Автобарахолка")
                .isAutoMarketDropdownMenuDisplayed();
    }

    @Test
    public void testOnlinerHeaderAutomarketDropdownSectionContainsData() {
        List<String> onlinerAutomarketItemList = ONLINER_HOME_PAGE
                .hoverOnHeaderLink("Автобарахолка")
                .getListOfAutoMarketDropdownItems();
        assertThat(onlinerAutomarketItemList.stream().
                anyMatch(t -> t.contains("Цена с НДС"))).as("").isTrue();
        assertThat(onlinerAutomarketItemList.stream().
                anyMatch(t -> t.contains("Минск"))).as("").isTrue();
        assertThat(onlinerAutomarketItemList.stream().
                anyMatch(t -> t.contains("Audi"))).as("").isTrue();
    }
}
