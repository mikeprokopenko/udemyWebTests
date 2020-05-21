package com.udemy;

import com.udemy.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest extends TestBase {

    HomePage homePage = new HomePage(driver, wait, cookie);
    HeaderMenu headerMenu = new HeaderMenu(driver, wait);
    SignUpPopup signUpPopup = new SignUpPopup(driver, wait);
    LoggedInHeaderMenu loggedInHeaderMenu = new LoggedInHeaderMenu(driver, wait, builder);
    ProfilePage profilePage = new ProfilePage(driver, wait);


    @Test(description = "Sign Up with valid credential")
    public void signUpWithValidCredentials() {

        homePage.openHomePage();

        Assert.assertEquals(headerMenu.getSignUpPopupBtnTitle(), "Sign Up");

        headerMenu.openSignUpPopup();

        Assert.assertEquals(signUpPopup.getPopupHeaderText(), "Sign Up and Start Learning!");

        signUpPopup.enterNameIntoField(utils.getUSER_NAME_FOR_SIGN_UP());

        signUpPopup.enterEmailIntoField(utils.getUSER_EMAIL_FOR_SIGN_UP());

        signUpPopup.enterPWIntoField(utils.getUSER_PW_FOR_SIGN_UP());

        signUpPopup.clickSignUpBtn();

        loggedInHeaderMenu.openProfilePage();

        Assert.assertEquals(profilePage.getUsernameInProfile(), utils.getUSER_NAME_FOR_SIGN_UP());

        profilePage.clickCloseAccountLinkInProfile();

        Assert.assertEquals(profilePage.getCloseAccountScreenTitle(), "Close Account");

        profilePage.clickCloseAccountPopupBtn();

        Assert.assertEquals(profilePage.getCloseAccountPopupTitle(), "CLOSE YOUR ACCOUNT?");

        profilePage.enterPWInCloseAccountPopup(utils.getUSER_PW_FOR_SIGN_UP());

        profilePage.clickCloseAccountBtnAfterEnteringPW();

        Assert.assertEquals(headerMenu.getSignUpPopupBtnTitle(), "Sign Up");

    }
}
