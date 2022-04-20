package com.HelloToby.Consumer.pages;

import com.HelloToby.Consumer.TestRunner;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Try extends BasePage{
    AppiumDriver<WebElement> driver = TestRunner.getDriver();
    @Override
    public MobileElement getMobileElement(String elementID) {
        return (MobileElement) driver.findElementById(elementID);
    }


    @Override
    public MobileElement getMobileElementByLocator(By locator) {
        return (MobileElement) driver.findElement(locator);

    }


}
