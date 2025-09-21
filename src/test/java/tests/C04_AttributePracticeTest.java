package tests;

import org.testng.annotations.Test;

public class C04_AttributePracticeTest {
    @Test(priority = 1)
    void test01(){
        System.out.println("Test 01");

    }

    @Test(priority =3 ,enabled = false , groups = "smoke")
    void test02() {
        System.out.println("Test 02");
    }

    @Test(priority =2,timeOut = 3000)
    void test03() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Test 03");
    }

    @Test(priority =5, groups = "regression")
    void test04() {
        System.out.println("Test 04");
    }

    @Test(priority = 4, groups = "api",timeOut = 1000)
    void test05() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Test 05");
    }


}
