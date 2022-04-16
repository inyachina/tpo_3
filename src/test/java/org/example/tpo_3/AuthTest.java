package org.example.tpo_3;

import org.example.tpo_3.model.main_page.AuthComponent;
import org.example.tpo_3.model.main_page.ProfileComponent;
import org.junit.Assert;
import org.junit.Test;

public class AuthTest extends SeleniumTest {

    public AuthComponent authComponent;
    public ProfileComponent profileComponent;


    @Test
    public void logInTest() {
        drivers.parallelStream().forEach(webDriver -> {
            profileComponent = new ProfileComponent(webDriver);
            authComponent = new AuthComponent(webDriver);

            authComponent.setLogin(Utils.CORRECT_LOGIN);
            authComponent.setPassword(Utils.CORRECT_PASSWORD);
            authComponent.clickSignInButton();
            Assert.assertEquals(profileComponent.getLogin(), Utils.CORRECT_LOGIN);
        });
    }

    @Test
    public void wrongLoginTest() {
        drivers.parallelStream().forEach(webDriver -> {
            authComponent = new AuthComponent(webDriver);
            authComponent.setLogin(Utils.WRONG_LOGIN);
            authComponent.setPassword(Utils.CORRECT_PASSWORD);
            authComponent.clickSignInButton();
            Assert.assertEquals("Ошибка. Вы ввели неверные данные авторизации", authComponent.getErrorMessage());
        });
    }

    @Test
    public void wrongPasswordTest() {
        drivers.parallelStream().forEach(webDriver -> {
            authComponent = new AuthComponent(webDriver);
            authComponent.setLogin(Utils.CORRECT_LOGIN);
            authComponent.setPassword(Utils.WRONG_PASSWORD);
            authComponent.clickSignInButton();
            Assert.assertEquals("Ошибка. Вы ввели неверные данные авторизации", authComponent.getErrorMessage());
        });
    }
}
