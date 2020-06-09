package com.udemy;

import com.udemy.pages.*;
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


    WebDriver driver;
    WebDriverWait wait;
    HeaderMenu headerMenu;
    HomePage homePage;
    LoggedInHeaderMenu loggedInHeaderMenu;
    ProfilePage profilePage;
    SignUpPopup signUpPopup;
    SearchResultsPage searchResultsPage;

    @BeforeTest(description = "Open the browser")
    public void beforeMethod() {

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--lang=en");
        options.addArguments("incognito");

        driver = new ChromeDriver(chromeService, options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 15);
        headerMenu = new HeaderMenu(driver, wait);
        homePage = new HomePage(driver, wait);
        loggedInHeaderMenu = new LoggedInHeaderMenu(driver, wait);
        profilePage = new ProfilePage(driver, wait);
        signUpPopup = new SignUpPopup(driver, wait);
        searchResultsPage = new SearchResultsPage(driver, wait);

    }

    @AfterTest (description = "Closing the browser")
    public void afterMethod() {

        driver.quit();
    }

}
