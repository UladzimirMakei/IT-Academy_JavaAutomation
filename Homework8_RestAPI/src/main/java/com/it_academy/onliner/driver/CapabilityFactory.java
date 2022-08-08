package com.it_academy.onliner.driver;

import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilityFactory {
    public DesiredCapabilities capabilities;

    public DesiredCapabilities getCapabilities(String browser) {
        if (browser.equals("firefox")) {
            capabilities = OptionsManager.getFirefoxDesiredCapabilities();
        } else if(browser.equals("edge")) {
            capabilities = OptionsManager.getEdgeDesiredCapabilities();
        } else capabilities = OptionsManager.getChromeDesiredCapabilities();
        return capabilities;
    }
}
