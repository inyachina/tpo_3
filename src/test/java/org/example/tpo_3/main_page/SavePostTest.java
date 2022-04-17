package org.example.tpo_3.main_page;

import org.example.tpo_3.SeleniumTest;
import org.example.tpo_3.Utils;
import org.example.tpo_3.model.main_page.AuthComponent;
import org.example.tpo_3.model.main_page.PostSectionComponent;
import org.example.tpo_3.model.main_page.ProfileComponent;
import org.example.tpo_3.model.saved_posts_page.SavedPostsComponent;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class SavePostTest extends SeleniumTest {

    @Test
    public void savePostTest() {
        drivers.parallelStream().forEach(webDriver -> {
                    Utils.passAuth(webDriver);

                    PostSectionComponent postSectionComponent = new PostSectionComponent(webDriver);
                    WebElement saveButton = postSectionComponent.getSaveButtonOfFirstPost();
                    WebElement title = postSectionComponent.getTitleOfFirstPost();
                    String savedPostTitle = title.getText();
                    saveButton.click();
                    WebElement categoryOption = postSectionComponent.getCategoryOption();
                    categoryOption.click();

                    ProfileComponent profileComponent = new ProfileComponent(webDriver);
                    WebElement savedListButton = profileComponent.getSavedListButton();
                    savedListButton.click();
                    Utils.waitUntilPageReload(webDriver);
                    Assert.assertTrue(webDriver.getCurrentUrl().contains(Utils.SAVED_POSTS_URL));

                    SavedPostsComponent savedPostsComponent = new SavedPostsComponent(webDriver);
                    String lastPostTitleInSavedPostPage = savedPostsComponent.getLastPostTitle().getText();
                    Assert.assertEquals(lastPostTitleInSavedPostPage, savedPostTitle);
                }
        );
    }
}
