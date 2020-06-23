package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@data-purpose='home-quick-search-box' or @class='udlite-text-input udlite-text-input-small udlite-text-sm udlite-search-form-autocomplete-input js-header-search-field']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@data-purpose='home-search-button' or @class='udlite-btn udlite-btn-large udlite-btn-ghost udlite-heading-md udlite-btn-icon udlite-btn-icon-large']")
    private WebElement searchBtn;

    By searchFieldLocator = By.xpath("//input[@data-purpose='home-quick-search-box' or @class='udlite-text-input udlite-text-input-small udlite-text-sm udlite-search-form-autocomplete-input js-header-search-field']");
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
        searchField.clear();
        searchField.sendKeys(keyword);
    }

    public void clickSearchBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(searchBtnLocator));
        searchBtn.click();
    }
}
