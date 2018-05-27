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

public class AboutPageTest {

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
    this.links.add("home");
    this.links.add("resume");
    this.links.add("portfolio");
    this.links.add("linkedin");
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
  public void loadsAboutPage() {
    MainPage aboutPage = new MainPage(driver, "/about", this.links);
    assertEquals("San Antonio Full-Stack Developer | Kia Farhang", aboutPage.getTitle());
  }

  @Test
  public void aboutPageContainsCorrectNumberOfLinks() {
    MainPage aboutPage = new MainPage(driver, "/about", this.links);
    List<WebElement> links = aboutPage.getLinks();
    assertEquals(4, links.size(), 0);
  }

  @Test
  public void testAutoComplete() {
    MainPage aboutPage = new MainPage(driver, "/about", this.links);
    for (String link: this.links) {
      // Get all but the last character of the link
      String shortenedLink = link.substring(0, link.length() - 2);
      String autoCompleteResult = aboutPage.autocompleteTerminal(shortenedLink);
      assertEquals(link, autoCompleteResult);
    }
  }
}
