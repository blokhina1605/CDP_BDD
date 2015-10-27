package com.epam.blokhina.utils;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class CustomUtils {

    public static double selectPriceOnly(String price) {
        price = price.trim().replaceAll("\\D", "");
        return Double.parseDouble(price);
    }

    public static List<Double> convertToDoubleList(List<WebElement> webElements) {
        return webElements.stream().map(webElement -> selectPriceOnly(webElement.getText())).collect(Collectors.toList());
    }

    public static List<String> getStrings(List<WebElement> webElementList) {
        return webElementList.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public static List<String> parseStringDescription(WebElement description) {
        String dTemp = description.getText().replaceAll("\\p{P}", " ").replaceAll("  ", " ").toLowerCase();
        String[] splitted = dTemp.split("\\p{P}|\\s");
        List<String> newDescription = new ArrayList<>();
        Collections.addAll(newDescription, splitted);
        return newDescription;
    }

    public static List<String> getStringDescriptionForWebElements(List<WebElement> webElementList) {
        List<String> description = new ArrayList<>();
        for (WebElement element : webElementList) {
            description.addAll(parseStringDescription(element));
        }
        return description;
    }
}
