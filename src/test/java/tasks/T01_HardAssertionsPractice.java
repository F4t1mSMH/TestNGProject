package tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class T01_HardAssertionsPractice {
//    Test Case: Positive Login Test
//1. Navigate to https://claruswaysda.github.io/signIn.html
//            2. Enter username: "admin"
//            3. Enter password: "123"
//            4. Click Submit button
//5. Use hard assertions to verify:
//    New page URL is "https://claruswaysda.github.io/signIn.html"
//    Page contains text "Employee Table"
    @Test
    void positiveLoginTest(){
        driver.get("https://claruswaysda.github.io/signIn.html");
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("123", Keys.ENTER);
        String expectedUrl = "https://claruswaysda.github.io/signIn.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "The new page URL match the expected URL.");

        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("Employee Table"), "The page contain the text 'Employee Table'.");

        System.out.println("This won't print if assertion fails");
    }

    WebDriver driver;
    @BeforeClass
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
