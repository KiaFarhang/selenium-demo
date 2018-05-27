package com.kiafarhang.selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HomePageTest {

  private static WebDriver driver;
  private List<String> links;

  @BeforeClass
  public static void setUp() {
    WebDriverManager.firefoxdriver().setup();
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

  @Before
  public void createLinks() {
    this.links = new ArrayList<String>();
    this.links.add("about");
    this.links.add("resume");
    this.links.add("portfolio");
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
    HomePage homePage = new HomePage(driver, this.links);
    assertEquals("San Antonio Full-Stack Developer | Kia Farhang", homePage.getTitle());
  }

  @Test
  public void homePageContainsCorrectNumberOfLinks() {
    HomePage homePage = new HomePage(driver, this.links);
    List<WebElement> links = homePage.getLinks();
    assertEquals(3, links.size(), 0);
  }
}
