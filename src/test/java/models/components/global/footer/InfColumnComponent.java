package models.components.global.footer;

import models.components.ComponentCssSel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSel(value = ".column.information")
public class InfColumnComponent extends FooterColumnComponent{

    public InfColumnComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
}
