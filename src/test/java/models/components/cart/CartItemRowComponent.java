package models.components.cart;

import models.components.Component;
import models.components.ComponentCssSel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSel(".cart-item-row")
public class CartItemRowComponent extends Component {

    private static final By unitPriceSel = By.cssSelector(".product-unit-price");
    private static final By quantityInputSel = By.cssSelector(".qty-input");
    private static final By subTotalSel = By.cssSelector(".product-subtotal");

    public CartItemRowComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public double unitPrice() {
        return Double.parseDouble(component.findElement(unitPriceSel).getText().trim());
    }

    public int quantity(){
        return Integer.parseInt(component.findElement(quantityInputSel).getText().trim());
    }

    public double subTotal(){
        return Double.parseDouble(component.findElement(subTotalSel).getText().trim());
    }
}
