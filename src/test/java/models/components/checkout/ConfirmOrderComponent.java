package models.components.checkout;

import models.components.Component;
import models.components.ComponentCssSel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSel("#opc-confirm_order")
public class ConfirmOrderComponent extends Component {

    public ConfirmOrderComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
}
