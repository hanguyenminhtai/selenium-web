package models.components.global.footer;

import models.components.ComponentCssSel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSel(value = ".column.follow-us")
public class FollowUsColumnComponent extends FooterColumnComponent{

    public FollowUsColumnComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
}
