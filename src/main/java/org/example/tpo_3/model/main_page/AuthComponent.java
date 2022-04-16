package org.example.tpo_3.model.main_page;

import org.example.tpo_3.Utils;
import org.example.tpo_3.model.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthComponent extends Component {
    @FindBy(xpath = "//input[@placeholder='Логин']")
    private WebElement loginInput;

    @FindBy(xpath = "//input[@placeholder='Пароль']")
    private WebElement passwordInput;

    @FindBy(xpath = "//span[text()='Войти']/parent::button")
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

    public void clickSignInButton() {
        signInButton.click();
    }

    public String getErrorMessage() {
        WebElement errorText = Utils.getElementBySelector(driver, By.xpath("//*[@id=\"signin-form\"]/div[5]/span"));
        return errorText.getText();
    }

    public Boolean isSignInButtonRendered() {
        return this.signInButton != null;
    }

    public void logIn() {
        setLogin(Utils.CORRECT_LOGIN);
        setPassword(Utils.CORRECT_PASSWORD);
        clickSignInButton();
    }

}
