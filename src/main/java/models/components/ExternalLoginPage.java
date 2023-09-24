package models.components;

import org.openqa.selenium.WebDriver;

public class ExternalLoginPage extends LoginPage {

    public ExternalLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected String usernameLocator() {
        return "ExternalLoginPage | usernameLocator";
    }

    @Override
    protected String passwordLocator() {
        return "ExternalLoginPage | passwordLocator";
    }

    @Override
    protected String loginButtonLocator() {
        return "ExternalLoginPage | loginButtonLocator";
    }
}
