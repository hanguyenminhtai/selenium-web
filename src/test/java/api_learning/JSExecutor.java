package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import url.Urls;

public class JSExecutor implements Urls {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get(baseUrl.concat(floatingMenuSlug));

            //scroll to bottom
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");

            Thread.sleep(1000);

            //scroll to top
            javascriptExecutor.executeScript("window.scrollTo(document.body.scrollHeight, 0);");

            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }

}
