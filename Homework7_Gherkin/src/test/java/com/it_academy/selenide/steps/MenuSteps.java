package com.it_academy.selenide.steps;

import com.it_academy.onliner.pageobject.OnlinerHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.BeforeEach;


import static com.codeborne.selenide.Selenide.open;

public class MenuSteps {

    private final OnlinerHomePage onlinerHomePage = new OnlinerHomePage();

    @Given("the user opens Onliner website")
    @BeforeEach
    public void navigateToOnliner() {
        open("https:www.onliner.by");
    }

    @When("the user hovers over {string} section")
    public void userHoversToHeaderLinkSection(String string) {
        onlinerHomePage
                .hoverOnHeaderLink(string);
    }

    @Then("\"Автобарахолка\" drop-down menu is displayed")
    public void userHoveredAutomarketMenuIsDisplayed() {
        onlinerHomePage
                .isCarMarketDropdownMenuDisplayed();
    }

    @Then("\"Дома и квартиры\" drop-down menu is displayed")
    public void userHoveredHouseAndFlatMenuIsDisplayed() {
        onlinerHomePage
                .isHouseAndFlatDropdownMenuDisplayed();
    }

    @Then("\"Автобарахолка\" drop-down menu contains {string} data")
    public void userHoveredCarMarketLinkContainsData(String string) {
        onlinerHomePage
                .hoverOnHeaderLink("Автобарахолка")
                .getListOfAutoMarketDropdownItems(string);
    }

    @Then("\"Дома и квартиры\" drop-down menu contains {string} data")
    public void userHoveredHouseAndFlatLinkContainsData(String string) {
        onlinerHomePage
                .hoverOnHeaderLink("Дома и квартиры")
                .getListOfHouseAndFlatDropdownItems(string);
    }
}
