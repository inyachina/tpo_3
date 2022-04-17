package org.example.tpo_3.model.saved_posts_page;

import org.example.tpo_3.Utils;
import org.example.tpo_3.model.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SavedPostsComponent extends Component {
    public SavedPostsComponent(WebDriver driver) {
        super(driver);
    }

    public WebElement getLastPostTitle(){
        return Utils.getElementBySelector(driver, By.xpath("//h2[@class='story__title'][1]"));
    }
}
