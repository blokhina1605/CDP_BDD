package com.epam.blokhina.pages.impl;

import com.epam.blokhina.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class CategoryLandingPage extends AbstractPage {
    private By subcategoryListPath = By.cssSelector("div.ct>a");

    public CategoryLandingPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getSubcategoryList() {
        return $$(subcategoryListPath);
    }
}
