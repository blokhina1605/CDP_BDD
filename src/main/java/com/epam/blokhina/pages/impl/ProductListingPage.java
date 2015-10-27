package com.epam.blokhina.pages.impl;

import com.epam.blokhina.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class ProductListingPage extends AbstractPage {
    private By listOfMinPrice = By.xpath("(//div[@class = 'is_empty_items'])[1]/a");
    private By listOfMaxPrice = By.xpath("(//div[@class = 'is_empty_items'])[2]/a");
    private By productsPricesList = By.cssSelector("div.price>strong");
    private By manufacturersList = By.xpath("(//div[@class = 'is_empty_items'])[3]/a");
    private String manufacturerPath = "(//div[@class = 'is_empty_items'])[3]/a[contains(.,'%s')]/following-sibling::i[1]";
    private By productsNamesList = By.cssSelector("div.name>a");
    private By sortByPriceBtn = By.cssSelector("div.order a:nth-of-type(1)");
    private By searchField = By.cssSelector("#edit-name-1");
    private By searchBtn = By.cssSelector("#edit-submit-1");

    public ProductListingPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getMinPrices() {
        return $$(listOfMinPrice);
    }

    public List<WebElement> getMaxPrices() {
        return $$(listOfMaxPrice);
    }

    public List<WebElement> getProductsPricesList() {
        return $$(productsPricesList);
    }

    public List<WebElement> getManufacturersList() {
        return $$(manufacturersList);
    }

    public WebElement getNumberNearManufacturer(String manufacturer) {
        return $(manufacturerPath, manufacturer);
    }

    public List<WebElement> getProductsNamesList() {
        return $$(productsNamesList);
    }

    public WebElement getSortByPriceBtn() {
        return $(sortByPriceBtn);
    }

    public WebElement getSearchField() {
        return $(searchField);
    }

    public WebElement getSearchBtn(){
        return $(searchBtn);
    }
}
