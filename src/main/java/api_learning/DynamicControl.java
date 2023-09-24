package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.ui.WaitForElementEnabled;
import url.Urls;

import java.time.Duration;

public class DynamicControl implements Urls {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            //navigate to target base
            driver.get(baseUrl.concat(dynamicControlSlug));

            //define parent locators | checkbox form & input form
            By checkBoxFormSel = By.id("checkbox-example");
            By inputFormSel = By.id("input-example");

            //checkbox form interaction
            WebElement checkBoxFormElem = driver.findElement(checkBoxFormSel);
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            boolean isLocal = System.getenv("isLocal") != null && System.getenv("isLocal").equalsIgnoreCase("true");
            if (isLocal) {
                javascriptExecutor.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 4px solid red;');", checkBoxFormElem);
            }

            Thread.sleep(2000);

            WebElement checkBoxElem = checkBoxFormElem.findElement(By.tagName("input"));
            if (!checkBoxElem.isSelected()) checkBoxElem.click();

            //input form
            WebElement inputFormElem = driver.findElement(inputFormSel);
            WebElement inputFieldElem = inputFormElem.findElement(By.tagName("input"));
            WebElement inputBtnElem = inputFormElem.findElement(By.tagName("button"));
            if (!inputFieldElem.isEnabled()) inputBtnElem.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));
            wait.until(new WaitForElementEnabled(By.cssSelector("#input-example input")));

            inputFieldElem.sendKeys("Toi la ban ban cung la toi!!!");

            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
