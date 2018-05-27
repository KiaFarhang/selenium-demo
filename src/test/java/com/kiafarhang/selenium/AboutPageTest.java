package com.kiafarhang.selenium;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class AboutPageTest extends PageTest {

  private MainPage aboutPage;
  private List<String> links;

  @Before
  public void createLinks() {
    this.links = new ArrayList<String>();
    this.links.add("home");
    this.links.add("resume");
    this.links.add("portfolio");
    this.links.add("linkedin");

    this.aboutPage = new MainPage(driver, "/about", this.links);
  }

  @Test
  public void loadsAboutPage() {
    assertEquals("San Antonio Full-Stack Developer | Kia Farhang", aboutPage.getTitle());
  }

  @Test
  public void aboutPageContainsCorrectNumberOfLinks() {
    List<WebElement> links = this.aboutPage.getLinks();
    assertEquals(4, this.links.size(), 0);
  }

  @Test
  public void testAutoComplete() {
    for (String link: this.links) {
      // Get all but the last character of the link
      String shortenedLink = link.substring(0, link.length() - 2);
      String autoCompleteResult = aboutPage.autocompleteTerminal(shortenedLink);
      assertEquals(link, autoCompleteResult);
    }
  }
}
