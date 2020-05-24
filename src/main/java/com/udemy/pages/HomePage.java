package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    By searchBtnLocator = By.xpath("//button[@data-purpose='home-search-button']");

    public void openHomePage() {
        driver.get("https://www.udemy.com/");
    }

    public void setCookies() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchFieldLocator));
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
    }

    public void enterKeywordIntoSearchField(String keyword) {
        wait.until(ExpectedConditions.elementToBeClickable(searchFieldLocator));
        WebElement searchField = driver.findElement(searchFieldLocator);
        searchField.clear();
        searchField.sendKeys(keyword);
    }

    public void clickSearchBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(searchBtnLocator));
        WebElement searchBtn = driver.findElement(searchBtnLocator);
        searchBtn.click();
    }
}
