package naukri_automation.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import naukri_automation.factory.Base;
import naukri_automation.pageObjectModel.LoginPage;

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
                captureScreenshot(scenario.getName().replace(" ", "_"));  // save screenshot
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            quitDriver();   // close browser
        }
    }
}
