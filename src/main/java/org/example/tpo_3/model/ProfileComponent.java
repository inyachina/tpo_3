package org.example.tpo_3.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProfileComponent extends Page {
    @FindBy(xpath = "//a[@class='user__nick user__nick_big']")
    private WebElement loginName;

    @FindBy(xpath = "//div[text()='выйти']")
    private WebElement logOutDiv;

    @FindBy(xpath = "//div[@class='popup__footer']/child::button[text()='Выйти']")
    private WebElement logOutButton;

//    @FindBy(xpath = "//div[@class='popup__footer']/child::button[text()='Выйти']")
//    private WebElement confirmLogOutButton;

    public ProfileComponent(WebDriver driver) {
        super(driver);
    }

    public String getLogin() {
        return loginName.getText();
    }

//    public void logout() {
//        //todo селениум дибил и не видит span "выйти"
//        Actions actions = new Actions(driver);
//        actions.moveToElement(logOutDiv).perform();
//        actions.moveToElement(logOutButton).click().perform();
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
}
