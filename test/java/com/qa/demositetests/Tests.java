package com.qa.demositetests;

import com.qa.demosite.DemoPagePortal;
import com.qa.demosite.pages.AddUserPage;
import com.qa.demosite.pages.LoginUserPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {

    private static WebDriver driver;
    private static WebElement target;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/drivers/chrome/chromedriver.exe");

        driver = new ChromeDriver();
    }

    @AfterAll
    public static void cleanup() {
        driver.quit();
    }

    @Test
    public void test() {
        driver.get("http://thedemosite.co.uk/index.php");

        DemoPagePortal website = PageFactory.initElements(driver, DemoPagePortal.class);
        AddUserPage addUserPage = PageFactory.initElements(driver, AddUserPage.class);
        LoginUserPage loginUserPage = PageFactory.initElements(driver, LoginUserPage.class);

        website.addUser();

        addUserPage.createUser("guest", "guest");

        website.loginUser();

        loginUserPage.loginUser("guest", "guest");

        String success = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")).getText();

        assertEquals("**Successful Login**", success);

    }
}
