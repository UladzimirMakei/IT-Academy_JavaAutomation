package com.it_academy.onliner.enums;

public enum OnlinerPageUrl {
        HOME_PAGE("https://www.onliner.by/");

        private String onlinerUrl;

        OnlinerPageUrl(String onlinerUrl) {
            this.onlinerUrl = onlinerUrl;
        }

    public String getOnlinerUrl() {
        return onlinerUrl;
    }
}
