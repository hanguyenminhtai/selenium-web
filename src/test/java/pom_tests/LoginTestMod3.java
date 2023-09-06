package pom_tests;

import driver.DriverFactory;
import models.components.LoginFormComponent;
import models.pages.LoginPageMod2;
import models.pages.LoginPageMod3;
import org.openqa.selenium.WebDriver;

public class LoginTestMod3 {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get("https://the-internet.herokuapp.com/login");

            LoginPageMod3 loginPage = new LoginPageMod3(driver);
            LoginFormComponent loginFormComp = loginPage.loginFormComp();
            loginFormComp.inputUsername("gder@gmail.com");
            loginFormComp.inputPassword("dsfef12");
            loginFormComp.clickLoginBtn();

        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }

}
