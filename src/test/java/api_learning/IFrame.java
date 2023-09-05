package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import url.Urls;

public class IFrame implements Urls {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get(baseUrl.concat(iframeSlug));

            By iFrameSel = By.cssSelector("[id$='ifr']");
            WebElement iFrameElem = driver.findElement(iFrameSel);

            driver.switchTo().frame(iFrameElem);

            WebElement editorInputElem = driver.findElement(By.id("tinymce"));
            editorInputElem.click();
            editorInputElem.clear();
            editorInputElem.sendKeys("new text..");
            Thread.sleep(2000);

            //Switch back parent frame
            driver.switchTo().defaultContent();
            driver.findElement(By.partialLinkText("Selenium")).click();
        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
