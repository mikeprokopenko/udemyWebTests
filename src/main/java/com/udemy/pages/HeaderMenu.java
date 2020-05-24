package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class HeaderMenu {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public HeaderMenu(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    By signUpPopUpBtnLocator = By.xpath("//button[@data-purpose='header-signup']");
    By loginHeaderBtnLocator = By.xpath("//button[@data-purpose='header-login']");
    By searchFieldLocator = By.xpath("//input[contains(@id, 'search-form-autocomplete')]");
    By categoriesDropdownLocator = By.xpath("//a[@data-purpose='browse-courses-link']");
    By lastCategoryTitleLocator = By.xpath("(//ul[@class='dropdown-menu' and @aria-labelledby='header.browse']//span[@class='fx'])[13]");
    String categoriesTitleTemplateXpath = "(//ul[@class='dropdown-menu' and @aria-labelledby='header.browse']//span[@class='fx'])";

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
        wait.until(ExpectedConditions.elementToBeClickable(categoriesDropdownLocator));
        WebElement categoriesDropdown = driver.findElement(categoriesDropdownLocator);
        Actions builder = new Actions(driver);
        Action moveToDropdown = builder
                .moveToElement(categoriesDropdown)
                .click(categoriesDropdown)
                .build();
        moveToDropdown.perform();
    }

    public ArrayList createArrayListOfCategories() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastCategoryTitleLocator));
        ArrayList<String> categories = new ArrayList<>();
        for (int i = 1; i <= 13; i++) {
            categories.add((driver.findElement(By.xpath(categoriesTitleTemplateXpath + "[" + i + "]"))).getText());
        }
        System.out.println("\n\nCategories Array List:\n" + categories.toString() + "\n\n");
        return categories;
    }


}
