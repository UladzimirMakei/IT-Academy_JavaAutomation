package com.it_academy.tests.rest_api;

import com.codeborne.selenide.junit5.SoftAssertsExtension;
import com.it_academy.tests.listeners.AllureListener;
import com.it_academy.onliner.rest_api.model.SushiveslaProduct;
import com.it_academy.onliner.rest_api.service.SushiveslaProductService;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static java.util.function.Predicate.isEqual;
import static org.assertj.core.api.Java6Assertions.assertThat;

@ExtendWith(AllureListener.class)
@ExtendWith(SoftAssertsExtension.class)
public class CatalogSushiveslaProductTest {

    @Test
    @Step("Throw API receive shushivesla content and verify it's not empty")
    @Description("Check data received throw API is not empty")
    public void ApiSushiveslaProductNameNotEmptyTest() {
        List<SushiveslaProduct> sushiveslaProducts = new SushiveslaProductService()
                .getSushiveslaProductItems();
        assertThat(sushiveslaProducts)
                .as("Some of sushivesla products' names are empty")
                .allMatch(name -> !name.getName().isEmpty());
    }

    @Test
    @Step("Throw API receive shushivesla content and verify that all items contain 'Роллы' title")
    @Description("Check all items received throw API  contain 'Роллы' title")
    public void ApiSushiveslaProductNamePrefixContainsRollTest() {
        List<String> namePrefix = new SushiveslaProductService()
                .getSushiveslaProductPrefixName();
        assertThat(namePrefix)
                .as("Some of sushivesla products' prefix names are not 'Роллы'")
                .allMatch(isEqual("Роллы"));
    }
}
