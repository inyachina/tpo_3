package org.example.tpo_3;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class SeleniumTest {
    protected List<WebDriver> drivers;

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

}
