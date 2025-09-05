package naukri_automation.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class ProfilePageExp {
    WebDriver driver;

    @FindBy(xpath = "/html/body/main/div/div/div[3]/div/div[3]/div[2]/a")
    WebElement completeProfile;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/span/div/div/div/div/div/div[1]/div[1]/div/div[1]/div/div[2]/div[1]/div/div[1]/em")
    WebElement editIcon;

    @FindBy(xpath = "//*[@id=\"editBasicDetailsForm\"]/div[3]/div[1]/div[1]/div/div/div[2]/div[2]/label")
    WebElement experiencedRadioButton;

    @FindBy(xpath = "//*[@id=\"exp-years-droopeFor\"]")
    WebElement expYears;

    @FindBy(xpath = "//*[@id=\"exp-months-droopeFor\"]")
    WebElement expMonths;

    @FindBy(xpath = "//*[@id=\"totalAbsCtc_id\"]")
    WebElement salary;

    @FindBy(id="salaryBreakDownDDFor")
    WebElement salaryBreakdown;

    @FindBy(xpath = "//*[@id=\"editBasicDetailsForm\"]/div[5]/div/div[2]/span[1]")
    WebElement availabilityDays;

    public ProfilePageExp(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void profilePage(){
        completeProfile.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        editIcon.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        experiencedRadioButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        if(experiencedRadioButton.isSelected()) {
            System.out.println("Exp radio button is selected");
        }

        Select select = new Select(expYears);
        select.selectByIndex(3);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        Select select1 = new Select(expMonths);
        select1.selectByIndex(4);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        salary.sendKeys("500000");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        Select select2 = new Select(salaryBreakdown);
        select2.selectByIndex(1);

        availabilityDays.click();











    }

}
