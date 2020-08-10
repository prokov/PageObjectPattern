package utils;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class FunctionalTest {

    protected static WebDriver driver;

    protected final Logger logger = LogManager.getLogger(getClass());



    @BeforeClass
    public static void setUp() {
        //	System.setProperty("webdriver.chrome.driver", "D:\\java\\selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    }


    @After
    public void cleanUp() {

    }

    @AfterClass
    public static void tearDown() {

    }

}