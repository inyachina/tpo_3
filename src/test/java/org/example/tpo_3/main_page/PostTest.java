package org.example.tpo_3.main_page;

import org.example.tpo_3.SeleniumTest;
import org.example.tpo_3.Utils;
import org.example.tpo_3.model.add_post_page.AddPostComponent;
import org.example.tpo_3.model.main_page.AuthComponent;
import org.example.tpo_3.model.main_page.ProfileComponent;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class PostTest extends SeleniumTest {

    @Test
    public void postTest() {
        drivers.parallelStream().forEach(webDriver -> {
            AuthComponent authComponent = new AuthComponent(webDriver);
            ProfileComponent profileComponent = new ProfileComponent(webDriver);
            AddPostComponent addPostComponent = new AddPostComponent(webDriver);
            WebElement tagInput = addPostComponent.getTagInput();
            WebElement addTextButton = addPostComponent.getAddTextButton();
            WebElement titleInput = addPostComponent.getTitleInput();

            authComponent.logIn();
            Utils.waitUntilPageReload(webDriver);
            profileComponent.waitUntilLoaded();
            WebElement addPostButton = profileComponent.getAddPostButton();

            addPostButton.click();
            Utils.waitUntilPageReload(webDriver);

            titleInput.sendKeys("Анекдот про кота");
            WebElement textArea = addPostComponent.getTextArea();
            addTextButton.click();
            textArea.sendKeys("У опытного кота март в апреле, когда спадает ажиотаж...");
            tagInput.sendKeys("Анекдот");

        });
    }
}
