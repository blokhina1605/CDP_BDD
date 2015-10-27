package com.epam.blokhina.helpers.impl;


import com.epam.blokhina.helpers.AbstractHelper;
import com.epam.blokhina.pages.impl.HomePage;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends AbstractHelper {

    private HomePage homePage;

    public HomePageHelper(WebDriver driver) {
        super(driver);
        homePage = new HomePage(driver);
    }

    //TODO: todo
    public HomePageHelper selectCategory(String category) {
        clickOnElementFromList(homePage.getCategoriesList(), category);
        return this;
    }

    public CategoryLandingPageHelper redirectToCategoryLandingPage() {
        return new CategoryLandingPageHelper(driver);
    }
}
