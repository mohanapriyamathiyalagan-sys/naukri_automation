package naukri_automation.factory;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.*;
import java.util.Properties;

public class Base {
        public static WebDriver driver;
        public static Properties properties;
    public void initializeDriver() throws IOException {
       propertyInitialize();
       String browser = properties.getProperty("app.browser");
       switch(browser){
           case "chrome":
               driver = new ChromeDriver();
               break;
           case "edge":
               driver = new EdgeDriver();
               break;
           default:
               driver = new ChromeDriver();
               break;
       }
        driver.manage().window().maximize();
    }

    public void propertyInitialize() throws IOException {
        properties = new Properties();
        InputStream input = getClass().getClassLoader().getResourceAsStream("config/application.properties");
        if(input == null){
            throw new FileNotFoundException("Property file not found in classpath");
        }
        properties.load(input);

    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
    public void highlight(WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].style.border='3px solid red'", element);
    }
    /*public void captureScreenshot(String fileName) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("screenshots/" + fileName + ".png");
        dest.getParentFile().mkdirs();
        FileHandler.copy(src, dest);
        System.out.println("Screenshot saved at: " + dest.getAbsolutePath());*/

    }

