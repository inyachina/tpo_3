package org.example.tpo_3.model;

import org.example.tpo_3.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthComponent extends Page {
    @FindBy(xpath = "//*[@id=\"signin-form\"]/div[1]/div/div/input")
    private WebElement loginInput;

    @FindBy(xpath = "//*[@id=\"signin-form\"]/div[2]/div/div/input")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"signin-form\"]/div[7]/button")
    private WebElement signInButton;

    public AuthComponent(WebDriver driver) {
        super(driver);
    }

    public void setLogin(String login) {
        loginInput.sendKeys(login);
    }

    public void setPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickSignInButton(){
        signInButton.click();
    }

}
