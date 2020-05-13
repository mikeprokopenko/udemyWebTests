package com.udemy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;

public class TestBase {

    File chromeDriver = new File("src/main/resources/chromedriver.exe");
    ChromeDriverService chromeService = new ChromeDriverService.Builder()
            .usingDriverExecutable(chromeDriver)
            .usingAnyFreePort()
            .build();

    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest(description = "Open the browser")
    public void beforeMethod() {

        driver = new ChromeDriver(chromeService);

        wait = new WebDriverWait(driver, 5);
    }

    @AfterTest (description = "Closing the browser")
    public void afterMethod() {

        driver.quit();
    }

}