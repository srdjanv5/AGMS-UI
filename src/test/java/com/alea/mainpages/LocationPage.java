package com.alea.mainpages;

import com.alea.base.PageBase;
import com.alea.util.HelperUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class LocationPage extends PageBase {
    public LocationPage(WebDriver driver) throws FileNotFoundException, IOException {
        super(driver);
    }

    //Web Elements

    @FindBy(xpath = "//h3[normalize-space()='Location']")
    private WebElement locationPageNameWE;

    @FindBy(xpath = "//a[@id='newRecord']")
    private WebElement addNewLocationBtnWE;

    @FindBy(xpath = "//a[contains(text(),'Name') and @href='/AGMSTest/Location/Read?grid-sort=Name-desc']")
    private WebElement locationNameColumnWE;

    @FindBy(xpath = "//a[contains(text(),'Group Name') and @href='/AGMSTest/Location/Read?grid-sort=GroupName-asc']")
    private WebElement locationGroupNameColumnWE;

    @FindBy(xpath = "//a[contains(text(), 'External identification') and @class='k-link']")
    private WebElement locationExternalIdColumnWE;

    @FindBy(xpath = "//a[contains(text(), 'Active') and @class='k-link']")
    private WebElement locationActiveStatusColumnWE;

    @FindBy(xpath = "//input[@id='Name']")
    private WebElement locationNameWE;

    @FindBy(xpath = "//span[@aria-owns='ddlGroupID_listbox']//span[@class='k-input'][contains(text(),'Please')]")
    private WebElement locationGroupWE;

    @FindBy(xpath = "//ul[@id='ddlGroupID_listbox']//li[contains(text(),'Automatska grupa')]")
    private WebElement specificGroupWE;

    @FindBy(xpath = "//a[@id='saveChanges']")
    private WebElement saveNewLocationBtnWE;

    @FindBy(xpath = "//span[normalize-space()='Game']")
    private WebElement gameTabWE;

    @FindBy(xpath = "//span[normalize-space()='Device']")
    private WebElement deviceTabWE;

    @FindBy(xpath = "//span[normalize-space()='Managers']")
    private WebElement managersTabWE;

    @FindBy(xpath = "//span[normalize-space()='Shell version']")
    private WebElement shellVersionTabWE;

    @FindBy(xpath = "//span[normalize-space()='Work shifts']")
    private WebElement workShiftsTabWE;

    @FindBy(xpath = "//span[normalize-space()='Voucher settings']")
    private WebElement voucherLimitForSendingMailTabWE;

    @FindBy(xpath = "//span[normalize-space()='Wall Presentation Links']")
    private WebElement wallPresentationTabWE;

    @FindBy(xpath = "//a[@id='btn-group-details']")
    private WebElement groupDetailsBtnWE;

    @FindBy(xpath = "//h3[normalize-space()='Successfully updated']")
    private WebElement successfullyUpdatedPopUpWE;

    @FindBy(xpath = "//div[@data-role='alert']//h3[contains(text(),'Error')]")
    private WebElement errorPopUpWE;


    // Methods


    public void verifyLocationPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String actualUrl = (alea_properties.getValue("URL.LOCATION"));
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        wait.until(ExpectedConditions.visibilityOf(locationPageNameWE));
        wait.until(ExpectedConditions.elementToBeClickable(addNewLocationBtnWE));
        wait.until(ExpectedConditions.visibilityOf(locationNameColumnWE));
        wait.until(ExpectedConditions.visibilityOf(locationGroupNameColumnWE));
        wait.until(ExpectedConditions.visibilityOf(locationExternalIdColumnWE));

        System.out.println("Location page is open and verified");

    }

    public void initiateCreatingNewLocation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(addNewLocationBtnWE));
        addNewLocationBtnWE.click();
    }

    public String insertLocationName() {
        String locationName = "Automatska grupa " + HelperUtil.getRandomString(5);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locationNameWE));
        locationNameWE.sendKeys(locationName);
        return locationName;
    }

    public void clickGroupDropdown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locationGroupWE));
        locationGroupWE.click();
    }

    public void selectGroupForLocation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", specificGroupWE);
        wait.until(ExpectedConditions.elementToBeClickable(specificGroupWE));
        System.out.println("regija: " + specificGroupWE.getText());
        specificGroupWE.click();
    }

    public void compleateCreatingNewLocation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",saveNewLocationBtnWE);
        wait.until(ExpectedConditions.elementToBeClickable(saveNewLocationBtnWE));
        saveNewLocationBtnWE.click();
    }
    public String createNewLocationMandatoryFields() throws InterruptedException {
        String locationName = "Automatska lokacija " + HelperUtil.getRandomString(3);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        addNewLocationBtnWE.click();

        String expectedUrl = (alea_properties.getValue("URL.ADDLOCATION"));
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        wait.until(ExpectedConditions.elementToBeClickable(locationNameWE));
        locationNameWE.sendKeys(locationName);

        wait.until(ExpectedConditions.elementToBeClickable(locationGroupWE));
        locationGroupWE.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",specificGroupWE);
        wait.until(ExpectedConditions.elementToBeClickable(specificGroupWE));
        specificGroupWE.click();
        Thread.sleep(200);

        js.executeScript("arguments[0].scrollIntoView();",saveNewLocationBtnWE);
        wait.until(ExpectedConditions.elementToBeClickable(saveNewLocationBtnWE));
        saveNewLocationBtnWE.click();

        return locationName;
    }


    public void verifyCreatedLocation(String locationName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(locationNameWE));
        assertTrue(locationNameWE.getAttribute("value").equals(locationName), "Location name not found");

        wait.until(ExpectedConditions.visibilityOf(gameTabWE));
        wait.until(ExpectedConditions.visibilityOf(deviceTabWE));
        wait.until(ExpectedConditions.visibilityOf(managersTabWE));
        wait.until(ExpectedConditions.visibilityOf(shellVersionTabWE));
        wait.until(ExpectedConditions.visibilityOf(workShiftsTabWE));
        wait.until(ExpectedConditions.visibilityOf(voucherLimitForSendingMailTabWE));
        wait.until(ExpectedConditions.elementToBeClickable(groupDetailsBtnWE));

        System.out.println("New Location is verified");
    }


    public void verifyGeoLocationPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean isElementEnabled = locationGroupWE.isEnabled();
        Assert.assertFalse(isElementEnabled, "The element is enabled");

    }


    public  void createNewGeoLocation(String regionName) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locationNameWE));
        locationNameWE.sendKeys(regionName);
        Thread.sleep(200);


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",saveNewLocationBtnWE);
        wait.until(ExpectedConditions.elementToBeClickable(saveNewLocationBtnWE));
        saveNewLocationBtnWE.click();
    }
}
