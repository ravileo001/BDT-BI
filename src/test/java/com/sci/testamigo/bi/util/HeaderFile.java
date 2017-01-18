package com.sci.testamigo.bi.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HeaderFile {
  BIRunnerSetup birunnersetup = new BIRunnerSetup();
  AppSetup appsetup = new AppSetup();
  protected transient final Log log = LogFactory.getLog(getClass());

  // ====================================================
  
  public void preRequisites() throws Throwable {
    birunnersetup.BIrunnerOptions(appsetup.getFeatureName("signin"));
  }

  // ====================================================
  
  public void postRequisites() throws Throwable {
    log.info("Start of the method Signing-Out");
    birunnersetup.BIrunnerOptions(appsetup.getFeatureName("Sign-Out"));
    log.info("End of the method Signing-Out");
  }
  
  // ====================================================
}