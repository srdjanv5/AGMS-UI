package com.alea.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class VerificationUtils {
    private final WebDriver driver;
    private final WaitHelper waitHelper;
    protected PropertiesUtil alea_properties = null;
    protected final String ALEA_PROPERTIES = "/alea.properties";


    public VerificationUtils(WebDriver driver, WaitHelper waitHelper) throws IOException {
        this.driver = driver;
        this.waitHelper = waitHelper;
        this.alea_properties = new PropertiesUtil(ALEA_PROPERTIES);
    }

    public void verifyPageUrl(String expectedUrlKey) {
        String expectedUrl = alea_properties.getValue(expectedUrlKey);
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl, "ERROR: The URL of the page does not match the expected URL.");
    }

    public void verifyElementWithTextAssertion(WebElement element, String expectedText) {
        waitHelper.waitForVisibility(element);
        Assert.assertEquals(element.getText(), expectedText, " ERROR: The text in the specified element does not match the expected text.");
    }
}
