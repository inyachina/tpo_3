package org.example.tpo_3.model;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

@Data
public class Component {
    protected WebDriver driver;

    public Component(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
