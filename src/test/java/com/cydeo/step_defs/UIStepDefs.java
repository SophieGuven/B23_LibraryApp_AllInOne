package com.cydeo.step_defs;

import com.cydeo.pages.LoginPage;
import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class UIStepDefs {

    @Given("the user on the login page")
    public void the_user_on_the_login_page() {
        new LoginPage().goTo();
    }
    @When("the user logged in as {string}")
    public void the_user_logged_in_as(String user) {
     new LoginPage().login(user);

        BrowserUtil.waitFor(6);
    }
    @Then("{string} should be displayed")
    public void should_be_displayed(String expectedResult) {
        System.out.println("Driver.getDriver().getCurrentUrl() = " + Driver.getDriver().getCurrentUrl());
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().endsWith(expectedResult));
    }





}
