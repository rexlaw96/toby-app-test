package com.HelloToby.Consumer.steps.regression;

import com.HelloToby.Consumer.pages.EScrollDirection;
import com.HelloToby.Consumer.pages.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class DirectBookingQuestionnaire extends Page {
    @Given("I click Service Button")
    public void iClickServiceButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Android.directBookingButton)));
        directBookingButton.click();
    }

    @Then("I shall direct to Home Service Onboarding with CTA Button")
    public void iShallDirectToHomeServiceOnboardingWithCTAButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Android.homeCleaningButton)));
//        for (int i = 0; i <= 1; i++) {
//            scrollElement(By.id(Android.homeCleaningButton) , EScrollDirection.down , 1200 , true);
//        }
    }

    @When("I click CTA Button on Home Service Onboarding Page")
    public void iClickCTAButtonOnHomeServiceOnboardingPage() {

    }

    @Then("I shall direct to Home Service Questionnaire Page")
    public void iShallDirectToHomeServiceQuestionnairePage() {
    }
}
