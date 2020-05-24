package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest extends TestBase {

    @Test(description = "Sign Up with valid credential")
    public void signUpWithValidCredentials() {

        homePage.openHomePage();

        Assert.assertEquals(headerMenu.getSignUpPopupBtnTitle(), "Sign Up");

        headerMenu.openSignUpPopup();

        Assert.assertEquals(signUpPopup.getPopupHeaderText(), "Sign Up and Start Learning!");

        signUpPopup
                .enterNameIntoField(utils.getUSER_NAME_FOR_SIGN_UP())
                .enterEmailIntoField(utils.getUSER_EMAIL_FOR_SIGN_UP())
                .enterPWIntoField(utils.getUSER_PW_FOR_SIGN_UP())
                .clickSignUpBtn();

//        loggedInHeaderMenu.openProfilePageViaStandardClick();
        loggedInHeaderMenu.openProfilePageViaActionBuilder();
//        loggedInHeaderMenu.openProfilePageViaJSE();

        Assert.assertEquals(profilePage.getUsernameInProfile(), utils.getUSER_NAME_FOR_SIGN_UP());

        profilePage.clickCloseAccountLinkInProfile();

        Assert.assertEquals(profilePage.getCloseAccountScreenTitle(), "Close Account");

        profilePage.clickCloseAccountPopupBtn();

        Assert.assertEquals(profilePage.getCloseAccountPopupTitle(), "CLOSE YOUR ACCOUNT?");

        profilePage
                .enterPWInCloseAccountPopup(utils.getUSER_PW_FOR_SIGN_UP())
                .clickCloseAccountBtnAfterEnteringPW();

        Assert.assertEquals(headerMenu.getSignUpPopupBtnTitle(), "Sign Up");

    }
}
