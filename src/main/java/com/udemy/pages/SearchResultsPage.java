package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {

    private final WebDriverWait wait;

    public SearchResultsPage(WebDriver driver, WebDriverWait wait) {
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[@class='udlite-heading-xxl']")
    private WebElement searchResultsTitle;

    @FindBy(xpath = "(//div[@class='course-list--container--3zXPS']//div[contains(@class, 'udlite-heading')])[1]")
    private WebElement firstSearchResultTitle;

    By searchResultsTitleLocator = By.xpath("//h1[@class='udlite-heading-xxl']");
    By firstSearchResultTitleLocator = By.xpath("(//div[@class='course-list--container--3zXPS']//div[contains(@class, 'udlite-heading')])[1]");

    public String getSearchResultsTitleText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultsTitleLocator));
        return searchResultsTitle.getText();
    }

    public String getTitleOfFirstSearchResult() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstSearchResultTitleLocator));
        return firstSearchResultTitle.getText();
    }
}
