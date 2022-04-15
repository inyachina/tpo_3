package org.example.tpo_3;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    @BeforeClass
    public static void prepareDrivers() {
        Utils.prepareDrivers();
    }

    @Test
    public void testDriver() {
        Utils.getDrivers().forEach(this::executeWithCapabilities);
    }

    private void executeWithCapabilities(WebDriver driver) {
        driver.get(Utils.BASE_URL);
        String title = driver.getTitle();
        Assert.assertEquals("Горячее – самые интересные и обсуждаемые посты | Пикабу", title);
        driver.quit();
    }
}
