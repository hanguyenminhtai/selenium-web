package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormInteraction {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get("https://the-internet.herokuapp.com/login");

            System.out.println(driver.getTitle());
            System.out.printf(driver.getCurrentUrl());

            By usernameSel = By.id("username");
            By passwordSel = By.cssSelector("#password");
            By loginSel = By.cssSelector("[type=\"submit\"]");
            //By poweredByLinkTextSel = By.linkText("Elemental Selenium");
            By poweredByLinkTextSel = By.partialLinkText("Selenium");

            WebElement usernameElem = driver.findElement(usernameSel);
            WebElement passwordElem = driver.findElement(passwordSel);
            WebElement loginElem = driver.findElement(loginSel);
            driver.findElement(poweredByLinkTextSel).click();

            // get attribute value
            System.out.println("Login btt type :" + loginElem.getAttribute("type"));
            System.out.println("Login btt color :" + loginElem.getCssValue("background-color"));

            //Interaction
            usernameElem.sendKeys("tomsmith");
            passwordElem.sendKeys("SuperSecretPassword!");
            loginElem.click();

            //go back pre page
            driver.navigate().back();

            //refresh page
            driver.navigate().refresh();

            //Re-interact with element again
            usernameElem = driver.findElement(usernameSel);
            passwordElem = driver.findElement(passwordSel);
            loginElem = driver.findElement(loginSel);
            usernameElem.sendKeys("adfasdf");
            passwordElem.sendKeys("SupSectPasswo");
            loginElem.click();

            //DEBUG PURPOSE ONLY
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
