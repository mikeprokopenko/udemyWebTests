package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    By usernameValueInProfileLocator = By.xpath("//hgroup[@class='tooltip-container']/h2");
    By closeAccountLinkInProfileLocator = By.xpath("(//div[@class='side-nav db-sm']/ul/li)[last()]/a");
    By closeAccountScreenTitleLocator = By.xpath("//div[@class='form-wrapper']/h2");
    By closeAccountPopupBtnLocator = By.xpath("//button[@data-purpose='delete-account-popup-opener']");
    By closeAccountPopupTitleLocator = By.xpath("//div[@class='modal-header']/h4");
    By passwordFieldInCloseAccountPopupLocator = By.id("id_password");
    By closeAccountBtnAfterEnteringPWLocator = By.id("submit-id-submit");
    By userEditAccountLinkLocator = By.xpath("//a[@data-purpose='user_manage:edit-account']");
    By emailFieldInEditAccountScreenLocator = By.xpath("//div[@class='form-control ']/b");

    public String getUsernameInProfile() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameValueInProfileLocator));
        WebElement usernameValueInProfile = driver.findElement(usernameValueInProfileLocator);
        return usernameValueInProfile.getText();
    }

    public void clickCloseAccountLinkInProfile() {
        wait.until(ExpectedConditions.elementToBeClickable(closeAccountLinkInProfileLocator));
        WebElement closeAccountLinkInProfile = driver.findElement(closeAccountLinkInProfileLocator);
        closeAccountLinkInProfile.click();
    }

    public String getCloseAccountScreenTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(closeAccountScreenTitleLocator));
        WebElement closeAccountScreenTitle = driver.findElement(closeAccountScreenTitleLocator);
        return closeAccountScreenTitle.getText();
    }

    public void clickCloseAccountPopupBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(closeAccountPopupBtnLocator));
        WebElement closeAccountPopupBtn = driver.findElement(closeAccountPopupBtnLocator);
        closeAccountPopupBtn.click();
    }

    public String getCloseAccountPopupTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(closeAccountPopupTitleLocator));
        WebElement closeAccountPopupTitle = driver.findElement(closeAccountPopupTitleLocator);
        return closeAccountPopupTitle.getText();
    }

    public ProfilePage enterPWInCloseAccountPopup(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(passwordFieldInCloseAccountPopupLocator));
        WebElement passwordFieldInCloseAccountPopup = driver.findElement(passwordFieldInCloseAccountPopupLocator);
        passwordFieldInCloseAccountPopup.clear();
        passwordFieldInCloseAccountPopup.sendKeys(password);
        return this;
    }

    public void clickCloseAccountBtnAfterEnteringPW() {
        wait.until(ExpectedConditions.elementToBeClickable(closeAccountBtnAfterEnteringPWLocator));
        WebElement closeAccountBtnAfterEnteringPW = driver.findElement(closeAccountBtnAfterEnteringPWLocator);
        closeAccountBtnAfterEnteringPW.click();
    }

    public void openEditAccountScreen() {
        wait.until(ExpectedConditions.elementToBeClickable(userEditAccountLinkLocator));
        WebElement userEditAccountLink = driver.findElement(userEditAccountLinkLocator);
        userEditAccountLink.click();
    }

    public String getEmailValueFromEditAccountScreen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailFieldInEditAccountScreenLocator));
        WebElement emailFieldInEditProfileScreen = driver.findElement(emailFieldInEditAccountScreenLocator);
        return emailFieldInEditProfileScreen.getText();
    }
}
