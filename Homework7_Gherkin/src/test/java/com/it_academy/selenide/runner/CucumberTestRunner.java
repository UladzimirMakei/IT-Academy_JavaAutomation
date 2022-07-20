package com.it_academy.selenide.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "pretty",
        monochrome = true,
        tags = "@smoke",
        glue = "com.cucumber.testng",
        features = "classpath:com/cucumber/testng/features"
)

public class CucumberTestRunner {
}
