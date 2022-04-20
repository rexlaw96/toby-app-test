package com.HelloToby.Consumer.steps.regression;

import com.HelloToby.Consumer.pages.Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class PassQuestionnaire extends Page {
    @Given("I go to Questionnaire")
    public void iGoToQuestionnaire() throws IOException, InterruptedException {
        callQuestionnaireAPI();
    }

    @Then("I shall direct to Questionnaire")
    public void iShallDirectToQuestionnaire() {
        
    }

    @And("I shall see CTA Button dimmed by default")
    public void iShallSeeCTAButtonDimmedByDefault() {
        
    }

    @When("I select answer")
    public void iSelectAnswer() {
        
    }

    @Then("I shall see CTA Button enable")
    public void iShallSeeCTAButtonEnable() {
    }
}
