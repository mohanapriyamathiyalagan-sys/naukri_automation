package naukri_automation.pageObjectModel;

import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class ProfilePageExp {
    WebDriver driver;

    By chatOverlay = By.cssSelector("div.chatbot_Overlay.show");

    @FindBy(xpath = "/html/body/main/div/div/div[3]/div/div[3]/div[2]/a")
    WebElement completeProfile;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/span/div/div/div/div/div/div[1]/div[1]/div/div[1]/div/div[2]/div[1]/div/div[1]/em")
    WebElement editIcon;

    @FindBy(xpath = "//*[@id='editBasicDetailsForm']/div[4]/div[1]/div[1]/div[1]/div/div[2]/div[2]/label")
    WebElement expRadio;

    @FindBy(id="exp-years-droopeFor")
    WebElement expYears;

    @FindBy(id = "exp-months-droopeFor")
    WebElement expMonths;

    @FindBy(xpath = "//*[@id=\"totalAbsCtc_id\"]")
    WebElement salary;

    @FindBy(id="salaryBreakDownDDFor")
    WebElement salaryBreakdown;

    @FindBy(xpath = "//*[@id=\"editBasicDetailsForm\"]/div[6]/div/div[2]/span[4]")
    WebElement availabilityDays;



    public ProfilePageExp(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void closeChatOverlayIfPresent() {
        List<WebElement> overlays = driver.findElements(chatOverlay);
        if (!overlays.isEmpty()) {
            try {
                WebElement closeBtn = overlays.get(0).findElement(By.cssSelector("button"));
                closeBtn.click();
                System.out.println("Chatbot closed ✅");
            } catch (Exception e) {
                System.out.println("Overlay found but no close button.");
            }
        } else {
            System.out.println("No chatbot overlay present.");
        }
    }

    public void profilePage() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("_t473abj3d2")));

        completeProfile.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        editIcon.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.elementToBeClickable(expRadio)).click();

        Actions action = new Actions(driver);
        expYears.click();
        Thread.sleep(2000);
        WebElement inputBox = driver.findElement(By.id("exp-years-droopeFor"));
        inputBox.sendKeys("5 Years");
        action.sendKeys(inputBox, Keys.ENTER).perform();

        Thread.sleep(2000);
        expMonths.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        WebElement inputBoxMon = driver.findElement(By.id("exp-months-droopeFor"));
        inputBoxMon.sendKeys("9 Months");
        action.sendKeys(inputBoxMon, Keys.ENTER).perform();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

        salary.sendKeys("5000000");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        action.sendKeys(salaryBreakdown, Keys.PAGE_DOWN).perform();
        salaryBreakdown.click();

        WebDriverWait wait2= new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement dropdown = wait2.until(ExpectedConditions.elementToBeClickable(
                By.id("salaryBreakDownDDFor")));
        dropdown.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        WebElement salaryBrk = driver.findElement(By.id("salaryBreakDownDDFor"));
        salaryBrk.clear();

        salaryBrk.sendKeys("Fixed + Variable");


        action.sendKeys(dropdown, Keys.ENTER).perform();

        WebElement fixedSalary = driver.findElement(By.xpath("//*[@id=\"fixedCtc_id\"]"));
        fixedSalary.sendKeys("2005000");

        WebElement variableSalary = driver.findElement(By.xpath("//*[@id=\"variableCtc_id\"]"));
        variableSalary.sendKeys("400000");


        availabilityDays.click();
        driver.findElement(By.id("saveBasicDetailsBtn")).click();
    }


}
