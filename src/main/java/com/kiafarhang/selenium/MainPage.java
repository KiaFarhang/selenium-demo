package com.kiafarhang.selenium;

import java.util.List;
import org.openqa.selenium.WebDriver;

class MainPage extends Page {

  MainPage(WebDriver driver, String path, List<String> links) {
    super(driver, path, links);
  }
}
