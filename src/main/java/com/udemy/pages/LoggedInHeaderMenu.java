package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoggedInHeaderMenu {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public LoggedInHeaderMenu(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindAll({
            @FindBy(xpath = "//a[@id ='header.profile']"),
            @FindBy(xpath = "//a[@aria-label='My profile']")
    })
    private WebElement userProfileDropdown;

    By userProfileBtnLocator = By.xpath("//a[@id ='header.profile' or @aria-label='My profile']");

    public void openProfilePageViaActionBuilder() {
        wait.until(ExpectedConditions.elementToBeClickable(userProfileBtnLocator));
        Actions builder = new Actions(driver);
        Action moveToDropdown = builder
                .moveToElement(userProfileDropdown)
                .pause(1000)
                .click(userProfileDropdown)
                .build();
        moveToDropdown.perform();
    }
}
