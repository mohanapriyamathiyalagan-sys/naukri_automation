package naukri_automation.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import naukri_automation.factory.Base;
import naukri_automation.pageObjectModel.LoginPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class Hooks extends Base {
    LoginPage loginPage;
    Base base;

    @Before
    public void setUp() throws IOException {
        base = new Base();
        base.initializeDriver();
        propertyInitialize();
        String url = properties.getProperty("url");
        driver.get(url);

      //  driver.get("https://naukri.com"); --> removing hardcoded here
        loginPage = new LoginPage(driver);
    }

    @After
    public void tearDown() throws IOException {

    File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("cucumber-reports.html"));
       // quitDriver();
    }
}
