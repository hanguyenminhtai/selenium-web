package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.ui.SelectEx;
import support.ui.WaitMoreThanOneTab;
import url.Urls;

import java.time.Duration;

public class ExplicitWait {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get(Urls.baseUrl.concat(Urls.loginSlug));

            By taoLaoSel = By.cssSelector("#qer");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
            wait.until(new WaitMoreThanOneTab());
//            wait.until(ExpectedConditions.visibilityOfElementLocated(taoLaoSel));
        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
