package naukri_automation.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import naukri_automation.factory.Base;
import org.testng.Assert;

public class StepDefinition_Login extends Base {
    NaukriLoginPage loginPage;

    @Given("I am on the Naukri login page")
    public void i_am_on_the_naukri_login_page() {
        loginPage = new NaukriLoginPage(driver);
        Assert.assertTrue(loginPage.getPageTitle().contains("Naukri.com"));
    }

    @When("I enter naukri username {string}")
    public void i_enter_naukri_username(String username) {
        loginPage.enterUsername(username);
    }

    @When("I enter naukri password {string}")
    public void i_enter_naukri_password(String password) {
        loginPage.enterPassword(password);
    }

    @When("I click on the Naukri login button")
    public void i_click_on_the_naukri_login_button() {
        loginPage.clickLogin();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        Assert.assertFalse(loginPage.getPageTitle().contains("Login"));
        System.out.println("Login Successful - Home Page Title: " + loginPage.getPageTitle());
    }
}
