package naukri_automation.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By username = By.id("usernameField");
    private By password = By.id("passwordField");
    private By loginBtn = By.xpath("//button[@type='submit']");


    public void enterUsername(String user) {
        driver.findElement(username).sendKeys(user);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
