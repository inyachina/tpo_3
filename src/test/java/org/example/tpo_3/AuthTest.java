package org.example.tpo_3;

import org.example.tpo_3.model.AuthComponent;
import org.example.tpo_3.model.ProfileComponent;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AuthTest {
    public List<WebDriver> drivers;

    public AuthComponent authComponent;
    public ProfileComponent profileComponent;

    @Before
    public void setup() {
        Utils.prepareDrivers();
        drivers = Utils.getDrivers();
        drivers.forEach(webDriver -> {
            webDriver.get(Utils.BASE_URL);
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        });
    }

    @After
    public void shutUp() {
        drivers.forEach(WebDriver::quit);
    }


    @Test
    public void logInAndLogOutTest() {
        drivers.parallelStream().forEach(webDriver -> {
            profileComponent = new ProfileComponent(webDriver);
            authComponent = new AuthComponent(webDriver);

            authComponent.setLogin(Utils.CORRECT_LOGIN);
            authComponent.setPassword(Utils.CORRECT_PASSWORD);
            authComponent.clickSignInButton();
            Assert.assertEquals(profileComponent.getLogin(), Utils.CORRECT_LOGIN);
//            profileComponent.logout();
//            Assert.assertTrue(authComponent.isSignInButtonRendered());
        });
    }

    @Test
    public void wrongLoginTest() {
        drivers.parallelStream().forEach(webDriver -> {
            authComponent = new AuthComponent(webDriver);
            authComponent.setLogin(Utils.WRONG_LOGIN);
            authComponent.setPassword(Utils.CORRECT_PASSWORD);
            authComponent.clickSignInButton();
            Assert.assertEquals( "Ошибка. Вы ввели неверные данные авторизации", authComponent.getErrorMessage());
        });
    }
}
