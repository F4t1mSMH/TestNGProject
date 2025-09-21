package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C06_SoftAssertionTask extends TestBase {
    /*
    1. Navigate to https://claruswaysda.github.io/signIn.html
    2. Enter username: "wronguser"
    3. Enter password: "wrongpass"
    4. Click Submit button
    5. Use soft assertions to verify: Alert message text is "Incorrect username or password"
     */

    @Test
    void softAssertionTest() {

        driver.get("https://claruswaysda.github.io/signIn.html");
        driver.findElement(By.id("username")).sendKeys("wrongusername");
        driver.findElement(By.id("password")).sendKeys("wrongpassword", Keys.ENTER);
        String alertText = driver.switchTo().alert().getText();

        //Assert.assertEquals(alertText, "Incorrect username or password");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(alertText, "Incorrect username or password","Messages did not match!");
        softAssert.assertTrue(true,"Condition is false!");
        softAssert.assertEquals(2, 2, "Values did not match!");
        softAssert.assertAll();
        
    }

}
