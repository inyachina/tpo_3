package org.example.tpo_3;

import org.example.tpo_3.model.main_page.AuthComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static final String CHROME_SYSTEM_PROPERTY_NAME = "webdriver.chrome.driver";
    public static final String CHROME_SYSTEM_PROPERTY_PATH = "drivers/chromedriver";
    public static final String FIREFOX_SYSTEM_PROPERTY_NAME = "webdriver.gecko.driver";
    public static final String FIREFOX_SYSTEM_PROPERTY_PATH = "drivers/geckodriver";

    public static final String BASE_URL = "https://pikabu.ru";

    public static final String ADD_URL = "/add";
    public static final String SAVED_POSTS_URL = "/saved-stories";

    public static final String CORRECT_LOGIN = "zpepa";
    public static final String CORRECT_PASSWORD = "язузф228";

    public static final String WRONG_LOGIN = "ninininin";
    public static final String WRONG_PASSWORD = "ninininin228";

    public static List<WebDriver> getDrivers() {
        List<WebDriver> drivers = new ArrayList<>();
        try {
            List<String> properties = Files.readAllLines(Paths.get("pikabu.properties"));
            for (String property : properties) {
                if (property.startsWith("WEB_DRIVER")) {
                    switch (property.toLowerCase().split("=")[1]) {
                        case "chrome":
                            drivers.add(getChromeDriver());
                            return drivers;
                        case "firefox":
                            drivers.add(getFirefoxDriver());
                            return drivers;
                        case "both":
                            drivers.add(getChromeDriver());
                            drivers.add(getFirefoxDriver());
                            return drivers;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Web driver is not specified");
    }

    private static ChromeDriver getChromeDriver() {
        if (!System.getProperties().containsKey(CHROME_SYSTEM_PROPERTY_NAME)) {
            throw new RuntimeException("Chrome driver not set properly");
        }
        System.out.println(CHROME_SYSTEM_PROPERTY_NAME);
        return new ChromeDriver();
    }

    private static FirefoxDriver getFirefoxDriver() {
        if (!System.getProperties().containsKey(FIREFOX_SYSTEM_PROPERTY_NAME)) {
            throw new RuntimeException("Firefox driver not set properly");
        }
        return new FirefoxDriver();
    }

    public static void prepareDrivers() {
        System.setProperty(CHROME_SYSTEM_PROPERTY_NAME, CHROME_SYSTEM_PROPERTY_PATH);
        System.setProperty(FIREFOX_SYSTEM_PROPERTY_NAME, FIREFOX_SYSTEM_PROPERTY_PATH);
    }

    public static void waitUntilPageReload(WebDriver driver) {
        WebDriverWait waitDriver = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitDriver.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public static WebElement getElementBySelector(WebDriver driver, By selector) {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(5), Duration.ofMillis(500));
        return driverWait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }


    public static void passAuth(WebDriver webDriver) {
        AuthComponent authComponent = new AuthComponent(webDriver);
        authComponent.logIn();
        authComponent.waitUntilAuthorized();
    }
}

