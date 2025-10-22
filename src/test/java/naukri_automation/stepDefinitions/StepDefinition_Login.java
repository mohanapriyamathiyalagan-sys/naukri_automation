package naukri_automation.stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import naukri_automation.factory.Base;
import naukri_automation.hooks.Hooks;
import naukri_automation.pageObjectModel.*;

import java.io.IOException;


public class StepDefinition_Login {
    LoginPage loginPage;
    ProfilePageExp profilePageExp;
    UploadResumeToNPage uploadResumeToNPage;
    EmploymentUpdate employmentUpdate;
    ResumeUpload resumeUpload;
    ProfileSummary profileSummary;
    UploadPhoto uploadPhoto;

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

        profilePageExp.closeChatOverlayIfPresent(Base.driver);
      //  profilePageExp.profilePage();
    }

    @Then("upload the resume and headline")
    public void uploadTheResume() {
        uploadResumeToNPage = new UploadResumeToNPage(Base.driver);
        //uploadResumeToNPage.uploadResume();
        // uploadResumeToNPage.resumeHeadLine();

    }

    @Then("update employment")
    public void updateEmployment() throws InterruptedException {
        employmentUpdate = new EmploymentUpdate(Base.driver);
       // employmentUpdate.updateEmployment();
    }
    @Then("upload Resume")
    public void uploadResume() {
        resumeUpload = new ResumeUpload(Base.driver);
        String filePath = "C:\\Users\\mohan\\Downloads\\Mohanapriya Mathiyalagan_5yrs_9months.pdf";
        resumeUpload.uploadResume(filePath);
    }

    @Then("profile Summary")
    public void profileSummary(){
        profileSummary = new ProfileSummary(Base.driver);
       // profileSummary.profileSummary();
    }

    @Then("upload Photo")
    public void uploadPhoto(){
        uploadPhoto = new UploadPhoto(Base.driver);
       // uploadPhoto.uploadPhoto();
    }

}
