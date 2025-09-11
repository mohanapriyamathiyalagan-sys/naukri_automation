package naukri_testingAutomation.pageObjectModell;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPagee {

        WebDriver driver;
        WebDriverWait wait;

        By emailField = By.id("usernameField");
        By passwordField = By.id("passwordField");
        By loginButton = By.xpath("//button[text()='Login']");

        public LoginPagee(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        }

        public void open() {
            driver.get("https://www.naukri.com/nlogin/login");
        }

        public void login(String email, String password) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
            driver.findElement(passwordField).sendKeys(password);
            driver.findElement(loginButton).click();
        }

}
