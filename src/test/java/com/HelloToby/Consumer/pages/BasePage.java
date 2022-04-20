package com.HelloToby.Consumer.pages;

import com.HelloToby.Consumer.TestRunner;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public abstract class BasePage {
//    public static final int waitTime = 300;
    //Phoebe 13/7/2020 change from 60 to 180
    public static final int waitTime = 300;
    protected WebDriverWait wait;
    protected WebDriverWait wait1Sec;
    protected WebDriverWait wait5Sec;
    protected WebDriverWait wait30Sec;
    protected TouchAction touchAction;

    public BasePage()  {
        TestRunner.sharedInstance();
        AppiumDriver<WebElement> driver = TestRunner.getDriver();
        this.wait = new WebDriverWait(driver, waitTime);
        this.wait1Sec = new WebDriverWait(driver, 1);
        this.wait5Sec = new WebDriverWait(driver, 5);
        this.wait30Sec = new WebDriverWait(driver, 30);
    }


    public abstract MobileElement getMobileElement(String elementID);

    public abstract MobileElement getMobileElementByLocator(By locator);

    protected MobileElement scrollToElement(By elementLocator, int repeatCount, int startX, int startY, int endX, int endY, int waitDuration) {
        MobileElement toVisibleElement = null;
        TestRunner. sharedInstance();
        AppiumDriver<WebElement> driver = TestRunner.getDriver();

        int i = 0;
        while (i < repeatCount) {
            try {
                toVisibleElement = (MobileElement) driver.findElement(elementLocator);
            } catch (Exception e) {
//                System.out.println(e.getMessage());
                System.out.println("can not find the target element");
            }

            try {
                if (toVisibleElement != null && toVisibleElement.isDisplayed()) {
                    System.out.println("target element is displayed");
                    return toVisibleElement;
                }
            } catch (Exception e) {
                System.out.println("element is not displayed");
            }

            System.out.println("going to scroll");
            TouchAction action = new TouchAction(driver);
            action.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(waitDuration)))
                    .moveTo(PointOption.point(endX, endY)).release();
            action.perform();
            System.out.println("scrolling finished");

            i = i + 1;
        }

        return toVisibleElement;
    }

    protected MobileElement scrollToElement(MobileElement targetElement, int repeatCount, int startX, int startY, int endX, int endY, int waitDuration) {
        MobileElement toVisibleElement = null;
        TestRunner.sharedInstance();
        AppiumDriver<WebElement> driver = TestRunner.getDriver();

        int i = 0;
        while (i < repeatCount) {
            try {
                toVisibleElement = targetElement;
            } catch (Exception e) {
//                System.out.println(e.getMessage());
                System.out.println("can not find the target element");
            }

            try {
                if (toVisibleElement != null && toVisibleElement.isDisplayed()) {
                    System.out.println("target element is displayed");
                    return toVisibleElement;
                }
            } catch (Exception e) {
                System.out.println("element is not displayed");
            }

            System.out.println("going to scroll");
            TouchAction action = new TouchAction(driver);
            action.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(waitDuration)))
                    .moveTo(PointOption.point(endX, endY)).release();
            action.perform();
            System.out.println("scrolling finished");

            i = i + 1;
        }

        return toVisibleElement;
    }

//    public void takeScreenshot(String type, String identifier) {
//        try {
//            Thread.sleep(300);
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        ScreenshotUtils screenshot = new ScreenshotUtils(HSAppiumDriver.sharedInstance().getDriver());
//        screenshot.takeScreenshot(type, identifier);
//        screenshot.saveScreenshotPNG();
//    }

    public void tearDown() {
        try {
            TestRunner.sharedInstance();
            TestRunner.getDriver().closeApp();
            TestRunner.sharedInstance();
            TestRunner.getDriver().quit();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            wait = null;
            wait1Sec =null;
            wait5Sec = null;
            wait30Sec = null;
            touchAction = null;
        }
    }

    protected TouchAction getTouchAction() {
        if (touchAction == null) {
            TestRunner.sharedInstance();
            touchAction = new TouchAction(TestRunner.getDriver());
        }
        return touchAction;
    }


    public void clickButton(By selector) {
        WebElement element;
        try {
            TestRunner.sharedInstance();
            element = wait.until(ExpectedConditions.visibilityOf(TestRunner.getDriver().findElement(selector)));
            element.click();
        } catch (Exception e) {
            Assert.fail("Element is NOT found");
        }
    }

    public boolean clickButton(By selector, boolean canAssert) {
        WebElement element;
        try {
            TestRunner.sharedInstance();
            element = wait30Sec.until(ExpectedConditions.visibilityOf(TestRunner.getDriver().findElement(selector)));
            element.click();
            return true;
        } catch (Exception e) {
            Assert.assertFalse(canAssert, "Element is NOT found");
            return false;
        }
    }

    public void checkElement(By selector) {
        try {
            TestRunner.sharedInstance();
            wait30Sec.until(ExpectedConditions.visibilityOf(TestRunner.getDriver().findElement(selector)));
        } catch (Exception e) {
            Assert.fail("Element is NOT found");
        }
    }

    public boolean checkElement(By selector, boolean canAssert) {
        try {
            //If the element exist, return true
            TestRunner.sharedInstance();
            wait30Sec.until(ExpectedConditions.visibilityOf(TestRunner.getDriver().findElement(selector)));
            return true;
        } catch (Exception e) {
            Assert.assertFalse(canAssert, "Element is NOT found");
            return false;
        }
    }
    //Simple tap by coordinates
    public void tapPoint(int x, int y) {
        try {
            getTouchAction()
                    .press(PointOption.point(new Point(x, y)))
                    .release()
                    .perform();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Tap action failed");
        }
        System.out.println("-> Tapped " + x + ", " + y);
    }

    //Scroll action
    //Scroll the whole screen, specifies scroll for how many times, and direction
    // -Param explain- | OverTime refers to how long would the drag action take, the bigger the number, the slower the scroll
    public void scrollElement(int times, EScrollDirection direction, int overTime) {
        for (int i = 0; i < times; i++) {
            //Scroll point reference is the screen itself
            TestRunner.sharedInstance();
            Dimension dimension = TestRunner.getDriver().manage().window().getSize();
            startScrolling(dimension, direction, overTime);
        }
    }

    //Overload ScrollElement, scroll the whole screen instead of a specific element
    //Scroll in certain direction until a given selector is found, can specify whether to assert if element is not found
    // -Param explain- | OverTime refers to how long would the drag action take, the bigger the number, the slower the scroll
    // -Param explain- | If canAssert is true, Assert when element is not found
    public boolean scrollElement(By selector, EScrollDirection direction, int overTime, boolean canAssert) {
        int scrollCount = 0;
        //Will only scroll 20 times
        while (scrollCount < 20) {
            try {
                //If cannot find the element within 1 second, jump to catch
                wait1Sec.until(ExpectedConditions.visibilityOf(TestRunner.getDriver().findElement(selector)));
                TestRunner.sharedInstance();
                System.out.println("---- " + TestRunner.getDriver().findElement(selector).getText() + " is found ----");
                //Stop the function when element is found
                return true;
            } catch (Exception e) {
                scrollCount++;
                System.out.println("-> Scrolling " + scrollCount + " time");
                //If I fail to find the element, scroll
                TestRunner.sharedInstance();
                Dimension dimension = TestRunner.getDriver().manage().window().getSize();
                startScrolling(dimension, direction, overTime);
            }
        }
        //If loop ends without finding the element, assert if needed
        Assert.assertFalse(canAssert, "Can Not find element");
        return false;
    }

    //Executing the scrolling action
    public void startScrolling(Dimension dimension, EScrollDirection direction, int overTime) {
        //Get the start and end point for the scroll action
        Point[] returnPoints = getScrollPoints(dimension, direction);
        Point startPoint = returnPoints[0];
        Point endPoint = returnPoints[1];
        //The actual action is performed here
        try {
            getTouchAction()
                    .press(PointOption.point(startPoint))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(overTime)))
                    .moveTo(PointOption.point(endPoint))
                    .release()
                    .perform();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Scroll action failed to perform");
        }
    }

    //Get Scroll start and end points
    public Point[] getScrollPoints(Dimension dimension, EScrollDirection dir) {

        float startX = 0;
        float startY = 0;
        float endX = 0;
        float endY = 0;

        //Define start/end X/Y points depending on direction
        switch (dir) {
            case up:
                startX = 0.5f;
                startY = 0.2f;
                endX = 0.5f;
                endY = 0.5f;
                break;
            case down:
                startX = 0.5f;
                startY = 0.8f;
                endX = 0.5f;
                endY = 0.2f;
                break;
            case left:
                startX = 0.2f;
                startY = 0.5f;
                endX = 0.8f;
                endY = 0.5f;
                break;
            case right:
                startX = 0.8f;
                startY = 0.5f;
                endX = 0.2f;
                endY = 0.5f;
                break;
            case trytry:
                startX = 0.5f;
                startY = 0.5f;
                endX = 0.5f;
                endY = 0.5f;
                break;
            default:
                break;
        }

        //Return start and end points as a point array
        return new Point[]
                {
                        new Point(Math.round(dimension.getWidth() * startX), Math.round(dimension.getHeight() * startY)),
                        new Point(Math.round(dimension.getWidth() * endX), Math.round(dimension.getHeight() * endY))
                };
    }

    //Calls Thread.Sleep
    public void threadSleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (Exception ignore) {
        }

    }

}
