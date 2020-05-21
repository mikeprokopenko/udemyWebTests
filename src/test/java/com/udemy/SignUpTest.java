package com.udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest extends TestBase {

    @Test(description = "Sign Up with valid credential")
    public void signUpWithValidCredentials() {

        By signUpPopUpButtonLocator = By.xpath("//button[@data-purpose='header-signup']");
        By signUpPopUpHeaderLocator = By.xpath("//div[@class=' loginbox-v4__header loginbox-v4__header--signup']");
        By fullNameFieldLocator = By.id("id_fullname");
        By emailFieldLocator = By.id("email--1");
        By passwordFieldLocator = By.id("password");
        By signUpButtonLocator = By.id("submit-id-submit");
        By profileButtonLocator = By.xpath("//a[@id ='header.profile']");
        By usernameFieldOnProfileLocator = By.xpath("//hgroup[@class='tooltip-container']/h2");
        By closeAccountLinkInProfileLocator = By.xpath("(//div[@class='side-nav db-sm']/ul/li)[last()]/a");
        By closeAccountPopupButtonLocator = By.xpath("//button[@data-purpose='delete-account-popup-opener']");
        By passwordFieldForClosingAccountLocator = By.id("id_password");
        By closeAccountButtonAfterEnteringPWLocator = By.id("submit-id-submit");


        driver.get("https://www.udemy.com/");


        wait.until(ExpectedConditions.elementToBeClickable(signUpPopUpButtonLocator));
        WebElement signUpPopupButton = driver.findElement(signUpPopUpButtonLocator);
        signUpPopupButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(signUpPopUpHeaderLocator));
        WebElement signUpPopupHeader = driver.findElement(signUpPopUpHeaderLocator);
        Assert.assertEquals(signUpPopupHeader.getText(), "Sign Up and Start Learning!");

        wait.until(ExpectedConditions.elementToBeClickable(signUpButtonLocator));
        WebElement fullNameField = driver.findElement(fullNameFieldLocator);
        fullNameField.clear();
        fullNameField.sendKeys(utils.getUSER_NAME_FOR_SIGN_UP());

        WebElement emailField = driver.findElement(emailFieldLocator);
        emailField.clear();
        emailField.sendKeys(utils.getUSER_EMAIL_FOR_SIGN_UP());

        WebElement passwordField = driver.findElement(passwordFieldLocator);
        passwordField.clear();
        passwordField.sendKeys(utils.getUSER_PW_FOR_SIGN_UP());

        WebElement signUpButton = driver.findElement(signUpButtonLocator);
        signUpButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(profileButtonLocator));
        WebElement profileButton = driver.findElement(profileButtonLocator);
        profileButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameFieldOnProfileLocator));
        WebElement usernameFieldOnProfile = driver.findElement(usernameFieldOnProfileLocator);
        Assert.assertEquals(usernameFieldOnProfile.getText(), utils.getUSER_NAME_FOR_SIGN_UP());

        wait.until(ExpectedConditions.elementToBeClickable(closeAccountLinkInProfileLocator));
        WebElement closeAccountLinkInProfile = driver.findElement(closeAccountLinkInProfileLocator);
        closeAccountLinkInProfile.click();

        wait.until(ExpectedConditions.elementToBeClickable(closeAccountPopupButtonLocator));
        WebElement closeAccountPopupButton = driver.findElement(closeAccountPopupButtonLocator);
        closeAccountPopupButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(closeAccountButtonAfterEnteringPWLocator));
        WebElement passwordFieldForClosingAccount = driver.findElement(passwordFieldForClosingAccountLocator);
        passwordFieldForClosingAccount.clear();
        passwordFieldForClosingAccount.sendKeys(utils.getUSER_PW_FOR_SIGN_UP());


        WebElement closeAccountButtonAfterEnteringPW = driver.findElement(closeAccountButtonAfterEnteringPWLocator);
        closeAccountButtonAfterEnteringPW.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(signUpPopUpButtonLocator));
        signUpPopupButton = driver.findElement(signUpPopUpButtonLocator);
        Assert.assertEquals(signUpPopupButton.getText(), "Sign Up");

    }
}
