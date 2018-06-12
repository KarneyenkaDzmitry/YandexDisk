package com.epam.ta.pages;

import com.epam.ta.pages.menu.ContextCreateFilesMenu;
import com.epam.ta.pages.menu.CreateNewFolderDiologueBody;
import com.epam.ta.pages.menu.UserAccountMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexDiskHomePage extends AbstractPage {
    private By leftMenu = new By.ByXPath("" +
            "//button[contains(@class, 'button2 button2_view_classic button2_size_n button2_theme_clear-inverse collapsible-buttons__more-button')]");

    private String itemsXpath = "//div[@class='listing__items']";
    private String BASE_URL = "https://disk.yandex.com/client/disk";
    private UserAccountMenu userAccountMenu;
    private ContextCreateFilesMenu contextCreateFilesMenu;

    @Override
    public void openPage() {

    }

    public YandexDiskHomePage(WebDriver driver) {
        super(driver);
    }

    public Boolean IsHomePage() {
        return IsElementPresent(leftMenu);
    }

    public YandexDiskLogInPage logOut() {
        userAccountMenu = new UserAccountMenu(driver);
        userAccountMenu.logOut();
        return new YandexDiskLogInPage(driver);
    }

    public CreateNewFolderDiologueBody createNewFolder(String name) {
        contextCreateFilesMenu = new ContextCreateFilesMenu(driver);
        contextCreateFilesMenu.chooseCreateNewFolder();
        return new CreateNewFolderDiologueBody(driver);
    }

    public boolean IsFolderExistOnPage(String name) {
        return IsElementPresent(By.xpath("//*[text()='" + name + "']"));
    }

    public boolean removeIntoTrashFirstXFiles(int x) {
        WebElement startElement = driver.findElement(By.xpath(itemsXpath+"/div"));
        String nameOfElement = startElement.getText();
        System.out.println(nameOfElement);

        WebElement lastElement = driver.findElement(By.xpath("//span[contains(text(), 'Trash')]"));
        new Actions(driver).moveToElement(startElement).build().perform();
        new Actions(driver).clickAndHold(startElement).build().perform();
        new Actions(driver).moveToElement(lastElement).build().perform();
        new Actions(driver).release().build().perform();
        new Actions(driver).doubleClick(lastElement).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, 5);

        return IsElementPresent(By.xpath("//h1[@title='Trash']")) && IsElementPresent(By.xpath("//span[contains(text(), '"+nameOfElement+"')]"));

        //new Actions(driver).contextClick().build().perform();



    }

}
