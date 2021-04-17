package org.example;

import org.example.POM.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Runner {
    private WebDriver driver;
    String URL = "https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html";
    BasePage basePage = new BasePage();


    @BeforeSuite
    @Parameters({"browser"})
    public void initDriver(@Optional("CH") String browser,@Optional("Texas") String city) throws Exception {
        switch (browser){
            case "CH":
                System.setProperty("webdriver.chrome.driver", "C://Users//Usuario//Documents//driversSelenium//chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "FX":
                System.setProperty("webdriver.gecko.driver","C://Users//Usuario//Documents//driversSelenium//geckodriver.exe");
                driver = new FirefoxDriver();
                break;

        }
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test (description = "Selecting one day")
    @Parameters("day")
    public void selectOneday(@Optional("Monday") String day) {
        Assert.assertEquals(true,basePage.selectDay(driver,day));
    }
    @Test (description = "Selecting one city")
    @Parameters("city")
    public void selectOneCity(@Optional("Texas") String city) {
        Assert.assertEquals(true,basePage.selectCity(driver,city));
    }
    @Test (description = "Clicking First Selected")
    public void btnClick() {
        Assert.assertEquals(true,basePage.clickFirstSelected(driver));
    }
    @AfterSuite
    public void quitDriver() throws Exception {
        driver.quit();
    }
}
