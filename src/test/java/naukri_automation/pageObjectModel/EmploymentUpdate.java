package naukri_automation.pageObjectModel;

import naukri_automation.factory.Base;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class EmploymentUpdate extends Base {


    @FindBy(xpath = "/html/body/main/div/div/div[3]/div/div[3]/div[2]/a")
    WebElement completeProfile;


    public EmploymentUpdate(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void updateEmployment() throws InterruptedException {
        completeProfile.click();

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[text()='Add']")));


        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input#exp-years-droopeFor")).click();
        driver.findElement(By.cssSelector("a[data-id='exp-years-droope_5']")).click();
        driver.findElement(By.cssSelector("input#exp-months-droopeFor")).click();
        driver.findElement(By.cssSelector("a[data-id='exp-months-droope_9']")).click();
        driver.findElement(By.cssSelector("input#companySugg")).sendKeys("Accenture");

        int attempts = 0;
        while (attempts < 3) {
            try {
                WebElement suggestion = driver.findElement(
                        By.xpath("//li[@class='sugTouple']//div[contains(text(),'Accenture')]"));
                suggestion.click();
                break;
            } catch (StaleElementReferenceException e) {
                attempts++;
            }
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement designationField = driver.findElement(By.id("designationSugg"));
        designationField.clear();
        designationField.sendKeys("Quality");

        By suggestionsLocator = By.xpath("//div[contains(@id,'sugDrp_designationSugg')]//li[@class='sugTouple']//div[@class='Sbtn']");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(suggestionsLocator));

        List<WebElement> suggestions = driver.findElements(suggestionsLocator);

        for (WebElement s : suggestions) {
            System.out.println("Found: " + s.getText());
            if (s.getText().trim().equalsIgnoreCase("Quality Manager")) {
                s.click();
                break;
            }
        }
        WebElement startedYear = driver.findElement(By.id("startedYearFor"));
        startedYear.click();
        Thread.sleep(200);

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement year2019 = wait1.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@id='startedYear']//a[normalize-space(text())='2019']")));
        wait1.until(ExpectedConditions.elementToBeClickable(year2019)).click();

        WebElement startedMonth = driver.findElement(By.id("startedMonth"));
        startedMonth.click();
        driver.findElement(By.xpath("//a[normalize-space(text())='Nov']")).click();

        WebElement currentSalary = driver.findElement(By.id("totalAbsCtc_id"));
        currentSalary.clear();
        currentSalary.sendKeys("6000000");

        driver.findElement(By.id("salaryBreakDownDD")).click();
        driver.findElement(By.xpath("//a[normalize-space(text())='Fixed']")).click();

        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).perform();

        String skillToAdd = "Selenium";
        List<WebElement> skills = driver.findElements(By.xpath("//span[@class='sugInp' and normalize-space(text())='" + skillToAdd + "']"));
        if (skills.isEmpty()) {
            WebElement input = driver.findElement(By.id("keySkillSugg"));
            input.sendKeys(skillToAdd);
             driver.findElement(By.xpath("//li[@class='sugTouple']//div[normalize-space(text())='Selenium']")).click();
            System.out.println(skillToAdd + " added successfully.");
        } else {
            System.out.println(skillToAdd + " is already present.");
        }

        WebElement jobProfileBox = driver.findElement(By.id("jobDescription"));
        jobProfileBox.clear();
        jobProfileBox.sendKeys("Am an expert on Automation and as a Java Full Stack Developer");

        driver.findElement(By.id("noticePeriodFor")).click();
        driver.findElement(By.cssSelector("a[data-id='noticePeriod_4']")).click();

        driver.findElement(By.id("submitEmployment")).click();
    }
}


