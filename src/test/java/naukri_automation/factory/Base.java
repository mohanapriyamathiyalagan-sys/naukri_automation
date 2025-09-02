package naukri_automation.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base {
    protected static WebDriver driver;

    public void initializeDriver() {
        if (driver == null) {
            System.out.println("Launching Chrome browser...");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }

    public void quitDriver() {
        if (driver != null) {
            System.out.println("Closing browser...");
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

}
