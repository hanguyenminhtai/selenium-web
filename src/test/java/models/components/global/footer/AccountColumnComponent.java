package models.components.global.footer;

import models.components.ComponentCssSel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSel(value = ".column.my-account")
public class AccountColumnComponent extends FooterColumnComponent{

    public AccountColumnComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
}
