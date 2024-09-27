package com.parallelExecution.AutomationParallelExecution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTest {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeClass
    @Parameters({"browser"} )
    public void setup(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver.set(new ChromeDriver());
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver.set(new FirefoxDriver());
        } else if (browser.equalsIgnoreCase("ie")) {
            driver.set(new InternetExplorerDriver());
        }
    }
    
    @Test
    public void TestChromeDriver() throws InterruptedException {
        driver.get().get("https://www.google.com");
        Thread.sleep(4000);
    }
    
    @AfterClass
    public void tearDown() {
           driver.get().quit();
           driver.remove();
        
    }
}
