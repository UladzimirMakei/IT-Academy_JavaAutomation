package com.it_academy.onliner.driver;

import org.openqa.selenium.remote.DesiredCapabilities;

import static com.it_academy.onliner.driver.OptionsManager.*;

public class CapabilityFactory {
    public DesiredCapabilities capabilities;

    public DesiredCapabilities getCapabilities(String browser) {
        switch (browser) {
            case ("firefox"): {
                capabilities = getFirefoxDesiredCapabilities();
                break;
            }
            case ("edge"): {
                capabilities = getEdgeDesiredCapabilities();
                break;
            }
            default: {
                capabilities = getChromeDesiredCapabilities();
                break;
            }
        }
        return capabilities;
    }
}
