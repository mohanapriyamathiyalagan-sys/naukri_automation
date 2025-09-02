package naukri_automation.stepDefinitions;


import io.cucumber.java.en.Given;
import naukri_automation.hooks.Hooks;
import naukri_automation.pageObjectModel.LoginPage;
import org.openqa.selenium.WebDriver;


public class StepDefinition_Login {
   // public static WebDriver driver;
    LoginPage loginPage;

    @Given("login to naukri page with username n password")
    public void loginPage() throws InterruptedException {
     loginPage = new LoginPage(Hooks.driver);
     loginPage.setInitLogin("miyamathi129@gamil.com", "M0h@n@2997");

    }





}
