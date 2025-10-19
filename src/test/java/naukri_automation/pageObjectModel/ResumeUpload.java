package naukri_automation.pageObjectModel;

import naukri_automation.factory.Base;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class ResumeUpload extends Base {

    @FindBy(xpath = "//a[@href='/mnjuser/profile']")
    private WebElement completeProfile;

    @FindBy(xpath = "//a[text()='Add 6 missing details']")
    private WebElement addMissingDetailsLink;

    @FindBy(css = "span.right.typ-14Bold")
    private WebElement profileCompletionText;

    @FindBy(xpath = "//input[@type='file']")
    private WebElement uploadInput;

    public ResumeUpload(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void uploadResume(String filePath) {
        completeProfile.click();

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0);");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(addMissingDetailsLink));

        addMissingDetailsLink.click();

        String text = profileCompletionText.getText().trim();
        int percent = Integer.parseInt(text.replace("%", ""));
        if (percent == 100) {
            System.out.println("Profile complete");
        } else {
            System.out.println("Profile not complete: " + percent + "%");
        }


        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement uploadInput = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file']")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", uploadInput);
        uploadInput.sendKeys(filePath);
    }

    @Test(dataProvider = "resumeFiles")
    public void uploadResumeTest(String filePath) {
        ResumeUpload resumePage = new ResumeUpload(driver);
        resumePage.uploadResume(filePath);
    }

    @DataProvider(name = "resumeFiles")
    public Object[][] provideResumeFiles() {
        return new Object[][]{
                {"C:\\Users\\Mohan\\Downloads\\Mohanapriya_5years_9Months.docx"},
        };
    }
}
