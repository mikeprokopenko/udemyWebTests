package com.udemy;

import com.udemy.pages.*;
import config.Utils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.util.Collections;

public class TestBase {

    File chromeDriver = new File("src/main/resources/chromedriver.exe");

        ChromeDriverService chromeService = new ChromeDriverService.Builder()
            .usingDriverExecutable(chromeDriver)
            .usingAnyFreePort()
            .build();

        Cookie cookie = new Cookie.Builder("dj_session_id", "wxb3l0upnarwlorj4iqyk4c6nvg2mk8u")
                .domain("www.udemy.com")
                .path("/")
                .build();


    WebDriver driver;
    WebDriverWait wait;
    Utils utils;
    HeaderMenu headerMenu;
    HomePage homePage;
    LoggedInHeaderMenu loggedInHeaderMenu;
    ProfilePage profilePage;
    SignUpPopup signUpPopup;

    @BeforeTest(description = "Open the browser")
    public void beforeMethod() {

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--lang=en");
        options.addArguments("incognito");

        driver = new ChromeDriver(chromeService, options);
        driver.manage().window().maximize();
        utils = new Utils();
        wait = new WebDriverWait(driver, 15);
        headerMenu = new HeaderMenu(driver, wait);
        homePage = new HomePage(driver, wait, cookie);
        loggedInHeaderMenu = new LoggedInHeaderMenu(driver, wait);
        profilePage = new ProfilePage(driver, wait);
        signUpPopup = new SignUpPopup(driver, wait);

    }

    @AfterTest (description = "Closing the browser")
    public void afterMethod() {

        driver.quit();
    }

}
