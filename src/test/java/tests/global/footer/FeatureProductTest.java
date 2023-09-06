package tests.global.footer;

import driver.DriverFactory;
import models.components.global.footer.*;
import models.components.product.ProductItemComponent;
import models.pages.HomePage;
import org.openqa.selenium.WebDriver;
import url.Urls;

import java.util.List;

public class FeatureProductTest {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            testFeaturedProductHomePage(driver);
        }catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();
    }

    private static void testFeaturedProductHomePage(WebDriver driver) {
        driver.get(Urls.demoBaseUrl);
        HomePage homePage = new HomePage(driver);
        List<ProductItemComponent> productItemComps = homePage.productGridComp().productItemComp();
        productItemComps.forEach(productItemComp -> System.out.println(productItemComp.productTitleElem().getText()));
    }
}
