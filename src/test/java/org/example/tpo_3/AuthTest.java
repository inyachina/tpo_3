package org.example.tpo_3;

import org.example.tpo_3.model.AuthComponent;
import org.example.tpo_3.model.ProfileComponent;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AuthTest {
    public static AuthComponent authComponent;
    public static ProfileComponent profileComponent;

    @BeforeClass
    public static void prepareDrivers() {
        Utils.prepareDrivers();
    }

    @Test
    public void loginTest() {
        List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            webDriver.get(Utils.BASE_URL);
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            profileComponent = new ProfileComponent(webDriver);
            authComponent = new AuthComponent(webDriver);
            authComponent.setLogin(Utils.CORRECT_LOGIN);
            authComponent.setPassword(Utils.CORRECT_PASSWORD);
            authComponent.clickSignInButton();
            Assert.assertEquals(profileComponent.getLogin(), Utils.CORRECT_LOGIN);
        });
        drivers.forEach(WebDriver::quit);
    }
}
