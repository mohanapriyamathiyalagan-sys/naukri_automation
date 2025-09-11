
package naukri_automation.pageObjectModel;

import io.cucumber.java.Scenario;
import naukri_automation.factory.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.time.Duration;


public class LoginPage {

    WebDriver driver;


   @FindBy(id = "login_Layer")
   WebElement initLogin;

    @FindBy(xpath = "//*[@id=\"root\"]/div[4]/div[2]/div/div/div[2]/div/form/div[2]/input")
    WebElement usernameField;

    @FindBy(xpath = "//*[@id=\"root\"]/div[4]/div[2]/div/div/div[2]/div/form/div[3]/input")
    WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"root\"]/div[4]/div[2]/div/div/div[2]/div/form/div[6]/button")
    WebElement loginButton;

    public LoginPage(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void setInitLogin(String username, String password)  {

        initLogin.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();

    }
}

