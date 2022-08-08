package com.it_academy.local;

import com.it_academy.onliner.driver.WebDriverFactoryStaticThreadLocal;
import com.it_academy.onliner.pageobject.OnlinerHomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static com.it_academy.onliner.driver.WebDriverFactoryStaticThreadLocal.setDriver;

@Execution(ExecutionMode.CONCURRENT)

public class ParallerExecutionLocalTest {
    private final OnlinerHomePage onlinerHomePage = new OnlinerHomePage();

    @ParameterizedTest
    @CsvSource(value = {"chrome", "edge", "firefox"})
    public void testOnlinerCatalogContainsSpecificSection(String browserType) {
        setDriver(browserType);
        setWebDriver(WebDriverFactoryStaticThreadLocal
                .getDriver());
        open("https://www.onliner.by/");
        onlinerHomePage
                .clickOnHeaderLink("Каталог")
                .clickOnCatalogSectionLink("Компьютеры и\u00a0сети")
                .isCompAndNetSideMenuDisplayed();
    }

    @ParameterizedTest
    @CsvSource(value = {"chrome", "edge", "firefox"})
    public void testOnlinerCatalogCompAndNetContainsSpecificSection(String browserType) {
        setDriver(browserType);
        setWebDriver(WebDriverFactoryStaticThreadLocal
                .getDriver());
        open("https:www.onliner.by");
        onlinerHomePage
                .clickOnHeaderLink("Каталог")
                .clickOnCatalogSectionLink("Компьютеры и\u00a0сети")
                .doesComputerAndNetSideMenuContainListOfTitles();
    }

    @AfterEach
    public void tearDown() {
        WebDriverFactoryStaticThreadLocal.closeDriver();
    }
}
