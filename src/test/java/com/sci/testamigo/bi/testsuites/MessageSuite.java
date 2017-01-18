package com.sci.testamigo.bi.testsuites;

import static com.sci.testamigo.bi.common.Constants.FEATUREDETAILS;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.sci.testamigo.bi.common.Constants;
import com.sci.testamigo.bi.pageobjects.Message;
import com.sci.testamigo.bi.pageobjects.Signin;
import com.sci.testamigo.bi.report.ReportManager;
import com.sci.testamigo.bi.util.AppSetup;
import com.sci.testamigo.bi.util.BIRunnerSetup;
import com.sci.testamigo.bi.util.HeaderFile;
import com.sci.testamigo.bi.util.PageCommonWD;

public class MessageSuite {
	WebDriver driver = PageCommonWD.getOpenBrowserHelp().getDriver();
	Message message = new Message();
	BIRunnerSetup birunnersetup = new BIRunnerSetup();
	HeaderFile headerFile = new HeaderFile();
	AppSetup appsetup = new AppSetup();
	ReportManager reportManager = new ReportManager();

	@Test
	public void LearnBrightIdeasrunner() throws Throwable {
		Messages(Constants.runnerflag);
	}

	public void Messages(boolean runnerflag) throws Throwable {
		try {
			if (runnerflag) {
				FEATUREDETAILS = reportManager.populateInitialData(Signin.class.getSimpleName());
				headerFile.preRequisites();
			}
			FEATUREDETAILS = reportManager.populateInitialData(Message.class.getSimpleName());
			birunnersetup.BIrunnerOptions(appsetup.getFeatureName("Messages"));

			if (runnerflag) {
				FEATUREDETAILS = reportManager.populateInitialData("sign-out");
				headerFile.postRequisites();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}