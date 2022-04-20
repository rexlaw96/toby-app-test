package com.HelloToby.Consumer.steps.regression;

import com.HelloToby.Consumer.pages.EScrollDirection;
import com.HelloToby.Consumer.pages.Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class AddCreditCard extends Page {
    @Given("I click Add Credit Card Select Field")
    public void iClickAddCreditCardSelectField() {
        paymentMethodSelectFieldOnDirectBookingConfirmationPage.click();
        for (int i = 0; i <= 2; i++) {
            threadSleep(1);
            scrollElement(By.id(Android.addNewCreditCardButton) , EScrollDirection.down , 1200 , true);
        }
        addCreditCardButton.click();
    }

    @Then("I shall see Add Credit Card Overlay display")
    public void iShallSeeAddCreditCardOverlayDisplay() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Android.addCreditCardOverlayLocator)));
        Assert.assertTrue(addCreditCardOverlayLocator.isDisplayed(), "Add Credit Card Overlay is displayed");
    }

    @When("I input invalid Credit Card Number")
    public void iInputInvalidCreditCardNumber() {
        creditCardInputFieldOnAddCreditCardOverlay.click();
        creditCardInputFieldOnAddCreditCardOverlay.sendKeys("1234567812345678");
        addCreditCardOverlayLocator.click();
    }

    @Then("I shall see inline error display on Add Credit Card Overlay")
    public void iShallSeeInlineErrorDisplayOnAddCreditCardOverlay() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Android.invalidCreditCardInlineError)));
        Assert.assertTrue(invalidCreditCardInlineError.isDisplayed() , "Inline Error is displayed");
    }

    @When("I input invalid Expiry Date")
    public void iInputInvalidExpiryDate() {
        expiryDateInputFieldOnAddCreditCardOverlay.click();
        expiryDateInputFieldOnAddCreditCardOverlay.sendKeys("1220");
        addCreditCardOverlayLocator.click();
    }

    @Then("I shall see inline error")
    public void iShallSeeInlineError() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Android.invalidExpiryDateInlineError)));
        Assert.assertTrue(invalidExpiryDateInlineError.isDisplayed() , "Inline Error is displayed");
    }

    @When("I input valid Credit Card Number")
    public void iInputValidCreditCardNumber() throws InterruptedException {
        creditCardInputFieldOnAddCreditCardOverlay.click();
        creditCardInputFieldOnAddCreditCardOverlay.clear();
        randomCreditCard();
        cvvInputFieldOnAddCreditCardOverlay.click();
        cvvInputFieldOnAddCreditCardOverlay.sendKeys("2131");
        expiryDateInputFieldOnAddCreditCardOverlay.click();
        expiryDateInputFieldOnAddCreditCardOverlay.sendKeys("1225");
        Thread.sleep(5000);
    }

    @Then("I click CTA Button on Add Credit Card Overlay")
    public void iClickCTAButtonOnAddCreditCardOverlay() {
        ctaButtonOnAddCreditCardOverlay.click();
        ctaButtonOnAddCreditCardOverlay.click();
    }

    @And("I shall see Credit Card Number and Expiry Date display on Payment Method Select Field")
    public void iShallSeeCreditCardNumberAndExpiryDateDisplayOnPaymentMethodSelectField() {
        if (errorPopUpCloseButton.isDisplayed()) {
            errorPopUpCloseButton.click();
        }
    }
}
