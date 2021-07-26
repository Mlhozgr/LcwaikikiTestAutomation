package com.lcwaikiki.methods;

import com.lcwaikiki.driver.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Methods {

    public static WebDriverWait wait;
    private static WebDriver driver;



    public Methods() {
        this.driver = BaseTest.driver;
        wait = new WebDriverWait(this.driver, 30);

    }
    public WebElement findElement(By by){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return driver.findElement(by);
    }

    public void click(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();
    }
    public void send_keys(By by ,String text){

        findElement(by).sendKeys(text);
    }
    public void hover(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();

    }


}
