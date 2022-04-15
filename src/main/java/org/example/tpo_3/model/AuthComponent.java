package org.example.tpo_3.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthComponent extends Page {
    @FindBy(xpath = "//input[@placeholder='Логин']")
    private WebElement loginInput;

    @FindBy(xpath = "//input[@placeholder='Пароль']")
    private WebElement passwordInput;

    @FindBy(xpath = "//span[text()='Войти']/parent::button")
    private WebElement signInButton;

    @FindBy(xpath = "//span[text()='Ошибка. Вы ввели неверные данные авторизации']")
    private WebElement errorText;

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
        return errorText.getText();
    }

    public Boolean isSignInButtonRendered(){
        return this.signInButton != null;
    }

}
