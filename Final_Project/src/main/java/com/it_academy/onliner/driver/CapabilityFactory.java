package com.it_academy.onliner.driver;

import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilityFactory {
    public DesiredCapabilities capabilities;

    public DesiredCapabilities getCapabilities(String browser) {
        switch (browser) {
            case ("firefox"): {
                capabilities = OptionsManager.getFirefoxDesiredCapabilities();
                break;
            }
            case ("edge"): {
                capabilities = OptionsManager.getEdgeDesiredCapabilities();
                break;
            }
            default: {
                capabilities = OptionsManager.getChromeDesiredCapabilities();
                break;
            }
        }
        return capabilities;
    }
}
