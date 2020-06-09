package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;

import static testData.UserData.registeredUser;

public class LoginTest extends TestBase {

    @Test (description = "Login by setting cookies")
    public void loginBySettingCookies() {

        homePage.openHomePage();

        Assert.assertTrue(headerMenu.getLoginBtnText().contains("Log In") || headerMenu.getLoginBtnText().contains("Log in"));

        homePage.setCookies();

        loggedInHeaderMenu.openProfilePageViaStandardClick();

        Assert.assertEquals(profilePage.getUsernameInProfile(), registeredUser.getName());

        profilePage.openEditAccountScreen();

        Assert.assertEquals(profilePage.getEmailValueFromEditAccountScreen(), registeredUser.getEmail());
    }
}
