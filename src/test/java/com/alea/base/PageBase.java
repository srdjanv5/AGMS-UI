package com.alea.base;

import com.alea.util.PropertiesUtil;
import com.alea.util.VerificationUtils;
import com.alea.util.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;


public class PageBase {
    protected WebDriver driver;
    protected PropertiesUtil alea_properties = null;
    protected final String ALEA_PROPERTIES = "/alea.properties";
    protected WaitHelper waitHelper;
    protected VerificationUtils verificationUtils;

    //Web Elements

    @FindBy(xpath = "//*[@href='/AGMSTest/Statistic/Index']")
    protected WebElement mainStatisticWE;
    @FindBy(xpath = "//a[@class='dropdown-toggle'][normalize-space()='Main']")
    protected WebElement mainPageWE;
    @FindBy(xpath = "//a[normalize-space()='Client']")
    private WebElement clientPageWE;
    @FindBy(xpath = "//a[normalize-space()='Company']")
    private WebElement companyPageWE;
    @FindBy(xpath = "//a[normalize-space()='Region']")
    private WebElement regionPageWE;
    @FindBy(xpath = "//a[@href='/AGMSTest/Group/Index']")
    private WebElement groupPageWE;
    @FindBy(xpath = "//a[@href='/AGMSTest/Location/Index']")
    private WebElement locationPageWE;
    @FindBy(xpath = "//a[normalize-space()='Device']")
    private WebElement devicePageWE;
    @FindBy(xpath = "//span[normalize-space()='Voucher']")
    private WebElement voucherMenuWE;
    @FindBy(xpath = "//a[@href='/AGMSTest/VoucherPayinPayout/Index']")
    private WebElement payinPyoutVocuhersPageWE;
    @FindBy(xpath = "//span[normalize-space()='Reports']")
    private WebElement reportsMenuWE;
    @FindBy(xpath = "//a[@href='/AGMSTest/Voucher/Index']")
    private WebElement voucherReviewPageWE;
    @FindBy(xpath = "//a[@href='javascript:;']")
    private WebElement userLoggedWE;
    @FindBy(xpath = "//a[@href='/AGMSTest/Account/LogOff']")
    private WebElement logOffBtnWE;
    @FindBy (xpath = "//a[normalize-space()='MyLucky6']")
    private WebElement myLucky6MenuWE;
    @FindBy (xpath = "//a[@href='/AGMSTest/GroupRegionCompanyProduction/MyLucky6']")
    private WebElement groupPageML6WE;
    @FindBy (xpath = "//a[@href='/AGMSTest/LocationGroupRegionCompanyProduction/MyLucky6']")
    private WebElement locationPageML6WE;

    //Methods
    public PageBase(WebDriver driver) throws IOException {
        this.driver = driver;
        this.waitHelper = new WaitHelper(driver);
        this.verificationUtils = new VerificationUtils(driver, waitHelper);
        PageFactory.initElements(this.driver, this);
        alea_properties = new PropertiesUtil(ALEA_PROPERTIES);
    }

    public void setDriver(WebDriver driver) throws IOException{
        this.driver = driver;
        this.waitHelper = new WaitHelper(driver);
        PageFactory.initElements(this.driver, this);
        alea_properties = new PropertiesUtil(ALEA_PROPERTIES);
    }
    public void navigateToMainPage(WebElement pageWE) {
        if (pageWE.isDisplayed()) {
            pageWE.click();
        } else {
            waitHelper.waitForClickable(mainPageWE);
            mainPageWE.click();
            waitHelper.waitForClickable(pageWE);
            pageWE.click();
        }
    }

    public void navigateToMyLucky6Page(WebElement pageWE) {
        if (pageWE.isDisplayed()) {
            pageWE.click();
        } else {
            waitHelper.waitForClickable(myLucky6MenuWE);
            myLucky6MenuWE.click();
            waitHelper.waitForClickable(pageWE);
            pageWE.click();
        }
    }

    public void navigateToVoucherPage(WebElement pageWE) {
        if (pageWE.isDisplayed()) {
            pageWE.click();
        } else {
            waitHelper.waitForClickable(voucherMenuWE);
            voucherMenuWE.click();
            waitHelper.waitForClickable(pageWE);
            pageWE.click();
        }
    }

    public void navigateToReportsPage(WebElement pageWE) {
        if (pageWE.isDisplayed()) {
            pageWE.click();
        } else {
            waitHelper.waitForClickable(reportsMenuWE);
            reportsMenuWE.click();
            waitHelper.waitForClickable(pageWE);
            pageWE.click();
        }
    }

    public void navigateToUserPage(WebElement pageWE) {
        if (pageWE.isDisplayed()) {
            pageWE.click();
        } else {
            waitHelper.waitForClickable(userLoggedWE);
            userLoggedWE.click();
            waitHelper.waitForClickable(pageWE);
            pageWE.click();
        }
    }

    public void navigateOnClientPage() {
        navigateToMainPage(clientPageWE);
    }

    public void navigateOnCompanyPage() {
        navigateToMainPage(companyPageWE);
    }

    public void navigateOnRegionPage() {
        navigateToMainPage(regionPageWE);
    }

    public void navigateOnGroupPage() {
        navigateToMainPage(groupPageWE);
    }

    public void navigateOnLocationPage() {
        navigateToMainPage(locationPageWE);
    }

    public void navigateOnDevicePage() {
        navigateToMyLucky6Page(devicePageWE);
    }

    public void navigateOnGroupML6Page() {
        navigateToMyLucky6Page(groupPageML6WE);
    }

    public void navigateOnPayInPayOutVouchersPage() {
        navigateToVoucherPage(payinPyoutVocuhersPageWE);
    }

    public void navigateOnVouchersReviewPage() {
        navigateToReportsPage(voucherReviewPageWE);
    }

    public void logOff() {
        navigateToUserPage(logOffBtnWE);
    }
}
