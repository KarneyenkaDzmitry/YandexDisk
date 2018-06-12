package com.epam.ta.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class YandexDiskStartPage extends AbstractPage {
    private String BASE_URL = "https://disk.yandex.com";

    By createYourYandexDiskButton = new By.ByXPath("//button[@id='nb-4']");
    By logInButton = new By.ByXPath("//a/span[@class='button2__text']");


    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }

    public YandexDiskStartPage(WebDriver driver) {
        super(driver);
    }

    public YandexRegistrationPage clickOnCreateYourYandexDiskButton() {
        openPage();
        WebElement button = driver.findElement(createYourYandexDiskButton);
        new Actions(driver).click(button).build().perform();
        return new YandexRegistrationPage(driver);
    }

    public YandexDiskLogInPage chooseYandexDiskLogInPage() {
        openPage();
        new Actions(driver).click(driver.findElement(logInButton)).build().perform();
        return new YandexDiskLogInPage(driver);
    }


}
