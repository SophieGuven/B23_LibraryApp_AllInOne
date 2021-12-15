package com.cydeo.pages;



import com.cydeo.utility.ConfigReader;
import com.cydeo.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "inputEmail")
    public WebElement emailBox;

    @FindBy(id = "inputPassword")
    public WebElement passwordBox;

    @FindBy(tagName = "button")
    public WebElement loginButton;

    @FindBy(id = "borrowed_books")
    public WebElement borrowedBooksNumber;

    public void goTo() {

        Driver.getDriver().get(ConfigReader.read("library_url"));

    }

    public void login(String userType){

        String username= ConfigReader.read(userType+"_username");
        String password=ConfigReader.read("password");


        emailBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginButton.click();

    }




}
