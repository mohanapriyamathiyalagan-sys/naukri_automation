package naukri_automation.pageObjectModel;

import naukri_automation.factory.Base;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.time.Duration;

public class ResumeUpload extends Base {

    private static final Logger log = LoggerFactory.getLogger(ResumeUpload.class);

    @FindBy(xpath = "//a[@href='/mnjuser/profile']")
    private WebElement completeProfile;

    @FindBy(xpath = "//a[contains(text(),'missing details')]")
    private WebElement addMissingDetailsLink;

    @FindBy(css = "span.right.typ-14Bold")
    private WebElement profileCompletionText;

    @FindBy(xpath = "//span[@class='dummyUploadNewCTA']")
    private WebElement uploadButton;

    public ResumeUpload(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void uploadResume(String filePath) {
        completeProfile.click();


        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(addMissingDetailsLink));

        String text = profileCompletionText.getText().trim();
        int percent = Integer.parseInt(text.replace("%", ""));
        if (percent == 100) {
            log.info("Profile is 100% complete");
        } else {
            log.info("Profile not complete: " + percent + "%");
        }

        wait.until(ExpectedConditions.elementToBeClickable(uploadButton)).click();

        WebElement uploadInput = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//input[@type='file']")
        ));

        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", uploadInput);
        uploadInput.sendKeys(filePath);

        log.info("Resume uploaded successfully from path: {}", filePath);
    }


}
