package com.it_academy.onliner.rest_api.service;

import com.google.common.collect.ImmutableMap;
import com.it_academy.onliner.rest_api.model.SushiveslaProduct;
import com.it_academy.onliner.rest_api.utils.GetRequestUtils;
import io.restassured.response.ResponseBody;

import java.util.List;
import java.util.Map;

import static com.it_academy.onliner.rest_api.endpoints.OnlinerEndpoints.*;
import static com.it_academy.onliner.rest_api.utils.ResponseBodyUtils.*;

public class SushiveslaProductService {
    private static final String PRODUCT_JSON_PATH = "products";
    private static final String PRODUCT_NAME_PREFIX_JSON_PATH = "products.name_prefix";

    public List<SushiveslaProduct> getSushiveslaProductItems() {
        ResponseBody responseBody = GetRequestUtils.makeRequestAndGetResponseBody(
                getCatalogSushiveslaEndPoint(),
                configureHeaders(), null);
        return getObjectsByJsonPath(
                responseBody, PRODUCT_JSON_PATH, SushiveslaProduct.class);
    }
    public List<String> getSushiveslaProductPrefixName() {
        ResponseBody responseBody = GetRequestUtils.makeRequestAndGetResponseBody(
                getCatalogSushiveslaFilterRollEndPoint(),
                configureHeaders(), null);
        return getObjectsByJsonPath(
                responseBody, PRODUCT_NAME_PREFIX_JSON_PATH, String.class);
    }

    public static Map<String, Object> configureHeaders() {
        return ImmutableMap.of("Host", "catalog.onliner.by");
    }
}
