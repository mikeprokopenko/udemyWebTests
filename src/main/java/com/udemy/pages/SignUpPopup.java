package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPopup {

    private final WebDriverWait wait;

    public SignUpPopup(WebDriver driver, WebDriverWait wait) {
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindAll({
            @FindBy(xpath = "//div[@class='loginbox-v4__header loginbox-v4__header--signup']"),
            @FindBy(xpath = "//div[@class=' loginbox-v4__header loginbox-v4__header--signup']")
    })
    private WebElement signUpPopupHeader;

    @FindBy(id = "id_fullname")
    private WebElement fullNameField;

    @FindBy(id = "email--1")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "submit-id-submit")
    private WebElement signUpBtn;

    By signUpPopupHeaderLocator = By.xpath("//div[@class='loginbox-v4__header loginbox-v4__header--signup' or @class=' loginbox-v4__header loginbox-v4__header--signup']");
    By fullNameFieldLocator = By.id("id_fullname");
    By emailFieldLocator = By.id("email--1");
    By passwordFieldLocator = By.id("password");
    By signUpBtnLocator = By.id("submit-id-submit");

    public String getPopupHeaderText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signUpPopupHeaderLocator));
        return signUpPopupHeader.getText();
    }

    public SignUpPopup enterNameIntoField(String name) {
        wait.until(ExpectedConditions.elementToBeClickable(fullNameFieldLocator));
        fullNameField.clear();
        fullNameField.sendKeys(name);
        return this;
    }

    public SignUpPopup enterEmailIntoField(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(emailFieldLocator));
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }

    public SignUpPopup enterPWIntoField(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(passwordFieldLocator));
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    public void clickSignUpBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(signUpBtnLocator));
        signUpBtn.click();
    }
}
