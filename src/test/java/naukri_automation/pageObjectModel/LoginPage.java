package naukri_automation.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebElement emailField;
    WebDriver driver;

   @FindBy(id = "login_Layer")
   WebElement initLogin;

    @FindBy(xpath = "//*[@id=\"root\"]/div[4]/div[2]/div/div/div[2]/div/form/div[2]/input")
    WebElement usernameField;

    @FindBy(xpath = "//*[@id=\"root\"]/div[4]/div[2]/div/div/div[2]/div/form/div[3]/input")
    WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"root\"]/div[4]/div[2]/div/div/div[2]/div/form/div[6]/button")
    WebElement loginButton;

   public LoginPage(WebDriver driver){
       this.driver=driver;
       PageFactory.initElements(driver, this);
   }

    public void setInitLogin(String username, String password) throws InterruptedException {
       initLogin.click();
       Thread.sleep(2000);
        usernameField.sendKeys(username);
        Thread.sleep(2000);
        passwordField.sendKeys(password);
        Thread.sleep(2000);
        loginButton.click();
    }



}
