package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Cookie cookie;

    public HomePage(WebDriver driver, WebDriverWait wait, Cookie cookie) {
        this.driver = driver;
        this.wait = wait;
        this.cookie = cookie;
    }

    By searchFieldLocator = By.id("search-field-home");

    public void openHomePage() {
        driver.get("https://www.udemy.com/");
    }

    public void setCookies() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchFieldLocator));
        driver.manage().addCookie(cookie);
    }
}
