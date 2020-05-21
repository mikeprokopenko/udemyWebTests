package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderMenu {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public HeaderMenu(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    By signUpPopUpBtnLocator = By.xpath("//button[@data-purpose='header-signup']");

    public String getSignUpPopupBtnTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signUpPopUpBtnLocator));
        WebElement signUpPopupBtn = driver.findElement(signUpPopUpBtnLocator);
        return signUpPopupBtn.getText();
    }

    public void openSignUpPopup() {
        wait.until(ExpectedConditions.elementToBeClickable(signUpPopUpBtnLocator));
        WebElement signUpPopupBtn = driver.findElement(signUpPopUpBtnLocator);
        signUpPopupBtn.click();
    }
}
