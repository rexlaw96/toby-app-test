package com.HelloToby.Consumer.steps.regression;

import com.HelloToby.Consumer.pages.Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DBConfirmationPage extends Page {
    @Given("I click CTA Button on Questionnaire last Question")
    public void iClickCTAButtonOnQuestionnaireLastQuestion() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Android.confirmationPageLocator)));
    }

    @Then("I shall direct to Confirmation Page from Questionnaire")
    public void iShallDirectToConfirmationPageFromQuestionnaire() {
        System.out.println("I am on confirmation Page");
    }

    @And("I shall see CTA Button enable by default")
    public void iShallSeeCTAButtonEnableByDefault() {
    }
}
