package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderMenuTest extends TestBase {

    @Test (description = "Testing of categories in the \"Categories\" menu")
    public void getCategoriesInMenu() {

        homePage.openHomePage();

        headerMenu.moveToCategoriesDropdown();

        Assert.assertEquals(headerMenu.createArrayListOfCategories(), utils.getARRAY_LIST_HEADER_CATEGORIES());
    }
}
