package com.HelloToby.Consumer.steps.regression;

import com.HelloToby.Consumer.pages.Page;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class PromotionSelectField extends Page {
    @When("I click Add Promotion Code Field")
    public void iClickAddPromotionCodeField() {
        do {
            if (serviceDetailCollapseButton.isDisplayed()) {
        try {
            promotionCodeSelectFieldOnDirectBookingConfirmationPage.click();
            Thread.sleep(2000);
            break;
        } catch (Exception e) {
        }
        try {
            addPromotionCode.click();
        } catch (Exception e){
        }
            }
            break;
        }
        while(true);
    }

    @Then("I can input Promotion Code")
    public void iCanInputPromotionCode() {
        do {
            if (serviceDetailCollapseButton.isDisplayed()) {
                try {
                    addPromotionCode.click();
                    Thread.sleep(3000);
                    break;
                } catch (Exception e) {
                }
                try {
                    promotionCodeOnComfirmationPage.click();
                    promotionCodeOnComfirmationPage.sendKeys("testestestest");
                } catch (Exception e) {
                }
            }
            break;
        }
        while(true);
    }

    @When("I input invalid Promotion Code")
    public void iInputInvalidPromotionCode() {
        promotionCodeOnComfirmationPage.clear();
        promotionCodeOnComfirmationPage.sendKeys("tobytest");
        promotionCodeUseButton.click();
        promotionCodeUseButton.click();
    }

    @Then("I shall see Promotion Code invalid Error Pop Up")
    public void iShallSeePromotionCodeInvalidErrorPopUp() {
        Assert.assertTrue("error msg is displayed" , invalidPromotionCodeErrorMsg.isDisplayed());
    }

    @When("I input valid Promotion Code")
    public void iInputValidPromotionCode() {
        promotionCodeOnComfirmationPage.sendKeys("fix");
    }

    @Then("I shall see inputted Promotion Code display on Promotion Code Select Field")
    public void iShallSeeInputtedPromotionCodeDisplayOnPromotionCodeSelectField() {
        promotionCodeUseButton.click();
    }
}
