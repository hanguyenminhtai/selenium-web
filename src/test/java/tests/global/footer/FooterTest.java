package tests.global.footer;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_flows.global.FooterTestFlow;
import tests.BaseTest;
import url.Urls;

public class FooterTest extends BaseTest {

    @Test
    public void testFooterCategoryPage() {
        WebDriver driver = getDriver();
        driver.get(Urls.demoBaseUrl);
        Assert.fail("Demo take screenshot....");
        FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
        footerTestFlow.verifyProductCatFooterComponent();
    }

    @Test
    public void testFooterRegisterPage() {
    }

    @Test
    public void testFooterLoginPage() {
    }

    @Test
    public void testFooterHomePage() {

    }
}