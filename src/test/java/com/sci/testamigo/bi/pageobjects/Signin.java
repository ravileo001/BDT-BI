package com.sci.testamigo.bi.pageobjects;

import org.openqa.selenium.WebElement;

import com.sci.testamigo.bi.model.WebElementDetails;
import com.sci.testamigo.bi.util.JWebElement;

public class Signin {

  // ==================================================================================

  public WebElement Username(WebElementDetails webElementDetails) {
    return JWebElement.getWebElement(webElementDetails);
  }

  // ==================================================================================

  public WebElement Password(WebElementDetails webElementDetails) {
    return JWebElement.getWebElement(webElementDetails);
  }

  // ==================================================================================

  public WebElement loginbtn(WebElementDetails webElementDetails) {
    return JWebElement.getWebElement(webElementDetails);
  }
}