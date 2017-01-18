package com.sci.testamigo.bi.stepdef;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sci.testamigo.bi.exceptions.TestAmigoException;
import com.sci.testamigo.bi.model.WebElementDetails;
import com.sci.testamigo.bi.pageobjects.BrightIdeasHome;
import com.sci.testamigo.bi.pageobjects.Message;
import com.sci.testamigo.bi.util.AppSetup;
import com.sci.testamigo.bi.util.JXMLParser;
import com.sci.testamigo.bi.util.PageCommonWD;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class MessageStepDef {
  WebDriver driver = PageCommonWD.getOpenBrowserHelp().getDriver();

  Message messages = new Message();
  private List<WebElementDetails> BIHomewebElementsList = JXMLParser.getInstance()
      .getWebElements(BrightIdeasHome.class.getSimpleName());
  BrightIdeasHome BIHome = new BrightIdeasHome();
  private List<WebElementDetails> ContactMyTrainerwebElementsList = JXMLParser.getInstance()
      .getWebElements(com.sci.testamigo.bi.pageobjects.ContactMyTrainer.class.getSimpleName());
  com.sci.testamigo.bi.pageobjects.ContactMyTrainer contactMyTrainer = new com.sci.testamigo.bi.pageobjects.ContactMyTrainer();
  private List<WebElementDetails> MessageswebElementsList = JXMLParser.getInstance()
      .getWebElements(Message.class.getSimpleName());
  String customMessage = null;
  // ==================================================================================

  @Given("^user is on Contact My Trainer$")
  public void user_is_on_Contact_My_Trainer() throws Throwable {
    try {
      customMessage = "Clicking on Contact My Trainer button";
      WebElementDetails contactMyTraineeLinkObj = BIHomewebElementsList.get(5);
      BIHome.contactMyTraineeLink(contactMyTraineeLinkObj).click();
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }
  }

  // ==================================================================================

  @Given("^user is on Message Section$")
  public void user_navigates_to_Message() throws Throwable {
    try {
      customMessage = "clicking on Message button";
      WebElementDetails messageLinkObj = BIHomewebElementsList.get(4);
      BIHome.messageLink(messageLinkObj).click();
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }
  }

  // ==================================================================================

  @Then("^send a message with subject \"([^\"]*)\" and message \"([^\"]*)\"$")
  public void send_a_message_with_subject_and_message(String arg1, String arg2) throws Throwable {
    try {
      customMessage = "Clicking on Private message link";
      WebElementDetails privateMsgLink = ContactMyTrainerwebElementsList.get(0);
      contactMyTrainer.privateMessageLink(privateMsgLink).findElement(By.tagName("a")).click();

      customMessage = "Enter data into subject";
      WebElementDetails subjectTextBoxObj = MessageswebElementsList.get(0);
      messages.subjectTextBox(subjectTextBoxObj).sendKeys(subjectTextBoxObj.getData());

      customMessage = "Enter data into message body";
      WebElementDetails messageBodyTextBoxObj = MessageswebElementsList.get(1);
      messages.messageBodyTextBox(messageBodyTextBoxObj).sendKeys(messageBodyTextBoxObj.getData());

      customMessage = "Clicking on Submit button";
      WebElementDetails submitBtnObj = MessageswebElementsList.get(2);
      messages.submitBtn(submitBtnObj).click();
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }
  }

  // ==================================================================================

  @Then("^verify the message status$")
  public void verify_the_status_message() throws Throwable {
    try {
      customMessage = "Verfying the message assertion";
      WebElementDetails ststusMsgObj = MessageswebElementsList.get(3);
      Assert.assertTrue("Failed to verify sent message status ",
          messages.statusMsg(ststusMsgObj).getText().contains("A message has been sent to testcoun."));
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }
  }

  // ==================================================================================

  @Then("^Select the message and delete the message$")
  public void Select_the_message_and_delete_the_message() throws Throwable {
    try {
      customMessage = "Clicking on Message Checkbox";
      WebElementDetails checkboxObj = MessageswebElementsList.get(4);
      WebElementDetails deleteBtnObj = MessageswebElementsList.get(5);
      messages.msgCheckBox(checkboxObj).findElement(By.cssSelector(".privatemsg-list.form-checkbox")).click();
      messages.deleteBtn(deleteBtnObj).click();
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }
  }

  // ==================================================================================

  @Then("^validate the message status$")
  public void validate_the_status_message() throws Throwable {
    try {
      customMessage = "Validating the message assertion";
      WebElementDetails ststusMsgObj = MessageswebElementsList.get(3);

      Assert.assertTrue("Failed to verify deleted message status ", messages.statusMsg(ststusMsgObj).findElements(By.tagName("li"))
          .get(1).getText().equals("The previous action can be undone."));
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }

  }

  @Then("^send a message withOut subject \"([^\"]*)\" and message \"([^\"]*)\"$")
  public void send_a_message_withOut_subject_and_message(String arg1, String arg2) throws Throwable {
    try {
      customMessage = "Clicking on Contact my trainer button";
      WebElementDetails privateMsgLink = ContactMyTrainerwebElementsList.get(0);
      contactMyTrainer.privateMessageLink(privateMsgLink).findElement(By.tagName("a")).click();

      customMessage = "Without data in Subject";
      WebElementDetails subjectTextBoxObj = MessageswebElementsList.get(0);
      messages.subjectTextBox(subjectTextBoxObj).sendKeys("");

      customMessage = "Without data in Message body";
      WebElementDetails messageBodyTextBoxObj = MessageswebElementsList.get(1);
      messages.messageBodyTextBox(messageBodyTextBoxObj).sendKeys("");

      customMessage = "Clicking on Submit button";
      WebElementDetails submitBtnObj = MessageswebElementsList.get(2);
      messages.submitBtn(submitBtnObj).click();
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }
  }

  @Then("^verify the error message status$")
  public void verify_the_error_message_status() throws Throwable {
    try {
      customMessage = "Verifying the assertion message status";
      WebElementDetails ststusMsgObj = MessageswebElementsList.get(6);
      Assert.assertTrue("Failed to verify error message", messages.statusMsg(ststusMsgObj).getText().contains("You must include a subject line with your message."));
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }
  }
}