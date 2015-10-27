package com.epam.blokhina.stepdefs;

import com.epam.blokhina.core.webdriver.DriverManager;
import com.epam.blokhina.helpers.impl.CategoryLandingPageHelper;
import com.epam.blokhina.helpers.impl.HomePageHelper;
import com.epam.blokhina.helpers.impl.ProductListingPageHelper;
import com.epam.blokhina.helpers.impl.SearchResultPageHelper;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class FilterTestStepdefs {

    private HomePageHelper homePageHelper;
    private CategoryLandingPageHelper categoryLandingPageHelper;
    private ProductListingPageHelper productListingPageHelper;
    private SearchResultPageHelper searchResultPageHelper;
    private WebDriver driver;

    @Before
    public void setUp() throws InterruptedException {
        driver = DriverManager.createInstance();
        homePageHelper = new HomePageHelper(driver);
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @Given("^I am on start page \"([^\"]*)\"$")
    public void I_am_on_start_page(String startPage) {
        homePageHelper.openPage(startPage);
    }

    @And("^I select category \"([^\"]*)\"$")
    public void I_select_category(String category) {
        categoryLandingPageHelper = homePageHelper.selectCategory(category)
                .redirectToCategoryLandingPage();
    }

    @And("^I select subcategory \"([^\"]*)\"$")
    public void I_select_subcategory(String subcategory) {
        productListingPageHelper = categoryLandingPageHelper.selectSubcategory(subcategory)
                .redirectToProductListingPage();
    }

    @And("^I set minimum \"([^\"]*)\" and maximum \"([^\"]*)\" prices$")
    public void I_set_minimum_and_maximum_prices(String minPrice, String maxPrice) {
        productListingPageHelper.setMinPrice(minPrice).setMaxPrice(maxPrice);
    }

    @Then("^I see results matching search parameters \"([^\"]*)\" \"([^\"]*)\"$")
    public void I_see_results_matching_search_parameters(String min, String max) {
        assertTrue(productListingPageHelper.verifyFilterByPrice(Double.parseDouble(min), Double.parseDouble(max)));
    }

    @And("^I select manufacturer:$")
    public void I_select_manufacturer(List<String> manufacturersList) {
        productListingPageHelper.selectManufacturers(manufacturersList);
    }

    @Then("^the number of products equals to the number next to the manufacturer$")
    public void that_the_number_of_products_equals_to_the_number_that_was_indicated_next_to_the_manufacturer_name() {
        assertEquals(productListingPageHelper.getNumberOfProducts(), productListingPageHelper.getProductListSize());
    }

    @And("^product names begin with the selected products$")
    public void product_names_begin_with_the_selected_products(List<String> manufacturersList) {
        assertTrue(productListingPageHelper.verifyFilterByManufacturer(manufacturersList));
    }

    @And("^I sort product by price$")
    public void I_sort_product_by_price() {
        productListingPageHelper.sortProductByPrice();
    }

    @And("^I get the name of the cheapest product$")
    public void I_get_the_name_of_the_cheapest_product() {
        productListingPageHelper.defineNameOfTheCheapestProduct();
    }

    @And("^enter product name into the search field and submit$")
    public void enter_product_name_into_the_search_field() {
        searchResultPageHelper = productListingPageHelper.inputNameIntoSearchField()
                .clickSearchBtn()
                .redirectToSearchResultPage();
    }

    @Then("^Search Results Page has (\\d+) product$")
    public void Search_Results_Page_has_product(int quantity) {
        assertEquals(quantity, searchResultPageHelper.getSearchResultsListSize());
    }

    @And("^product name is equal to specified name$")
    public void product_name_is_equal_to_specified_name() {
        assertEquals(productListingPageHelper.getTheCheapestProductName(), searchResultPageHelper.getNameOfFirstProduct());
    }
}
