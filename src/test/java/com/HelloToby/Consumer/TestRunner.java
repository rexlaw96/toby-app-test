package com.HelloToby.Consumer;

//import com.HelloToby.reporting.ReportWithConfigs;
import com.HelloToby.reporting.ReportWithConfigs;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
//import io.cucumber.java.Scenario;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/regression"},
        plugin = {
                "pretty",
                "html:target/report/index.html",
                "json:target/report/cucumber.json"
        },
        // tags = "@Test_1",
        glue={"com/HelloToby/Consumer/steps/regression"}
)



public class TestRunner {

    private TestNGCucumberRunner testNGCucumberRunner;
    public static AppiumDriver<WebElement> driver;
    private static AppiumDriverLocalService server;
    private static TestRunner instance = null;
    public static synchronized TestRunner sharedInstance() {
        if (instance == null) {
            instance = new TestRunner();
        }
        return instance;
    }
    public boolean isRunningOniOS() {
        return driver instanceof IOSDriver;
    }



    @BeforeSuite
    public void startAppium() throws MalformedURLException, InterruptedException {
        System.out.println("...setup aos appium");

//this.deviceName = devicename;
//this.os = os;
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
        serviceBuilder.withIPAddress("127.0.0.1");
        serviceBuilder.usingAnyFreePort();
        serviceBuilder.usingDriverExecutable(new File("/opt/homebrew/bin/node"));
        serviceBuilder.withAppiumJS(new File("/opt/homebrew/bin/appium"));
        serviceBuilder.withArgument(GeneralServerFlag.LOG_TIMESTAMP);
        serviceBuilder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        // can reuse the session and when have error ,log it.
        serviceBuilder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");

// The XCUITest driver requires that a path to the Carthage binary is in the PATH variable.
// I have this set for my shell, but the Java process does not see it. It can be inserted here.
//HashMap<String, String> environment = new HashMap();
//environment.put("PATH", "/usr/local/bin:" + System.getenv("PATH"));
//serviceBuilder.withEnvironment(environment);

        System.out.println("Starting Appium Client...");
        server = AppiumDriverLocalService.buildService(serviceBuilder);
        if(server.isRunning()) {
            server.stop();
// try {
// Runtime.getRuntime().exec("killall -KILL node");
// Runtime.getRuntime().exec("killall -KILL qemu-system-i386");
// } catch (IOException e) {
// e.printStackTrace();
// }
        }
        server.start();
        System.out.println("...Appium URL : "+server.getUrl());
        // to see what is the port using


        startAOSSession();
//        startIOSSession();

    }

    // after start Appium , link the emulator to it

    // second large hook
//    @BeforeClass
    public static void startAOSSession() throws MalformedURLException, InterruptedException {
        System.out.println("...start aos Session");

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("deviceName", "SM_A4260");
        cap.setCapability("platformVersion", "11.0");
        cap.setCapability("app", "/Users/Rex/Downloads/app-staging.apk");
        cap.setCapability("isAutoAcceptAlert", "true");
        cap.setCapability("noReset","true");
        cap.setCapability("fullReset","false");




        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
//        driver = new AndroidDriver<WebElement>(server.getUrl(), cap);
//        System.out.println("testDriver" + driver);
//        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
//        Thread.sleep(50000);
//        System.out.println("sleep");

// baseStep.setTLDriver(new AndroidDriver (service.getUrl(),capabilities));
// //wait = new WebDriverWait(baseStep.getTLDriver(), Long.parseLong(getPropertiesByObjectKey("longwait")));
// System.out.println("...setupDriver ThreadLocalDriver.getTLDriver() session : "+baseStep.getTLDriver().getSessionId());
// baseStep.getTLDriver().manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

    }

//    public static void startIOSSession() throws MalformedURLException {
//        System.out.println("...start IOS Session");
//
//        DesiredCapabilities cap = new DesiredCapabilities();
//        cap.setCapability("platformName", "iOS");
//        cap.setCapability("automationName", "XCUITest");
//        cap.setCapability("deviceName", "iPhone 11 Pro Max");
//        cap.setCapability("platformVersion", "13.3");
//        cap.setCapability("app", "/Users/elise.mc.luk/Desktop/Train/PizzaHut_iOS_Sim_CRM_UAT.zip");
//        cap.setCapability("isAutoAcceptAlert", "true");


//                driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
//        driver = new IOSDriver<WebElement>(server.getUrl(), cap);
//        System.out.println("testDriver" + driver);
//        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

// baseStep.setTLDriver(new AndroidDriver (service.getUrl(),capabilities));
// //wait = new WebDriverWait(baseStep.getTLDriver(), Long.parseLong(getPropertiesByObjectKey("longwait")));
// System.out.println("...setupDriver ThreadLocalDriver.getTLDriver() session : "+baseStep.getTLDriver().getSessionId());
// baseStep.getTLDriver().manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

//    }

    @BeforeTest(alwaysRun = true)
    public void setUpClass() {
        this.testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = {"cucumber"}, description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        this.testNGCucumberRunner.runScenario(pickleWrapper.getPickle());

// System.out.println("...getLine : "+pickleWrapper.getPickle().getLine());
// System.out.println("...getName : "+pickleWrapper.getPickle().getName());
// System.out.println("...getScenarioLine : "+pickleWrapper.getPickle().getScenarioLine());
// System.out.println("...getTags : "+pickleWrapper.getPickle().getTags());
// System.out.println("...getUri : "+pickleWrapper.getPickle().getUri());

        // ** get Pickle =  get the steps and run

    }

// @DataProvider
// public Object[][] scenarios() {
// return this.testNGCucumberRunner == null ? new Object[0][0] : this.testNGCucumberRunner.provideScenarios();
// }

    @DataProvider
    public Object[][] scenarios() {
        System.out.println("...scenarios size : "+testNGCucumberRunner.provideScenarios().length);
        return testNGCucumberRunner.provideScenarios();
    }

    public static AppiumDriver<WebElement> getDriver() {
        return driver;
    }

    @AfterTest(alwaysRun=true)
    public void tearDownClass() {
        testNGCucumberRunner.finish();
        new ReportWithConfigs().generateReport();
//        TestRunner.getDriver().quit();

    }

}

