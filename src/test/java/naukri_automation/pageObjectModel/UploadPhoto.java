package naukri_automation.pageObjectModel;

import naukri_automation.factory.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadPhoto extends Base {

    @FindBy(xpath = "//a[@href='/mnjuser/profile']")
    private WebElement completeProfile;

    @FindBy(xpath = "//span[@class='nk-user-img']")
    private WebElement uploadPhoto;

    @FindBy(xpath = "//input[@id='fileUpload']")
    private WebElement innerUploadPhoto;


public UploadPhoto(WebDriver driver){
    this.driver = driver;
    PageFactory.initElements(driver, this);
}

public void uploadPhoto(){
    completeProfile.click();
    uploadPhoto.click();
    WebElement upload = driver.findElement(By.id("fileUpload"));
    ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", upload);
    upload.sendKeys("C:\\Users\\mohan\\Downloads\\MohanapriyaM.jpg");
}
}
