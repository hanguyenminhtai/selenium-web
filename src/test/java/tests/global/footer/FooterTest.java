package tests.global.footer;

import driver.DriverFactory;
import models.components.global.footer.FooterColumnComponent;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import test_flows.global.FooterTestFlow;
import url.Urls;

public class FooterTest {

    @Test(priority = 1, dependsOnMethods = {"testFooterRegisterPage"})
    public void testFooterCategoryPage() {
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get(Urls.demoBaseUrl);
        FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
        footerTestFlow.verifyFooterComponent();
    }

    @Test(priority = 2)
    public void testFooterRegisterPage() {
        String actual = "qwer";
        String expected = "dfdsf";
//        Verifier.verifyEquals(actual, expected);

        // Hard assertion
        Assert.assertEquals(actual, expected, "[ERR] Welcome message is incorrect!");
        Assert.assertTrue(actual.equals(expected), "......");
        Assert.assertFalse(actual.equals(expected), "......");
        Assert.fail();
        Assert.fail("......");
    }

    @Test(priority = 3)
    public void testFooterLoginPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(1, 2);
        softAssert.assertEquals(true, true);
        softAssert.assertEquals(3, 2);

        softAssert.assertAll(); // won't print Hello

        System.out.println("Hello");
    }


    private static void testFooterColumn(FooterColumnComponent footerColComp) {
        System.out.println(footerColComp.headerElem().getText());
        footerColComp.linksElem().forEach(link -> {
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
        });
    }
}