package com.alea.mainpages;

import com.alea.base.PageBase;
import com.alea.util.AppLogger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import java.io.*;
import java.time.Duration;

public class HomePage extends PageBase {

    //Web Elements
    @FindBy(xpath = "//*[@name='LoginUserName']")
    private WebElement userNameWE;
    @FindBy(xpath = "//*[@id='pageTitle']/div/div[1]/h3")
    private WebElement homePageTextWE;
    @FindBy(xpath = "//span[normalize-space()='Total']")
    private WebElement totalStatsWE;
    @FindBy(xpath = "//a[@id='SearchButton']")
    private WebElement searchBtnWE;
    @FindBy(xpath = "//div[@id='columns-drop']")
    private WebElement eyeFilterWE;
    @FindBy(xpath = "//h1[normalize-space()='Error']")
    private WebElement errorMessageWE;
    @FindBy(xpath = "//h2[@class='text-danger']")
    private WebElement errorDangerMessageWE;
    @FindBy(xpath = "//span[normalize-space()='Dusko Operater']")
    private WebElement operatorUserNameWE;
    @FindBy (xpath = "//a[normalize-space()='MyLucky6']")
    private WebElement myLucky6MenuWE;
    @FindBy (xpath = "//a[@href='/AGMSTest/LocationGroupRegionCompanyProduction/MyLucky6']")
    private WebElement locationPageML6WE;

    //Methods

    public HomePage(WebDriver driver) throws IOException {
        super(driver);
    }

    public void verifyHomePage() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            String expectedUrl = (alea_properties.getValue("URL.HOME"));
            String actualUrl = driver.getCurrentUrl();
            Assert.assertEquals(expectedUrl, actualUrl);

            wait.until(ExpectedConditions.visibilityOf(homePageTextWE));
            wait.until(ExpectedConditions.visibilityOf(totalStatsWE));
            wait.until(ExpectedConditions.visibilityOf(eyeFilterWE));
            wait.until(ExpectedConditions.visibilityOf(searchBtnWE));

            AppLogger.info("Home page is open and verified!");
    }

    public void verifyOperator() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Thread.sleep(300);
        wait.until(ExpectedConditions.visibilityOf(errorMessageWE));
        Assert.assertTrue(errorMessageWE.getText().equals("Error"), "Message not found!");

        wait.until(ExpectedConditions.visibilityOf(errorDangerMessageWE));
        Assert.assertTrue(errorDangerMessageWE.getText().equals("You don't have permission to visit this page!"), "Message not found!");

        wait.until(ExpectedConditions.visibilityOf(operatorUserNameWE));
        Assert.assertTrue(operatorUserNameWE.getText().equals("Dusko Operater"), "User not found!");
    }

    public void checkedRememberMe() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(mainStatisticWE));

        Cookie lpCookie = driver.manage().getCookieNamed(".AspNet.ApplicationCookie");
        System.out.println("Collected Cookies: " + lpCookie);

        driver.close();

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/google-chrome");
        options.addArguments("--start-maximized");
        options.addArguments("chrome.switches", "--disable-extensions");
        driver = new ChromeDriver(options);
        this.setDriver(driver);
        driver.get(alea_properties.getValue("URL.HOME"));
        driver.manage().addCookie(lpCookie);
        driver.get(alea_properties.getValue("URL.HOME"));

        WebDriverWait waitAgain = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitAgain.until(ExpectedConditions.visibilityOf(mainStatisticWE));
    }

    public void dontRememberMe() throws IOException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(mainStatisticWE));

        driver.close();

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/opt/google/chrome");
        options.addArguments("--start-maximized");
        options.addArguments("chrome.switches", "--disable-extensions");
        driver = new ChromeDriver(options);
        this.setDriver(driver);
        driver.get(alea_properties.getValue("URL.HOME"));

        WebDriverWait waitAgain = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitAgain.until(ExpectedConditions.elementToBeClickable(userNameWE));
    }
}
