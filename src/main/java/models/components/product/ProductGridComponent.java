package models.components.product;

import models.components.Component;
import models.components.ComponentCssSel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@ComponentCssSel(value = ".product-grid")
public class ProductGridComponent extends Component {

    public ProductGridComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public List<ProductItemComponent> productItemComp(){
        return findComponents(ProductItemComponent.class, driver);
    }
}
