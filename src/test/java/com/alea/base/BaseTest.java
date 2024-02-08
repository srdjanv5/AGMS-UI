package com.alea.base;

import com.alea.util.PropertiesUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected PropertiesUtil alea_properties = null;
    protected final String ALEA_PROPERTIES = "/alea.properties";
    public BaseTest() throws IOException {
        alea_properties = new PropertiesUtil(ALEA_PROPERTIES);
    }

    @BeforeMethod
    @Parameters({ "browser" })
    public void setUp(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
            FirefoxProfile profile = new FirefoxProfile();
            profile.setPreference("security.sandbox.content.level", 5);
            profile.setPreference("dom.disable_beforeunload", true);
            FirefoxOptions options = new FirefoxOptions();
            options.setProfile(profile);
            driver = new FirefoxDriver(options);
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("chrome.switches", "--disable-extensions");
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        } else {
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));    }


    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
