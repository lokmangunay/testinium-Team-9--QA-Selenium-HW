package com.selenium.page;

import com.selenium.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By emailLocator = By.xpath("//input[@id='login-email']");
    private By passwordLocator = By.id("login-password-input");
    private By logInButtonLocator = By.className("submit");

    public void logInMethod(String email, String password) {

        click(emailLocator);
        type(emailLocator, email);
        click(passwordLocator);
        type(passwordLocator, password);
        click(logInButtonLocator);
    }

}
