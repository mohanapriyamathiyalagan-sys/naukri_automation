

package naukri_automation.pageObjectModel;

import naukri_automation.factory.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProfileSummary extends Base {
    @FindBy(xpath = "//a[@href='/mnjuser/profile']")
    private WebElement completeProfile;

    @FindBy(xpath = "//span[text()='Add profile summary']")
    WebElement profileSummary;

    @FindBy(id = "profileSummaryTxt")
    WebElement enterSummaryText;

    @FindBy(xpath = "//Button[text()='Save']")
    WebElement saveButton;

    public ProfileSummary(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void profileSummary(){
        completeProfile.click();
        profileSummary.click();
        enterSummaryText.clear();
        enterSummaryText.sendKeys("Results-driven Automation Engineer with experience in building and maintaining automation frameworks using Selenium, Java, and TestNG." +
                " Proficient in creating data-driven and reusable test scripts. " +
                "Strong problem-solving skills with a keen eye for detail and commitment to software quality assurance.");
        saveButton.click();
    }

}
