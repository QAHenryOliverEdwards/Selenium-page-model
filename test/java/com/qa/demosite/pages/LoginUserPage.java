package com.qa.demosite.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginUserPage {

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "FormsButton2")
    private WebElement submit;

    public LoginUserPage(WebDriver driver) {

    }

    public void loginUser(String loginUsername, String loginPassword) {
        username.sendKeys(loginUsername);
        password.sendKeys(loginPassword);
        submit.click();
    }
}
