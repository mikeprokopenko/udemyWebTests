package com.udemy;

import Config.UserConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test (description = "Login with valid credentials")
    public void loginWithValidCredentials() {

        By loginPopupButtonLocator = By.xpath("//button[@data-purpose='header-login']");

        driver.get("https://www.udemy.com/");

        wait.until(ExpectedConditions.elementToBeClickable(loginPopupButtonLocator));
        WebElement loginPopupButton = driver.findElement(loginPopupButtonLocator);
        loginPopupButton.click();



    }

}
