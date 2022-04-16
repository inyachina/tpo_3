package org.example.tpo_3.model.main_page;

import lombok.Getter;
import org.example.tpo_3.model.Component;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class HeaderComponent extends Component {
    @FindBy(xpath = "/html/body/div[1]/header/div[2]/div/div[2]/div[3]/div/div/form/button")
    private WebElement searchButton;

    @FindBy(xpath = "/html/body/div[1]/header/div[2]/div/div[2]/div[3]/div/div[1]/form/div/input[1]")
    private WebElement searchInput;

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }
}
