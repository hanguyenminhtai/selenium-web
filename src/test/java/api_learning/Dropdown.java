package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.ui.SelectEx;
import url.Urls;

public class Dropdown implements Urls {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get(baseUrl.concat(dropdownSlug));

            //dropdown locator and element
            By dropdownSel = By.id("dropdown");
            WebElement dropdownElem = driver.findElement(dropdownSel);

            //select dropdown
            SelectEx select = new SelectEx(dropdownElem);

            //select by visible text op1
            select.selectOption1();
            Thread.sleep(1000);

            //select by index op2
            select.selectByIndex(2);
            Thread.sleep(1000);

            //select by value op1
            select.selectByValue("1");
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
