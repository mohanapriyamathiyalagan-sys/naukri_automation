package naukri_automation.pageObjectModel;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class UploadResumeToNPage {

    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/span/div/div/div/div/div/div[2]/div[1]/div/div/ul/li[2]/a")
    WebElement uploadResume;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/span/div/div/div/div/div/div[2]/div[1]/div/div/ul/li[3]/span")
    WebElement resumeHeadLine;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/span/div/div/div/div/div/div[2]/div[1]/div/div/ul/li[5]/a")
    WebElement employmentWord;

    @FindBy(xpath = "//*[@id=\"companySugg\"]")
    WebElement currentCompanyName;

    @FindBy(xpath = "//*[@id=\"designationSugg\"]")
    WebElement jobTitle;

    @FindBy(id="startedYearFor")
    WebElement startedYear;

    @FindBy(id="startedMonthFor")
    WebElement startedMonth;

    @FindBy(xpath = "//*[@id=\"totalAbsCtc_id\"]")
    WebElement salary;

    @FindBy(id="keySkillSugg")
    WebElement skills;

    @FindBy(id="jobDescription")
    WebElement jobDescription;

    @FindBy(id="noticePeriodFor")
    WebElement noticePeriod;

    @FindBy(id="submitEmployment")
    WebElement saveButton;


    public UploadResumeToNPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

   public void uploadResume(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
        uploadResume.click();
        uploadResume.sendKeys("C:\\Users\\mohan\\Downloads\\Mohanapriya Mathiyalagan_5yrs_9months.pdf");
    }

    public void resumeHeadLine(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".valign-wrapper")));// Wait for overlay to disappear    Wrapper = a container box, Overlay = a covering sheet on top of the page.

       // Now click the element
        //Run JavaScript to scroll the page until this element is visible.
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", resumeHeadLine);  //JavascriptExecutor, which allows running JavaScript in the browser
        //arguments[0] → means the first element you pass from Java
        //.scrollIntoView(true) → scrolls the page until that element is visible at the top of the viewport.
        resumeHeadLine.click();


        //need to scroll down here
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
       /* WebElement editIcon = driver.findElement(By.xpath("//*[@id=\"lazyResumeHead\"]/div/div/div[1]/span[2]"));
        editIcon.click();
        */
        WebElement resumeEdit = driver.findElement(By.xpath("//*[@id='lazyResumeHead']/div/div/div[1]/span[2]"));

       // Scroll it into view (so it's visible)
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", resumeEdit);
        // Click using JavaScript (bypasses the overlay problem)
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", resumeEdit);

        WebElement enterHeadLine = driver.findElement(By.xpath("//*[@id=\"resumeHeadlineTxt\"]"));
        enterHeadLine.clear();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
        enterHeadLine.clear();
        enterHeadLine.sendKeys("\"SDET with Expertise in Selenium, Appium, and Test Automation Frameworks\"");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement saveButton = driver.findElement(By.xpath("/html/body/div[6]/div[8]/div[2]/form/div[3]/div/button"));
        saveButton.click();
    }

    public void updateEmployment(){
        Actions action = new Actions(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ltLayer.close")));

        List<WebElement> overlays = driver.findElements(By.cssSelector(".ltLayer.close"));
        if (!overlays.isEmpty() && overlays.get(0).isDisplayed()) {
            overlays.get(0).click();
        } else {
            System.out.println("No visible overlay present, continuing...");
        }
        WebElement closeBtn = driver.findElement(By.cssSelector(".ltLayer.close"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", closeBtn);


        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", employmentWord);
        employmentWord.click();

        currentCompanyName.clear();
        currentCompanyName.sendKeys("Accenture");
        action.sendKeys(jobTitle, Keys.ENTER).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        jobTitle.clear();
        jobTitle.sendKeys("Quality Assurance Engineer 1");
        action.sendKeys(jobTitle, Keys.ENTER).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        startedYear.clear();
        startedYear.click();
        startedYear.sendKeys("2019"); // type year
        startedYear.sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        startedMonth.click();
        startedMonth.clear();
        startedMonth.sendKeys("Nov");
        startedMonth.sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        salary.clear();
        salary.sendKeys("50,00,000");
        action.sendKeys(salary, Keys.ENTER).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));

        skills.sendKeys("Selenium");
        action.sendKeys(skills, Keys.ENTER).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));


        jobDescription.sendKeys("Am an expert in Selenium+java, Api, Devops, Coding");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
        noticePeriod.sendKeys("1 Month");
        action.sendKeys(noticePeriod, Keys.ENTER).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));

        saveButton.click();




    }
}
