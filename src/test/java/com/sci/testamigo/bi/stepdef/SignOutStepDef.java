package com.sci.testamigo.bi.stepdef;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sci.testamigo.bi.model.WebElementDetails;
import com.sci.testamigo.bi.pageobjects.BrightIdeasHome;
import com.sci.testamigo.bi.util.JXMLParser;
import com.sci.testamigo.bi.util.PageCommonWD;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class SignOutStepDef {
  WebDriver driver = PageCommonWD.getOpenBrowserHelp().getDriver();
  protected transient final Log log = LogFactory.getLog(getClass());
  BrightIdeasHome BIhome = new BrightIdeasHome();
  private List<WebElementDetails> BIHomewebElementsList = JXMLParser.getInstance()
      .getWebElements(BrightIdeasHome.class.getSimpleName());

  // ==================================================================================

  @Given("^click on Logout button$")
  public void clicks_on_Logout_button() throws Throwable {
    WebElementDetails menuItems = BIHomewebElementsList.get(3);
    BIhome.menuList(menuItems).findElements(By.tagName("li")).get(4).click();
  }

  // ==================================================================================

  @Then("^verify Login page title$")
  public void verifies_Loginpage() throws Throwable {
    driver = PageCommonWD.getOpenBrowserHelp().getDriver();
    Assert.assertTrue(driver.getTitle().equals("Welcome to Bright IDEAS | Bright IDEAS"));
    log.info("Successfully Loggedout from the Application");
    driver.quit();
    log.info("Broswer Closed");
  }
}