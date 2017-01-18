package com.sci.testamigo.bi.testsuites;

import static com.sci.testamigo.bi.common.Constants.FEATUREDETAILS;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.sci.testamigo.bi.common.Constants;
import com.sci.testamigo.bi.pageobjects.Settings;
import com.sci.testamigo.bi.pageobjects.Signin;
import com.sci.testamigo.bi.report.ReportManager;
import com.sci.testamigo.bi.util.AppSetup;
import com.sci.testamigo.bi.util.BIRunnerSetup;
import com.sci.testamigo.bi.util.HeaderFile;
import com.sci.testamigo.bi.util.PageCommonWD;

public class SettingsSuite {

	WebDriver driver = PageCommonWD.getOpenBrowserHelp().getDriver();
	Settings settings = new Settings();
	BIRunnerSetup cucumberrun = new BIRunnerSetup();
	HeaderFile headerFile = new HeaderFile();
	AppSetup appsetup = new AppSetup();
	ReportManager reportManager = new ReportManager();

	@Test
	public void settingRunner() throws Throwable {
		settings(Constants.runnerflag);
	}

	public void settings(boolean runnerflag) throws Throwable {
		try {
			if (runnerflag) {
				FEATUREDETAILS = reportManager.populateInitialData(Signin.class.getSimpleName());
				headerFile.preRequisites();
			}

			FEATUREDETAILS = reportManager.populateInitialData(Settings.class.getSimpleName());
			cucumberrun.BIrunnerOptions(appsetup.getFeatureName(settings.getClass().getSimpleName()));

			if (runnerflag) {
				FEATUREDETAILS = reportManager.populateInitialData("sign-out");
				headerFile.postRequisites();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}