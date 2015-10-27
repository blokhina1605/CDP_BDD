package com.epam.blokhina.helpers.impl;

import com.epam.blokhina.helpers.AbstractHelper;
import com.epam.blokhina.pages.impl.ProductListingPage;
import com.epam.blokhina.utils.CustomUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class ProductListingPageHelper extends AbstractHelper {

    private ProductListingPage productListingPage;
    private static int NUMBER_OF_PRODUCTS = 0;
    private static String THE_CHEAPEST_PRODUCT_NAME = null;

    public ProductListingPageHelper(WebDriver driver) {
        super(driver);
        productListingPage = new ProductListingPage(driver);
    }

    public ProductListingPageHelper setMinPrice(String minPrice) {
        clickOnElementFromList(productListingPage.getMinPrices(), minPrice);
        return this;
    }

    public ProductListingPageHelper setMaxPrice(String maxPrice) {
        clickOnElementFromList(productListingPage.getMaxPrices(), maxPrice);
        return this;
    }

    public int getProductListSize() {
        return productListingPage.getProductsPricesList().size();
    }

    public boolean verifyFilterByPrice(double min, double max) {
        for (Double price : CustomUtils.convertToDoubleList(productListingPage.getProductsPricesList())) {
            if (price < min || price > max) {
                return false;
            }
        }
        return true;
    }

    public ProductListingPageHelper selectManufacturers(List<String> manufacturersList) {
        for (String manufacturer : manufacturersList) {
            NUMBER_OF_PRODUCTS += CustomUtils.selectPriceOnly(productListingPage.getNumberNearManufacturer(manufacturer).getText());
            clickOnElementFromList(productListingPage.getManufacturersList(), manufacturer);
        }
        return this;
    }

    public int getNumberOfProducts() {
        return NUMBER_OF_PRODUCTS;
    }

    public boolean verifyFilterByManufacturer(List<String> manufacturersList) {
        boolean flag = false;
        for (WebElement webElement : productListingPage.getProductsNamesList()) {
            for (String manufacturer : manufacturersList) {
                if (webElement.getText().startsWith(manufacturer)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return false;
            }
            flag = false;
        }
        return true;
    }

    public ProductListingPageHelper sortProductByPrice() {
        productListingPage.clickElement(productListingPage.getSortByPriceBtn());
        return this;
    }

    public ProductListingPageHelper defineNameOfTheCheapestProduct() {
        double firstProductPrice = CustomUtils.selectPriceOnly(productListingPage.getProductsPricesList().get(0).getText());
        double secondProductPrice = CustomUtils.selectPriceOnly(productListingPage.getProductsPricesList().get(1).getText());
        if (firstProductPrice < secondProductPrice) {
            THE_CHEAPEST_PRODUCT_NAME = productListingPage.getProductsNamesList().get(0).getText();
        }
        return this;
    }

    public ProductListingPageHelper inputNameIntoSearchField() {
        productListingPage.inputText(productListingPage.getSearchField(), THE_CHEAPEST_PRODUCT_NAME);
        return this;
    }

    public ProductListingPageHelper clickSearchBtn() {
        productListingPage.clickElement(productListingPage.getSearchBtn());
        return this;
    }

    public SearchResultPageHelper redirectToSearchResultPage() {
        return new SearchResultPageHelper(driver);
    }

    public String getTheCheapestProductName() {
        return THE_CHEAPEST_PRODUCT_NAME;
    }
}
