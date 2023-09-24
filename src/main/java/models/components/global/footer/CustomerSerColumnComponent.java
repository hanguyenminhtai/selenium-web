package models.components.global.footer;

import models.components.ComponentCssSel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSel(value = ".column.customer-service")
public class CustomerSerColumnComponent extends FooterColumnComponent{

    public CustomerSerColumnComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
}
