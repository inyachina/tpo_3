package org.example.tpo_3;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.List;

public abstract class SeleniumTest {
    protected List<WebDriver> drivers;

    @Before
    public void setup() {
        Utils.prepareDrivers();
        drivers = Utils.getDrivers();
        drivers.forEach(webDriver -> {
            webDriver.get(Utils.BASE_URL);
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        });
    }

    @After
    public void shutUp() {
        drivers.forEach(WebDriver::quit);
    }

}
