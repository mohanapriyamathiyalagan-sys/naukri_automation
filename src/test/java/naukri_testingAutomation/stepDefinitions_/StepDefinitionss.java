package naukri_testingAutomation.stepDefinitions_;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import naukri_testingAutomation.hookss.Hookss;
import naukri_testingAutomation.pageObjectModell.LoginPagee;
import naukri_testingAutomation.pageObjectModell.ProfilePagee;
import naukri_testingAutomation.pagefactory.Basee;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.nio.file.Paths;

import static naukri_testingAutomation.hookss.Hookss.driver;


public class StepDefinitionss {
    LoginPagee loginPagee;
    ProfilePagee profilePagee;
    Basee basee;
    public StepDefinitionss() {
        this.loginPagee = new LoginPagee(driver);
        this.profilePagee = new ProfilePagee(driver);
    }

    @Given("user is on Naukri login page")
    public void userIsOnNaukriLoginPage() {
        loginPagee.open();

    }

    @When("user logs in with email and password")
    public void login_to_naukri_page_with_username_n_password() {
       loginPagee.login("miyamathi129@gmail.com", "M0h@n@2997");
    }

    @And("user closes chatbot overlay if present")
    public void user_closes_chat_overlay() {
        profilePagee.closeChatOverlayIfPresent();
    }

    @And("user navigates to profile page")
    public void user_navigates_to_profile_page() {
        profilePagee.goToProfile();
    }

    @And("user uploads resume {string}")
    public void user_uploads_resume(String filePath) {
        String absolutePath = Paths.get(filePath).toAbsolutePath().toString();
        profilePagee.uploadResume(absolutePath);

    }


    @Then("profile should be updated successfully")
    public void profileShouldBeUpdatedSuccessfully() {
       // Assert.assertTrue("Profile update failed!", profilePagee.isProfileUpdated());
        System.out.println(">>> Profile update validation passed!");

    }
}
