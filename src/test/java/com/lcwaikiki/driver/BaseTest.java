package com.lcwaikiki.driver;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;

    private String baseUrl = "https://www.lcwaikiki.com/tr-TR/TR";
    private String browser = "chrome";


    @BeforeScenario
    public void setUp() {
        driver = LocalBrowserExec.LocalDriver(browser);
        driver.manage().timeouts().pageLoadTimeout(299, TimeUnit.SECONDS).implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterScenario
    public void tearDown()  {
        driver.quit();
    }

}
