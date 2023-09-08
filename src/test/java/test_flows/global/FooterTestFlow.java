package test_flows.global;

import models.components.global.TopMenuComponent;
import static models.components.global.TopMenuComponent.MainCatItemComponent;
import static models.components.global.TopMenuComponent.CatItemComponent;
import models.components.global.footer.FooterColumnComponent;
import models.components.global.footer.FooterComponent;
import models.pages.BasePage;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import url.Urls;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FooterTestFlow {

    private final WebDriver driver;

    public FooterTestFlow(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyFooterComponent() {
        BasePage basePage = new BasePage(driver);
        FooterComponent footerComponent = basePage.footerComp();
        verifyInfColumn(footerComponent.infColumnComp());
        //verifyAccountColumn(footerComponent.accountColumnComp());
    }

    private void verifyInfColumn(FooterColumnComponent footerColumnComp) {
        String baseUrl = Urls.demoBaseUrl;
        List<String> expectedLinkTexts = Arrays.asList(
                "Sitemap", "Shipping & Returns", "Privacy Notice", "Conditions of Use",
                "About us", "Contact us");
        List<String> expectedHrefs = Arrays.asList(
                baseUrl + "/sitemap", baseUrl + "/shipping-returns", baseUrl + "/privacy-policy", baseUrl + "/conditions-of-use",
                baseUrl + "/about-us", baseUrl + "/contactus");
        verifyFooterColumn(footerColumnComp, expectedLinkTexts, expectedHrefs);
    }

    private void verifyAccountColumn(FooterColumnComponent footerColumnComp) {
        List<String> expectedLinkTexts = new ArrayList<>();
        List<String> expectedHrefs = new ArrayList<>();
        verifyFooterColumn(footerColumnComp, expectedLinkTexts, expectedHrefs);
    }

    public void verifyProductCatFooterComponent(){
        //random pickup item
        BasePage basePage =new BasePage(driver);
        TopMenuComponent topMenuComp = basePage.topMenuComp();
        List<MainCatItemComponent> mainCatCompsElem = topMenuComp.mainItemsElem();
        if(mainCatCompsElem.isEmpty()) Assert.fail("[ERR] There is no item on top menu!");

        MainCatItemComponent randomMainItemCompElem = mainCatCompsElem.get(new SecureRandom().nextInt(mainCatCompsElem.size()));
        String randomCatHref = randomMainItemCompElem.catItemLinkElem().getAttribute("href");

        //get sublist
        List<CatItemComponent> catItemComps = randomMainItemCompElem.catItemComps();

        if(catItemComps.isEmpty()) randomMainItemCompElem.catItemLinkElem().click();
        else {
            int randomIndex = new SecureRandom().nextInt(catItemComps.size());
            CatItemComponent randomCatItemComp = catItemComps.get(randomIndex);
            randomCatHref = randomCatItemComp.getComponent().getAttribute("href");
            randomCatItemComp.getComponent().click();
        }

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.urlContains(randomCatHref));
        }catch (TimeoutException e){
            Assert.fail("[ERR] Target page is not matched!");
        }

        //verify footer component
        verifyFooterComponent();
    }

    private void verifyFooterColumn(
            FooterColumnComponent footerColComp, List<String> expectedLinkTexts, List<String> expectedHrefs) {

        List<String> actualLinkTexts = new ArrayList<>();
        List<String> actualHrefs = new ArrayList<>();

        for (WebElement link : footerColComp.linksElem()) {
            actualLinkTexts.add(link.getText().trim());
            actualHrefs.add(link.getAttribute("href"));
        }

        if (actualLinkTexts.isEmpty() || actualHrefs.isEmpty()) {
            Assert.fail("[ERR] Texts or hyperlink is empty in footer column!");
        }

        //verify link text
        Assert.assertEquals(actualLinkTexts, expectedLinkTexts, "[ERR] Actual and expected link text different");

        //verify hrefs
        Assert.assertEquals(actualHrefs, expectedHrefs, "[ERR] Actual and expected hyperlinks different");
    }
}

