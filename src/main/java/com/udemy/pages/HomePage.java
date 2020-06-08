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

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    By searchFieldLocator = By.xpath("//input[@data-purpose='home-quick-search-box' or @class='udlite-text-input udlite-text-input-large udlite-text-md udlite-search-form-autocomplete-input']");
    By searchBtnLocator = By.xpath("//button[@data-purpose='home-search-button' or @class='udlite-btn udlite-btn-large udlite-btn-ghost udlite-heading-md udlite-btn-icon udlite-btn-icon-large']");

    public void openHomePage() {
        driver.get("https://www.udemy.com/");
    }

    public void setCookies(Cookie cookie) {
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
