package org.example.tpo_3;

import org.example.tpo_3.model.main_page.AuthComponent;
import org.example.tpo_3.model.main_page.ProfileComponent;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LogoutTest {
    public List<WebDriver> drivers;

    public AuthComponent authComponent;
    public ProfileComponent profileComponent;

    @Test
    public void logOutTest() {
        Utils.prepareDrivers();
        drivers = Utils.getDrivers();
        drivers.forEach(webDriver -> {
            webDriver.get(Utils.BASE_URL);
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            profileComponent = new ProfileComponent(webDriver);
            authComponent = new AuthComponent(webDriver);
            authComponent.logIn();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            profileComponent.logout();
            Assert.assertTrue(authComponent.isSignInButtonRendered());
            webDriver.quit();
        });
    }
}
