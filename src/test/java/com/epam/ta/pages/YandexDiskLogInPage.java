package com.epam.ta.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class YandexDiskLogInPage extends AbstractPage {
    private By passwordField = new By.ByXPath("//input[@type='password']");
    private By loginField = new By.ByXPath("//input[@name='login']");
    private By enterButton = new By.ByXPath("//span[text()='Sign in']");
    private By doNotRemindSanBox = new By.ByXPath("//label[@class='passport-Checkbox']/span");


    private String BASE_URL = "";

    @Override
    public void openPage() {

    }

    public YandexDiskLogInPage(WebDriver driver) {
        super(driver);
    }

    public YandexDiskHomePage ligIn(String login, String password) {
        if (IsElementPresent(passwordField) && IsElementPresent(enterButton) && IsElementPresent(loginField)) {
            WebElement element2 = driver.findElement(passwordField);
            WebElement element1 = driver.findElement(loginField);
            new Actions(driver).moveToElement(element1).build().perform();
            new Actions(driver).click(element1).build().perform();
            new Actions(driver).sendKeys(login).build().perform();
            new Actions(driver).moveToElement(element2).build().perform();
            new Actions(driver).click(element2).build().perform();
            new Actions(driver).sendKeys(password).build().perform();
            new Actions(driver).click(driver.findElement(doNotRemindSanBox)).build().perform();
            new Actions(driver).click(driver.findElement(enterButton)).build().perform();
            return new YandexDiskHomePage(driver);
        } else {
            return new YandexDiskHomePage(driver);
        }
    }

    public boolean IsYandexDiskLogInPage() {
        return IsElementPresent(passwordField) && IsElementPresent(enterButton) && IsElementPresent(loginField);
    }
}
