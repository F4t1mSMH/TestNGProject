package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C05_DependencyTesting {

    /*
        1.Create a class called DependencyTest
        2.Create a @BeforeClass method to set up WebDriver
        3.Create the following dependent test chain:
            openYahoo()- Navigate to Yahoo
            openBing()- Navigate to Bing (depends on Yahoo test)
            openDuckDuckGo() - Navigate to DuckDuckGo (depends on Bing test)
        4. Add intentional failure in Yahoo test and observe behavior
        5.Create @AfterClass method to close driver
     */
    @Test(enabled = false)
    void openYahoo() {
        driver.get("https://Yahoo.com");
        System.out.println("intentional failure");
    }

    @Test(dependsOnMethods = "openYahoo")
    void openBing() {
        driver.get("https://Bing.com");
    }

    @Test(dependsOnMethods = {"openBing"})
    void openDuckDuckGo() {
        driver.get("https://DuckDuckGo.com");
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
