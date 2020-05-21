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

    By userProfileDropdownLocator = By.xpath("//div[@class='dropdown--open-on-hover dropdown--user dropdown--open-on-hover dropdown']");

    public void openProfilePage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userProfileDropdownLocator));
        WebElement userProfileDropdown = driver.findElement(userProfileDropdownLocator);
        Actions builder = new Actions(driver);
        Action clickProfileIcon = builder
                .click(userProfileDropdown)
                .build();
        clickProfileIcon.perform();
    }
}
