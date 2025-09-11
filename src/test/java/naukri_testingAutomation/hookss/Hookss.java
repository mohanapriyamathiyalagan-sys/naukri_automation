package naukri_testingAutomation.hookss;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import naukri_testingAutomation.pagefactory.Basee;
import org.openqa.selenium.WebDriver;

public class Hookss {

    public static WebDriver driver;

    @Before
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");
        driver = Basee.initializeDriver(browser);
        System.out.println("✅ " + browser + " launched before scenario");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println(" Browser closed after scenario");
        }
    }
}
