package com.sci.testamigo.bi.stepdef;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sci.testamigo.bi.exceptions.TestAmigoException;
import com.sci.testamigo.bi.model.WebElementDetails;
import com.sci.testamigo.bi.pageobjects.BrightIdeasHome;
import com.sci.testamigo.bi.pageobjects.Settings;
import com.sci.testamigo.bi.util.AppSetup;
import com.sci.testamigo.bi.util.JXMLParser;
import com.sci.testamigo.bi.util.PageCommonWD;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SettingsStepDef {
  private List<WebElementDetails> webElementsList = JXMLParser.getInstance()
      .getWebElements(Settings.class.getSimpleName());
  private List<WebElementDetails> BIHomewebElementsList = JXMLParser.getInstance()
      .getWebElements(BrightIdeasHome.class.getSimpleName());
  WebDriver driver = PageCommonWD.getOpenBrowserHelp().getDriver();

  AppSetup appsetup = new AppSetup();
  BrightIdeasHome bihome = new BrightIdeasHome();
  Settings settings = new Settings();
  protected transient final Log log = LogFactory.getLog(getClass());
  String customMessage = null;
  // ==================================================================================

  @When("^user clicks on Account Settings menu link$")
  public void user_click_on_settings_show_settings_page() throws Throwable {
    WebElementDetails settingsLinkTextobj = BIHomewebElementsList.get(3);
    bihome.menuList(settingsLinkTextobj).findElements(By.tagName("li")).get(3).click();
  }

  // ==================================================================================

  @Then("^Enter Valid Credentials in current,new and confirm password fields$")
  public void Enter_Valid_Credentials_in_current_new_and_confirm_password_fields() throws Throwable {
    log.info("Start of the Scenario update password");
    try {
      customMessage = "Enter Password";
      WebElementDetails currentPasswordTextBoxObj = webElementsList.get(0);
      settings.currentPasswordTextBox(currentPasswordTextBoxObj).sendKeys(currentPasswordTextBoxObj.getData());

      customMessage = "Enter New Password";
      WebElementDetails newPasswordTextBoxObj = webElementsList.get(1);
      settings.newPasswordTextBox(newPasswordTextBoxObj).sendKeys(newPasswordTextBoxObj.getData());

      customMessage = "Enter Confirm Password";
      WebElementDetails confirmPasswordTextBoxObj = webElementsList.get(2);
      settings.confirmPasswordTextBox(confirmPasswordTextBoxObj).sendKeys(confirmPasswordTextBoxObj.getData());
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }
  }

  // ==================================================================================

  @Then("^click on save button$")
  public void click_on_save_button() throws Throwable {
    try {
      customMessage = "Clicking on Submit button";
      WebElementDetails submitBtnObj = webElementsList.get(6);
      settings.submitBtn(submitBtnObj).click();
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }
  }

  // ==================================================================================

  @Then("^Enter Valid Data in current password and Email fields$")
  public void Enter_Valid_Data_in_current_password_and_Email_fields() throws Throwable {
    log.info("Start of the Scenario Update EmailId");
    try {
      customMessage = "Enter Current Password";
      WebElementDetails currentPasswordTextBoxObj = webElementsList.get(0);
      settings.currentPasswordTextBox(currentPasswordTextBoxObj).sendKeys(currentPasswordTextBoxObj.getData());

      customMessage = "Enter EmailID";
      WebElementDetails updateMailIDTextBoxObj = webElementsList.get(3);
      settings.updateMailIDTextBox(updateMailIDTextBoxObj).sendKeys(updateMailIDTextBoxObj.getData());
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }
  }

  // ==================================================================================

  @Then("^Choose the Language \"([^\"]*)\"$")
  public void Choose_the_Language(String arg1) throws Throwable {
    log.info("Start of the Scenario update Language");
    try {
      WebElementDetails englishLanguageRadioBtnObj = webElementsList.get(4);
      WebElementDetails spanishLanguageRadioBtnObj = webElementsList.get(5);

      switch (arg1) {
      case "english":
        customMessage = "Clicking on English radio button";
        if (!settings.englishLanguageRadioBtn(englishLanguageRadioBtnObj).isSelected()) {
          settings.englishLanguageRadioBtn(englishLanguageRadioBtnObj).click();
        }
        break;
      case "spanish":
        customMessage = "Clicking on Spanish radio button";
        if (!settings.spanishLanguageRadioBtn(spanishLanguageRadioBtnObj).isSelected()) {
          settings.spanishLanguageRadioBtn(spanishLanguageRadioBtnObj).click();
        }
      default:
        break;
      }
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }
  }

  // ==================================================================================

  @Then("^Verify the status message$")
  public void Verify_the_status_message() throws Throwable {
    try {
      customMessage = "Assertion for the Settings Status message";
      WebElementDetails statusMsgObj = webElementsList.get(7);

      String feedbackstatus = settings.statusMsg(statusMsgObj).getText();
      Assert.assertTrue("Assertion for the Settings Status message has been failed ",feedbackstatus.contains("Se han guardado los cambios")
          || feedbackstatus.contains("The changes have been saved."));
      log.info("Changes have been saved sucessfully");
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }
  }

  // ==================================================================================

  @Then("^Enter Invalid Credentials in current,new and confirm password fields$")
  public void Enter_Invalid_Credentials_in_current_new_and_confirm_password_fields() throws Throwable {
    log.info("Start of the Scenario update password ");
    try {
      customMessage = "Enter Current Password";
      WebElementDetails currentPasswordTextBoxObj = webElementsList.get(0);
      settings.currentPasswordTextBox(currentPasswordTextBoxObj).sendKeys(currentPasswordTextBoxObj.getData());

      customMessage = "Enter New Password";
      WebElementDetails newPasswordTextBoxObj = webElementsList.get(1);
      settings.newPasswordTextBox(newPasswordTextBoxObj).sendKeys(newPasswordTextBoxObj.getData());

      customMessage = "Enter Confirm Password";
      WebElementDetails confirmPasswordTextBoxObj = webElementsList.get(9);
      settings.confirmPasswordTextBox(confirmPasswordTextBoxObj).sendKeys(confirmPasswordTextBoxObj.getData());
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }
  }

  // ==================================================================================

  @Then("^Verify the error message$")
  public void Verify_the_error_message() throws Throwable {
    WebElementDetails statusMsgObj = webElementsList.get(7);
    try {
      customMessage = "Assertion for the Password Status Message";
      String feedbackstatus = settings.statusMsg(statusMsgObj).getText();
      Assert.assertTrue("Failed to verify error message",feedbackstatus
          .contains("Your current password is missing or incorrect; it's required to change the Password.")
          || feedbackstatus.contains("diffrent password in new and current password fields")
          || feedbackstatus.contains("The specified passwords do not match."));
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }
  }

  // ==================================================================================

  @Then("^Enter Invalid Data in current password and Email fields$")
  public void enter_Invalid_Data_in_current_password_and_Email_fields() throws Throwable {
    log.info("Start of the Scenario update EmailId");
    try {
      customMessage = "Enter Current Password";
      WebElementDetails currentPasswordTextBoxObj = webElementsList.get(0);
      settings.currentPasswordTextBox(currentPasswordTextBoxObj).sendKeys(currentPasswordTextBoxObj.getData());

      customMessage = "Enter Email ID";
      WebElementDetails updateMailIDTextBoxObj = webElementsList.get(10);
      settings.updateMailIDTextBox(updateMailIDTextBoxObj).sendKeys(updateMailIDTextBoxObj.getData());
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }
  }

  // ==================================================================================

  @Then("^Verify the email error message$")
  public void verify_the_email_error_message() throws Throwable {
    try {
      WebElementDetails statusMsgObj = webElementsList.get(7);
      String feedbackstatus = settings.statusMsg(statusMsgObj).getText();
      WebElementDetails placeholderObj = webElementsList.get(7);
      String Placeholder = settings.placeHolder(placeholderObj).getText();
      
      customMessage = "Assertion for the Email Status Message";
      Assert.assertTrue("Assertion for the Email Status Message has been failed",!(feedbackstatus.contains(
          "Your current password is missing or incorrect; it's required to change the E-mail address..")
          || feedbackstatus.contains("The e-mail address " + Placeholder + " is not valid.")));
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }
  }
}