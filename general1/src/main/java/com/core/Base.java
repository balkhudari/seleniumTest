package com.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import java.io.IOException;

import static com.core.utils.ReadConfig.readConfig;

public class Base {

    public static WebDriver driver;

    String browserName;
    String path;

    @BeforeTest(alwaysRun = true)
    public void beforeTest() throws IOException {

        path = readConfig("path");
        browserName = readConfig("browserName");

        if (browserName.equals("chrome")) {
            System.out.println("Browser : Chrome");

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browserName.equals("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else if (browserName.equals("ie")) {

            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();

        } else if (browserName.equals("edge")) {

            WebDriverManager.iedriver().setup();
            driver = new EdgeDriver();
        }
        driver.get(path);
        //System.out.println(" starting The Test Suite ");

    }

    @AfterTest()
    public void afterTest() {

        driver.close();
    }

}



