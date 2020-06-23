package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {

    private final WebDriverWait wait;

    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//hgroup[@class='tooltip-container']/h2")
    private WebElement usernameValueInProfile;

    @FindBy(xpath = "(//div[@class='side-nav db-sm']/ul/li)[last()]/a")
    private WebElement closeAccountLinkInProfile;

    @FindBy(xpath = "//div[@class='form-wrapper']/h2")
    private WebElement closeAccountScreenTitle;

    @FindBy(xpath = "//button[@data-purpose='delete-account-popup-opener']")
    private WebElement closeAccountPopupBtn;

    @FindBy(xpath = "//div[@class='modal-header']/h4")
    private WebElement closeAccountPopupTitle;

    @FindBy(id = "id_password")
    private WebElement passwordFieldInCloseAccountPopup;

    @FindBy(id = "submit-id-submit")
    private WebElement closeAccountBtnAfterEnteringPW;

    @FindBy(xpath = "//a[@data-purpose='user_manage:edit-account']")
    private WebElement userEditAccountLink;

    @FindBy(xpath = "//div[@class='form-control ']/b")
    private WebElement emailFieldInEditProfileScreen;

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
        return usernameValueInProfile.getText();
    }

    public void clickCloseAccountLinkInProfile() {
        wait.until(ExpectedConditions.elementToBeClickable(closeAccountLinkInProfileLocator));
        closeAccountLinkInProfile.click();
    }

    public String getCloseAccountScreenTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(closeAccountScreenTitleLocator));
        return closeAccountScreenTitle.getText();
    }

    public void clickCloseAccountPopupBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(closeAccountPopupBtnLocator));
        closeAccountPopupBtn.click();
    }

    public String getCloseAccountPopupTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(closeAccountPopupTitleLocator));
        return closeAccountPopupTitle.getText();
    }

    public ProfilePage enterPWInCloseAccountPopup(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(passwordFieldInCloseAccountPopupLocator));
        passwordFieldInCloseAccountPopup.clear();
        passwordFieldInCloseAccountPopup.sendKeys(password);
        return this;
    }

    public void clickCloseAccountBtnAfterEnteringPW() {
        wait.until(ExpectedConditions.elementToBeClickable(closeAccountBtnAfterEnteringPWLocator));
        closeAccountBtnAfterEnteringPW.click();
    }

    public void openEditAccountScreen() {
        wait.until(ExpectedConditions.elementToBeClickable(userEditAccountLinkLocator));
        userEditAccountLink.click();
    }

    public String getEmailValueFromEditAccountScreen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailFieldInEditAccountScreenLocator));
        return emailFieldInEditProfileScreen.getText();
    }
}
