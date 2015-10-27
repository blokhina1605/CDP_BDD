package com.epam.blokhina.core.webdriver;


import com.epam.blokhina.core.properties.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

import static com.epam.blokhina.core.properties.UtilsConstants.BROWSERS_CONFIGURATION;

public class DriverManager {
    private static WebDriver driver;

    private static PropertyReader propertiesReader = new PropertyReader(BROWSERS_CONFIGURATION);
    private static final String BROWSER_TYPE = propertiesReader.getPropertyValue("browser.type");

    public static WebDriver createInstance() {
        switch (BROWSER_TYPE) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                driver = new FirefoxDriver();
                break;
        }
        return optimizeDriver(driver);
    }

    private static WebDriver optimizeDriver(WebDriver driver) {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        return driver;
    }
}
