package naukri_testingAutomation.runnerr;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


    @CucumberOptions(
            features = "src/test/resources/features",
            glue = {"naukri_testingAutomation.stepDefinitions_", "naukri_testingAutomation.hookss"},
            plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"},
            monochrome = true
    )
    public class Runnerr extends AbstractTestNGCucumberTests {
    }


