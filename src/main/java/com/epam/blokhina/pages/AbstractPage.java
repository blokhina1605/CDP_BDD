package com.epam.blokhina.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;


public class AbstractPage {
    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElement(By elementPath) {
        $(elementPath, ExpectedConditions::elementToBeClickable).click();
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public void inputText(By elementPath, String text) {
        WebElement element = $(elementPath, ExpectedConditions::visibilityOfElementLocated);
        element.clear();
        element.sendKeys(text);
    }

    public void inputText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public WebElement $(By locator, Function<By, ExpectedCondition<WebElement>> conditionFunction) {
        Wait<WebDriver> wait = getWebDriverWait(driver);
        return wait.until(conditionFunction.apply(locator));
    }

    protected WebElement $(By element) {
        return driver.findElement(element);
    }

    protected WebElement $(String xpath, String... args) {
        return driver.findElement(By.xpath(String.format(xpath, args)));
    }

    protected List<WebElement> $$(By by) {
        return driver.findElements(by);
    }

    public void openPage(String url) {
        this.driver.get(url);
    }

    private static Wait<WebDriver> getWebDriverWait(WebDriver driver) {
        return new FluentWait<>(driver)
                .withTimeout(20, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
    }
}
