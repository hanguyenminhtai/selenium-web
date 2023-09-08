package tests.testng;

import org.testng.annotations.*;

public class TestNGHook01 {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("\t-->beforeTest");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("\t\t-->beforeClass");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("\t\t\t-->beforeMethod");
    }

    @Test
    public void testSth(){
        System.out.println("\t\t\t\t-->Test");
    }

    @BeforeMethod
    public void afterMethod() {
        System.out.println("\t\t\t-->afterMethod");
    }

    @BeforeClass
    public void afterClass(){
        System.out.println("\t\t-->afterClass");
    }

    @BeforeTest
    public void afterTest(){
        System.out.println("\t-->afterTest");
    }
}
