package com.lcwaikiki.steps;

import com.github.javaparser.utils.Log;
import com.lcwaikiki.driver.BaseTest;
import com.lcwaikiki.methods.Methods;
import com.thoughtworks.gauge.Logger;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.LoggerFactory;

import java.util.List;

public class StepImplementation extends BaseTest {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    Methods methods;
    public StepImplementation() {
        methods = new Methods();
    }

    @Step("<id>li elemente tıkla")
    public void clickId(String id){
        methods.click(By.id(id));
        logger.info("Elemente tiklandi");
    }

    @Step("<css>li elementin üzerinde dur")
    public void hoverElement(String css){
        methods.hover(By.cssSelector(css));
        logger.info("Elementin üzerine gelindi");
    }

    @Step("<key> saniye bekle")
    public void wait(int key) throws InterruptedException{
        Thread.sleep(key*1000);
        logger.info(key+ "saniye beklendi");
    }

    @Step("<url>li sayfada olduğunu kontrol et")
    public void assertPage(String url){
        Assert.assertEquals("Url'ler Eşleşmiyor",driver.getCurrentUrl(),url);
        logger.info("Sayfa kontrolu yapildi");
    }

    @Step("<xpath>xpath li elemente tıkla")
    public void clickXpath(String xpath){
        methods.click(By.xpath(xpath));
        logger.info("Elemente tiklandi");
    }


    @Step("<css1>css li elemente tıkla")
    public void clickCss(String css1){
        methods.click(By.cssSelector(css1));
        logger.info("Elemente tiklandi");
    }


    @Step("<xpath>xpathli listeden ilk 3 ürünü favorilere ekle")
    public void addToFav(String xpath){
        List<WebElement> urunler = driver.findElements(By.xpath(xpath));
        urunler.get(0).click();
        urunler.get(1).click();
        urunler.get(2).click();
        logger.info("urunler favorilere eklendi");

    }

    @Step("<xpath>xpathli eleman <exp> e eşit değilse <text> yazdır")
    public void checkFav(String xpath,String exp,String text) {
       Assert.assertEquals(text,exp,methods.findElement(By.xpath(xpath)).getText());
        logger.info("Kontrol yapildi");
    }
    @Step("<text>in sayfada olup olmadığını kontrol et")
    public void textControl(String text){
        Assert.assertTrue("Favorideki ürünler silinmedi",methods.findElement(By.cssSelector(text)).isDisplayed());
        logger.info("Text gorunurlugu kontrol edildi");
    }




}
