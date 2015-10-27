package com.epam.blokhina.helpers.impl;

import com.epam.blokhina.helpers.AbstractHelper;
import com.epam.blokhina.pages.impl.SearchResultPage;
import org.openqa.selenium.WebDriver;


public class SearchResultPageHelper extends AbstractHelper {

    private SearchResultPage searchResultPage;

    public SearchResultPageHelper(WebDriver driver) {
        super(driver);
        searchResultPage = new SearchResultPage(driver);
    }

    public int getSearchResultsListSize() {
        return searchResultPage.getResults().size();
    }

    public String getNameOfFirstProduct(){
        return searchResultPage.getResults().get(0).getText();
    }
}
