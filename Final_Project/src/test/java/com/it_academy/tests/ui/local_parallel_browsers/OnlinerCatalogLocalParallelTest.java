package com.it_academy.tests.ui.local_parallel_browsers;

import com.codeborne.selenide.junit5.SoftAssertsExtension;
import com.it_academy.onliner.pageobject.OnlinerHomePage;
import com.it_academy.tests.listeners.AllureListener;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static com.it_academy.onliner.driver.WebDriverFactoryStaticThreadLocal.*;
import static com.it_academy.onliner.enums.OnlinerPageUrl.HOME_PAGE;


@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(AllureListener.class)
@ExtendWith(SoftAssertsExtension.class)

public class OnlinerCatalogLocalParallelTest {
    private final OnlinerHomePage onlinerHomePage = new OnlinerHomePage();

    @ParameterizedTest
    @CsvSource(value = {"chrome", "edge", "firefox"})
    public void testOnlinerCatalogCompAndNetContainsSpecificSection(String browserType) {
        setDriver(browserType);
        setWebDriver(getDriver());
        open(HOME_PAGE.getOnlinerUrl());
        onlinerHomePage
                .clickOnHeaderLink("Каталог")
                .clickOnCatalogSectionLink("Компьютеры и\u00a0сети")
                .isCompAndNetSideMenuDisplayed("Комплектующие");
    }

    @AfterEach
    public void tearDown() {
        closeDriver();
    }
}
