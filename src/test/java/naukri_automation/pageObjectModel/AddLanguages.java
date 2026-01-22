package naukri_automation.pageObjectModel;

import naukri_automation.factory.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddLanguages extends Base {
    @FindBy(xpath = "//a[@href='/mnjuser/profile']")
    private WebElement completeProfile;

    @FindBy(xpath = "//span[@class='pend-act-txt typ-14Bold']")
    WebElement addLanguages1Icon;

    @FindBy(xpath = "//span[@class='add' and normalize-space(text())='Add languages']")
    WebElement addLanguagues2Icon;

    @FindBy(xpath = "//a[@id='add-new-language' and text()='Add language']")
    WebElement addLanguage;

    @FindBy(xpath = "//input[@id='pd-language--0For']")
    WebElement searchLanguage;

    @FindBy(xpath = "//input[@id='pd-proficiency-0For']")
    WebElement searchProficiency;


    public AddLanguages(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addLanguages(){
        completeProfile.click();
        addLanguages1Icon.click();
        addLanguagues2Icon.click();
        addLanguage.click();
        searchLanguage.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement englishLan = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@data-id, 'pd-language--0_1')]")));
        englishLan.click();

        searchProficiency.click();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement prof= wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@data-id, 'pd-proficiency-0_2')]")));
        prof.click();










    }
}
