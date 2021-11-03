package com.softserve.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SearchGoogle {

    @Test
    public void testWedDriver() throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver",
//                "./lib/chromedriver.exe");
        //
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //
//        WebDriverManager.firefoxdriver().setup();
//        WebDriver driver = new FirefoxDriver();
        //
        // Thread.sleep(1000); // For Presentation Only
        //
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // default 0
        driver.get("http://www.google.com");
        System.out.println("0. Page title is: " + driver.getTitle());
        // driver.navigate().to("http://www.google.com");
        //Thread.sleep(1000); // For Presentation Only
        //
        WebElement element = driver.findElement(By.name("q"));
        //element.sendKeys("Cheese!" + Keys.ENTER);
        //Thread.sleep(1000); // For Presentation Only
        //System.out.println("1. Page title is: " + driver.getTitle());
        element.sendKeys("Cheese!");
        // Thread.sleep(2000); // For Presentation Only
        //
        element.submit();
        System.out.println("1. Page title is: " + driver.getTitle());
//        Thread.sleep(2000); // For Presentation Only
        System.out.println("2. Page title is: " + driver.getTitle());
        //
        // driver.findElement(By.cssSelector("a[href*='en.wikipedia.org/wiki/Cheese']")).click();
        driver.findElement(By.partialLinkText("Cheese - Wikipedia")).click();
//        Thread.sleep(2000); // For Presentation Only
        System.out.println("3. Page title is: " + driver.getTitle());
        //
        WebElement actual = driver.findElement(By.id("siteSub"));
        //Assert.assertEquals("From Wikipedia, the free encyclopedia", actual.getText());
        Assert.assertEquals(actual.getText(), "From Wikipedia, the free encyclopedia");
        //
        Thread.sleep(2000); // For Presentation Only
        // driver.close();
        driver.quit();
    }
}
