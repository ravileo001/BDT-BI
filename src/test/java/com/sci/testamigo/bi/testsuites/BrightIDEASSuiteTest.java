package com.sci.testamigo.bi.testsuites;

import org.junit.Test;
import static com.sci.testamigo.bi.common.Constants.FEATUREDETAILS;
import static com.sci.testamigo.bi.common.Constants.suiteflag;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.cucumber.listener.ExtentCucumberFormatter;
import com.sci.testamigo.bi.pageobjects.LearnBrightIdeas;
import com.sci.testamigo.bi.pageobjects.Message;
import com.sci.testamigo.bi.pageobjects.PracticeBrightIdeas;
import com.sci.testamigo.bi.pageobjects.Settings;
import com.sci.testamigo.bi.pageobjects.Signin;
import com.sci.testamigo.bi.report.ReportManager;
import com.sci.testamigo.bi.util.AppSetup;
import com.sci.testamigo.bi.util.HeaderFile;

public class BrightIDEASSuiteTest {
  AppSetup appsetup = new AppSetup();
  SettingsSuite settings;
  LBISuite learnBrightIdeas;
  PBISuite practiceBrightIdeas;
  MessageSuite messages;
  ReportManager reportManager = new ReportManager();
  HeaderFile headerFile = new HeaderFile();

  @Test
  /* gets corresponding feature files */
  public void BrighIdeasRunner() throws Throwable {

    try {

      FEATUREDETAILS = reportManager.populateInitialData(Signin.class.getSimpleName());
      headerFile.preRequisites();

      learnBrightIdeas = new LBISuite();
      learnBrightIdeas.LearnBrightIdeas(suiteflag);

      practiceBrightIdeas = new PBISuite();
      practiceBrightIdeas.practiceBrightIdeas(suiteflag);

      messages = new MessageSuite();
      messages.Messages(suiteflag);

      settings = new SettingsSuite();
      settings.settings(suiteflag);

      FEATUREDETAILS = reportManager.populateInitialData("sign-out");
      headerFile.postRequisites();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
