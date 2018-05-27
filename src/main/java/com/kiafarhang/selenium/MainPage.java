package com.kiafarhang.selenium;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

class MainPage {
  private final WebDriver driver;
  private String url;
  private List<WebElement> links;

  MainPage(WebDriver driver, String relativePath, List<String> links) {
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

  String autocompleteTerminal(String string) {
    WebElement commandLineForm = this.driver.findElement(By.tagName("form"));
    WebElement input = commandLineForm.findElement(By.tagName("input"));
    if (!input.getAttribute("value").equals("")) {
      input.clear();
    }
    input.sendKeys(string);
    input.sendKeys(Keys.TAB);
    return input.getAttribute("value");
  }
}
