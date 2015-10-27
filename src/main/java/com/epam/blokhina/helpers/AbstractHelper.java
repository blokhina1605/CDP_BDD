package com.epam.blokhina.helpers;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AbstractHelper {
    protected WebDriver driver;

    public AbstractHelper(WebDriver driver) {
        this.driver = driver;
    }

    public AbstractHelper openPage(String startPage) {
        driver.get(startPage);
        return this;
    }

    public void clickOnElementFromList(List<WebElement> list, String element) {
        for (WebElement reqElement : list) {
            if (reqElement.getText().equals(element)) {
                reqElement.click();
                break;
            }
        }
    }
}
