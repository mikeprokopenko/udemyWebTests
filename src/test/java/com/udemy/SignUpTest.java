package com.udemy;

import Config.UserConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class SignUpTest {

    @Test(description = "Sign Up with valid credential")
    public void signUpWithValidCredentials() {
        File chromeDriver = new File("src/main/resources/chromedriver.exe");
        ChromeDriverService chromeService = new ChromeDriverService.Builder()
                .usingDriverExecutable(chromeDriver)
                .usingAnyFreePort()
                .build();

        WebDriver driver = new ChromeDriver(chromeService);

        driver.get("https://www.udemy.com/");
        pause(2000);

        WebElement signUpPopupButton = driver.findElement(
                By.xpath("//button[@data-purpose='header-signup']"));
        signUpPopupButton.click();
        pause(1000);

        WebElement signUpPopupHeader = driver.findElement(
                By.xpath("//div[@class=' loginbox-v4__header loginbox-v4__header--signup']"));
        Assert.assertEquals(signUpPopupHeader.getText(), "Зарегистрируйтесь и начните обучение!");
        pause(1000);

        WebElement fullNameField = driver.findElement(
                By.xpath("//input[@id='id_fullname']"));
        fullNameField.clear();
        fullNameField.sendKeys(UserConfig.userName);
        pause(1000);

        WebElement emailField = driver.findElement(
                By.xpath("//input[@id='email--1']"));
        emailField.clear();
        emailField.sendKeys(UserConfig.userEmail);
        pause(1000);

        WebElement passwordField = driver.findElement(
                By.xpath("//input[@id='password']"));
        passwordField.clear();
        passwordField.sendKeys(UserConfig.userPassword);
        pause(3000);

        WebElement signUpButton = driver.findElement(
                By.xpath("//input[@id='submit-id-submit']"));
        signUpButton.click();
        pause(7000);

        WebElement profileButton = driver.findElement(
                By.xpath("//a[@id='header.profile']"));
        profileButton.click();
        pause(3000);

        WebElement usernameFieldOnProfile = driver.findElement(
                By.xpath("//hgroup[@class='tooltip-container']/h2"));
        pause(3000);
        Assert.assertEquals(usernameFieldOnProfile.getText(), UserConfig.userName);

        WebElement closeAccountLinkInProfile = driver.findElement(
                By.xpath("(//div[@class='side-nav db-sm']/ul/li)[last()]/a"));
        closeAccountLinkInProfile.click();
        pause(1000);

        WebElement closeAccountPopupButton = driver.findElement(
                By.xpath("//button[@data-purpose='delete-account-popup-opener']"));
        closeAccountPopupButton.click();
        pause(1000);

        WebElement passwordFieldForClosingAccount = driver.findElement(
                By.xpath("//input[@id='id_password']"));
        passwordFieldForClosingAccount.clear();
        passwordFieldForClosingAccount.sendKeys(UserConfig.userPassword);
        pause(2000);


        WebElement closeAccountButtonAfterEnteringPW = driver.findElement(
                By.xpath("//input[@id='submit-id-submit']"));
        closeAccountButtonAfterEnteringPW.click();
        pause(2000);

        signUpPopupButton = driver.findElement(
                By.xpath("//button[@data-purpose='header-signup']"));
        Assert.assertEquals(signUpPopupButton.getText(), "Зарегистрироваться");
        pause(2000);

        driver.quit();

    }

    private void pause (int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
