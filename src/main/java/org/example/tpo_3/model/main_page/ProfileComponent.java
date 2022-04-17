package org.example.tpo_3.model.main_page;

import lombok.Getter;
import org.example.tpo_3.Utils;
import org.example.tpo_3.model.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


@Getter
public class ProfileComponent extends Component {
    @FindBy(xpath = "//a[contains(@class, 'user__nick')]/parent::div[contains(@class, 'user__info')]")
    private WebElement loginName;

    public ProfileComponent(WebDriver driver) {
        super(driver);
    }

    public String getLogin() {
        return loginName.getText();
    }

    public WebElement getAddPostButton(){
        return Utils.getElementBySelector(driver, By.xpath("//a[contains(@class, 'button_add')]"));
    }

    public WebElement getSavedListButton() {
        return Utils.getElementBySelector(driver, By.xpath("//a[text()='Сохраненное']"));
    }

    public WebElement getLogoutButton() {
        return Utils.getElementBySelector(driver, By.xpath("//div[contains(@class, 'user__exit')]"));
    }

    public WebElement getConfirmButton() {
        return Utils.getElementBySelector(driver, By.xpath("//button[text()='Выйти']"));
    }
}
