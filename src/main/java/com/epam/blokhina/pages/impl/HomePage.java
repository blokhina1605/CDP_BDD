package com.epam.blokhina.pages.impl;

import com.epam.blokhina.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class HomePage extends AbstractPage {

    private By categoriesListPath = By.cssSelector("a.main_page_link_catalog");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getCategoriesList() {
        return $$(categoriesListPath);
    }
}
