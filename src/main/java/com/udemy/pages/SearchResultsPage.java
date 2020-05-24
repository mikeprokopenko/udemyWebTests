package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public SearchResultsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    By searchResultsTitleLocator = By.xpath("//h1[@class='udlite-heading-xxl']");
    By firstSearchResultTitleLocator = By.xpath("(//div[@class='course-list--container--3zXPS']//div[contains(@class, 'udlite-heading')])[1]");

    public String getSearchResultsTitleText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultsTitleLocator));
        WebElement searchResultsTitle = driver.findElement(searchResultsTitleLocator);
        return searchResultsTitle.getText();
    }

    public String getTitleOfFirstSearchResult() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstSearchResultTitleLocator));
        WebElement firstSearchResultTitle = driver.findElement(firstSearchResultTitleLocator);
        return firstSearchResultTitle.getText();
    }
}
