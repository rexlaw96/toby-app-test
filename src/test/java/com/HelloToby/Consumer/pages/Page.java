package com.HelloToby.Consumer.pages;

import com.HelloToby.Consumer.TestRunner;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import static com.HelloToby.Consumer.TestRunner.driver;


public class Page extends BasePage implements PageConstant {

//    private ApiRespond apiRespond;
    private int randomSelectPackage;

    private static final ApiRespond apiRespond = new ApiRespond();

    private static final Map<java.lang.String[], Integer> answerMap = new HashMap<java.lang.String[], Integer>();

    private static final Map<Integer, java.lang.String[]> randomIndex = new HashMap<Integer, java.lang.String[]>();


//    public Page(ApiRespond apiRespond) {
//
//        this.apiRespond = apiRespond;
//    }

//    public Page(RandomSelectPackage randomSelectPackage) {
//
//        this.randomSelectPackage = randomSelectPackage;
//    }
    private JSONObject JSONObject;
    private Object String;
    private static final Random rand = new Random();
    private static final HashMap<Integer, String> map = new HashMap<>();
    private static final HashMap<Integer, String> pack = new HashMap<>();
    private static Integer randomValue =  null;
    JSONObject requestParams2 = new JSONObject();
    JSONObject requestParams = new JSONObject();
    JSONArray questions_empty = new JSONArray();
    String[] packID = {Android.HCHOOPKGNEW, Android.HOCDPKGNEW, Android.HCDEPKGNEW, Android.HCUNPKGNEW, Android.HCCLPKGNEW, Android.HCFOPKGNEW, Android.HCHPCPKGNEW, Android.HCLAPKGNEW
            , Android.HCMIPKGNEW, Android.HCMOPKGNEW, Android.HCRUPKGNEW, Android.HQAIPKGNEW, Android.SMINPKGNEW};



    private static Object TestResultManager;
    @iOSXCUITFindBy(accessibility = "Allow")
    protected WebElement allowAlert;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")
    @iOSXCUITFindBy(accessibility = "splash btn hk en")
    protected WebElement continueButton;


    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Skip\"]")
    protected WebElement nextbutton1;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.ImageView")
    @iOSXCUITFindBy(accessibility = "Walk_BG")
    protected WebElement nextbutton2;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup")
    @iOSXCUITFindBy(accessibility = "walk btn start en")
    protected WebElement exploreButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[4]")
    protected WebElement profileButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.View")
    protected WebElement loginButtonEnable;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.view.ViewGroup/android.widget.TextView[1]")
    protected WebElement loginwithemailButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.EditText")
    protected WebElement emailInputField;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText")
    protected WebElement passwordInputField;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup")
    protected WebElement loginButton_email;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")
    protected WebElement userName_userCenter;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup")
    protected WebElement closeButton_login;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup")
    protected WebElement areaButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[2]")
    protected WebElement contactNumberInputField;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]")
    protected WebElement continueButton_login;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup")
    protected WebElement continueWithFacebookButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.view.ViewGroup/android.widget.TextView")
    protected WebElement continueWithEmailButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]")
    protected WebElement languageSelector;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.TextView")
    protected WebElement continueButtonLanguage;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup")
    protected WebElement chinese_select;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ImageView")
    protected WebElement arrowButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.View")
    protected WebElement allowNotificationButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[3]")
    protected WebElement laterButtonOnNotificationButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")
    protected WebElement closeButtonOnLoginPage;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.View")
    protected WebElement goToLoginPageButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]")
    protected WebElement areaCodeOnLoginPage;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText")
    protected WebElement numberInputFieldOnLoginPage;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup")
    protected WebElement continueButtonOnLoginPage;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[1]")
    protected WebElement onboardingLocator;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
    protected WebElement backButtonOnLoginWithEmailPage;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]")
    protected WebElement loginButtonOnLoginWithEmailPage;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.EditText")
    protected WebElement emailInputFieldOnLoginWithEmailPage;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText")
    protected WebElement passwordInputFieldOnLoginWithEmailPage;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText")
    protected WebElement forgotPasswordButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[1]")
    protected WebElement loginWithEmailPageLocator;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[2]")
    protected WebElement errorMsgInvalidEmail;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText")
    protected WebElement emailPasswordInputField;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")
    protected WebElement closeButtonOnEmailLoginPage;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[1]")
    protected WebElement loginPageLocator;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[2]")
    protected WebElement errorMsgInvalidNumber;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/search_btn")
    protected WebElement searchBarOnLandingPage;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/home_directButton")
    protected WebElement directBookingButton;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/allBooking_button")
    protected WebElement allBookingButton;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/back_button")
    protected WebElement backButtonOnDirectBookingPage;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/search_btn")
    protected WebElement searchBarOnDirectBookingPage;

    @AndroidFindBy(xpath = "//*[contains(@text , '下一步')]")
    protected WebElement ctaButtonOnHomeServiceOnboarding;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/cancel_button")
    protected WebElement cancelButtonOnQuestionnaire;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/cancel_confirm_box_continueBtn")
    protected WebElement continueButtonOnCancelPopUp;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/cancel_confirm_box_leaveBtn")
    protected WebElement leaveButtonOnCancelPopUp;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[2]")
    protected WebElement invalidPromotionCodeErrorMsg;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/service_detail_collapse_button")
    protected WebElement serviceDetailCollapseButton;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/dropdown_coupon_btn")
    protected WebElement promotionCodeSelectFieldOnDirectBookingConfirmationPage;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/payment_select_btn")
    protected WebElement paymentMethodSelectFieldOnDirectBookingConfirmationPage;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/payment_submit")
    protected WebElement ctaButtonOnDirectBookingConfirmationPage;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/promoCode_input")
    protected WebElement promotionCodeOnComfirmationPage;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/dropdown_coupon_btn")
    protected WebElement addPromotionCode;

    @AndroidFindBy(xpath = "//*[contains(@text,'請輸入你的優惠碼')]")
    protected WebElement promotionCodeInputFieldOnConfirmationPage;

    @AndroidFindBy(xpath = "//*[contains(@text,'testestestest')]")
    protected WebElement promotionCodeCleaning;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/bankTransferPopup_confirm")
    protected WebElement ctaButtonOnFPSPaymentOverlay;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/promoCode_submit")
    protected WebElement promotionCodeUseButton;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/PAYME")
    protected WebElement payMePaymentMethod;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/ALIPAYHK")
    protected WebElement aliPayHKPaymentMethod;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/STRIPE_GOOGLEPAY")
    protected WebElement googlePayPaymentMethod;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/new")
    protected WebElement addCreditCardButtonOnPaymentMethod;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/BANK_TRANSFER")
    protected WebElement fpsPaymentMethod;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/new")
    protected WebElement addCreditCardButton;

    @AndroidFindBy(xpath = "//*[contains(@text , '新增信用卡')]")
    protected WebElement addCreditCardOverlayLocator;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ImageView")
    protected WebElement closeButtonOnAddCreditCardOverlay;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/credit_card_number")
    protected WebElement creditCardInputFieldOnAddCreditCardOverlay;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/credit_card_expired")
    protected WebElement expiryDateInputFieldOnAddCreditCardOverlay;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/credit_card_cvc")
    protected WebElement cvvInputFieldOnAddCreditCardOverlay;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/new_card_submit")
    protected WebElement ctaButtonOnAddCreditCardOverlay;

    @AndroidFindBy(xpath = "//*[contains(@text , '無效信用卡號碼')]")
    protected WebElement invalidCreditCardInlineError;

    @AndroidFindBy(xpath = "//*[contains(@text , '無效有效期')]")
    protected WebElement invalidExpiryDateInlineError;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/alipayhk_navigation_btn")
    protected WebElement alipayHKLocator;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.View/android.view.View[1]/android.widget.ImageView")
    protected WebElement homeButton;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/back_button")
    protected WebElement backButtonOnBeautyLandingPage;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/search_btn")
    protected WebElement searchBarOnStoreListingPage;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/question-HCHOO-PKG-1-16")
    protected WebElement question1_16;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/HCHOO-PKG-1-16-answer-1")
    protected WebElement answer1_16_1;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/HCHOO-PKG-1-16-answer-4")
    protected WebElement answer1_16_4;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/question-HCHOO-PKG-1-3")
    protected WebElement question1_3;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/HCHOO-PKG-1-3-answer-decrement")
    protected WebElement decrementButton;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/HCHOO-PKG-1-3_answer_increment")
    protected WebElement incrementButton;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/question-HCHOO-PKG-1-4")
    protected WebElement question1_4;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/HCHOO-PKG-1-4-overlay-select-date")
    protected WebElement selectDateButton;

    @AndroidFindBy(xpath = "//*[contains(@text , '30')]")
    protected WebElement date_30;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/timelist-option-7")
    protected WebElement timeSlot;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/question-DB-HK-district")
    protected WebElement districtSelect;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/dropdown_DB_HK-district-answer-parent-0-btn")
    protected WebElement districtAnswer;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/dropdown-DB-HK-district-answer-parent-0-option-KL")
    protected WebElement klButton;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/dropdown_DB_HK_district-answer-child-0-btn")
    protected WebElement childButton;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/question-GEN-CONTACT-ADDRESS_ADDRESS")
    protected WebElement addressQuestion;

    @AndroidFindBy(xpath = "//*[contains(@text , '街道及大廈名稱')]")
    protected WebElement findLocationField;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/address_autocomplete_gps_search_btn")
    protected WebElement gpsSearchButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.EditText")
    protected WebElement locationInputField;

    @AndroidFindBy(xpath = "//*[contains(@text , '樓層及室號')]")
    protected WebElement roomInputField;

    @AndroidFindBy(xpath = "//*[contains(@text , '完成')]")
    protected WebElement ctaButtonOnCreateAddressOverlay;

    @AndroidFindBy(xpath = "//*[contains(@text , '新增地址')]")
    protected WebElement createAddressOverlayLocator;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/back_button")
    protected WebElement backButtonOnHRIDLandingPage;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/search_btn")
    protected WebElement searchBarOnHRIDLandingPage;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/back_button")
    protected WebElement backButtonOnHRIDCalculatorPage;

    @AndroidFindBy(xpath = "//*[contains(@text , '還沒有帳戶? 登記')]")
    protected WebElement login;

    @AndroidFindBy(xpath = "//*[contains(@text , '賬戶')]")
    protected WebElement userCenterButton;

    @AndroidFindBy(xpath = "//*[contains(@text , '登出')]")
    protected WebElement logoutButton;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/phone")
    protected WebElement loginWithPhoneNumber;

    @AndroidFindBy(xpath = "//*[contains(@text , '登入')]")
    protected WebElement continueWithPhoneButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.EditText")
    protected WebElement smsCode1;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText")
    protected WebElement smsCode2;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.EditText")
    protected WebElement smsCode3;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.EditText")
    protected WebElement smsCode4;

    @AndroidFindBy(xpath = "//*[contains(@text , '姓名')]")
    protected WebElement fillinEmail;

    @AndroidFindBy(xpath = "//*[contains(@text , '電郵')]")
    protected WebElement fillinName;

    @AndroidFindBy(xpath = "//*[contains(@text , '建立帳戶')]")
    protected WebElement createAccountButton;

    @AndroidFindBy(xpath = "//*[contains(@text , '探索')]")
    protected WebElement homePageButton;

    @AndroidFindBy(xpath = "//*[contains(@text , '家居清潔')]")
    protected WebElement HCHOOPKGNEW;

    @AndroidFindBy(xpath = "//*[contains(@text , '上門煮飯')]")
    protected WebElement HOCDPKGNEW;

    @AndroidFindBy(xpath = "//*[contains(@text , '深層大掃除')]")
    protected WebElement HCDEPKGNEW;

    @AndroidFindBy(xpath = "//*[contains(@text , '吉屋清潔')]")
    protected WebElement HCUNPKGNEW;

    @AndroidFindBy(xpath = "//*[contains(@text , '洗衣服務')]")
    protected WebElement HCLAPKGNEW;

    @AndroidFindBy(xpath = "//*[contains(@text , '上門按摩')]")
    protected WebElement SMINPKGNEW;

    @AndroidFindBy(xpath = "//*[contains(@text , '冷氣清洗')]")
    protected WebElement HQAIPKGNEW;

    @AndroidFindBy(xpath = "//*[contains(@text , '滅蟲服務')]")
    protected WebElement HCHPCPKGNEW;

    @AndroidFindBy(xpath = "//*[contains(@text , '地毯清潔')]")
    protected WebElement HCRUPKGNEW;

    @AndroidFindBy(xpath = "//*[contains(@text , '除霉及防霉服務')]")
    protected WebElement HCMOPKGNEW;

    @AndroidFindBy(xpath = "//*[contains(@text , '裝修後清潔')]")
    protected WebElement HCCLPKGNEW;

    @AndroidFindBy(xpath = "//*[contains(@text , '入伙前清潔')]")
    protected WebElement HCMIPKGNEW;

    @AndroidFindBy(xpath = "//*[contains(@text , '除甲醛')]")
    protected WebElement HCFOPKGNEW;

    @AndroidFindBy(xpath = "//*[contains(@text , '下一步')]")
    protected WebElement nextButtonOnOnboardingPage;

    @AndroidFindBy(xpath = "//*[contains(@text , '完成')]")
    protected WebElement completeButton;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/close")
    protected WebElement errorPopUpCloseButton;

    @AndroidFindBy(id = "com.hellotoby.consumer.android.staging:id/beauty_directButton")
    protected WebElement beautyButton;

    @AndroidFindBy(xpath = "//*[contains(@text , '髮型屋')]")
    protected WebElement salonButton;

    @AndroidFindBy(xpath = "//*[contains(@text , '美容院')]")
    protected WebElement cosmeticButton;

    @AndroidFindBy(xpath = "//*[contains(@text , '按摩')]")
    protected WebElement massageButton;

    @AndroidFindBy(xpath = "//*[contains(@text , '美甲')]")
    protected WebElement manicureButton;

    @AndroidFindBy(xpath = "//*[contains(@text , '地區')]")
    protected WebElement districtFilterButton;

    @AndroidFindBy(xpath = "//*[contains(@text , '髮型服務')]")
    protected WebElement hairService;

    @AndroidFindBy(xpath = "//*[contains(@text , '篩選')]")
    protected WebElement filterButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[6]/android.view.ViewGroup")
    protected WebElement filterScrollButton;

    @AndroidFindBy(xpath = "//*[contains(@text , '智能排序')]")
    protected WebElement sortingButton;

    @AndroidFindBy(xpath = "//*[contains(@text , '重設')]")
    protected WebElement resetButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[7]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup")
    protected WebElement salonStoreBookmarkButton;






    public Page() {
        PageFactory.initElements(new AppiumFieldDecorator(TestRunner.getDriver()), this);

    }

    @Override
    public MobileElement getMobileElement(String elementID) {
        return (MobileElement) driver.findElementById(elementID);
    }

    @Override
    public MobileElement getMobileElementByLocator(By locator) {
        return (MobileElement) driver.findElement(locator);
    }

    public String phoneNumber() {
        Random rand = new Random();
        int num1 = (rand.nextInt(7) + 1) * 100 + (rand.nextInt(8) * 10) + rand.nextInt(8);
        int num2 = rand.nextInt(743);
        int num3 = rand.nextInt(10000);

        DecimalFormat df3 = new DecimalFormat("9000"); // 3 zeros
        DecimalFormat df4 = new DecimalFormat("0000"); // 4 zeros

        return df3.format(num1) + df4.format(num3);
    }

    public void allowLocationChecking() {
        driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).isDisplayed();
        System.out.println("Allow Location Alert Pop Up is display");
        driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_one_time_button")).click();
    }

    public void address() throws InterruptedException {
        addressQuestion.isDisplayed();
        for (int i = 0; i <= 1; i++) {
            threadSleep(1);
            scrollElement(1, EScrollDirection.down, 500);
        }
        driver.findElement(By.id("com.hellotoby.consumer.android.staging:id/GEN-CONTACT-ADDRESS_createBtn")).click();
        findLocationField.isDisplayed();
        findLocationField.click();
        gpsSearchButton.isDisplayed();
        gpsSearchButton.click();
        try {
            allowLocationChecking();
        } catch (Exception e) {
        }
        Thread.sleep(1000);
        List<WebElement> gpsResult = driver.findElements(By.xpath("//*[contains(@resource-id , 'result')]"));
        List<String> gps_Result_ID = new ArrayList<>();
        for (int j = 0; j <= gpsResult.size() - 1; j++) {
            WebElement gpsRsultXpath = gpsResult.get(j);
            gps_Result_ID.add(gpsRsultXpath.getAttribute("resource-id"));
        }
        System.out.println(gps_Result_ID);
        System.out.println("GPS Search is work");
        ArrayList<String> locationValue = new ArrayList<>();
        locationValue.add("Central");
        locationValue.add("kwun tong");
        locationValue.add("New Territories");
        Random rand = new Random();
        int locationValues = rand.nextInt(locationValue.size());
        Thread.sleep(2000);
        locationInputField.sendKeys(locationValue.get(locationValues));
        Thread.sleep(1000);
        List<WebElement> gpsSearchResult = driver.findElements(By.xpath("//*[contains(@resource-id , 'autocomplete')]"));
        List<String> gps_Search_Result_ID = new ArrayList<>();
        for (int k = 0; k <= gpsSearchResult.size() - 1; k++) {
            WebElement gpsSearchRsultXpath = gpsSearchResult.get(k);
            gps_Search_Result_ID.add(gpsSearchRsultXpath.getAttribute("resource-id"));
        }
        System.out.println(gps_Search_Result_ID);
        System.out.println("GPS Search is work.");
        int gps_Search_Random = rand.nextInt(gps_Search_Result_ID.size());
        driver.findElement(By.id(gps_Search_Result_ID.get(gps_Search_Random))).click();
        Thread.sleep(1000);
        roomInputField.sendKeys("50");
        Thread.sleep(1000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.EditText");
        el3.sendKeys("hihihi");
        MobileElement el4 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.EditText");
        el4.sendKeys("51234123");
        MobileElement el5 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.EditText");
        el5.sendKeys("tobytestcase3@test.com");
        createAddressOverlayLocator.click();
        Thread.sleep(2000);
        ctaButtonOnCreateAddressOverlay.click();
    }

    public void randomInputValue() {
        ArrayList<String> value = new ArrayList<>();
        value.add("5");
        value.add("15");
        value.add("169");
        Random rand = new Random();
        int randomValue = rand.nextInt(value.size());
        driver.findElement(By.xpath("//*[contains(@text , '請說明')]")).sendKeys(value.get(randomValue));
    }

    public void randomCreditCard() {
        ArrayList<String> creditCard = new ArrayList<>();
        creditCard.add("5555555555554444");
        creditCard.add("378282246310005");
        creditCard.add("4000056655665556");
        Random rand = new Random();
        int randomCreditCard = rand.nextInt(creditCard.size());
        creditCardInputFieldOnAddCreditCardOverlay.sendKeys(creditCard.get(randomCreditCard));
    }

    public void callLoginAPI() {
        RestAssured.baseURI = "http://47.89.50.192:8888/api";
        RequestSpecification request = RestAssured.given();
        requestParams.put("email", "ggff@test.com");
        requestParams.put("password", "123456");
        request.header("Content-Type", "application/json;charset=UTF-8");
        Response response = request.body(requestParams).post("/user/login/?locale=zh-hk&localeId=zh-hk&nfcountry=HK");
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
        System.out.println(response.asString());
    }

    public void randomIndex() {
        String[] packID = {Android.HCHOOPKGNEW, Android.HOCDPKGNEW, Android.HCDEPKGNEW, Android.HCUNPKGNEW, Android.HCCLPKGNEW, Android.HCFOPKGNEW, Android.HCHPCPKGNEW, Android.HCLAPKGNEW
                , Android.HCMIPKGNEW, Android.HCMOPKGNEW, Android.HCRUPKGNEW, Android.HQAIPKGNEW, Android.SMINPKGNEW};
        for (int i = 0; i < packID.length; i++) {
            pack.put(i, packID[i]);
        }
        randomValue = rand.nextInt(pack.size());
        randomIndex.put(randomValue , packID);
    }

    public void randomSelectPackage() {
        randomIndex();
        randomIndex.get(randomValue);

    }

    public void clickPackage() {
            for (int i = 0; i <= 1; i++) {
                scrollElement(By.xpath(pack.get(randomValue)), EScrollDirection.down, 4000, true);
            }
            driver.findElement(By.xpath(pack.get(randomValue))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Android.ctaHomeServiceOnboardingPage)));
            ctaButtonOnHomeServiceOnboarding.click();

        }

    public java.lang.String getPackageID() {
        randomSelectPackage();
        String[] catID = {"HCHOO", "HOCD", "HCDE", "HCUN", "HCCL", "HCFO", "HCHPC", "HCLA", "HCMI", "HCMO", "HCRU", "HQAI", "SMIN"};
        for (int i = 0; i < catID.length; i++) {
            map.put(i, catID[i]);
        }
        System.out.println(map.get(randomValue));
        return map.get(randomValue);
    }



    public void callQuestionnaireAPI() throws IOException, InterruptedException {
        String mapRandomValue = this.getPackageID();
        JSONObject requestParams2 = new JSONObject();
        RestAssured.baseURI = "http://47.89.50.192:8888/api";
        RequestSpecification request = RestAssured.given();
        clickPackage();
        callLoginAPI();
        requestParams2.put("questions" , questions_empty);
        requestParams2.put("pageNum" , 999);
        requestParams2.put("version" , 2);
        System.out.println(requestParams2);
        request.header("Content-Type", "application/json;charset=UTF-8");
        Response getPackageResponse = request.body(requestParams2).post("/package/direct/" + mapRandomValue + "-PKG-NEW/questions?locale=zh-hk&localeId=zh-hk&nfcountry=HK");
        int statusCode2 = getPackageResponse.getStatusCode();
        System.out.println(statusCode2);
        System.out.println(getPackageResponse.asString());
        Object postResult = getPackageResponse.asString();
        JSONObject result = JSON.parseObject((java.lang.String) postResult);
        JSONObject getRespondData = result.getJSONObject("data");
        System.out.println(getRespondData);
        JSONArray getRespondQuestions = getRespondData.getJSONArray("questions");
        System.out.println(getRespondQuestions);
        int currentQuestionIndex = 0;
        int total = 1;

        JSONArray answers = new JSONArray(); //create a new array list for questions
        while (currentQuestionIndex <= total) {
            JSONArray updateTotal = getRespondQuestions;
            total = updateTotal.size();
            currentQuestionIndex++;
            this.updateAnswerToServer(answers, getRespondQuestions , getRespondQuestions , getRespondQuestions);
            //updateAnswerToServer = update request body
        }
}

    public JSONObject genNumberAnswer(JSONArray getRespondQuestions) {
        for (Object apiResult : getRespondQuestions) {
            Map<String, Object> apiQuestions = (Map<String, Object>) apiResult;
            JSONArray apiValue = (JSONArray) apiQuestions.get("possibleValues");
            String questionNumber = (String) apiQuestions.get("questionNumber");
            JSONObject answerValueIndex = apiValue.getJSONObject(0);
            Object answerValue = answerValueIndex.get("value");
            System.out.println(answerValue);
            String valueItem = null;
            if (apiValue.get(0) != null) {
                JSONObject questionsValue = (JSONObject) apiValue.get(0);
                valueItem = (String) questionsValue.get("value");
            }


            JSONObject answer = new JSONObject();
            Object value = null;

            if (answerValue instanceof String) {
                value = answerValue;
            }

            if (value != null) {
                answer.put("value", valueItem);
            }
            JSONArray answers = new JSONArray();
            answers.add(answer);

            JSONObject question = new JSONObject();
            question.put("questionNumber", questionNumber);
            question.put("answers", answers);

            JSONArray questions = new JSONArray();
            questions.add(question);

            JSONObject numberAnswer = new JSONObject();
            numberAnswer.put("pageNum", 999);
            numberAnswer.put("questions", questions);
            numberAnswer.put("version", 2);
            System.out.println(numberAnswer);

            return numberAnswer;
        }

        return null;
    }



    public com.alibaba.fastjson.JSONObject getEnumerationAnswer(JSONArray getRespondQuestions) {
        for (Object apiResult : getRespondQuestions) {
            Map<String, Object> apiQuestions = (Map<String, Object>) apiResult;
            JSONArray apiValue = (JSONArray) apiQuestions.get("possibleValues");
            String questionNumber = (String) apiQuestions.get("questionNumber");
            JSONObject answerValueIndex = apiValue.getJSONObject(0);
            Object answerValue = answerValueIndex.get("value");
            System.out.println(answerValue);
            String valueItem = null;
            if (apiValue.get(0) != null) {
                JSONObject questionsValue = (JSONObject) apiValue.get(0);
                valueItem = (String) questionsValue.get("value");
            }


            JSONObject answer = new JSONObject();
            Object value = null;
            if (answerValue instanceof String) {
                value = 1;
            } else {
                value = "a";
            }
            if (value != null) {
                answer.put("value", valueItem);
            }
            JSONArray answers = new JSONArray();
            answers.add(answer);

            JSONObject question = new JSONObject();
            question.put("questionNumber", questionNumber);
            question.put("answers", answers);

            JSONArray questions = new JSONArray();
            questions.add(question);

            JSONObject numberAnswer = new JSONObject();
            numberAnswer.put("pageNum", 999);
            numberAnswer.put("questions", questions);
            numberAnswer.put("version", 2);
            System.out.println(numberAnswer);

            return numberAnswer;
        }
        return null;
    }

//    private JSONObject getAddressAnswer(JSONArray getRespondQuestions) {
//        for (Object apiResult : getRespondQuestions) {
//            Map<String, Object> apiQuestions = (Map<String, Object>) apiResult;
//            JSONArray apiValue = (JSONArray) apiQuestions.get("possibleValues");
//            String questionNumber = (String) apiQuestions.get("questionNumber");
//            JSONObject answerValueIndex = apiValue.getJSONObject(0);
//            Object answerValue = answerValueIndex.get("value");
//            System.out.println(answerValue);
//            String valueItem = null;
//            if (apiValue.get(0) != null) {
//                JSONObject questionsValue = (JSONObject) apiValue.get(0);
//                valueItem = (String) questionsValue.get("value");
//            }
//
//
//            return null;
//        }
//        return null;
//    }
//
//    private JSONObject getDateTimeAnwer() {
//
//        apiRespond.sample();
//
//        // Refer to enum answer
//        return dateTimeAnswer;
//    }

    /// ...

    private void updateAnswerToServer(JSONArray answers, JSONArray answerByQuestionType , JSONArray getRespondQuestions , JSONArray genNumberAnswer) throws InterruptedException {
        for (Object apiResult : getRespondQuestions) {
            Map<String, Object> apiQuestions = (Map<String, Object>) apiResult;
            String questionNumber = (String) apiQuestions.get("questionNumber");
            System.out.println(questionNumber);
            System.out.println(apiQuestions.get("type"));
            JSONObject answer = answerByQuestionType((String) apiQuestions.get("type"), questionNumber, answerByQuestionType , genNumberAnswer);
            answers.add(answer);

        }
    }

    public JSONObject answerByQuestionType(String type, String questionNumber, JSONArray getEnumerationAnswer , JSONArray genNumberAnswer) throws InterruptedException {
        Random rand = new Random();
        switch (type) {
            case "ENUMERATION":
                try {
                    driver.findElement(By.id("com.hellotoby.consumer.android.staging:id/" + questionNumber + "_answer_0")).click();
                    Thread.sleep(2000);
                    driver.findElement(By.id("com.hellotoby.consumer.android.staging:id/db_form_nextBtn")).click();
                    return getEnumerationAnswer(getEnumerationAnswer);
                } catch (Exception e) {
                }
//                try {
//                    driver.findElement(By.id("com.hellotoby.consumer.android.staging:id/" + questionNumber + "_answer_3")).click();
//                    Thread.sleep(2000);
//                    driver.findElement(By.id("com.hellotoby.consumer.android.staging:id/db_form_nextBtn")).click();
//                } catch (Exception e) {
//                }
                break;
            case "NUMBER":
                try {
                    Thread.sleep(2000);
                    driver.findElement(By.id("com.hellotoby.consumer.android.staging:id/db_form_nextBtn")).click();
                    return genNumberAnswer(genNumberAnswer);
                } catch (Exception e) {
                }
                break;
            case "DATETIME":
                Thread.sleep(2000);
                List<WebElement> newTimeXpath = driver.findElements(By.xpath("//*[contains(@resource-id , 'timelist')]"));
                List<String> timeID = new ArrayList<>();
                for (int i = 0; i <= newTimeXpath.size() - 1; i++) {
                    WebElement timeXpath = newTimeXpath.get(i);
                    timeID.add(timeXpath.getAttribute("resource-id"));
                    System.out.println(timeID);
                }
                Thread.sleep(1000);
            {
                int randomValue_time = rand.nextInt(timeID.size());
                driver.findElement(By.id(timeID.get(randomValue_time))).click();
                Thread.sleep(2000);
            }
            Thread.sleep(2000);
            driver.findElement(By.id("com.hellotoby.consumer.android.staging:id/db_form_nextBtn")).click();

//            return this.getDateTimeAnwer();
            break;
            case "ADDRESS":
                try {
                    Thread.sleep(2000);
                    driver.findElement(By.id("com.hellotoby.consumer.android.staging:id/GEN-CONTACT-ADDRESS_answer_0")).click();
                    driver.findElement(By.id("com.hellotoby.consumer.android.stagin g:id/db_form_nextBtn")).click();
                    break;
                } catch (Exception e) {
                }
                try {
                    Thread.sleep(2000);
                    driver.findElement(By.id("com.hellotoby.consumer.android.staging:id/GEN-CONTACT-ADDRESS_createBtn")).click();
                    driver.findElement(By.id("com.hellotoby.consumer.android.staging:id/address")).isDisplayed();
                    driver.findElement(By.id("com.hellotoby.consumer.android.staging:id/address")).click();
                    driver.findElement(By.id("com.hellotoby.consumer.android.staging:id/address_autocomplete_gps_search_btn")).isDisplayed();
                    driver.findElement(By.id("com.hellotoby.consumer.android.staging:id/address_autocomplete_gps_search_btn")).click();
                    try {
                        driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).isDisplayed();
                        System.out.println("Allow Location Alert Pop Up is display");
                        driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_one_time_button")).click();
                    } catch (Exception e) {
                    }
                    Thread.sleep(1000);
                    List<WebElement> gpsResult = driver.findElements(By.xpath("//*[contains(@resource-id , 'result')]"));
                    List<String> gps_Result_ID = new ArrayList<>();
                    for (int j = 0; j <= gpsResult.size() - 1; j++) {
                        WebElement gpsRsultXpath = gpsResult.get(j);
                        gps_Result_ID.add(gpsRsultXpath.getAttribute("resource-id"));
                    }
                    System.out.println(gps_Result_ID);
                    System.out.println("GPS Search is work");
                    ArrayList<String> locationValue = new ArrayList<>();
                    locationValue.add("Central");
                    locationValue.add("kwun tong");
                    locationValue.add("New Territories");
                    int locationValues = rand.nextInt(locationValue.size());
                    Thread.sleep(2000);
                    driver.findElement(By.id("com.hellotoby.consumer.android.staging:id/address")).sendKeys(locationValue.get(locationValues));
                    driver.findElement(By.id("com.hellotoby.consumer.android.staging:id/address")).sendKeys(locationValue.get(locationValues));
                    Thread.sleep(1000);
                    List<WebElement> gpsSearchResult = driver.findElements(By.xpath("//*[contains(@resource-id , 'autocomplete')]"));
                    List<String> gps_Search_Result_ID = new ArrayList<>();
                    for (int k = 0; k <= gpsSearchResult.size() - 1; k++) {
                        WebElement gpsSearchRsultXpath = gpsSearchResult.get(k);
                        gps_Search_Result_ID.add(gpsSearchRsultXpath.getAttribute("resource-id"));
                    }
                    System.out.println(gps_Search_Result_ID);
                    System.out.println("GPS Search is work.");
                    int gps_Search_Random = rand.nextInt(gps_Search_Result_ID.size());
                    Thread.sleep(1000);
                    driver.findElement(By.id(gps_Search_Result_ID.get(gps_Search_Random))).click();
                    driver.findElement(By.id(gps_Search_Result_ID.get(gps_Search_Random))).click();
                    System.out.println("Selected Location");
                    Thread.sleep(3000);
                    driver.findElement(By.id("com.hellotoby.consumer.android.staging:id/addressDetail")).click();
                    driver.findElement(By.id("com.hellotoby.consumer.android.staging:id/addressDetail")).sendKeys("50");
                    Thread.sleep(1000);
//                    MobileElement el3 = (MobileElement) driver.findElementsById("com.hellotoby.consumer.android.staging:id/name");
//                    el3.click();
//                    el3.sendKeys("hihihi");
//                    MobileElement el4 = (MobileElement) driver.findElementsById("com.hellotoby.consumer.android.staging:id/phone");
//                    el4.sendKeys("51234123");
//                    MobileElement el5 = (MobileElement) driver.findElementsById("com.hellotoby.consumer.android.staging:id/email");
//                    el5.sendKeys("tobytestcase3@test.com");
//                    el5.sendKeys(Keys.ENTER);
//                    Thread.sleep(2000);
                    driver.findElement(By.xpath("//*[contains(@text , '完成')]")).click();
                    Thread.sleep(2000);
                    driver.findElement(By.id("com.hellotoby.consumer.android.staging:id/db_form_nextBtn")).click();

//                    return this.getAddressAnswer();
                } catch (Exception e) {
                }
                break;
            case "CLEANER":
                Thread.sleep(2000);
                driver.findElement(By.id("com.hellotoby.consumer.android.staging:id/Cleaner_answer_1")).click();
                Thread.sleep(2000);
                driver.findElement(By.id("com.hellotoby.consumer.android.staging:id/db_form_nextBtn")).click();
                break;
            case "IMAGENUMBER":
                Thread.sleep(2000);
                driver.findElement(By.id("com.hellotoby.consumer.android.staging:id/db_form_nextBtn")).click();
                break;
            case "TEXT":
                List<WebElement> inputText = driver.findElements(By.xpath("//*[contains(@resource-id , 'input')]"));
                List<String> inputID = new ArrayList<>();
                for (int i = 0; i <= inputText.size() - 1; i++) {
                    WebElement timeXpath = inputText.get(i);
                    inputID.add(timeXpath.getAttribute("resource-id"));
                    System.out.println(inputID);
                }
                int randomValue_time = rand.nextInt(inputID.size());
                driver.findElement(By.id(inputID.get(randomValue_time))).sendKeys("1234");
                Thread.sleep(2000);
                driver.findElement(By.id("com.hellotoby.consumer.android.staging:id/db_form_nextBtn")).click();
        }

        return null;
    }


}














