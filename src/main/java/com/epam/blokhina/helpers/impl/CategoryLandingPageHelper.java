package com.epam.blokhina.helpers.impl;

import com.epam.blokhina.helpers.AbstractHelper;
import com.epam.blokhina.pages.impl.CategoryLandingPage;
import org.openqa.selenium.WebDriver;


public class CategoryLandingPageHelper extends AbstractHelper {
    private CategoryLandingPage categoryLandingPage;

    public CategoryLandingPageHelper(WebDriver driver) {
        super(driver);
        categoryLandingPage = new CategoryLandingPage(driver);
    }

    public CategoryLandingPageHelper selectSubcategory(String subcategory) {
        clickOnElementFromList(categoryLandingPage.getSubcategoryList(), subcategory);
        return this;
    }

    public ProductListingPageHelper redirectToProductListingPage() {
        return new ProductListingPageHelper(driver);
    }
}
