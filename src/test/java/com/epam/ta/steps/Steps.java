package com.epam.ta.steps;

import com.epam.ta.driver.DriverSingleton;
import com.epam.ta.pages.YandexDiskHomePage;
import com.epam.ta.pages.YandexDiskStartPage;
import com.epam.ta.pages.YandexRegistrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Steps {
    private WebDriver driver;


    public void initBrowser() {
        driver = DriverSingleton.getDriver();
    }

    public void closeDriver() {
        DriverSingleton.closeDriver();
    }


    public Boolean createNewDiskButton() {
        YandexDiskStartPage page = new YandexDiskStartPage(driver);
        return page.clickOnCreateYourYandexDiskButton().isRegistrationPresent();
    }

    public boolean loginYandexDisk(String login, String password) {
        YandexDiskStartPage page = new YandexDiskStartPage(driver);
        return page.chooseYandexDiskLogInPage().ligIn(login, password).IsHomePage();
    }

    public boolean logOutYandexDisk() {
        YandexDiskHomePage page = new YandexDiskHomePage(driver);
        return page.logOut().IsYandexDiskLogInPage();
    }

    public boolean createNewFolder(String name) {
        YandexDiskHomePage page = new YandexDiskHomePage(driver);
        return page.createNewFolder(name).createNewFolder(name).IsFolderExistOnPage(name);
    }

    public boolean deleteFirstXFilesWithMouse(int x) {
        YandexDiskHomePage page = new YandexDiskHomePage(driver);
        return page.removeIntoTrashFirstXFiles(x);
    }

    public boolean runJSExecutor() {
        YandexDiskStartPage page = new YandexDiskStartPage(driver);
        page.openPage();
        WebElement element = driver.findElement(By.id("nb-4"));
        page.highlightElement(element);
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("document.getElementById('nb-4').click()");
        return new YandexRegistrationPage(driver).isRegistrationPresent();
    }

}
