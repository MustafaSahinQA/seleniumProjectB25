package com.cydeo.tests.Day5_TestNG_INtro_Dropdowns;

import com.cydeo.utilities.WebdriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T1_StaleElementRefEx {

    public static void main(String[] args) throws InterruptedException {
        //TC #1: StaleElementReferenceException handling
        //1. Open Chrome browser
        WebDriver driver = WebdriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. Go to https://practice.cydeo.com/add_remove_elements/
        driver.get("https://practice.cydeo.com/add_remove_elements/");
        //3. Click to “Add Element” button
        WebElement AddElementBtn = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
       Thread.sleep(2000);
        AddElementBtn.click();
        //4. Verify “Delete” button is displayed after clicking.
        WebElement DeleteBtn = driver.findElement(By.xpath("//button[@class='added-manually']"));
        System.out.println("DeleteBtn.isDisplayed() = " + DeleteBtn.isDisplayed());
        //5. Click to “Delete” button.
        DeleteBtn.click();
        //6. Verify “Delete” button is NOT displayed after clicking.
        //USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
        //
        try {
            System.out.println("DeleteBtn.isDisplayed() = " + DeleteBtn.isDisplayed());
        } catch (StaleElementReferenceException e) {

            System.out.println("-->StaleElementReferenceException exception is thrown");
            System.out.println("-->This means the web element is completely deleted from the page");
            System.out.println("deleteButton.isDisplayed() = false");



        }
        }
    }