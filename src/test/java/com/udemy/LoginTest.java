package com.udemy;

import Config.UserConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test (description = "Login with valid credentials")
    public void loginWithValidCredentials() {

        By loginPopupButtonLocator = By.xpath("//button[@data-purpose='header-login']");
        By loginPopupHeaderLocator = By.xpath("//div[@class='loginbox-v4__header']");
        By emailForLoginFieldLocator = By.id("email--1");
        By passwordForLoginFieldLocator = By.id("id_password");
        By loginButtonInPopupLocator = By.id("submit-id-submit");
        By profileButtonLocator = By.id("header.profile");
        By usernameFieldInProfileLocator = By.xpath("//hgroup[@class='tooltip-container']/h2");
        By logoutButtonInProfileLocator = By.xpath("//a[@data-purpose='do-logout']");

        driver.get("https://www.udemy.com/");

        wait.until(ExpectedConditions.elementToBeClickable(loginPopupButtonLocator));
        WebElement loginPopupButton = driver.findElement(loginPopupButtonLocator);
        loginPopupButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPopupHeaderLocator));
        WebElement loginPopupHeader = driver.findElement(loginPopupHeaderLocator);
        Assert.assertEquals(loginPopupHeader.getText(), "Войдите в учетную запись Udemy!");

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButtonInPopupLocator));
        WebElement emailForLoginField = driver.findElement(emailForLoginFieldLocator);
        emailForLoginField.clear();
        emailForLoginField.sendKeys(UserConfig.userEmailForLogin);

        WebElement passwordForLoginField = driver.findElement(passwordForLoginFieldLocator);
        passwordForLoginField.clear();
        passwordForLoginField.sendKeys(UserConfig.userPasswordForLogin);

        wait.until(ExpectedConditions.elementToBeClickable(loginPopupButtonLocator));
        WebElement loginButtonInPopup = driver.findElement(loginButtonInPopupLocator);
        loginButtonInPopup.click();

        wait.until(ExpectedConditions.elementToBeClickable(profileButtonLocator));
        WebElement profileButton = driver.findElement(profileButtonLocator);
        profileButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameFieldInProfileLocator));
        WebElement usernameFieldInProfile = driver.findElement(usernameFieldInProfileLocator);
        Assert.assertEquals(usernameFieldInProfile.getText(), UserConfig.userNameForLogin);

        WebElement logoutButtonInProfile = driver.findElement(logoutButtonInProfileLocator);
        logoutButtonInProfile.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPopupButtonLocator));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.udemy.com/logout/");
        loginPopupButton = driver.findElement(loginPopupButtonLocator);
        Assert.assertEquals(loginPopupButton.getText(), "Log In");
    }

}
