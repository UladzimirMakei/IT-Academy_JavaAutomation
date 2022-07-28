package com.it_academy.onliner.rest_api.endpoints;

import static com.it_academy.onliner.framework.PropertiesReader.*;

public class OnlinerEndpoints {

    public static String getCatalogSushiveslaEndPoint() {
        return getEndpointProperty("catalog.shushivesla");
    }

    public static String getCatalogSushiveslaFilterRollEndPoint() {
        return getEndpointProperty("catalog.shushivesla.rolls");
    }
}
