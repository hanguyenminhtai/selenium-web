package models.components;

import org.openqa.selenium.WebDriver;

public class InternalLoginPage extends LoginPage {

    public InternalLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected String usernameLocator() {
        return "InternalLoginPage | usernameLocator";
    }

    @Override
    protected String passwordLocator() {
        return "InternalLoginPage | passwordLocator";
    }

    @Override
    protected String loginButtonLocator() {
        return "InternalLoginPage | loginButtonLocator";
    }
}
