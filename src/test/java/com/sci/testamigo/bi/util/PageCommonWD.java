package com.sci.testamigo.bi.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class PageCommonWD {
  private WebDriver driver;
  private static PageCommonWD browserHelp;

  // Create new web driver instance
  private PageCommonWD() {
    ProfilesIni profile = new ProfilesIni();
    FirefoxProfile fp = profile.getProfile("Defaultbrowse");
    this.driver = new FirefoxDriver(fp);
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().window().maximize();
  }

  public static PageCommonWD getOpenBrowserHelp() {
    if (null == browserHelp) {
      browserHelp = new PageCommonWD();
    }
    return browserHelp;
  }

  public WebDriver getDriver() {
    return driver;
  }

  void setDriver(WebDriver driver) {
    this.driver = driver;
  }
}