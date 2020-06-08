package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;

import static testData.UserData.registeredUser;

public class LoginTest extends TestBase {

    @Test (description = "Login by setting cookies")
    public void loginBySettingCookies() {

        homePage.openHomePage();

        Assert.assertEquals(headerMenu.getLoginBtnText(), "Log In");

        homePage.setCookies(cookie);

        loggedInHeaderMenu.openProfilePageViaStandardClick();

        Assert.assertEquals(profilePage.getUsernameInProfile(), registeredUser.getName());

        profilePage.openEditAccountScreen();

        Assert.assertEquals(profilePage.getEmailValueFromEditAccountScreen(), registeredUser.getEmail());
    }
}
