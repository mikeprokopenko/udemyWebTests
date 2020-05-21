package com.udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test (description = "Login by setting cookies")
    public void loginBySettingCookies() {

        By loginHeaderButtonLocator = By.xpath("//button[@data-purpose='header-login']");
        By profileButtonLocator = By.xpath("//a[@id ='header.profile']");
        By usernameFieldInProfileLocator = By.xpath("//hgroup[@class='tooltip-container']/h2");
        By accountProfileLinkLocator = By.xpath("//a[@data-purpose='user_manage:edit-account']");
        By emailFieldInProfileLocator = By.xpath("//div[@class='form-control ']/b");

        driver.get("https://www.udemy.com/");

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginHeaderButtonLocator));
        WebElement loginHeaderButton = driver.findElement(loginHeaderButtonLocator);
        Assert.assertEquals(loginHeaderButton.getText(), "Log In");

        driver.manage().addCookie(cookie);

        driver.navigate().refresh();

        wait.until(ExpectedConditions.elementToBeClickable(profileButtonLocator));
        WebElement profileButton = driver.findElement(profileButtonLocator);
        profileButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameFieldInProfileLocator));
        WebElement usernameFieldInProfile = driver.findElement(usernameFieldInProfileLocator);
        Assert.assertEquals(usernameFieldInProfile.getText(), utils.getUSER_NAME_FOR_LOGIN());

        wait.until(ExpectedConditions.elementToBeClickable(accountProfileLinkLocator));
        WebElement accountProfileLink = driver.findElement(accountProfileLinkLocator);
        accountProfileLink.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(emailFieldInProfileLocator));
        WebElement emailFieldInProfile = driver.findElement(emailFieldInProfileLocator);
        Assert.assertEquals(emailFieldInProfile.getText(), utils.getUSER_EMAIL_FOR_LOGIN());
    }

}
