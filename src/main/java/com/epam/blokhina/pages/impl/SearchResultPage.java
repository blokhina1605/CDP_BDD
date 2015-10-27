package com.epam.blokhina.pages.impl;

import com.epam.blokhina.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collection;
import java.util.List;


public class SearchResultPage extends AbstractPage {

    private By searchResults = By.cssSelector("div.name");

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getResults() {
        return $$(searchResults);
    }
}
