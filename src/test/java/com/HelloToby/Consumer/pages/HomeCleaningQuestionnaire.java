package com.HelloToby.Consumer.pages;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.appium.java_client.MobileElement;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import static com.HelloToby.Consumer.TestRunner.driver;
import com.HelloToby.Consumer.pages.Page;

public class HomeCleaningQuestionnaire extends BasePage implements PageConstant {
    public void questions() {
        List <WebElement> answerList = (List<WebElement>) driver.findElement(By.xpath("//*[contains(@resource-id , 'answer')]"));
        List<String> answerID = new ArrayList<>();
        for (int i = 0; i <= answerList.size() - 1; i++) {
            WebElement newAnswerList = answerList.get(i);
            answerID.add(newAnswerList.getAttribute("resource-id"));
            System.out.println(answerID);
        }
        Random rand = new Random();
        int randomAnswer = rand.nextInt(answerID.size());
        driver.findElement(By.id(answerID.get(randomAnswer))).click();
    }

    @Override
    public MobileElement getMobileElement(String elementID) {

        return null;
    }

    @Override
    public MobileElement getMobileElementByLocator(By locator) {
        return null;
    }
}