package com.epam.ta.pages.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextCreateFilesMenu implements MenuBars {
    private WebDriver driver;
    private By clientListingTable = new By.ByXPath("//div[contains(@class, 'client-listing')]");
    private By createNewFolderRef = new By.ByXPath("//div[@class='menu__item']/span[contains(text(), 'New folder')]");


    public ContextCreateFilesMenu(WebDriver driver) {
        this.driver = driver;
    }

    private ContextCreateFilesMenu showContextCreateMenu() {
        WebElement element  = driver.findElement(clientListingTable);
        new Actions(driver).contextClick(element).build().perform();
        return this;
    }

    public CreateNewFolderDiologueBody chooseCreateNewFolder() {
        showContextCreateMenu();
        WebElement element  = driver.findElement(createNewFolderRef);
        new Actions(driver).moveToElement(element).click().build().perform();
        return new CreateNewFolderDiologueBody(driver);
    }


}
