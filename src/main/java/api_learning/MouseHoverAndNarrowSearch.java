package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import url.Urls;

import javax.management.relation.RoleInfoNotFoundException;
import javax.swing.*;
import java.util.List;

public class MouseHoverAndNarrowSearch implements Urls {

    private final static By figureSel = By.className("figure");
    private final static By profileNameSel = By.cssSelector(".figcaption h5");
    private final static By profileLinkSel = By.cssSelector(".figcaption a");


    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get(baseUrl.concat(hoverSlug));

            List<WebElement> figuresElem = driver.findElements(figureSel);
            if (figuresElem.isEmpty())
                throw new RuntimeException("There is no profile img displayed");

            //define actions obj
            Actions actions = new Actions(driver);

            for (WebElement figureElem : figuresElem) {
                WebElement profileNameElem = figureElem.findElement(profileNameSel);
                WebElement profileLinkElem = figureElem.findElement(profileLinkSel);

                //before mouse hover
                System.out.println(profileNameElem.getText()+": \n" + profileLinkElem.isDisplayed());
                System.out.println(profileNameElem.getText()+": \n" + profileNameElem.isDisplayed());
                //mouse hover
                actions.moveToElement(figureElem).perform();

                //after mouse hover
                System.out.println(profileNameElem.getText()+": \n" + profileLinkElem.isDisplayed());
                System.out.println(profileNameElem.getText()+": \n" + profileNameElem.isDisplayed());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
