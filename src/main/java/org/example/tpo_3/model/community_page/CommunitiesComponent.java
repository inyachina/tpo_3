package org.example.tpo_3.model.community_page;

import lombok.Getter;
import org.example.tpo_3.model.Component;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class CommunitiesComponent extends Component {

    @FindBy(xpath = "//button[text()='Подписаться']")
    private WebElement firstSubscribeButton;

    @FindBy(xpath = "//a/parent::div[@class='community__title'][1]")
    private WebElement firstTitle;

    @FindBy(xpath = "//a[text()='Мои сообщества']")
    private WebElement myCommunitiesTab;

    public CommunitiesComponent(WebDriver driver) {
        super(driver);
    }

}
