package naukri_automation.factory;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;

public class Base {
        public static WebDriver driver;

        public void initializeDriver() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        public void quitDriver() {
            if (driver != null) {
                driver.quit();
            }
        }

        public void highlight(WebElement element) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
        }

        // take screenshot
        public void captureScreenshot(String fileName) throws IOException {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(src, new File("screenshots/" + fileName + ".png"));
        }
    }

