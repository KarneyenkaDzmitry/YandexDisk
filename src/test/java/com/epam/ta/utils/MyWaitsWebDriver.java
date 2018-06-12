package com.epam.ta.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import javax.annotation.Nullable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class MyWaitsWebDriver {
    private WebDriver driver;

    public MyWaitsWebDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void implisityWait(long seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    //ExplicitWaits
    public WebElement explisityWait(final By element, long second) {
        WebElement dynamicElement = (new WebDriverWait(driver, second)).until(new ExpectedCondition<WebElement>(){
            @Nullable
            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(element);
            }
        });
        return  dynamicElement;
    }

    //User Wait
    public void fluentWait(final By element, long timeout, long polling) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(timeout, TimeUnit.SECONDS)
                .pollingEvery(polling, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        WebElement nextPage = wait.until(new Function<WebDriver,WebElement>(){
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(element);
            }
        });
    }

    //User Wait
    public void functionWait(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    //Thread.sleep(miliseconds);
    public void sleeper(int seconds) {
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
