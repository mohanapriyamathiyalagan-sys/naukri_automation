package naukri_automation.stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import naukri_automation.hooks.Hooks;
import naukri_automation.pageObjectModel.LoginPage;
import naukri_automation.pageObjectModel.ProfilePageExp;
import org.openqa.selenium.WebDriver;


public class StepDefinition_Login {
    LoginPage loginPage;
    ProfilePageExp profilePageExp;

    @Given("login to naukri page with username n password")
    public void loginPage() throws InterruptedException {
     loginPage = new LoginPage(Hooks.driver);
     loginPage.setInitLogin("miyamathi129@gmail.com", "M0h@n@2997");

    }


    @When("complete the profile exp page and click on save")
    public void completeTheProfileExpPageAndClickOnSave() {
        profilePageExp.profilePage();
    }
}
