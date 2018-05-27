package com.kiafarhang.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PageTest {

  protected WebDriver driver;

  @BeforeClass
  public static void setUp() {
    WebDriverManager.firefoxdriver().setup();
    WebDriverManager.chromedriver().setup();
  }

  @Before
  public void createDriver() {
    if (driver == null) {
      driver = new FirefoxDriver();
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
  }

  @After
  public void cleanUp() {
    this.driver.manage().deleteAllCookies();

    if (this.driver != null) {
      this.driver.quit();
    }
  }

}
