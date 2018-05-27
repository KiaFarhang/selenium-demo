package com.kiafarhang.selenium;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

abstract class Page {

  private final WebDriver driver;
  private String url;
  private List<WebElement> links;

  Page(WebDriver driver, String relativePath, List<String> links) {
    this.driver = driver;
    this.url = "https://kiafarhang.com".concat(relativePath);
    this.driver.get(this.url);
    WebElement linkContainer = this.driver.findElement(By.className("link-container"));
    this.links = linkContainer.findElements(By.tagName("a"));
  }

  String getTitle() {
    return this.driver.getTitle();
  }

  List<WebElement> getLinks() {
    return this.links;
  }
}
