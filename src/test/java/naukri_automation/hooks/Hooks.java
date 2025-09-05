package naukri_automation.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import naukri_automation.factory.Base;
import naukri_automation.pageObjectModel.LoginPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;

public class Hooks extends Base {
    LoginPage loginPage;

    @Before
    public void setUp() {
        initializeDriver();
        driver.get("https://naukri.com");
        loginPage = new LoginPage(driver);
    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                highlight(loginPage.emailField);
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

                scenario.attach(screenshot, "image/png", scenario.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
          //  quitDriver();
        }
    }
}
