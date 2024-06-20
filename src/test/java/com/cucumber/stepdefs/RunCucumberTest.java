package com.cucumber.stepdefs;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = { "pretty",
                "json:target/surefire-reports/cucumber.json",
                "html:target/cucumber-report.html",
                "junit:target/cucumber-report.xml"},
        glue = {"com.cucumber.stepdefs"},
        features = {"src/test/resources"}
)
public class RunCucumberTest {
}