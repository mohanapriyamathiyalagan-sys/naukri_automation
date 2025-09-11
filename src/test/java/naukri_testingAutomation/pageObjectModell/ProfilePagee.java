package naukri_testingAutomation.pageObjectModell;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProfilePagee {

        WebDriver driver;
        WebDriverWait wait;

        By profileLink = By.xpath("//a[@href='/mnjuser/profile']");
        By resumeUpload = By.id("attachCV");
        By chatOverlay = By.cssSelector("div.chatbot_Overlay.show");

        public ProfilePagee(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
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

        public void goToProfile() {
            wait.until(ExpectedConditions.elementToBeClickable(profileLink)).click();
        }

        public void uploadResume(String filePath) {
            WebElement upload = wait.until(ExpectedConditions.presenceOfElementLocated(resumeUpload));
            upload.sendKeys(filePath);
            System.out.println("Resume uploaded successfully ✅");
        }


}
