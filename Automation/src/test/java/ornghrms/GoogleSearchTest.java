package ornghrms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class GoogleSearchTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Sachin\\Downloads\\Chromeexe\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void searchSelenium() throws InterruptedException {
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium automation");
        searchBox.submit();
        Thread.sleep(2000);
        String pageSource = driver.getPageSource().toLowerCase();
        Assert.assertTrue(pageSource.contains("selenium") || driver.getTitle().toLowerCase().contains("selenium"));
    }

    @AfterClass
    public void teardown() {
        if (driver != null)
            driver.quit();
    }
}
