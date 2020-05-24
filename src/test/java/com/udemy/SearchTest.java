package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends TestBase {

    @Test (description = "Search on the HomePage")
    public void searchOnHomePage() {

        homePage.openHomePage();

        homePage.enterKeywordIntoSearchField(utils.getSearchKeyword());

        homePage.clickSearchBtn();

        Assert.assertTrue(searchResultsPage.getSearchResultsTitleText().contains(utils.getSearchKeyword().toLowerCase()));

        Assert.assertFalse(!driver.getCurrentUrl().contains("ref=home"));

        Assert.assertTrue(searchResultsPage.getTitleOfFirstSearchResult().toLowerCase().contains(utils.getSearchKeyword().toLowerCase()));

        Assert.assertEquals(headerMenu.getSearchFieldEnteredValue(), utils.getSearchKeyword());

    }
}
