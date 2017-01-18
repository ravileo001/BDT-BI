package com.sci.testamigo.bi.testsuites;

import static com.sci.testamigo.bi.common.Constants.FEATUREDETAILS;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.sci.testamigo.bi.common.Constants;
import com.sci.testamigo.bi.pageobjects.LearnBrightIdeas;
import com.sci.testamigo.bi.pageobjects.Signin;
import com.sci.testamigo.bi.report.ReportManager;
import com.sci.testamigo.bi.util.AppSetup;
import com.sci.testamigo.bi.util.BIRunnerSetup;
import com.sci.testamigo.bi.util.HeaderFile;
import com.sci.testamigo.bi.util.PageCommonWD;

public class LBISuite {
	WebDriver driver = PageCommonWD.getOpenBrowserHelp().getDriver();
	LearnBrightIdeas lbi = new LearnBrightIdeas();
	HeaderFile headerFile = new HeaderFile();
	BIRunnerSetup birunnersetup = new BIRunnerSetup();
	AppSetup appsetup = new AppSetup();
	ReportManager reportManager = new ReportManager();

	@Test
	public void LearnBrightIdeasrunner() throws Throwable {
		LearnBrightIdeas(Constants.runnerflag);
	}

	public void LearnBrightIdeas(boolean runnerflag) throws Throwable {
		try {
			if (runnerflag) {
				FEATUREDETAILS = reportManager.populateInitialData(Signin.class.getSimpleName());
				headerFile.preRequisites();
			}

			FEATUREDETAILS = reportManager.populateInitialData(LearnBrightIdeas.class.getSimpleName());
			birunnersetup.BIrunnerOptions(appsetup.getFeatureName(lbi.getClass().getSimpleName()));

			if (runnerflag) {
				FEATUREDETAILS = reportManager.populateInitialData("sign-out");
				headerFile.postRequisites();
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
}