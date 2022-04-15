package org.example.tpo_3.model;

import lombok.Data;
import org.openqa.selenium.WebDriver;

@Data
public class Page {
    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }
}
