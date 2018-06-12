package com.epam.ta.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexRegistrationPage extends AbstractPage {
    private String BASE_URI = "";

    private By registrationDiv = new By.ByXPath("//div[@class='registration__block']");


    @Override
    public void openPage() {

    }

    public YandexRegistrationPage(WebDriver driver) {

        super(driver);
    }

    public Boolean isRegistrationPresent() {
        return !driver.findElements(registrationDiv).isEmpty();
    }
}
