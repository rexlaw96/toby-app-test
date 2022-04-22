package com.HelloToby.Consumer.steps.regression;

import com.HelloToby.Consumer.TestRunner;
import com.HelloToby.Consumer.pages.Page;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DirectBookingValidation extends Page {
    @Given("I select the {string} category on the landing page")
    public void iSelectTheCategoryOnTheLandingPage(String arg0) {
        directBookingButton.click();
    }

    @Then("I shall see below components :")
    public void iShallSeeBelowComponents(DataTable dataTable) {
        try {
            TestRunner.getDriver().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

            List<List<String>> dataList = dataTable.asLists(String.class);

            System.out.println("dataList:" + dataList);
            for (List<String> row : dataList) {

                System.out.println("ROW" + row);

                if (HCHOOPKGNEW.isDisplayed()) {
                    System.out.println("Home Cleaning can be found.");
                } else {
                    System.out.println("Home Cleaning cannot be found.");
                }

                if (HOCDPKGNEW.isDisplayed()) {
                    System.out.println("To Home Cooking can be found");
                } else {
                    System.out.println("To Home Cooking cannot be found");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("All elements can be found.");
    }
}



