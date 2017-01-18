package com.sci.testamigo.bi.stepdef;

import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sci.testamigo.bi.common.Constants;
import com.sci.testamigo.bi.exceptions.TestAmigoException;
import com.sci.testamigo.bi.model.WebElementDetails;
import com.sci.testamigo.bi.pageobjects.BrightIdeasHome;
import com.sci.testamigo.bi.pageobjects.Settings;
import com.sci.testamigo.bi.pageobjects.Signin;
import com.sci.testamigo.bi.util.AppSetup;
import com.sci.testamigo.bi.util.JXMLParser;
import com.sci.testamigo.bi.util.PageCommonWD;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class SigninStepDef {
  WebDriver driver = PageCommonWD.getOpenBrowserHelp().getDriver();
  AppSetup appsetup = new AppSetup();
  protected transient final Log log = LogFactory.getLog(getClass());
  ResourceBundle resourceBundle = null;
  BrightIdeasHome BIHome = new BrightIdeasHome();
  
  private List<WebElementDetails> webElementsList = JXMLParser.getInstance().getWebElements(Signin.class.getSimpleName());
  private List<WebElementDetails> BIHomewebElementsList = JXMLParser.getInstance().getWebElements(BrightIdeasHome.class.getSimpleName());
  private List<WebElementDetails> settingsWebElementsList =  JXMLParser.getInstance().getWebElements(Settings.class.getSimpleName());
  String customMessage = null;
  // ==================================================================================

  @BeforeClass
  public void setup() {
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }

  // ==================================================================================

  @Given("^user is redirected to Bright Ideas Login page$")
  public void user_is_redirected_to_Bright_Ideas_Login_page() throws Throwable {
    try {
      log.info(" Start of the Scenario Login to Bright Ideas application as a participant user");
      resourceBundle = ResourceBundle.getBundle("ApplicationResources");
      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
      driver.get(resourceBundle.getString(Constants.APPLICATION_URL));
      Assert.assertTrue("Failed to verify Login page title",driver.getTitle().equals("Welcome to Bright IDEAS | Bright IDEAS"));
      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
      driver.manage().window().maximize();
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage,AppSetup.getMethodName() );
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage,AppSetup.getMethodName() );
    }
  }

  // ==================================================================================

  @And("^enter valid credentials and click on Login button$")
  public void enter_valid_credentials() throws Throwable {
    try {
      Signin login = new Signin();
      
      WebElementDetails userNameTextBoxObj = webElementsList.get(0);
      login.Username(userNameTextBoxObj).sendKeys(userNameTextBoxObj.getData());
      appsetup.driverwait(1000);

      WebElementDetails passwordTextBoxObj = webElementsList.get(1);
      login.Password(passwordTextBoxObj).sendKeys(passwordTextBoxObj.getData());
      appsetup.driverwait(1000);
      
      WebElementDetails loginBtnObj = webElementsList.get(2);
      login.loginbtn(loginBtnObj).click();
      appsetup.driverwait(1000);
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage,AppSetup.getMethodName() );
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage,AppSetup.getMethodName() );
    }
  }

  // ==================================================================================

  @Then("^verify BrightIDEAS Home page title$")
  public void verify_BrightIDEAS_Home_page_title() throws Throwable {
    driver = PageCommonWD.getOpenBrowserHelp().getDriver();
    Settings settings = new Settings();
    
    try {
      
      if (driver.getTitle().equals("IDEAS Brillantes")) {
        WebElementDetails settingsLinkTextobj = BIHomewebElementsList.get(3);
        BIHome.menuList(settingsLinkTextobj).findElements(By.tagName("li")).get(3).click();

        WebElementDetails englishLanguageRadioBtnObj = settingsWebElementsList.get(4);
        settings.englishLanguageRadioBtn(englishLanguageRadioBtnObj).click();

        WebElementDetails submitBtnObj = settingsWebElementsList.get(6);
        settings.submitBtn(submitBtnObj).click();

        WebElementDetails learnBrightIdeasLinkObj = BIHomewebElementsList.get(0);
        BIHome.learnBrightIdeasLink(learnBrightIdeasLinkObj).click();
        appsetup.driverwait(1000);
      }
      customMessage = "Page title verification";
      Assert.assertTrue("Failed to verify Home page title ",driver.getTitle().equalsIgnoreCase("Bright IDEAS"));
      log.info("Page title verified ");
      log.info(" End of the Scenario Login to Bright Ideas application as a participant user");
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage,AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage,AppSetup.getMethodName() );
    }
  }
}