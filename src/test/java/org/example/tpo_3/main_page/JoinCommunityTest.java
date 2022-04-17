package org.example.tpo_3.main_page;

import org.example.tpo_3.SeleniumTest;
import org.example.tpo_3.Utils;
import org.example.tpo_3.model.HeaderComponent;
import org.example.tpo_3.model.community_page.CommunitiesComponent;
import org.example.tpo_3.model.community_page.MyCommunitiesComponent;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class JoinCommunityTest extends SeleniumTest {

    @Test
    public void joinCommunityTest() {
        drivers.parallelStream().forEach(webDriver -> {
                    Utils.passAuth(webDriver);

                    HeaderComponent headerComponent = new HeaderComponent(webDriver);
                    headerComponent.getCommunityTab().click();
                    Utils.waitUntilPageReload(webDriver);

                    CommunitiesComponent communitySectionComponent = new CommunitiesComponent(webDriver);
                    WebElement firstSubscribeButton = communitySectionComponent.getFirstSubscribeButton();
                    String communityTitle = communitySectionComponent.getFirstTitle().getText();
                    firstSubscribeButton.click();

                    WebElement myCommunitiesTab = communitySectionComponent.getMyCommunitiesTab();
                    myCommunitiesTab.click();

                    Utils.waitUntilPageReload(webDriver);
                    MyCommunitiesComponent myCommunitiesComponent = new MyCommunitiesComponent(webDriver);
                    WebElement unsubscribeButtonByTitle = myCommunitiesComponent.getUnsubscribeButtonByTitle(communityTitle);

                    Assert.assertNotNull(unsubscribeButtonByTitle);
                }
        );
    }
}
