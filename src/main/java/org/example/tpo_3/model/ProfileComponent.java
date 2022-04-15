package org.example.tpo_3.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfileComponent extends Page{
    @FindBy(xpath = "/html/body/div[1]/div[1]/div[1]/aside/div[1]/div[1]/div/div[2]/div[1]/a")
    private WebElement loginName;
    public ProfileComponent(WebDriver driver) {
        super(driver);
    }

    public String getLogin(){
        return loginName.getText();
    }
}
