package models.components.checkout;

import models.components.Component;
import models.components.ComponentCssSel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSel("#opc-payment_info")
public class PaymentInfoComponent extends Component {

    public PaymentInfoComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
}
