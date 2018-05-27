package com.kiafarhang.selenium;

import static org.junit.Assert.assertEquals;

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

public class PortfolioPageTest {

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
    this.links.add("about");
    this.links.add("github");
    this.links.add("top-100");
    this.links.add("primaries");
    this.links.add("distillr");
    this.links.add("sapd-scraper");
    this.links.add("podcast-widget");
    this.links.add("graphic-quiz");
    this.links.add("story-template");
    this.links.add("football-bracket");
    this.links.add("tceq-scraper");
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
  public void loadsPortfolioPage() {
    MainPage portfolioPage = new MainPage(driver, "/portfolio", this.links);
    assertEquals("San Antonio Full-Stack Developer | Kia Farhang", portfolioPage.getTitle());
  }

  @Test
  public void portfolioPageContainsCorrectNumberOfLinks() {
    MainPage portfolioPage = new MainPage(driver, "/portfolio", this.links);
    List<WebElement> links = portfolioPage.getLinks();
    assertEquals(12, links.size(), 0);
  }

  @Test
  public void testAutoComplete() {
    MainPage portfolioPage = new MainPage(driver, "/portfolio", this.links);
    for (String link: this.links) {
      // Get all but the last character of the link
      String shortenedLink = link.substring(0, link.length() - 2);
      String autoCompleteResult = portfolioPage.autocompleteTerminal(shortenedLink);
      assertEquals(link, autoCompleteResult);
    }
  }
}
