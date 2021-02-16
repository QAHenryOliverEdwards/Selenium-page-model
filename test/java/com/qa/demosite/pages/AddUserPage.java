package com.qa.demosite.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddUserPage {

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "FormsButton2")
    private WebElement submit;

    public AddUserPage(WebDriver webDriver) {
    }

    public void createUser(String inputUser, String inputPassword) {

        username.sendKeys(inputUser);
        password.sendKeys(inputPassword);

        submit.click();
    }
}
