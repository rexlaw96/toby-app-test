package com.HelloToby.Consumer.steps.regression;

import com.HelloToby.Consumer.pages.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.HelloToby.Consumer.TestRunner.driver;

public class CompetePayment extends Page {
    @Given("I selected Payment Method on Payment Overlay")
    public void iSelectedPaymentMethodOnPaymentOverlay() {
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.hellotoby.consumer.android.staging:id/CARD")));
        driver.findElement(By.id("com.hellotoby.consumer.android.staging:id/CARD")).click();
    }

    @When("I click CTA Button on Confirmation Page")
    public void iClickCTAButtonOnConfirmationPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.hellotoby.consumer.android.staging:id/payment_submit")));
        driver.findElement(By.id("com.hellotoby.consumer.android.staging:id/payment_submit")).click();
    }

    @Then("I direct to Thank You Your Booking Page")
    public void iDirectToThankYouYourBookingPage() {

    }
}
