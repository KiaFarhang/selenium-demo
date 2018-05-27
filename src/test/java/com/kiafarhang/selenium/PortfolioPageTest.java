package com.kiafarhang.selenium;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class PortfolioPageTest extends PageTest {

  private MainPage portfolioPage;
  private List<String> links;

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

    this.portfolioPage = new MainPage(this.driver, "/portfolio", this.links);
  }

  @Test
  public void loadsPortfolioPage() {
    assertEquals("San Antonio Full-Stack Developer | Kia Farhang", portfolioPage.getTitle());
  }

  @Test
  public void portfolioPageContainsCorrectNumberOfLinks() {
    List<WebElement> links = portfolioPage.getLinks();
    assertEquals(12, this.links.size(), 0);
  }

  @Test
  public void testAutoComplete() {
    for (String link: this.links) {
      // Get all but the last character of the link
      String shortenedLink = link.substring(0, link.length() - 2);
      String autoCompleteResult = portfolioPage.autocompleteTerminal(shortenedLink);
      assertEquals(link, autoCompleteResult);
    }
  }
}
