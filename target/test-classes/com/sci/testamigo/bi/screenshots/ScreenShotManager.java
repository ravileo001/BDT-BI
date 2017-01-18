/**
 * @author Jp
 *
 */
package com.sci.testamigo.bi.screenshots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.sci.testamigo.bi.util.AppSetup;
import com.sci.testamigo.bi.util.PageCommonWD;

public class ScreenShotManager {

  private static ScreenShotManager manager = null;
  
  //==========================================================================
  
  public static synchronized ScreenShotManager getInstance() {
    if(manager == null) {
      manager = new ScreenShotManager();
    }
    return manager;
  }
  
  //==========================================================================
  
  private ScreenShotManager() { }

  //==========================================================================
  
  public String saveScreenShot(String className, String type) {
    File scrFile = null;
    String screenShotLocation = null;
    
    try {
      scrFile = ((TakesScreenshot) PageCommonWD.getOpenBrowserHelp().getDriver()).getScreenshotAs(OutputType.FILE);
      
      screenShotLocation = AppSetup.getScreenShotsRepositoryFilePath(className, type);
      
      FileUtils.copyFile(scrFile, new File(screenShotLocation));
    } catch (IOException ioe) {
      ioe.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return screenShotLocation;
  }
  //==========================================================================
}
