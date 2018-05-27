package com.kiafarhang.selenium;

import java.util.List;
import org.openqa.selenium.WebDriver;

class HomePage extends Page {

  HomePage(WebDriver driver, List<String> links) {
    super(driver, "", links);
  }
}
