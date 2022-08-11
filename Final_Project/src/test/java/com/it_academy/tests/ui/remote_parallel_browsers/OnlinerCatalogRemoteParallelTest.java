package com.it_academy.tests.ui.remote_parallel_browsers;

import com.it_academy.onliner.driver.WebDriverFactoryStaticThreadRemote;
import com.it_academy.onliner.pageobject.OnlinerHomePage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static com.it_academy.onliner.enums.OnlinerPageUrl.HOME_PAGE;

@Execution(ExecutionMode.CONCURRENT)

public class OnlinerCatalogRemoteParallelTest {
    private final OnlinerHomePage onlinerHomePage = new OnlinerHomePage();

    @Disabled
    @ParameterizedTest
    @CsvSource(value = {"chrome", "edge", "firefox"})
    public void testOnlinerCatalogContainsSpecificSectionChrome(String browser) {
        WebDriverFactoryStaticThreadRemote.setDriver(browser);
        setWebDriver(WebDriverFactoryStaticThreadRemote.getDriver());
        open(HOME_PAGE.getOnlinerUrl());
        onlinerHomePage
                .clickOnHeaderLink("Каталог")
                .clickOnCatalogSectionLink("Компьютеры и\u00a0сети")
                .isCompAndNetSideMenuDisplayed("Комплектующие");
        WebDriverFactoryStaticThreadRemote.closeDriver();
    }
}
