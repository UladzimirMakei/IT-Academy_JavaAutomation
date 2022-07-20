package com.it_academy.selenide.steps;

import com.it_academy.onliner.pageobject.OnlinerHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class MenuSteps {

    private final OnlinerHomePage ONLINER_HOME_PAGE = new OnlinerHomePage();

    @Given("the user opens Onliner website")
    @BeforeEach
    public void navigateToOnliner() {
        open("https:www.onliner.by");
    }

    @When("the user hovers over {string} section")
    public void userHoversToHeaderLinkSection(String string) {
        ONLINER_HOME_PAGE
                .hoverOnHeaderLink(string);
    }

    @Then("\"Автобарахолка\" drop-down menu is displayed")
    public void userHoveredAutomarketMenuIsDisplayed() {
        ONLINER_HOME_PAGE
                .isCarMarketDropdownMenuDisplayed();
    }

    @Then("\"Дома и квартиры\" drop-down menu is displayed")
    public void userHoveredHouseAndFlatMenuIsDisplayed() {
        ONLINER_HOME_PAGE
                .isHouseAndFlatDropdownMenuDisplayed();
    }

    @And("\"Автобарахолка\" drop-down menu contains {string} data")
    public void userHoveredCarMarketLinkContainsData(String string) {
        ONLINER_HOME_PAGE
                .hoverOnHeaderLink("Автобарахолка")
                .getListOfAutoMarketDropdownItems(string);
    }

    @And("\"Дома и квартиры\" drop-down menu contains {string} data")
    public void userHoveredHouseAndFlatLinkContainsData(String string) {
         ONLINER_HOME_PAGE
                .hoverOnHeaderLink("Дома и квартиры")
                .getListOfHouseAndFlatDropdownItems(string);
    }
}
