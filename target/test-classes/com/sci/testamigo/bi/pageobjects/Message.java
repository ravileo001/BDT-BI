package com.sci.testamigo.bi.pageobjects;

import org.openqa.selenium.WebElement;

import com.sci.testamigo.bi.model.WebElementDetails;
import com.sci.testamigo.bi.util.JWebElement;

public class Message {

  public WebElement subjectTextBox(WebElementDetails webElementDetails) {
    return JWebElement.getWebElement(webElementDetails);
  }

  public WebElement messageBodyTextBox(WebElementDetails webElementDetails) {
    return JWebElement.getWebElement(webElementDetails);
  }

  public WebElement submitBtn(WebElementDetails webElementDetails) {
    return JWebElement.getWebElement(webElementDetails);
  }

  public WebElement statusMsg(WebElementDetails webElementDetails) {
    return JWebElement.getWebElement(webElementDetails);
  }

  public WebElement msgCheckBox(WebElementDetails webElementDetails) {
    return JWebElement.getWebElement(webElementDetails);
  }

  public WebElement deleteBtn(WebElementDetails webElementDetails) {
    return JWebElement.getWebElement(webElementDetails);
  }

  public WebElement verifyErrorMsg(WebElementDetails webElementDetails) {
    return JWebElement.getWebElement(webElementDetails);
  }
}