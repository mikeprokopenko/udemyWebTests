package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoggedInHeaderMenu {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public LoggedInHeaderMenu(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    By userProfileBtnLocator = By.xpath("//a[@id ='header.profile']");

    public void openProfilePageViaStandardClick() {
        wait.until(ExpectedConditions.elementToBeClickable(userProfileBtnLocator));
        WebElement userProfileDropdown = driver.findElement(userProfileBtnLocator);
        userProfileDropdown.click();
    }

    public void openProfilePageViaActionBuilder() {
        wait.until(ExpectedConditions.elementToBeClickable(userProfileBtnLocator));
        WebElement userProfileDropdown = driver.findElement(userProfileBtnLocator);
        Actions builder = new Actions(driver);
        Action moveToDropdown = builder
                .moveToElement(userProfileDropdown)
                .click(userProfileDropdown)
                .build();
        moveToDropdown.perform();

    }

    public void openProfilePageViaJSE() {
        wait.until(ExpectedConditions.elementToBeClickable(userProfileBtnLocator));
        WebElement userProfileDropdown = driver.findElement(userProfileBtnLocator);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();", userProfileDropdown);
    }
}
