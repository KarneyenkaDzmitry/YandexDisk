package com.epam.ta.pages.menu;

import com.epam.ta.pages.AbstractPage;
import com.epam.ta.pages.YandexDiskHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateNewFolderDiologueBody extends AbstractPage implements MenuBars {
    private By saveButton = By.xpath("//button/child::span[text()='Save']");
    private By newFolderFieldForType = By.xpath("//form[@class='rename-dialog__rename-form']/span/input[@class='textinput__control']");
    private By dialogTitleText = By.xpath("//div[@class='dialog__title']");

    public CreateNewFolderDiologueBody(WebDriver driver) {
        super(driver);
    }

    public void openPage() {

    }

    public YandexDiskHomePage createNewFolder(String name) {
        if (IsElementPresent(saveButton) && IsElementPresent(newFolderFieldForType) && IsElementPresent(dialogTitleText)) {
            /*try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            new Actions(driver).moveToElement(driver.findElement(newFolderFieldForType)).sendKeys(name).build().perform();
            /*try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            new Actions(driver).moveToElement(driver.findElement(saveButton)).click().build().perform();
        }
        return new YandexDiskHomePage(driver);
    }
}
