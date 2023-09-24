package models.components.global.header;

import models.components.Component;
import models.components.ComponentCssSel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSel(".header")
public class HeaderComponent extends Component {

    private final static By shoppingCartLinkSel = By.cssSelector("#topcartlink");

    public HeaderComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public void clickOnShoppingCartLink(){
        WebElement shoppingCartLinkElem = component.findElement(shoppingCartLinkSel);
        scrollUpToElem(shoppingCartLinkElem);
        shoppingCartLinkElem.click();
    }
}
