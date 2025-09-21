package tests;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class C02_Attributes {
    @Test(priority = 2, dependsOnGroups = "B")
    void test01() {
        System.out.print("Test 01: ");
        System.out.println("This method depends on Group B");
    }

    @Test(groups = "A")
    void test02() {
        System.out.println("Test 02");
    }

    @Test(priority = 4, dependsOnMethods = "test06", description = "This method depends on method 06", groups = "A")
    void test03() {
        System.out.println("Test 03");
    }

    @Test(priority = 1, groups = "B")
    void test04() {
        System.out.println("Test 04");
    }

    @Test(priority = 5, enabled = false)
    void test05() {
        System.out.println("Test 05");
    }

    @Test(priority = 6, timeOut = 1000, groups = "B")//ThreadTimeoutException
    void test06() throws InterruptedException {
        //Thread.sleep(2000);
        System.out.println("Test 06");
    }

    @BeforeGroups(groups = "B")
    void bg(){
        System.out.println("Before group B:");
    }
}
