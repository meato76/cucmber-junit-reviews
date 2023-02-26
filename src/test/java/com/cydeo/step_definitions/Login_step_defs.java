package com.cydeo.step_definitions;

import com.cydeo.pages.SeamlessLoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class Login_step_defs {

    SeamlessLoginPage loginPage=new SeamlessLoginPage();
    @Given("the user is on the log in page")
    public void the_user_is_on_the_log_in_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("seamless.url"));
    }
    @When("the user enter valid username")
    public void the_user_enter_valid_username() {
        loginPage.txt_username.sendKeys(ConfigurationReader.getProperty("seamless.username"));
    }
    @When("the user enter valid password")
    public void the_user_enter_valid_password() {
        loginPage.txt_password.sendKeys(ConfigurationReader.getProperty("seamless.password"));
    }
    @When("the user clicks the log in button")
    public void the_user_clicks_the_log_in_button() {
        loginPage.btn_log_in.click();
    }
    @Then("the user should be able to log in")
    public void the_user_should_be_able_to_log_in() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Files1"));
    }

    @Then("the user should not be able to log in")
    public void the_user_should_not_be_able_to_log_in() {
        Assert.assertEquals("Seamlessly",Driver.getDriver().getTitle());
    }





    @When("the user enters username {string}")
    public void the_user_enter_username_with_param(String username) {
        if (username.equals("empty")){
            loginPage.txt_username.sendKeys("");
        }else {
            loginPage.txt_username.sendKeys(username);
        }

    }
    @When("the user enters password {string}")
    public void the_user_enter_password_with_param(String password) {
        if (password.equals("empty")){
            loginPage.txt_password.sendKeys("");
        }else {
            loginPage.txt_password.sendKeys(password);
        }
    }






}