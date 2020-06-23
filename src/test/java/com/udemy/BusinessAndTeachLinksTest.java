package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;

import static config.BaseConstants.*;

public class BusinessAndTeachLinksTest extends TestBase {

    @Test (description = "Testing the Business and Teach links in the header")

    public void checkBusinessAndTeachLinks() {

        homePage.openHomePage();

        headerMenu.clickUdemyForBusinessBtn();

        Assert.assertEquals(headerMenu.getUdemyForBusinessTitleText(), UDEMY_FOR_BUSINESS_TITLE);

        Assert.assertTrue(driver.getCurrentUrl().contains("business.udemy.com"));

        driver.close();

        headerMenu.clickTeachOnUdemyBtn();

        Assert.assertEquals(headerMenu.getTeachOnUdemyTitleText(), TEACH_ON_UDEMY_TITLE);

        Assert.assertTrue(driver.getCurrentUrl().contains("teaching"));
    }
}
