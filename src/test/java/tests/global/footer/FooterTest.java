package tests.global.footer;

import driver.DriverFactory;
import models.components.global.footer.*;
import models.pages.HomePage;
import org.openqa.selenium.WebDriver;
import url.Urls;

public class FooterTest {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            testFooterHomePage(driver);
            testFooterCategoryPage(driver);
            testFooterRegisterPage(driver);
            testFooterLoginPage(driver);
        }catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();
    }

    private static void testFooterHomePage(WebDriver driver) {
        driver.get(Urls.demoBaseUrl);
        HomePage homePage = new HomePage(driver);
        InfColumnComponent infColumnComp = homePage.footerComp().infColumnComp();

        CustomerSerColumnComponent customerSerColumnComp = homePage.footerComp().customerSerColumnComp();

        FollowUsColumnComponent followUsColumnComp = homePage.footerComp().followUsColumnComp();

        AccountColumnComponent accountColumnComp = homePage.footerComp().accountColumnComp();

        testFooterColumn(infColumnComp);
        testFooterColumn(customerSerColumnComp);
        testFooterColumn(followUsColumnComp);
        testFooterColumn(accountColumnComp);
    }

    private static void testFooterCategoryPage(WebDriver driver) {
    }

    private static void testFooterRegisterPage(WebDriver driver) {
    }

    private static void testFooterLoginPage(WebDriver driver) {
    }

    private static void testFooterColumn(FooterColumnComponent footerColumnComponent){
        System.out.println(footerColumnComponent.headerElem().getText());
        footerColumnComponent.linksElem().forEach(link -> {
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
        });
    }

}
