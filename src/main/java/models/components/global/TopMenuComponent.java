package models.components.global;

import models.components.Component;
import models.components.ComponentCssSel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.List;

@ComponentCssSel(value = ".top-menu")
public class TopMenuComponent extends Component {

    public TopMenuComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public List<MainCatItemComponent> mainItemsElem() {
        return findComponents(MainCatItemComponent.class, driver);
    }

    @ComponentCssSel(".top-menu > li")
    public static class MainCatItemComponent extends Component {

        public MainCatItemComponent(WebDriver driver, WebElement component) {
            super(driver, component);
        }

        public WebElement catItemLinkElem(){
            return component.findElement(By.tagName("a"));
        }

        public List<SublistComponent> sublistComps(){
            Actions actions = new Actions(driver);
            actions.moveToElement(component).perform();
            return findComponents(SublistComponent.class, driver);
        }
    }

    @ComponentCssSel(".sublist li a")
    public static class SublistComponent extends Component {

        public SublistComponent(WebDriver driver, WebElement component) {
            super(driver, component);
        }
    }

}
