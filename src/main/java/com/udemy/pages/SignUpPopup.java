package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPopup {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public SignUpPopup(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    By signUpPopupHeaderLocator = By.xpath("//div[@class='loginbox-v4__header loginbox-v4__header--signup' or @class=' loginbox-v4__header loginbox-v4__header--signup']");
    By fullNameFieldLocator = By.id("id_fullname");
    By emailFieldLocator = By.id("email--1");
    By passwordFieldLocator = By.id("password");
    By signUpBtnLocator = By.id("submit-id-submit");

    public String getPopupHeaderText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signUpPopupHeaderLocator));
        WebElement signUpPopupHeader = driver.findElement(signUpPopupHeaderLocator);
        return signUpPopupHeader.getText();
    }

    public SignUpPopup enterNameIntoField(String name) {
        wait.until(ExpectedConditions.elementToBeClickable(fullNameFieldLocator));
        WebElement fullNameField = driver.findElement(fullNameFieldLocator);
        fullNameField.clear();
        fullNameField.sendKeys(name);
        return this;
    }

    public SignUpPopup enterEmailIntoField(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(emailFieldLocator));
        WebElement emailField = driver.findElement(emailFieldLocator);
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }

    public SignUpPopup enterPWIntoField(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(passwordFieldLocator));
        WebElement passwordField = driver.findElement(passwordFieldLocator);
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    public void clickSignUpBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(signUpBtnLocator));
        WebElement signUpBtn = driver.findElement(signUpBtnLocator);
        signUpBtn.click();
    }
}
