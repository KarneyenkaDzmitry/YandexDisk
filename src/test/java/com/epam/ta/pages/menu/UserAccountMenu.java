package com.epam.ta.pages.menu;

import com.epam.ta.pages.AbstractPage;
import com.epam.ta.pages.YandexDiskLogInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class UserAccountMenu extends AbstractPage implements MenuBars {
    private By userAccountMenu = new By.ByXPath("//*[@id=\"nb-1\"]/body/div[1]/div/div/div[1]/div/div[4]/div/div[2]/div[3]/div/a[1]/div/div[1]");
    private By logOutRef = new By.ByXPath("//li/a[contains(@class, 'user2__menu-item_action_exit')]");
    private By newFolderMenuOnTheTopOfThePage = new By.ByXPath("//span[contains(@class, 'resources-action-bar__close')]/div/button");


    public void openPage() {

    }

    public UserAccountMenu(WebDriver driver) {
        super(driver);
    }

    public UserAccountMenu openUserAccountMenuBar() {
        if (IsElementPresent(newFolderMenuOnTheTopOfThePage)){
            /*try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            new Actions(driver).click(driver.findElement(newFolderMenuOnTheTopOfThePage)).build().perform();
        }
        new Actions(driver).click(driver.findElement(userAccountMenu)).build().perform();
        return this;
    }

    public YandexDiskLogInPage  logOut() {
        openUserAccountMenuBar();
        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        new Actions(driver).click(driver.findElement(logOutRef)).build().perform();
        return new YandexDiskLogInPage(driver);
    }
}
