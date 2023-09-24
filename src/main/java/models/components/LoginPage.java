package models.components;

import org.openqa.selenium.WebDriver;

public abstract class LoginPage {

    protected WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    protected void login() {
        System.out.println(usernameLocator());
        System.out.println(passwordLocator());
        System.out.println(loginButtonLocator());
    }

    protected abstract String usernameLocator();
    protected abstract String passwordLocator();
    protected abstract String loginButtonLocator();
}
