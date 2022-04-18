package org.example.tpo_3.model.main_page;

import lombok.Getter;
import org.example.tpo_3.Utils;
import org.example.tpo_3.model.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Getter
public class AuthComponent extends Component {
    @FindBy(xpath = "//input[@name='username']")
    private WebElement loginInput;

    @FindBy(xpath = "//input[@name='password']")
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

    public void logIn() {
        setLogin(Utils.CORRECT_LOGIN);
        setPassword(Utils.CORRECT_PASSWORD);
        clickSignInButton();
    }

    public void waitUntilAuthorized() {
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
        w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[text()='Войти']/parent::button")));
    }
}
