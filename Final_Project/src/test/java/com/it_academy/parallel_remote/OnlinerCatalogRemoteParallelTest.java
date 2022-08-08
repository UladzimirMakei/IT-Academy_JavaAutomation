package com.it_academy.parallel_remote;

import com.it_academy.onliner.driver.WebDriverFactoryStaticThreadRemote;
import com.it_academy.onliner.pageobject.OnlinerHomePage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static com.it_academy.onliner.pageobject.OnlinerHomePage.getOnlinerUrl;

@Execution(ExecutionMode.CONCURRENT)

public class OnlinerCatalogRemoteParallelTest {
    private final OnlinerHomePage onlinerHomePage = new OnlinerHomePage();

    @Disabled
    @ParameterizedTest
    @CsvSource(value = {"chrome", "edge", "firefox"})
    public void testOnlinerCatalogContainsSpecificSectionChrome(String browser) {
        WebDriverFactoryStaticThreadRemote.setDriver(browser);
        setWebDriver(WebDriverFactoryStaticThreadRemote.getDriver());
        open(getOnlinerUrl());
        onlinerHomePage
                .clickOnHeaderLink("Каталог")
                .clickOnCatalogSectionLink("Компьютеры и\u00a0сети")
                .isCompAndNetSideMenuDisplayed("Комплектующие");
        WebDriverFactoryStaticThreadRemote.closeDriver();
    }
}
