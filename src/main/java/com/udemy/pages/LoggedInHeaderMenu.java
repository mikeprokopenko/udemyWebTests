package com.udemy.pages;

import org.openqa.selenium.By;
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

    By userProfileDropdownLocator = By.xpath("//div[@data-purpose='user-avatar']");
    By profileLinkInDropdownLocator = By.xpath("//a[@data-purpose='edit-profile']");

    public void openProfilePage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userProfileDropdownLocator));
        WebElement userProfileDropdown = driver.findElement(userProfileDropdownLocator);
        Actions builder = new Actions(driver);
        Action moveMouseOnUserDropdown = builder
                .moveToElement(userProfileDropdown)
                .build();
        moveMouseOnUserDropdown.perform();
        wait.until(ExpectedConditions.elementToBeClickable(profileLinkInDropdownLocator));
        WebElement profileLinkInDropdown = driver.findElement(profileLinkInDropdownLocator);
        Action moveAndClickProfileLink = builder
                .moveToElement(profileLinkInDropdown)
                .click(profileLinkInDropdown)
                .build();
        moveAndClickProfileLink.perform();
    }
}
