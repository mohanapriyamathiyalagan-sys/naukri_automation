package naukri_automation.stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import naukri_automation.factory.Base;
import naukri_automation.hooks.Hooks;
import naukri_automation.pageObjectModel.LoginPage;
import naukri_automation.pageObjectModel.ProfilePageExp;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.time.Duration;


public class StepDefinition_Login {
    LoginPage loginPage;
    ProfilePageExp profilePageExp;

    @Given("login to naukri page with username n password")
    public void loginPage() throws IOException {
     loginPage = new LoginPage(Hooks.driver);
     profilePageExp = new ProfilePageExp(Hooks.driver);

        String username = Base.properties.getProperty("username");
        String password = Base.properties.getProperty("password");
        loginPage.setInitLogin(username, password);
    }


    @When("complete the profile exp page and click on save")
    public void completeTheProfileExpPageAndClickOnSave() throws InterruptedException {

        profilePageExp.closeChatOverlayIfPresent();
        profilePageExp.profilePage();
    }
}
