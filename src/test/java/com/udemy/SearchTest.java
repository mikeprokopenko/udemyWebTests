package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;

import static config.BaseConstants.SEARCH_KEYWORD;

public class SearchTest extends TestBase {

    @Test (description = "Search on the HomePage")
    public void searchOnHomePage() {

        homePage.openHomePage();

        homePage.enterKeywordIntoSearchField(SEARCH_KEYWORD);

        homePage.clickSearchBtn();

        Assert.assertTrue(searchResultsPage.getSearchResultsTitleText().contains(SEARCH_KEYWORD.toLowerCase()));

        Assert.assertTrue(driver.getCurrentUrl().contains("q=" + SEARCH_KEYWORD));

        Assert.assertTrue(searchResultsPage.getTitleOfFirstSearchResult().toLowerCase().contains(SEARCH_KEYWORD.toLowerCase()));

        Assert.assertEquals(headerMenu.getSearchFieldEnteredValue(), SEARCH_KEYWORD);

    }
}
