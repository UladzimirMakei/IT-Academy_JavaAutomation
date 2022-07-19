package com.it_academy.selenium.Tests;

import com.it_academy.onliner.pageobject.OnlinerHomePage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OnlinerHouseAndFlatTest extends BaseTest {
    private final OnlinerHomePage ONLINER_HOME_PAGE = new OnlinerHomePage();

    @Test
    public void testOnlinerHeaderHouseAndFlatDropdownSectionIsDisplayedWhenSelected() {
        ONLINER_HOME_PAGE
                .hoverOnHeaderLink("Дома и квартиры")
                .isHouseAndFlatDropdownMenuDisplayed();
    }

    @Test
    public void testOnlinerHeaderHouseAndFlatDropdownSectionContainsData() {
        List<String> onlinerHouseAndFlatItemList = ONLINER_HOME_PAGE
                .hoverOnHeaderLink("Дома и квартиры")
                .getListOfHouseAndFlatDropdownItems();
        assertThat(onlinerHouseAndFlatItemList.stream().
                anyMatch(t -> t.contains("Минск"))).as("").isTrue();
        assertThat(onlinerHouseAndFlatItemList.stream().
                anyMatch(t -> t.contains("1-комнатные"))).as("").isTrue();
        assertThat(onlinerHouseAndFlatItemList.stream().
                anyMatch(t -> t.contains("До"))).as("").isTrue();
        assertThat(onlinerHouseAndFlatItemList.stream().
                anyMatch(t -> t.contains("$"))).as("").isTrue();
    }
}
