package com.alea.mainpages;

import com.alea.base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class LogInPage extends PageBase {
    public LogInPage(WebDriver driver) throws IOException {
        super(driver);
        driver.get(alea_properties.getValue("URL.LOGIN"));
    }

    //Web Elements
    @FindBy(xpath = "//label[normalize-space()='User name']")
    private WebElement userNameTextWE;
    @FindBy(xpath = "//*[@name='LoginUserName']")
    private WebElement userNameInputWE;
    @FindBy(xpath = "//label[normalize-space()='Password']")
    private WebElement passwordTextWE;
    @FindBy(xpath = "//*[@name='LoginPassword']")
    private WebElement passwordInputWE;
    @FindBy(xpath = "//*[@class='btn_green btn_wide login_btn']")
    private WebElement signInBtnWE;
    @FindBy(xpath = "//*[@class='checkbox_label']")
    private WebElement remeberMeWE;
    @FindBy(xpath = "//p[@class='text-center margin_top_20']")
    private WebElement logInMessageWE;


    //Methods

    public void verifyLogInPage() {
        verifyLogInPageURL();
        verifyLoginPageForm();
    }
    public void verifyLogInPageURL() {
        verificationUtils.verifyPageUrl("URL.LOGIN");
    }

    public void verifyLoginPageForm() {
        verificationUtils.verifyElementWithTextAssertion(userNameTextWE, "USER NAME");
        waitHelper.waitForClickable(userNameInputWE);
        verificationUtils.verifyElementWithTextAssertion(passwordTextWE, "PASSWORD");
        waitHelper.waitForClickable(passwordInputWE);
        waitHelper.waitForClickable(signInBtnWE);
        waitHelper.waitForClickable(remeberMeWE);

        verificationUtils.verifyElementWithTextAssertion(userNameTextWE, "USER NAME");
        verificationUtils.verifyElementWithTextAssertion(userNameTextWE, "USER NAME");
        verificationUtils.verifyElementWithTextAssertion(userNameTextWE, "USER NAME");

    }
//    public void verifyLogInPage1() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        wait.until(ExpectedConditions.visibilityOf(userNameTextWE));
//        assertTrue(userNameTextWE.getText().equals("USER NAME"), "Username element could not be found");
//        wait.until(ExpectedConditions.elementToBeClickable(userNameInputWE));
//
//        wait.until(ExpectedConditions.visibilityOf(passwordTextWE));
//        assertTrue(passwordTextWE.getText().equals("PASSWORD"), "Password element could not be fount");
//        wait.until(ExpectedConditions.elementToBeClickable(passwordInputWE));
//
//        wait.until(ExpectedConditions.elementToBeClickable(signInBtnWE));
//        wait.until(ExpectedConditions.elementToBeClickable(remeberMeWE));
//
//        String expectedUrl = (alea_properties.getValue("URL.LOGIN"));
//        String actualUrl = driver.getCurrentUrl();
//        Assert.assertEquals(expectedUrl, actualUrl);
//
//        assertTrue(logInMessageWE.getText().contains("Alea Control Management System"), "Message is not good");
//        System.out.println("Log in page is open and verified!");
//    }


    public void logInAdmin(String user) {
        if ("admin".equals(user)){
            waitHelper.waitForClickable(userNameInputWE);
            userNameInputWE.sendKeys(alea_properties.getValue("ADMIN.USER"));
            waitHelper.waitForClickable(passwordInputWE);
            passwordInputWE.sendKeys(alea_properties.getValue("ADMIN.PASSWORD"));
            signInBtnWE.click();
            System.out.println("User is logged in as Admin");
        }
        else {
            System.out.println("Test failed! User not logged in.");
        }
    }

    public void logInLimitedAdmin( String user) {
        if ("limited admin".equals(user)){
            waitHelper.waitForClickable(userNameInputWE);
            userNameInputWE.sendKeys(alea_properties.getValue("LIMITED.ADMIN.USER"));
            waitHelper.waitForClickable(passwordInputWE);
            passwordInputWE.sendKeys(alea_properties.getValue("LIMITED.ADMIN.PASSWORD"));
            signInBtnWE.click();
            System.out.println("User is logged in as Limited Admin");
        }
        else {
            System.out.println("Test failed! User not logged in.");
        }
    }

    public void logInClientManager( String user) {
        if ("client manager".equals(user)){
            waitHelper.waitForClickable(userNameInputWE);
            userNameInputWE.sendKeys(alea_properties.getValue("CLIENT.USER"));
            waitHelper.waitForClickable(passwordInputWE);
            passwordInputWE.sendKeys(alea_properties.getValue("CLIENT.PASSWORD"));
            signInBtnWE.click();
            System.out.println("User is logged in as Client Manager");
        }
        else {
            System.out.println("Test failed! User not logged in.");
        }
    }

    public void logInCompanyManager( String user) {
        if ("company manager".equals(user)){
            waitHelper.waitForClickable(userNameInputWE);
            userNameInputWE.sendKeys(alea_properties.getValue("COMPANY.USER"));
            waitHelper.waitForClickable(passwordInputWE);
            passwordInputWE.sendKeys(alea_properties.getValue("COMPANY.PASSWORD"));
            signInBtnWE.click();
            System.out.println("User is logged in as Company Manager");
        }
        else {
            System.out.println("Test failed! User not logged in.");
        }
    }

    public void logInRegionManager( String user) {
        if ("region manager".equals(user)){
            waitHelper.waitForClickable(userNameInputWE);
            userNameInputWE.sendKeys(alea_properties.getValue("REGION.USER"));
            waitHelper.waitForClickable(passwordInputWE);
            passwordInputWE.sendKeys(alea_properties.getValue("REGION.PASSWORD"));
            signInBtnWE.click();
            System.out.println("User is logged in as Region Manager");
        }
        else {
            System.out.println("Test failed! User not logged in.");
        }
    }

    public void logInGroupManager( String user) {
        if ("group manager".equals(user)){
            waitHelper.waitForClickable(userNameInputWE);
            userNameInputWE.sendKeys(alea_properties.getValue("GROUP.USER"));
            waitHelper.waitForClickable(passwordInputWE);
            passwordInputWE.sendKeys(alea_properties.getValue("GROUP.PASSWORD"));
            signInBtnWE.click();
            System.out.println("User is logged in as Group Manager");
        }
        else {
            System.out.println("Test failed! User not logged in.");
        }
    }

    public void logInLocationManager( String user) {
        if ("location manager".equals(user)){
            waitHelper.waitForClickable(userNameInputWE);
            userNameInputWE.sendKeys(alea_properties.getValue("LOCATION.USER"));
            waitHelper.waitForClickable(passwordInputWE);
            passwordInputWE.sendKeys(alea_properties.getValue("LOCATION.PASSWORD"));
            signInBtnWE.click();
            System.out.println("User is logged in as Location Manager");
        }
        else {
            System.out.println("Test failed! User not logged in.");
        }
    }

    public void logInOperator( String user) {
        if ("operator".equals(user)){
            waitHelper.waitForClickable(userNameInputWE);
            userNameInputWE.sendKeys(alea_properties.getValue("OPERATOR.USER"));
            waitHelper.waitForClickable(passwordInputWE);
            passwordInputWE.sendKeys(alea_properties.getValue("OPERATOR.PASSWORD"));
            signInBtnWE.click();
            System.out.println("User is logged in as Operator");
        }
        else {
            System.out.println("Test failed! User not logged in.");
        }
    }

    public void rememberMe( String user) {
        if ("admin".equals(user)){
            waitHelper.waitForClickable(userNameInputWE);
            userNameInputWE.sendKeys(alea_properties.getValue("ADMIN.USER"));
            waitHelper.waitForClickable(passwordInputWE);
            passwordInputWE.sendKeys(alea_properties.getValue("ADMIN.PASSWORD"));
            waitHelper.waitForClickable(remeberMeWE);
            remeberMeWE.click();
            signInBtnWE.click();
            System.out.println("User is logged in as Admin and remembered.");
        } else {
            System.out.println("Test failed! User not logged in.");
        }
    }

    public void verifyValidations(String userName, String password) {
        waitHelper.waitForClickable(userNameInputWE);
        userNameInputWE.sendKeys(userName);
        waitHelper.waitForClickable(passwordInputWE);
        passwordInputWE.sendKeys(password);
        signInBtnWE.click();
        if ("".equals(userName)) {
            System.out.println("UserName is empty: " + userName.isEmpty());
        }else if ("".equals(password)) {
            System.out.println("Password is empty: " + password.isEmpty());
        }
    }
}
