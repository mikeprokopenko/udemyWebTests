package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class HeaderMenu {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public HeaderMenu(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    By signUpPopUpBtnLocator = By.xpath("//div/*[@class='udlite-btn udlite-btn-small udlite-btn-primary udlite-heading-sm' or @data-purpose='header-signup']");
    By loginHeaderBtnLocator = By.xpath("//div/*[@class='udlite-btn udlite-btn-small udlite-btn-secondary udlite-heading-sm' or @data-purpose='header-login']");
    By searchFieldLocator = By.xpath("//input[contains(@id, 'search-form-autocomplete')]");
    By categoriesBtnLocator = By.xpath("//div/*[@data-purpose='browse-courses-link' or @class='header--browse-nav--82GLV popover--popover--t3rNO popover--popover-hover--14ngr']");
    By categoriesDropdownLocator = By.xpath("//div//*[@class='js-browse-nav-level-one browse-nav--nav--1WzbY' or @class='dropdown-menu__list dropdown-menu__list--level-one']");

    public String getSignUpPopupBtnTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signUpPopUpBtnLocator));
        WebElement signUpPopupBtn = driver.findElement(signUpPopUpBtnLocator);
        return signUpPopupBtn.getText();
    }

    public void openSignUpPopup() {
        wait.until(ExpectedConditions.elementToBeClickable(signUpPopUpBtnLocator));
        WebElement signUpPopupBtn = driver.findElement(signUpPopUpBtnLocator);
        signUpPopupBtn.click();
    }

    public String getLoginBtnText() {
        wait.until(ExpectedConditions.elementToBeClickable(loginHeaderBtnLocator));
        WebElement loginHeaderBtn = driver.findElement(loginHeaderBtnLocator);
        return loginHeaderBtn.getText();
    }

    public String getSearchFieldEnteredValue() {
        wait.until(ExpectedConditions.elementToBeClickable(searchFieldLocator));
        WebElement searchField = driver.findElement(searchFieldLocator);
        return searchField.getAttribute("value");
    }

    public void moveToCategoriesDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(categoriesBtnLocator));
        WebElement categoriesDropdown = driver.findElement(categoriesBtnLocator);
        Actions builder = new Actions(driver);
        Action moveToDropdown = builder
                .moveToElement(categoriesDropdown)
                .click(categoriesDropdown)
                .build();
        moveToDropdown.perform();
    }

    public List<String> getMainCategoriesTitles() {

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(categoriesDropdownLocator));
        List<WebElement> mainCategoriesElements = driver.findElements(categoriesDropdownLocator);
        List<String> mainCategoriesTitles = new ArrayList<>();
        for (WebElement oneElement : mainCategoriesElements) {
            mainCategoriesTitles.add(oneElement.getText());
        }
        return mainCategoriesTitles;
    }

}
