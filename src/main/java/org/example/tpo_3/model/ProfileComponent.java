package org.example.tpo_3.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfileComponent extends Page {
    @FindBy(xpath = "/html/body/div[1]/div[1]/div[1]/aside/div[1]/div[1]/div/div[2]/div[1]/a")
    private WebElement loginName;

//    @FindBy(xpath = "/html/body/div[1]/div/div[1]/aside/div[1]/div[1]")
//    private WebElement logOutDiv;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/aside/div[1]/div[1]/div/div[2]/div[2]")
    private WebElement logOutButton;

//    @FindBy(xpath = "/html/body/div[4]/div/div/div[1]/div[2]/button[1]")
//    private WebElement confirmLogOutButton;

    public ProfileComponent(WebDriver driver) {
        super(driver);
    }

    public String getLogin() {
        return loginName.getText();
    }

    public void logout() {
        //todo селениум дибил и не видит span "выйти"
//        Actions actions = new Actions(driver);
//        actions.moveToElement(logOutDiv).perform();
//        actions.moveToElement(logOutButton).click().perform();
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
