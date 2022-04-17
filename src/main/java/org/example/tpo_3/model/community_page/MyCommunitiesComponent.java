package org.example.tpo_3.model.community_page;

import lombok.Getter;
import org.example.tpo_3.Utils;
import org.example.tpo_3.model.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Getter
public class MyCommunitiesComponent extends Component {

    public MyCommunitiesComponent(WebDriver driver) {
        super(driver);
    }

    public WebElement getUnsubscribeButtonByTitle(String text) {
        return Utils.getElementBySelector(driver,
                By.xpath("//button[text()='Отписаться']/parent::span/parent::div/child::div/child::a[text()='" + text + "']"));
    }

}
