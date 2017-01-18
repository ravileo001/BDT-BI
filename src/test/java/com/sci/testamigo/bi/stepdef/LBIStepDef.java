package com.sci.testamigo.bi.stepdef;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sci.testamigo.bi.exceptions.TestAmigoException;
import com.sci.testamigo.bi.model.WebElementDetails;
import com.sci.testamigo.bi.pageobjects.Achivements;
import com.sci.testamigo.bi.pageobjects.BrightIdeasHome;
import com.sci.testamigo.bi.pageobjects.LearnBrightIdeas;
import com.sci.testamigo.bi.pageobjects.LearnBrightIdeasSessions;
import com.sci.testamigo.bi.util.AppSetup;
import com.sci.testamigo.bi.util.JXMLParser;
import com.sci.testamigo.bi.util.PageCommonWD;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LBIStepDef {
  WebDriver driver;
  AppSetup appsetup = new AppSetup();
  LearnBrightIdeas lbi = new LearnBrightIdeas();
  BrightIdeasHome BIHome = new BrightIdeasHome();
  Achivements achievements = new Achivements();
  LearnBrightIdeasSessions lbiSessionsPage = new LearnBrightIdeasSessions();
  protected transient final Log log = LogFactory.getLog(getClass());
  public static int sessionrepeatno = 0;
  public static int videono;
  String customMessage = null;

  private List<WebElementDetails> webElementsList = JXMLParser.getInstance()
      .getWebElements(LearnBrightIdeas.class.getSimpleName());
  private List<WebElementDetails> BIHomewebElementsList = JXMLParser.getInstance()
      .getWebElements(BrightIdeasHome.class.getSimpleName());
  private List<WebElementDetails> achivementswebElementsList = JXMLParser.getInstance()
      .getWebElements(Achivements.class.getSimpleName());
  private List<WebElementDetails> lbiSessionsPagewebElementsList = JXMLParser.getInstance()
      .getWebElements("LearnBrightIdeasSessionsPage");
  private List<WebElementDetails> lbiVideowebElementsList = JXMLParser.getInstance()
      .getWebElements("LearnBrightIdeasVideoPage");

  // ==================================================================================

  @Given("^user navigate to LEARN BRIGHT IDEAS section$")
  public void user_navigates_to_LEARN_BRIGHT_IDEAS() throws Throwable {
    try {
      customMessage = "click on LearnBrightIdeas";
      WebElementDetails learnBrightIdeasLinkObj = BIHomewebElementsList.get(0);
      BIHome.learnBrightIdeasLink(learnBrightIdeasLinkObj).click();
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }
  }

  // ==================================================================================

  @Then("^click on video (\\d+)$")
  public void click_on_Video(int videoNo) throws Throwable {
    try {
      try {
        customMessage = "Clicking on Video";
        WebElementDetails video1LinkObj = webElementsList.get(1);
        WebElementDetails video2LinkObj = webElementsList.get(2);
        WebElementDetails video3LinkObj = webElementsList.get(3);
        WebElementDetails video4LinkObj = webElementsList.get(4);
        WebElementDetails video5LinkObj = webElementsList.get(5);
        WebElementDetails video6LinkObj = webElementsList.get(6);
        WebElementDetails video7LinkObj = webElementsList.get(7);
        WebElement[] video = { lbi.video1Link(video1LinkObj), lbi.video2Link(video2LinkObj),
            lbi.video3Link(video3LinkObj), lbi.video4Link(video4LinkObj), lbi.video5Link(video5LinkObj),
            lbi.video6Link(video6LinkObj), lbi.video7Link(video7LinkObj) };
        video[videoNo - 1].click();
        appsetup.driverwait(1000);

        // Play & Pause the Video and Getting the Buffer time
        verifyvideotime();
        appsetup.driverwait(2000);

        WebElementDetails videogrid1LinkObj = webElementsList.get(14);
        WebElementDetails videogrid2LinkObj = webElementsList.get(15);
        WebElementDetails videogrid3LinkObj = webElementsList.get(16);
        WebElementDetails videogrid4LinkObj = webElementsList.get(17);
        WebElementDetails videogrid5LinkObj = webElementsList.get(18);
        WebElementDetails videogrid6LinkObj = webElementsList.get(19);
        WebElementDetails videogrid7LinkObj = webElementsList.get(20);
        WebElementDetails videogrid8LinkObj = webElementsList.get(21);

        WebElement[] videogrids = { lbi.videogrid1(videogrid1LinkObj), lbi.videogrid2(videogrid2LinkObj),
            lbi.videogrid3(videogrid3LinkObj), lbi.videogrid4(videogrid4LinkObj),
            lbi.videogrid5(videogrid5LinkObj), lbi.videogrid6(videogrid6LinkObj),
            lbi.videogrid7(videogrid7LinkObj), lbi.videogrid8(videogrid8LinkObj) };
        videocompletestatus(videogrids[videoNo - 1], videogrids[videoNo]);

      } catch (NoSuchElementException e) {

        WebElementDetails video2DisableModeObj = webElementsList.get(8);
        WebElementDetails video3DisableModeObj = webElementsList.get(9);
        WebElementDetails video4DisableModeObj = webElementsList.get(10);
        WebElementDetails video5DisableModeObj = webElementsList.get(11);
        WebElementDetails video6DisableModeObj = webElementsList.get(12);
        WebElementDetails video7DisableModeObj = webElementsList.get(13);

        WebElement[] videodisbaleMode = { lbi.video2DisableMode(video2DisableModeObj),
            lbi.video3DisableMode(video3DisableModeObj), lbi.video4DisableMode(video4DisableModeObj),
            lbi.video5DisableMode(video5DisableModeObj), lbi.video6DisableMode(video6DisableModeObj),
            lbi.video7DisableMode(video7DisableModeObj) };
        if (videodisbaleMode[videoNo - 2].isDisplayed()) {
          log.info("Selected video in disabled mode please complete the prevoius video");
        }
      } catch (Exception e) {
      }
      videono = videoNo;
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }
  }

  // ==================================================================================

  @Then("^click on session (\\d+)$")
  public void click_on_session(int sessionNo) throws Throwable {
    try {
      customMessage = "Clicking on Practise Session";
      WebElementDetails Videogrid8Obj = webElementsList.get(21);
      WebElementDetails Videogrid9Obj = webElementsList.get(22);
      WebElementDetails Videogrid10Obj = webElementsList.get(23);
      WebElementDetails Videogrid11Obj = webElementsList.get(24);

      switch (sessionNo) {
      case 1:
        lbi.videogrid8(Videogrid8Obj).findElement(By.cssSelector(".learn-brigh-ideas-grid-image")).click();
        session1();
        sessioncompletestatus(lbi.videogrid8(Videogrid8Obj));
        break;
      case 2:
        lbi.videogrid9(Videogrid9Obj).findElement(By.cssSelector(".learn-brigh-ideas-grid-image")).click();
        session2();
        sessioncompletestatus(lbi.videogrid9(Videogrid9Obj));
        break;
      case 3:
        lbi.videogrid10(Videogrid10Obj).findElement(By.cssSelector(".learn-brigh-ideas-grid-image")).click();
        session3();
        sessioncompletestatus(lbi.videogrid10(Videogrid10Obj));
        break;
      case 4:
        lbi.videogrid11(Videogrid11Obj).findElement(By.cssSelector(".learn-brigh-ideas-grid-image")).click();
        session4();
        sessioncompletestatus(lbi.videogrid11(Videogrid11Obj));
        log.info("Completed 4th practice session");
        break;
      default:
        log.info("Select the session no between 1 to 4 only");
        break;
      }
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }
  }

  // ===================================================================================
  // Achievement Webelements
  WebElementDetails achivementsLinkObj = BIHomewebElementsList.get(2);
  WebElementDetails UnlockStatusListObj = achivementswebElementsList.get(0);

  @Then("^verify achivement status is unlocked for (\\d+)th video$")
  public void verify_achivement_status_is_unlocked_for_th_video(int arg1) throws Throwable {
    try {
      customMessage = "Verifying the Achievment Status for Video";
      if (videono == 7) {
        BIHome.achivemetsLink(achivementsLinkObj).click();
        appsetup.driverwait(3000);
        boolean flag = false;
        for (int i = 0; i < achievements.UnlockStatusList(UnlockStatusListObj).size(); i++) {
          String achievement = achievements.UnlockStatusList(UnlockStatusListObj).get(i)
              .findElement(By.cssSelector(".achievement-title")).getText();
          if (achievement.equalsIgnoreCase("First Steps")) {
            flag = true;
            log.info("'First Steps' Acheivement unlocked");
          }
        }
        Assert.assertTrue("Failed to verify 'First Steps' Achivement status", flag);
      }
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }
  }

  // ==================================================================================

  @Then("^verify achivement status is unlocked for  (\\d+)nd and (\\d+)th Sessions$")
  public void verify_achivement_status_is_unlocked_for_nd_and_th_Sessions(int arg1, int arg2) throws Throwable {
    try {
      customMessage = "Verifying the Achievment Status for Practise Session";
      sessionrepeatno = sessionrepeatno + 1;
      if (sessionrepeatno == 2 || sessionrepeatno == 4) {
        boolean flag = false;
        if (sessionrepeatno == 2) {
          BIHome.achivemetsLink(achivementsLinkObj).click();
          appsetup.driverwait(3000);
          for (int i = 0; i < achievements.UnlockStatusList(UnlockStatusListObj).size(); i++) {
            String achivment = achievements.UnlockStatusList(UnlockStatusListObj).get(i)
                .findElement(By.cssSelector(".achievement-title")).getText();
            if (achivment.equalsIgnoreCase("Find Your Stride")) {
              flag = true;
              log.info("'Find Your Stride' Acheivement unlocked");
            }
          }
        } else if (sessionrepeatno == 4) {
          BIHome.achivemetsLink(achivementsLinkObj).click();
          appsetup.driverwait(3000);
          for (int i = 0; i < achievements.UnlockStatusList(UnlockStatusListObj).size(); i++) {
            String achivment = achievements.UnlockStatusList(UnlockStatusListObj).get(i)
                .findElement(By.cssSelector(".achievement-title")).getText();
            if (achivment.equalsIgnoreCase("Barrier Breaker")) {
              flag = true;
              log.info("'Barrier Breaker' Acheivement unlocked");
            }
          }
        }
        Assert.assertTrue("Failed to verify 'Barrier Breaker' Achivement status ", flag);
      }
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }
  }

  // ==================================================================================

  public void verifyvideotime() throws InterruptedException {
    driver = PageCommonWD.getOpenBrowserHelp().getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 60);
    WebElement playerIframe = wait
        .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#videoplayer")));
    driver.switchTo().frame(playerIframe);

    // test code to pause, drag the progress bar and click on play button
    appsetup.driverwait(6000);
    // to enable the video control panel

    WebElementDetails playBtnObj = lbiVideowebElementsList.get(0);

    Point pt = lbi.playButton(playBtnObj).getLocation();
    Actions move1 = new Actions(driver);
    Action action = (Action) move1.moveByOffset(pt.getX(), pt.getY()).click().build();
    action.perform();

    lbi.playButton(playBtnObj).click();
    appsetup.driverwait(1000);

    WebElementDetails ProgressBarObj = lbiVideowebElementsList.get(1);

    WebElement slider = lbi.ProgressBar(ProgressBarObj);
    Actions move = new Actions(driver);
    Action action1 = (Action) move.dragAndDropBy(slider, 280, 0).build();
    action1.perform();
    appsetup.driverwait(1000);

    WebElementDetails pauseBtnObj = lbiVideowebElementsList.get(2);

    lbi.pauseButton(pauseBtnObj).click();
    // code to get buffer time
    long starttime = System.currentTimeMillis();
    appsetup.driverwait(5000);

    WebElementDetails loadingBarObj = lbiVideowebElementsList.get(3);
    WebElementDetails playedBarObj = lbiVideowebElementsList.get(4);

    String[] v = lbi.LoadingBar(loadingBarObj).getAttribute("width").split("%");
    double value = Double.parseDouble(v[0]);

    while (Double.compare(value, 90.00) < 0) {
      Thread.sleep(1000);
      log.info("Video Loading Status: " + lbi.LoadingBar(loadingBarObj).getAttribute("width"));
      log.info("Video Progressbar Status: " + lbi.PlayedBar(playedBarObj).getAttribute("width"));
      v = lbi.LoadingBar(loadingBarObj).getAttribute("width").split("%");
      value = Double.parseDouble(v[0]);
    }

    long endtime = System.currentTimeMillis();
    long elaspsedtime = endtime - starttime;
    log.info("Total Buffer Time: " + Math.round(elaspsedtime / 1000) + " Sec ");

    // Getting the progress bar width for checking whether video is
    // completed or not
    while (!(lbi.PlayedBar(playedBarObj).getAttribute("width").equalsIgnoreCase("100%")
        || lbi.PlayedBar(playedBarObj).getAttribute("width").equalsIgnoreCase("0%"))) {
      appsetup.driverwait(1000);
      log.info("Video Progressbar Status: " + lbi.PlayedBar(playedBarObj).getAttribute("width"));
    }
    WebElementDetails backToLaernBrightIdeasLink = lbiVideowebElementsList.get(5);

    driver.switchTo().defaultContent();
    lbi.backToLaernBrightIdeasLink(backToLaernBrightIdeasLink).click();
  }

  // ==================================================================================

  public void sessioncompletestatus(WebElement presentvideo) throws InterruptedException {
    appsetup.driverwait(2000);
    Assert.assertTrue("Status for the completed Practice activity is not updated",
        presentvideo.findElement(By.cssSelector(".learn-brigh-ideas-grid-star-unlocked")).isDisplayed());
  }

  // ==================================================================================

  public void videocompletestatus(WebElement presentvideo, WebElement nextvideo) throws InterruptedException {
    appsetup.driverwait(2000);
    Assert.assertTrue("Status for the completed Practice video is not updated",
        presentvideo.findElement(By.cssSelector(".learn-brigh-ideas-grid-star-unlocked")).isDisplayed());
    Assert.assertTrue("Next video still unlocked state after completing the present video",
        nextvideo.findElement(By.cssSelector(".learn-brigh-ideas-grid-image")).isDisplayed());
  }

  // ==================================================================================

  public void session1() throws InterruptedException {
    driver = PageCommonWD.getOpenBrowserHelp().getDriver();

    WebElementDetails session1NextpageBtnObj = lbiSessionsPagewebElementsList.get(0);
    WebElementDetails session1Option1BtnObj = lbiSessionsPagewebElementsList.get(1);
    WebElementDetails session1Ellipse1BtnObj = lbiSessionsPagewebElementsList.get(2);
    appsetup.driverwait(5000);

    appsetup.driverwait(10000);

    WebDriverWait wait = new WebDriverWait(driver, 60);
    wait.until(ExpectedConditions.visibilityOf(lbiSessionsPage.session1NextPageBtn(session1NextpageBtnObj)));

    for (int i = 0; i < 10; i++) {
      appsetup.driverwait(2000);
      if (i == 2) {
        try {
          lbiSessionsPage.session1Option1Btn(session1Option1BtnObj).click();
        } catch (ElementNotVisibleException e) {
          lbiSessionsPage.session1NextPageBtn(session1NextpageBtnObj).click();
          lbiSessionsPage.session1Option1Btn(session1Option1BtnObj).click();
        }
      }
      if (i == 8) {
        lbiSessionsPage.session1Ellipse1Btn(session1Ellipse1BtnObj).click();
      }
      lbiSessionsPage.session1NextPageBtn(session1NextpageBtnObj).click();
    }
    WebElementDetails backToLaernBrightIdeasLink = lbiVideowebElementsList.get(5);
    lbi.backToLaernBrightIdeasLink(backToLaernBrightIdeasLink).click();
  }

  // ==================================================================================

  public void session2() throws InterruptedException {

    WebElementDetails session2NextpageBtnObj = lbiSessionsPagewebElementsList.get(3);
    WebElementDetails session2Option1BtnObj = lbiSessionsPagewebElementsList.get(4);
    WebElementDetails session2Ellipse1BtnObj = lbiSessionsPagewebElementsList.get(5);

    WebDriverWait wait = new WebDriverWait(driver, 60);
    wait.until(ExpectedConditions.visibilityOf(lbiSessionsPage.session2NextPageBtn(session2NextpageBtnObj)));
    for (int i = 0; i < 10; i++) {
      appsetup.driverwait(2000);
      if (i == 2) {
        try {
          lbiSessionsPage.session2Option1Btn(session2Option1BtnObj).click();
        } catch (ElementNotVisibleException e) {
          lbiSessionsPage.session2NextPageBtn(session2NextpageBtnObj).click();
          lbiSessionsPage.session2Option1Btn(session2Option1BtnObj).click();
        }
      }
      if (i == 8) {
        lbiSessionsPage.sessio2Ellipse1Btn(session2Ellipse1BtnObj).click();
      }
      lbiSessionsPage.session2NextPageBtn(session2NextpageBtnObj).click();
    }
    WebElementDetails backToLaernBrightIdeasLink = lbiVideowebElementsList.get(5);
    lbi.backToLaernBrightIdeasLink(backToLaernBrightIdeasLink).click();
  }

  // ==================================================================================

  public void session3() throws InterruptedException {

    WebElementDetails session3NextpageBtnObj = lbiSessionsPagewebElementsList.get(6);
    WebElementDetails session3Option1BtnObj = lbiSessionsPagewebElementsList.get(7);
    WebElementDetails session3Ellipse1BtnObj = lbiSessionsPagewebElementsList.get(8);

    WebDriverWait wait = new WebDriverWait(driver, 60);
    wait.until(ExpectedConditions.visibilityOf(lbiSessionsPage.session3NextPageBtn(session3NextpageBtnObj)));
    for (int i = 0; i < 10; i++) {
      appsetup.driverwait(2000);
      if (i == 2) {
        try {
          lbiSessionsPage.session3Option1Btn(session3Option1BtnObj).click();
        } catch (ElementNotVisibleException e) {
          lbiSessionsPage.session3NextPageBtn(session3NextpageBtnObj).click();
          lbiSessionsPage.session3Option1Btn(session3Option1BtnObj).click();
        }
      }
      if (i == 8) {
        lbiSessionsPage.session3Ellipse1Btn(session3Ellipse1BtnObj).click();
      }
      lbiSessionsPage.session3NextPageBtn(session3NextpageBtnObj).click();
    }
    WebElementDetails backToLaernBrightIdeasLink = lbiVideowebElementsList.get(5);
    lbi.backToLaernBrightIdeasLink(backToLaernBrightIdeasLink).click();
  }

  // ==================================================================================

  public void session4() throws InterruptedException {

    WebElementDetails session4NextpageBtnObj = lbiSessionsPagewebElementsList.get(9);
    WebElementDetails session4Option1BtnObj = lbiSessionsPagewebElementsList.get(10);
    WebElementDetails session4Ellipse1BtnObj = lbiSessionsPagewebElementsList.get(11);

    WebDriverWait wait = new WebDriverWait(driver, 60);
    wait.until(ExpectedConditions.visibilityOf(lbiSessionsPage.session4NextPageBtn(session4NextpageBtnObj)));
    for (int i = 0; i < 10; i++) {
      appsetup.driverwait(2000);
      if (i == 2) {
        try {
          lbiSessionsPage.session4Option1Btn(session4Option1BtnObj).click();
        } catch (ElementNotVisibleException e) {
          lbiSessionsPage.session4NextPageBtn(session4NextpageBtnObj).click();
          lbiSessionsPage.session4Option1Btn(session4Option1BtnObj).click();
        }
      }
      if (i == 8) {
        lbiSessionsPage.session4Ellipse1Btn(session4Ellipse1BtnObj).click();
      }
      lbiSessionsPage.session4NextPageBtn(session4NextpageBtnObj).click();
    }
    WebElementDetails backToLaernBrightIdeasLink = lbiVideowebElementsList.get(5);
    lbi.backToLaernBrightIdeasLink(backToLaernBrightIdeasLink).click();
  }
}