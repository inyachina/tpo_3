package org.example.tpo_3.main_page;

import org.example.tpo_3.SeleniumTest;
import org.example.tpo_3.Utils;
import org.example.tpo_3.model.main_page.HeaderComponent;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class SearchTest extends SeleniumTest {

    @Test
    public void searchTest() {
        drivers.parallelStream().forEach(webDriver -> {
            HeaderComponent headerComponent = new HeaderComponent(webDriver);
            WebElement searchInput = headerComponent.getSearchInput();
            WebElement searchButton = headerComponent.getSearchButton();
            searchButton.click();
            searchInput.sendKeys("тест");
            searchButton.click();
            Utils.waitUntilPageReload(webDriver);
            Assert.assertTrue(webDriver.getCurrentUrl().contains("search"));
        });
    }
}
