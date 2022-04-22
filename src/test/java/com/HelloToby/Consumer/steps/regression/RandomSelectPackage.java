package com.HelloToby.Consumer.steps.regression;

import com.HelloToby.Consumer.pages.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RandomSelectPackage extends Page {
    @Given("I am on direct booking landing page")
    public void iAmOnDirectBookingLandingPage() {
        HCHOOPKGNEW.isDisplayed();
    }

    @When("I random select package")
    public void iRandomSelectPackage() {
        clickPackage();
        getPackageRandomValue();
    }

    @Then("I shall direct to Home Cleaning Onboarding Page")
    public void iShallDirectToHomeCleaningOnboardingPage() {
    }
}
