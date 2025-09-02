package naukri_automation.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import naukri_automation.factory.Base;

public class Hooks extends Base {

    @Before
    public void setUp() {
        initializeDriver();
        driver.get("https://naukri.com");
    }

    @After
    public void tearDown() {
        quitDriver();
    }
}
