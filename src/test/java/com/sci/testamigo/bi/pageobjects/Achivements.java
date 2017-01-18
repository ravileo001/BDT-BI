package com.sci.testamigo.bi.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.sci.testamigo.bi.model.WebElementDetails;
import com.sci.testamigo.bi.util.JWebElement;

public class Achivements {
  
  public List<WebElement> UnlockStatusList(WebElementDetails webElementDetails) {
    return JWebElement.getWebElements(webElementDetails);
  }
}