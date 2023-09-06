package pom_tests;

import driver.DriverFactory;
import models.pages.LoginPageMod1;
import models.pages.LoginPageMod2;
import org.openqa.selenium.WebDriver;

public class LoginTestMod2 {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get("https://the-internet.herokuapp.com/login");

            LoginPageMod2 loginPage = new LoginPageMod2(driver);
            loginPage.inputUsername("gder@gmail.com");
            loginPage.inputPassword("dsfef12");
            loginPage.clickLoginBtn();

        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }

}
