package com.kiafarhang.selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FunctionalTest {

  private static WebDriver driver;

  @BeforeClass
  public static void setUp() {
    WebDriverManager.firefoxdriver().setup();
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

  @After
  public void cleanUp() {
    driver.manage().deleteAllCookies();
  }

  @AfterClass
  public static void teardown() {
    if (driver != null) {
      driver.quit();
    }
  }

  @Test
  public void loadsHomePage() {
    HomePage homePage = new HomePage(driver);
    assertEquals("San Antonio Full-Stack Developer | Kia Farhang", homePage.getTitle());
  }

  @Test
  public void homePageContainsCorrectLinks() {
    HomePage homePage = new HomePage(driver);
    List<String> links = new ArrayList<String>();
    links.add("about");
    links.add("resume");
    links.add("portfolio");

    assertTrue(homePage.containsLinks(links));

  }
}
