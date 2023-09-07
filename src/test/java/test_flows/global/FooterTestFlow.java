package test_flows.global;

import models.components.global.footer.FooterColumnComponent;
import org.openqa.selenium.WebDriver;

public class FooterTestFlow {

    private final WebDriver driver;

    public FooterTestFlow(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyFooterComponent(){
        verifyInfColumn();
        verifyAccountColumn();
    }

    private void verifyInfColumn() {
    }

    private void verifyAccountColumn() {
    }

    private void testFooterColumn(FooterColumnComponent footerColComp) {
        System.out.println(footerColComp.headerElem().getText());
        footerColComp.linksElem().forEach(link -> {
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
        });
    }
}
