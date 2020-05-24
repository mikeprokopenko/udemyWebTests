package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test (description = "Login by setting cookies")
    public void loginBySettingCookies() {

        homePage.openHomePage();

        Assert.assertEquals(headerMenu.getLoginBtnText(), "Log In");

        homePage.setCookies();

        loggedInHeaderMenu.openProfilePageViaStandardClick();

        Assert.assertEquals(profilePage.getUsernameInProfile(), utils.getUSER_NAME_FOR_LOGIN());

        profilePage.openEditAccountScreen();

        Assert.assertEquals(profilePage.getEmailValueFromEditAccountScreen(), utils.getUSER_EMAIL_FOR_LOGIN());
    }
}
