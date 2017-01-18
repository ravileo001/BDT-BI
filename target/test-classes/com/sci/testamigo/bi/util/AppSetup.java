package com.sci.testamigo.bi.util;

import static com.sci.testamigo.bi.common.Constants.XML;
import static com.sci.testamigo.bi.common.Constants.XML_REPOSITORY;

import java.io.File;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.sci.testamigo.bi.common.Constants;
import com.sci.testamigo.bi.report.FeatureDetails;
import com.sci.testamigo.bi.report.ScenarioDetails;

import cucumber.api.java.After;

public class AppSetup {

  WebDriver driver = PageCommonWD.getOpenBrowserHelp().getDriver();
  ResourceBundle resourceBundle = null;
  BIRunnerSetup birunnersetup = new BIRunnerSetup();
  protected transient final Log log = LogFactory.getLog(getClass());
  FeatureDetails featureDeatils = new FeatureDetails();
  ScenarioDetails scenarioDeatils = new ScenarioDetails();
  
  // ==========================================================================

  public static String getXMLFilePath(String xmlFileName) {
    StringBuffer xmlFilePath = new StringBuffer("");
    xmlFilePath.append(System.getProperty("user.dir"));
    xmlFilePath.append(XML_REPOSITORY);
    xmlFilePath.append(xmlFileName);
    xmlFilePath.append(XML);
    return xmlFilePath.toString();
  }

  // ==========================================================================

  @After
  // Embed a screenshot in test report if test is marked as failed
  public byte[] CaptureScreen() {
    driver = PageCommonWD.getOpenBrowserHelp().getDriver();
    TakesScreenshot oScn = (TakesScreenshot) driver;
    byte[] screenshot = oScn.getScreenshotAs(OutputType.BYTES);
    return screenshot;
  }

  public void driverwait(int time) throws InterruptedException {
    Thread.sleep(time);
  }


  public String getFeatureName(String featureName) throws InterruptedException {
    String actualFeatureName = null;
    resourceBundle = ResourceBundle.getBundle("ApplicationResources");
    File directory = new File("target//generated-test-sources//cucumber");
    File[] listofFiles = directory.listFiles();

    if (listofFiles != null) {
      for (int i = 0; i < listofFiles.length; i++) {
        if (listofFiles[i].getName().contains(featureName.toLowerCase() + ".feature")
            || listofFiles[i].getName().contains(featureName + ".feature")) {
          actualFeatureName = listofFiles[i].getName();
        }
      }
    }
    return actualFeatureName;
  }

   // ==========================================================================

  public static String getMethodName() {
    return Thread.currentThread().getStackTrace()[2].getMethodName();
  }

  // ===========================================================================

  public static String getScreenShotsRepositoryFilePath(String className, String type) {
    StringBuffer screenShotsRepositoryFilePath = new StringBuffer("");
    screenShotsRepositoryFilePath.append("E://ApacheTomcat//webapps//testmate_app_data");
    //System.getProperty("user.dir")
    screenShotsRepositoryFilePath.append(Constants.SCREEN_SHOTS_REPOSITORY);
    screenShotsRepositoryFilePath.append(className);
    screenShotsRepositoryFilePath.append(Constants.UNDER_SCORE);
    screenShotsRepositoryFilePath.append(type);
    screenShotsRepositoryFilePath.append(Constants.UNDER_SCORE);
    screenShotsRepositoryFilePath.append(Constants.time);
    screenShotsRepositoryFilePath.append(Constants.PNG);
    return screenShotsRepositoryFilePath.toString();
  }

  // ===========================================================================
}