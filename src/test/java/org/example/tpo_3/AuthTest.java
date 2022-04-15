package org.example.tpo_3;

import org.example.tpo_3.model.AuthComponent;
import org.example.tpo_3.model.ProfileComponent;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AuthTest {
    public static List<WebDriver> drivers;

    public static AuthComponent authComponent;
    public static ProfileComponent profileComponent;

    @BeforeClass
    public static void setup() {
        Utils.prepareDrivers();
        drivers = Utils.getDrivers();
        drivers.forEach(webDriver -> {
            webDriver.get(Utils.BASE_URL);
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        });
    }

    @AfterClass
    public static void shutUp() {
        drivers.forEach(WebDriver::quit);
    }



    @Test
    public void loginTest() {
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
    public void logoutTest() {
        drivers.parallelStream().forEach(webDriver -> {
            profileComponent = new ProfileComponent(webDriver);
            authComponent = new AuthComponent(webDriver);
            profileComponent.logout();
//            Assert.assertTrue(authComponent.isSignInButtonRendered());
        });
    }

//    @Test
//    public void wrongLoginTest() {
//        drivers.parallelStream().forEach(webDriver -> {
//            authComponent = new AuthComponent(webDriver);
//            authComponent.setLogin(Utils.CORRECT_LOGIN);
//            authComponent.setPassword(Utils.WRONG_PASSWORD);
//            authComponent.clickSignInButton();
//            Assert.assertEquals(authComponent.getErrorMessage(), "Ошибка. Вы ввели неверные данные авторизации");
//        });
//    }
}
