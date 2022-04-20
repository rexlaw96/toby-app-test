package com.HelloToby.Consumer.steps.regression;

import com.HelloToby.Consumer.pages.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StoreListingPage extends Page {
    @Given("I am on Store Landing Page")
    public void iAmOnStoreLandingPage() {
        beautyButton.click();
    }

    @When("I click Salon Button on Store Landing Page")
    public void iClickSalonButtonOnStoreLandingPage() {
        salonButton.click();
    }

    @Then("I shall direct to Salon Store Listing Page")
    public void iShallDirectToSalonStoreListingPage() {
        salonStoreBookmarkButton.isDisplayed();
    }
}
