package com.HelloToby.listeners;

import com.HelloToby.Consumer.TestRunner;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Arrays;

public class TestListener implements ITestListener {

    String filePath = "target/screen/";

    int startCounter = 0;
    int endCounter = 0;
    int successCounter = 0;
    int failureCounter = 0;
    int skipCounter = 0;
    int onTestStartCounter = 0;
    int onTestFailedButWithinSuccessPercentageCounter = 0;



    @Override
    public void onStart(ITestContext context) {
        System.out.println("onStart counter = " + (++startCounter));
    }


    @Override
    public void onFinish(ITestContext context) {
        System.out.println("onFinish counter= " + (++endCounter));
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart counter : " + (++onTestStartCounter));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("...onTestSuccess counter : " + (++successCounter));

        System.out.println("onTestSuccess Result " + result );
        String methodName = result.getName().trim();
        System.out.println("onTestSuccess methodName " + methodName );

        ITestContext context = result.getTestContext();
        System.out.println("..onTestSuccess context getPassedTest : " + context.getPassedTests()   );

        takeScreenShot(result, methodName, TestRunner.getDriver());

    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("...onTestFailure" + (++failureCounter));
        String methodName = result.getName().trim();
        takeScreenShot(result, methodName, TestRunner.getDriver());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("...onTestSkipped" + (++skipCounter));

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result){
        System.out.println("...nTestFailedButWithinSuccessPercentage" + (++onTestFailedButWithinSuccessPercentageCounter));

    }

    public void takeScreenShot(ITestResult result, String methodName, WebDriver driver) {
        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//The below method will save the screen shot in d drive with test method name
        if (result.getStatus() == ITestResult.SUCCESS) {
            try {
                String fileName = filePath+"success/"+ Arrays.toString(result.getParameters())+new Timestamp(System.currentTimeMillis())+".jpg";
                FileUtils.copyFile(screenShot, new File(fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (result.getStatus() == ITestResult.FAILURE) {
            try {
                String fileName = filePath+"failed/"+Arrays.toString(result.getParameters())+new Timestamp(System.currentTimeMillis())+".jpg";
                FileUtils.copyFile(screenShot, new File(fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }









}
