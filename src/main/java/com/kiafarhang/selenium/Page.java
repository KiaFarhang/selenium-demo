package com.kiafarhang.selenium;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

abstract class Page {

  private final WebDriver driver;
  private String url = "https://kiafarhang.com";
  private WebElement linkContainer;

  Page(WebDriver driver) {
    this.driver = driver;
    this.setUp();
  }

  Page(WebDriver driver, String relativePath) {
    this.driver = driver;
    this.url = this.url.concat(relativePath);
    this.setUp();
  }

  private void setUp() {
    this.driver.get(this.url);
    this.linkContainer = this.driver.findElement(By.className("link-container"));
  }

  String getTitle() {
    return this.driver.getTitle();
  }

  boolean containsLinks(List<String> links) {
    boolean containsLinks = true;
    for (String link : links) {
      try {
        WebElement linkElement = driver.findElement(By.linkText(link));
      } catch (NoSuchElementException exception) {
        containsLinks = false;
      }
    }
    return containsLinks;
  }
}
