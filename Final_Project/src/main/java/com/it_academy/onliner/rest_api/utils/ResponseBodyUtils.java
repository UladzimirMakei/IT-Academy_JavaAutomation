package com.it_academy.onliner.rest_api.utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;

import java.util.List;

public class ResponseBodyUtils {
    public static <T> List<T> getObjectsByJsonPath(
            ResponseBody responseBody, String jsonPath, Class<T> type) {
        return responseBody
                .jsonPath()
                .getList(jsonPath, type);
    }

    public static String getStringJsonValue(ResponseBody responseBody, String jsonPath) {
        return JsonPath.from(responseBody.asString()).getString(jsonPath);
    }
}
