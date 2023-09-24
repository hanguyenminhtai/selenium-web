package api_learning;

import dev.failsafe.internal.util.Assert;
import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FormInteractionMultipleMatching {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get("https://the-internet.herokuapp.com/login");

            By loginInputFieldsSel = By.tagName("input");

            List<WebElement> loginFormFieldsEml = driver.findElements(loginInputFieldsSel);
            final int USERNAME_INDEX = 0;
            final int PASSWORD_INDEX = 1;
            if(!loginFormFieldsEml.isEmpty()){
                loginFormFieldsEml.get(USERNAME_INDEX).sendKeys("addf@gmail.com");
                loginFormFieldsEml.get(PASSWORD_INDEX).sendKeys("1234qwe");
            }else {
              //  Assert.fail("report");
            }


            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
