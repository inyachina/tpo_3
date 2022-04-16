package org.example.tpo_3.model;

import org.example.tpo_3.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfileComponent extends Page {
    @FindBy(xpath = "/html/body/div[1]/div[1]/div[1]/aside/div[1]/div[1]/div/div[2]/div[1]/a")
    private WebElement loginName;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[1]/aside/div[1]/div[1]/div/div[2]/div[2]")
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
