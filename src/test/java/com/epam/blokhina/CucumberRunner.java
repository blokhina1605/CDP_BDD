package com.epam.blokhina;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(tags = {"~@ignore"}, format = {"pretty", "json:target/cucumber.json", "html:target/cucumber.html"},
        features = {"features/"}, glue = "com.epam.blokhina.stepdefs")
public class CucumberRunner {
}
