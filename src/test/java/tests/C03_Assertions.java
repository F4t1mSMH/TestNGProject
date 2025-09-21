package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C03_Assertions {

    @Test
    void hardAssertionTest() {

        Assert.assertEquals(5, 5);
        System.out.println("-------------");

        Assert.assertTrue(false);
        System.out.println("**************");//This line will not be executed.

    }

    @Test
    void softAssertionTest() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(15, 5);
        System.out.println("-------------");

        softAssert.assertTrue(false);
        System.out.println("**************");//This line will not be executed.

        softAssert.assertAll();
        System.out.println("=============");
    }


}
