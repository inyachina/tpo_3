package org.example.tpo_3.model.main_page;

import lombok.Getter;
import org.example.tpo_3.Utils;
import org.example.tpo_3.model.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Getter
public class PostSectionComponent extends Component {

    public PostSectionComponent(WebDriver driver) {
        super(driver);
    }

    public WebElement getSaveButtonOfFirstPost() {
        return Utils.getElementBySelector(driver, By.xpath("//div[@class='story__save hint '][1]"));
    }
    public WebElement getTitleOfFirstPost() {
        return Utils.getElementBySelector(driver, By.xpath("//a[contains(@class, 'story__title-link')][1]"));
    }

    public WebElement getCategoryOption() {
        return Utils.getElementBySelector(driver, By.xpath("//div[@class='story-save__cat'][1]"));
    }
}
