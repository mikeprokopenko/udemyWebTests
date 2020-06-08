package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;

import static testData.UserData.newUser;

public class SignUpTest extends TestBase {

    @Test(description = "Sign Up with valid credential")
    public void signUpWithValidCredentials() {

        homePage.openHomePage();

        Assert.assertEquals(headerMenu.getSignUpPopupBtnTitle(), "Sign Up");

        headerMenu.openSignUpPopup();

        Assert.assertEquals(signUpPopup.getPopupHeaderText(), "Sign Up and Start Learning!");

        signUpPopup
                .enterNameIntoField(newUser.getName())
                .enterEmailIntoField(newUser.getEmail())
                .enterPWIntoField(newUser.getPassword())
                .clickSignUpBtn();

//        loggedInHeaderMenu.openProfilePageViaStandardClick();
        loggedInHeaderMenu.openProfilePageViaActionBuilder();
//        loggedInHeaderMenu.openProfilePageViaJSE();

        Assert.assertEquals(profilePage.getUsernameInProfile(), newUser.getName());

        profilePage.clickCloseAccountLinkInProfile();

        Assert.assertEquals(profilePage.getCloseAccountScreenTitle(), "Close Account");

        profilePage.clickCloseAccountPopupBtn();

        Assert.assertEquals(profilePage.getCloseAccountPopupTitle(), "CLOSE YOUR ACCOUNT?");

        profilePage
                .enterPWInCloseAccountPopup(newUser.getPassword())
                .clickCloseAccountBtnAfterEnteringPW();

        Assert.assertEquals(headerMenu.getSignUpPopupBtnTitle(), "Sign Up");

    }
}
