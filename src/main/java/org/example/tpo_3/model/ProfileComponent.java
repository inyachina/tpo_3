package org.example.tpo_3.model;

import org.example.tpo_3.Utils;
import org.openqa.selenium.By;
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

    public ProfileComponent(WebDriver driver) {
        super(driver);
    }

    public String getLogin() {
        return loginName.getText();
    }

    public void logout() {
        Utils.waitUntilPageReload(this.driver);
        logOutButton.click();
        WebElement confirmLogOutButton = Utils.getElementBySelector(driver, By.xpath("/html/body/div[4]/div/div/div[1]/div[2]/button[1]"));
        confirmLogOutButton.click();
    }
}
