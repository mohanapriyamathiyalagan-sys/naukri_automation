package allActions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class AllActions {
    static WebDriver driver;
    public static void main(String[] args) {
         driver = new ChromeDriver();
        driver.get("https://www.naukri.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));

        AllActions allActions = new AllActions();
        allActions.loginPage(driver);
        allActions.profilePage(driver);
       // allActions.radioButton(driver);
        allActions.dropDown(driver);
    }

    public void loginPage(WebDriver driver){

       WebElement loginLayer = driver.findElement(By.xpath("//*[@id=\"login_Layer\"]"));
       loginLayer.click();

       WebElement loginUsername = driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div[2]/div/div/div[2]/div/form/div[2]/input"));
       loginUsername.sendKeys("mohana2997@gmail.com");

       WebElement loginPassword = driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div[2]/div/div/div[2]/div/form/div[3]/input"));
       loginPassword.sendKeys("Pr1y@12345");

       WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div[2]/div/div/div[2]/div/form/div[6]/button"));
       loginButton.click();


    }

    public void profilePage(WebDriver driver)  {
        WebElement profilePage = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[4]/div/div[2]/img"));
        profilePage.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
        WebElement viewUpdateProfile = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[4]/div[2]/div[2]/div/div[1]/div[2]/a"));
        viewUpdateProfile.click();
        WebElement editIcon = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/span/div/div/div/div/div/div[1]/div[1]/div/div/div/div[2]/div[1]/div/div[1]/em"));
        editIcon.click();
        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys(Keys.CONTROL+"a");
        name.sendKeys(Keys.DELETE);
        name.sendKeys("Mohanapriya Mathiyalagan");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void radioButton(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement workStatusExp = driver.findElement(By.xpath("//*[@id=\"editBasicDetailsForm\"]/div[4]/div[1]/div[1]/div[1]/div/div[2]/div[2]/label"));
        workStatusExp.click();

        WebElement workStatusExpInput = driver.findElement(By.id("exp-radio-id"));
        if(workStatusExpInput.isSelected()){
            System.out.println("Experienced option is selected");
        } else {
            System.out.println(" Please select the Experienced radio button");
        }
    }

    public void dropDown(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebElement yearDrop = driver.findElement(By.id("exp-years-droopeFor"));
        yearDrop.click();

        WebElement yearOption = driver.findElement(By.xpath("//div[@id='exp-years-droopeFor']//li[text()='5 Years']"));
        yearOption.click();


        WebElement monthDrop = driver.findElement(By.id("exp-months-droopeFor"));
        monthDrop.click();

        WebElement monthOption = driver.findElement(By.xpath("//div[@id='exp-months-droopeFor']//li[text()='7 Months']"));
        monthOption.click();
    }

    public void quitTheWindow(){
        driver.quit() ;
    }


}
