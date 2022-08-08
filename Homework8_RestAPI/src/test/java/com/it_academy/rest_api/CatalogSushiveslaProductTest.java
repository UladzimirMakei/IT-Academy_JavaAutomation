package com.it_academy.rest_api;

import com.it_academy.onliner.rest_api.model.SushiveslaProduct;
import com.it_academy.onliner.rest_api.service.SushiveslaProductService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.function.Predicate.*;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class CatalogSushiveslaProductTest {

    @Test
    public void ApiSushiveslaProductNameNotEmptyTest() {
        List<SushiveslaProduct> sushiveslaProducts = new SushiveslaProductService()
                .getSushiveslaProductItems();
        assertThat(sushiveslaProducts)
                .as("Some of sushivesla products' names are empty")
                .allMatch(name -> !name.getName().isEmpty());
    }

    @Test
    public void ApiSushiveslaProductNamePrefixContainsRollTest() {
        List<String> namePrefix = new SushiveslaProductService()
                .getSushiveslaProductPrefixName();
        assertThat(namePrefix)
                .as("Some of sushivesla products' prefix names are not 'Роллы'")
                .allMatch(isEqual("Роллы"));
    }
}
