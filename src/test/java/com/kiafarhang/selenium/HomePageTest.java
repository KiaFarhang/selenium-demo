package com.kiafarhang.selenium;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class HomePageTest extends PageTest {

  private MainPage homePage;
  private List<String> links;

  @Before
  public void createLinks() {
    this.links = new ArrayList<String>();
    this.links.add("about");
    this.links.add("resume");
    this.links.add("portfolio");

    this.homePage = new MainPage(this.driver, "/", this.links);
  }

  @Test
  public void loadsHomePage() {
    assertEquals("San Antonio Full-Stack Developer | Kia Farhang", this.homePage.getTitle());
  }

  @Test
  public void homePageContainsCorrectNumberOfLinks() {
    List<WebElement> links = this.homePage.getLinks();
    assertEquals(3, links.size(), 0);
  }

  @Test
  public void testAutoComplete() {
    for (String link: this.links) {
      // Get all but the last character of the link
      String shortenedLink = link.substring(0, link.length() - 2);
      String autoCompleteResult = this.homePage.autocompleteTerminal(shortenedLink);
      assertEquals(link, autoCompleteResult);
    }
  }
}
