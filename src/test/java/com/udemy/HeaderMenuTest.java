package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;


import static config.BaseConstants.MAIN_CATEGORIES_LIST;

public class HeaderMenuTest extends TestBase {

    @Test (description = "Testing of categories in the \"Categories\" menu")
    public void getCategoriesInMenu() {

        homePage.openHomePage();

        headerMenu.moveToCategoriesDropdown();

        Assert.assertEquals(headerMenu.getMainCategoriesTitles(), MAIN_CATEGORIES_LIST);
    }
}
