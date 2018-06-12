package com.epam.ta.pages;

import com.epam.ta.utils.MyWaitsWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public abstract class AbstractPage {
    protected WebDriver driver;
    protected MyWaitsWebDriver driverWait = new MyWaitsWebDriver(driver);
    private String PATH_TO_SCREENSHOTS_FOLDER = ".\\target\\";

    public abstract void openPage();

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public void highlightElement(WebElement element) {
        String bg = element.getCssValue("color");
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("document.getElementById('nb-4').style.color='rgb(0, 255, 0)';", element);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        //wait.withTimeout(5, TimeUnit.SECONDS);
        driverWait.sleeper(5);
        newMethodOfScreenshot();
        driverWait.sleeper(5);
        //wait.withTimeout(5, TimeUnit.SECONDS);
        js.executeScript("document.getElementById('nb-4').style.color='" + bg +  "';", element);
        //makeScreenshots();// take screenshot here
        //js.executeScript("arguments[0].style.color = '" + bg + "'", element);
    }

    /*public void makeScreenshots() {
        try {
            File screenshot = ((TakesScreenshot) instance).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFileToDirectory(screenshot, new File(PATH_TO_SCREENSHOTS_FOLDER));
            //Logger.htmlOutput("Teken screenshots <a href='screenshots/" + screenshot.getName() + "'>" + screenshot.getName()+"</a>");
        } catch (WebDriverException e) {
            //Logger.error(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
    public void newMethodOfScreenshot() {
        try {
            Robot robot = new Robot();
            String format = "jpg";
            String fileName = "Job" +(int)(Math.random()*1000) +"." + format;

            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
            ImageIO.write(screenFullImage, format, new File(PATH_TO_SCREENSHOTS_FOLDER + fileName));

            //System.out.println("A full screenshot saved!");
        } catch (AWTException ex) {
            System.err.println(ex);
        } catch (IOException ex){}
    }


    public boolean IsElementPresent(By locator) {
        return !driver.findElements(locator).isEmpty();
    }
}
