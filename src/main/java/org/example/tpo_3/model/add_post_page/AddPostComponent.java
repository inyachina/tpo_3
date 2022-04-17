package org.example.tpo_3.model.add_post_page;

import lombok.Getter;
import org.example.tpo_3.model.Component;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class AddPostComponent extends Component {
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/main/div/form/div[1]/span/div")
    private WebElement titleInput;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/main/div/form/section[1]/div[1]/input")
    private WebElement tagInput;

    @FindBy(xpath = "//button[text()='Предпросмотр']")
    private WebElement previewButton;

    public AddPostComponent(WebDriver driver) {
        super(driver);
    }
}
