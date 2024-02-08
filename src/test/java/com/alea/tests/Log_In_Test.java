package com.alea.tests;

import com.alea.base.BaseTest;
import com.alea.mainpages.HomePage;
import com.alea.mainpages.LogInPage;
import org.testng.annotations.Test;

import java.io.IOException;

public class Log_In_Test extends BaseTest {

    public Log_In_Test() throws IOException {
        super();
    }

    long startTime = System.currentTimeMillis();

    @Test(description = "Login - Valid Admin Credentials", priority = 1)
    public void log_in_admin_test() throws Exception {
        LogInPage logInPage = new LogInPage(driver);
        logInPage.verifyLogInPage();
        logInPage.logInAdmin("admin");

        HomePage homePage = new HomePage(driver);
        homePage.verifyHomePage();
    }

    @Test(description = "Login - Valid Limited Admin Credentials", priority = 2)
    public void log_in_limited_admin_test() throws Exception {
        LogInPage logInPage = new LogInPage(driver);
        logInPage.verifyLogInPage();
        logInPage.logInLimitedAdmin("limited admin");

        HomePage homePage = new HomePage(driver);
        homePage.verifyHomePage();
    }

    @Test(description = "Login - Valid Client Manager Credentials", priority = 3)
    public void log_in_client_test() throws Exception {
        LogInPage logInPage = new LogInPage(driver);
        logInPage.verifyLogInPage();
        logInPage.logInClientManager("client manager");

        HomePage homePage = new HomePage(driver);
        homePage.verifyHomePage();
    }

    @Test(description = "Login - Valid Company Manager Credentials", priority = 5)
    public void log_in_company_manager_test() throws Exception {
        LogInPage logInPage = new LogInPage(driver);
        logInPage.verifyLogInPage();
        logInPage.logInCompanyManager("company manager");

        HomePage homePage = new HomePage(driver);
        homePage.verifyHomePage();
    }

    @Test(description = "Login - Valid Region Manager Credentials", priority = 6)
    public void log_in_region_manager_test() throws Exception {
        LogInPage logInPage = new LogInPage(driver);
        logInPage.verifyLogInPage();
        logInPage.logInRegionManager("region manager");

        HomePage homePage = new HomePage(driver);
        homePage.verifyHomePage();
    }

    @Test(description = "Login - Valid Group Manager Credentials", priority = 7)
    public void log_in_group_manager_test() throws Exception {
        LogInPage logInPage = new LogInPage(driver);
        logInPage.verifyLogInPage();
        logInPage.logInGroupManager("group manager");

        HomePage homePage = new HomePage(driver);
        homePage.verifyHomePage();
    }

    @Test(description = "Login - Valid Location Manager Credentials", priority = 8)
    public void log_in_location_manager_test() throws Exception {
        LogInPage logInPage = new LogInPage(driver);
        logInPage.verifyLogInPage();
        logInPage.logInLocationManager("location manager");

        HomePage homePage = new HomePage(driver);
        homePage.verifyHomePage();
    }

    @Test(description = "Login - Valid Operator Credentials", priority = 9)
    public void log_in_operator_test() throws Exception {
        LogInPage logInPage = new LogInPage(driver);
        logInPage.verifyLogInPage();
        logInPage.logInOperator("operator");

        HomePage homePage = new HomePage(driver);
        homePage.verifyOperator();
    }

    @Test(description = "Login - Check Remember Me", priority = 10)
    public void remember_me_test() throws Exception {
        LogInPage logInPage = new LogInPage(driver);
        logInPage.verifyLogInPage();
        logInPage.rememberMe("admin");

        HomePage homePage = new HomePage(driver);
        homePage.setDriver(driver);
        homePage.checkedRememberMe();
    }

    @Test(description = "Login - Don`t check Remember Me", priority = 11)
    public void dont_remember_me_test() throws Exception {
        LogInPage logInPage = new LogInPage(driver);
        logInPage.verifyLogInPage();
        logInPage.logInAdmin("admin");

        HomePage homePage = new HomePage(driver);
        homePage.setDriver(driver);
        homePage.dontRememberMe();
    }

    @Test(description = "Login - Invalid credentials", priority = 12)
    public void verify_validations_test() throws Exception {
        LogInPage logInPage = new LogInPage(driver);
        logInPage.verifyLogInPage();
        logInPage.verifyValidations("Invalid username", "Invalid password");
    }

    @Test(description = "Login - Empty fields", priority = 13)
    public void verify_validations_test0() throws Exception {
        LogInPage logInPage = new LogInPage(driver);
        logInPage.verifyLogInPage();
        logInPage.verifyValidations("", "");
    }

    @Test(description = "Login - Empty password", priority = 14)
    public void verify_validations_test1() throws Exception {
        LogInPage logInPage = new LogInPage(driver);
        logInPage.verifyLogInPage();
        logInPage.verifyValidations("invaliduser", "");
    }

    @Test(description = "Login - Empty username", priority = 15)
    public void verify_validations_test2() throws Exception {
        LogInPage logInPage = new LogInPage(driver);
        logInPage.verifyLogInPage();
        logInPage.verifyValidations("", "invalidpasword");
    }

    @Test(description = "Login - Empty credentials", priority = 16)
    public void verify_validations_test3() throws Exception {
        LogInPage logInPage = new LogInPage(driver);
        logInPage.verifyLogInPage();
        logInPage.verifyValidations("", "");
    }

    @Test(description = "Login - Valid username, empty password", priority = 17)
    public void verify_validations_test4() throws Exception {
        LogInPage logInPage = new LogInPage(driver);
        logInPage.verifyLogInPage();
        logInPage.verifyValidations("DuskoPralica", "");
    }

    @Test(description = "Login - Valid password, empty username", priority = 18)
    public void verify_validations_test5() throws Exception {
        LogInPage logInPage = new LogInPage(driver);
        logInPage.verifyLogInPage();
        logInPage.verifyValidations("", "Test!!2021");

        System.out.println("Test took: " + ((System.currentTimeMillis() - startTime) / 1000) + "seconds");
    }

}
