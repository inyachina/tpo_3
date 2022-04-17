package org.example.tpo_3;

import org.example.tpo_3.model.main_page.AuthComponent;
import org.example.tpo_3.model.main_page.ProfileComponent;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class LogoutTest extends SeleniumTest {

    @Test
    public void logOutTest() {
        drivers.forEach(webDriver -> {
            Utils.passAuth(webDriver);

            ProfileComponent profileComponent = new ProfileComponent(webDriver);
            WebElement logoutButton = profileComponent.getLogoutButton();
            logoutButton.click();
            WebElement confirmLogoutButton = profileComponent.getConfirmButton();
            confirmLogoutButton.click();

            Utils.waitUntilPageReload(webDriver);
            AuthComponent authComponent = new AuthComponent(webDriver);
            WebElement signInButton = authComponent.getSignInButton();
            Assert.assertNotNull(signInButton);
        });
    }
}
