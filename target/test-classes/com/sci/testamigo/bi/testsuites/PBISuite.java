package com.sci.testamigo.bi.testsuites;

import static com.sci.testamigo.bi.common.Constants.FEATUREDETAILS;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.sci.testamigo.bi.common.Constants;
import com.sci.testamigo.bi.pageobjects.PracticeBrightIdeas;
import com.sci.testamigo.bi.pageobjects.Signin;
import com.sci.testamigo.bi.report.ReportManager;
import com.sci.testamigo.bi.util.AppSetup;
import com.sci.testamigo.bi.util.BIRunnerSetup;
import com.sci.testamigo.bi.util.HeaderFile;
import com.sci.testamigo.bi.util.PageCommonWD;

public class PBISuite {
	WebDriver driver = PageCommonWD.getOpenBrowserHelp().getDriver();
	PracticeBrightIdeas pbi = new PracticeBrightIdeas();
	HeaderFile headerFile = new HeaderFile();
	BIRunnerSetup birunnersetup = new BIRunnerSetup();
	AppSetup appsetup = new AppSetup();
	ReportManager reportManager = new ReportManager();

	@Test
	public void practiceBrightIdeasrunner() throws Throwable {
		practiceBrightIdeas(Constants.runnerflag);
	}

	public void practiceBrightIdeas(boolean runnerflag) throws Throwable {
		try {
			if (runnerflag) {
				FEATUREDETAILS = reportManager.populateInitialData(Signin.class.getSimpleName());
				headerFile.preRequisites();
			}

			FEATUREDETAILS = reportManager.populateInitialData(PracticeBrightIdeas.class.getSimpleName());
			birunnersetup.BIrunnerOptions(appsetup.getFeatureName(pbi.getClass().getSimpleName()));

			if (runnerflag) {
				FEATUREDETAILS = reportManager.populateInitialData("sign-out");
				headerFile.postRequisites();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}