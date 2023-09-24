package models.components.global.footer;

import models.components.Component;
import models.components.ComponentCssSel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSel(value = ".footer")
public class FooterComponent extends Component {

    public FooterComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public InfColumnComponent infColumnComp(){
        return findComponent(InfColumnComponent.class, driver);
    }

    public CustomerSerColumnComponent customerSerColumnComp(){
        return findComponent(CustomerSerColumnComponent.class, driver);
    }

    public AccountColumnComponent accountColumnComp(){
        return findComponent(AccountColumnComponent.class, driver);
    }

    public FollowUsColumnComponent followUsColumnComp(){
        return findComponent(FollowUsColumnComponent.class, driver);
    }
}
