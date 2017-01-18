package com.sci.testamigo.bi.pageobjects;

import org.openqa.selenium.WebElement;

import com.sci.testamigo.bi.model.WebElementDetails;
import com.sci.testamigo.bi.util.JWebElement;

public class ContactMyTrainer {

  public WebElement privateMessageLink(WebElementDetails webElementDetails) {
    return JWebElement.getWebElement(webElementDetails);
  }
}