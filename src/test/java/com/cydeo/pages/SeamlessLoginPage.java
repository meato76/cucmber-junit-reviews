package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeamlessLoginPage {
    public SeamlessLoginPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//input[@id='user']")
    public WebElement txt_username;



    @FindBy(xpath = "//input[@id='password']")
    public WebElement txt_password;

    @FindBy(xpath = "//input[@id='submit-form']")
    public WebElement btn_log_in;
}
