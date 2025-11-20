package ornghrms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.time.Duration;

public class ornghrms {
    WebDriver driver;
    WebDriverWait wait;

    // ===== LOCATORS =====
    By usernameField = By.xpath("//input[@name='username']");
    By passwordField = By.xpath("//input[@type='password']");
    By loginButton   = By.xpath("//button[@type='submit']");

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");

        // ADDING WAIT
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ===== HELP METHOD TO WAIT FOR ELEMENT =====
    public WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // ===== ACTION METHODS =====
    public void enterUsername(String username) {
        waitForElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        waitForElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        waitForElement(loginButton).click();
    }

    public void loginToOrangeHRM(String user, String pass)throws InterruptedException {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
        Thread.sleep(2000);
    }

    // ====== TEST ======
    @Test
    public void verifyLogin() throws InterruptedException{
        loginToOrangeHRM("Admin", "admin123");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
