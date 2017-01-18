package com.sci.testamigo.bi.stepdef;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sci.testamigo.bi.exceptions.TestAmigoException;
import com.sci.testamigo.bi.model.WebElementDetails;
import com.sci.testamigo.bi.pageobjects.Achivements;
import com.sci.testamigo.bi.pageobjects.BrightIdeasHome;
import com.sci.testamigo.bi.pageobjects.PracticeBrightIdeas;
import com.sci.testamigo.bi.util.AppSetup;
import com.sci.testamigo.bi.util.JXMLParser;
import com.sci.testamigo.bi.util.PageCommonWD;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class PBIStepDef {
  WebDriver driver = PageCommonWD.getOpenBrowserHelp().getDriver();
  AppSetup appsetup = new AppSetup();
  BrightIdeasHome BIHome = new BrightIdeasHome();
  PracticeBrightIdeas pbi = new PracticeBrightIdeas();
  public static int problemNo = 0;
  Achivements achievements = new Achivements();
  protected transient final Log log = LogFactory.getLog(getClass());
  
  private List<WebElementDetails> webElementsList = JXMLParser.getInstance().getWebElements(PracticeBrightIdeas.class.getSimpleName());
  private List<WebElementDetails> BIHomewebElementsList = JXMLParser.getInstance().getWebElements(BrightIdeasHome.class.getSimpleName());
  private List<WebElementDetails> achivementswebElementsList = JXMLParser.getInstance().getWebElements(Achivements.class.getSimpleName());
  String customMessage = null;

  @BeforeClass
  public void setup() {
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
  }

  // ==================================================================================

  // Menu Navigation
  @Given("^user is on Practice Bright IDEAS section$")
  public void user_is_on_Practice_Bright_IDEAS_section() throws Throwable {
    try {
      customMessage = "Clicking on PBI link";
      WebElementDetails pbiLinkWebElementObj = BIHomewebElementsList.get(1);
      if (!BIHome.practiceBrightIdeasLink(pbiLinkWebElementObj).isDisplayed()) {
        log.info("Please complete the learn bright ideas section");
      }
      BIHome.practiceBrightIdeasLink(pbiLinkWebElementObj).click();
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }
  }

  // ==================================================================================

  @And("^start a New Problem$")
  public void start_a_New_Problem() throws Throwable {
    try {
      customMessage = "Clicking on Start New Problem";
      WebElementDetails startNewPrbmWebElementObj = webElementsList.get(0);
      pbi.startNewPrblmBtn(startNewPrbmWebElementObj).click();
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }
  }

  // ==================================================================================

  // PBI Screen
  @Then("^choose different type of Problem \"([^\"]*)\"$")
  public void choose_different_type_of_Problem(int problemNo) throws Throwable {
    try {
      customMessage = "Clicking on different Problem";
      WebElementDetails firstPrbmWebElementObj = webElementsList.get(1);
      WebElementDetails secondPrbmWebElementObj = webElementsList.get(2);
      WebElementDetails thirdPrbmWebElementObj = webElementsList.get(3);
      WebElementDetails fourthPrbmWebElementObj = webElementsList.get(4);
      WebElementDetails fifthPrbmWebElementObj = webElementsList.get(5);
      WebElementDetails sixthPrbmWebElementObj = webElementsList.get(6);
      WebElementDetails seventhPrbmWebElementObj = webElementsList.get(7);
      WebElementDetails eighthPrbmWebElementObj = webElementsList.get(8);

      WebElement[] video = { pbi.problemBtn1(firstPrbmWebElementObj), pbi.problemBtn2(secondPrbmWebElementObj),
          pbi.problemBtn3(thirdPrbmWebElementObj), pbi.problemBtn4(fourthPrbmWebElementObj),
          pbi.problemBtn5(fifthPrbmWebElementObj), pbi.problemBtn6(sixthPrbmWebElementObj),
          pbi.problemBtn7(seventhPrbmWebElementObj), pbi.problemBtn8(eighthPrbmWebElementObj) };
      video[problemNo - 1].click();
      appsetup.driverwait(1500);

      customMessage = "Clicking on Sub Problem";
      WebElementDetails subPrbmWebElementObj = webElementsList.get(9);
      pbi.subproblemBtn(subPrbmWebElementObj).get(1).click();
      appsetup.driverwait(3000);
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }
  }

  // ==================================================================================

  @And("^describe WHAT is the problem with \"([^\"]*)\" rating$")
  public void describe_WHAT_is_the_problem_without_rating(int Starnumber) throws Throwable {
    try {
      appsetup.driverwait(2000);
      customMessage = "Enter Problem description";
      WebElementDetails descPrbmWebElementObj = webElementsList.get(10);
      pbi.problemTxtbox(descPrbmWebElementObj).sendKeys(descPrbmWebElementObj.getData());
      appsetup.driverwait(2000);

      customMessage = "Select a Star under Description Problem";
      WebElementDetails firstRatePrbmWebElementObj = webElementsList.get(11);
      WebElementDetails secondRatePrbmWebElementObj = webElementsList.get(12);
      WebElementDetails thirdRatePrbmWebElementObj = webElementsList.get(13);
      WebElementDetails fourthRatePrbmWebElementObj = webElementsList.get(14);
      WebElementDetails fifthRatePrbmWebElementObj = webElementsList.get(15);

      WebElement[] rating = { pbi.rating1Btn(firstRatePrbmWebElementObj),
          pbi.rating2Btn(secondRatePrbmWebElementObj), pbi.rating3Btn(thirdRatePrbmWebElementObj),
          pbi.rating4Btn(fourthRatePrbmWebElementObj), pbi.rating5Btn(fifthRatePrbmWebElementObj) };
      rating[Starnumber - 1].click();
      appsetup.driverwait(1000);

      customMessage = "Clicking on Next button";
      WebElementDetails nxtBtnWebElementObj = webElementsList.get(16);
      pbi.nextBtn(nxtBtnWebElementObj).click();

      problemNo = problemNo + 1;
      appsetup.driverwait(3000);
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }
  }

  // ==================================================================================

  @And("^different questions like Where, When, Who, Why, How fields$")
  public void different_questions_like_Where_When_Who_Why_How_fields() throws Throwable {
    try {
      customMessage = "Enter data to Where text box";
      WebElementDetails whereTxtWebElementObj = webElementsList.get(17);
      pbi.whereTxtbox(whereTxtWebElementObj).sendKeys(whereTxtWebElementObj.getData());

      customMessage = "Enter data to When text box";
      WebElementDetails whenTxtWebElementObj = webElementsList.get(18);
      pbi.whenTxtbox(whenTxtWebElementObj).sendKeys(whenTxtWebElementObj.getData());

      customMessage = "Enter data to Who text box";
      WebElementDetails whoTxtWebElementObj = webElementsList.get(19);
      pbi.whoTxtbox(whoTxtWebElementObj).sendKeys(whoTxtWebElementObj.getData());

      customMessage = "Enter data to Why text box";
      WebElementDetails whyTxtWebElementObj = webElementsList.get(20);
      pbi.whyTxtbox(whyTxtWebElementObj).sendKeys(whyTxtWebElementObj.getData());

      customMessage = "Enter data to How text box";
      WebElementDetails howTxtWebElementObj = webElementsList.get(21);
      pbi.howTxtbox(howTxtWebElementObj).sendKeys(howTxtWebElementObj.getData());

      customMessage = "Clicking on Next button";
      WebElementDetails secndNxtBtnWebElementObj = webElementsList.get(22);
      pbi.secondNextBtn(secndNxtBtnWebElementObj).click();
      appsetup.driverwait(3000);
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }
  }

  @Then("^verify achivement status of Basic Bulb and Power Switch are unlocked after (\\d+)st and (\\d+)th problem creation$")
  public void verify_achivement_status_of_is_unlocked_after_st_and_th_problem_creation(int arg1, int arg2)
      throws Throwable {
    try {
      if (problemNo == 1 || problemNo == 5) {
        customMessage = "Clicking on PBI button";
        WebElementDetails pbiLinkWebElementObj = BIHomewebElementsList.get(1);
        BIHome.practiceBrightIdeasLink(pbiLinkWebElementObj).click();
        log.info("Problem creation is sucessful");

        customMessage = "Clicking on Achievement button";
        WebElementDetails achievmentsWebElementObj = BIHomewebElementsList.get(2);
        BIHome.achivemetsLink(achievmentsWebElementObj).click();
        appsetup.driverwait(3000);

        customMessage = "Verifying the Problem Creation Achievments";
        WebElementDetails UnlockStatusListObj = achivementswebElementsList.get(0);
        boolean flag = false;

        if (problemNo == 1) {
          for (int i = 0; i < achievements.UnlockStatusList(UnlockStatusListObj).size(); i++) {
            String achievement = achievements.UnlockStatusList(UnlockStatusListObj).get(i)
                .findElement(By.cssSelector(".achievement-title")).getText();
            if (achievement.equalsIgnoreCase("Basic Bulb")) {
              flag = true;
              log.info("'Basic Bulb' Acheivement unlocked");
            }
          }
        } else {
          for (int i = 0; i < achievements.UnlockStatusList(UnlockStatusListObj).size(); i++) {
            String achievement = achievements.UnlockStatusList(UnlockStatusListObj).get(i)
                .findElement(By.cssSelector(".achievement-title")).getText();
            if (achievement.equalsIgnoreCase("Power Switch")) {
              flag = true;
              log.info("'Power Switch' Acheivement unlocked");
            }
          }
        }
        Assert.assertTrue("Failed to verify 'Power Switch' achivement unlock status  ", flag);
        customMessage = "Again navigating to PBI";
        BIHome.practiceBrightIdeasLink(pbiLinkWebElementObj).click();
        appsetup.driverwait(2000);

        customMessage = "Clicking on first problem Continue button";
        WebElementDetails contProbWebElementObj = webElementsList.get(23);
        /*
         * driver.findElements(By.cssSelector(
         * ".views-row.views-row-1.practice-bi-item")).get(0).
         * findElement(By.linkText("Continue")).click();
         */
        pbi.prblmContBtn(contProbWebElementObj).get(0).findElement(By.linkText("Continue")).click();
        appsetup.driverwait(5000);
      }
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }
  }

  // ==================================================================================

  @And("^define your Ideas$")
  public void define_your_Ideas() throws Throwable {
    try {
      customMessage = "Enter data into Options text field";
      WebElementDetails option1WebElementObj = webElementsList.get(24);
      WebElementDetails option2WebElementObj = webElementsList.get(25);
      WebElementDetails option3WebElementObj = webElementsList.get(26);
      WebElementDetails option4WebElementObj = webElementsList.get(27);
      WebElementDetails option5WebElementObj = webElementsList.get(28);
      WebElementDetails option6WebElementObj = webElementsList.get(29);
      WebElementDetails option7WebElementObj = webElementsList.get(30);
      WebElementDetails option8WebElementObj = webElementsList.get(31);
      WebElementDetails option9WebElementObj = webElementsList.get(32);
      WebElementDetails option10WebElementObj = webElementsList.get(33);
      WebElementDetails option11WebElementObj = webElementsList.get(34);
      WebElementDetails option12WebElementObj = webElementsList.get(35);
      WebElementDetails option13WebElementObj = webElementsList.get(36);
      WebElementDetails option14WebElementObj = webElementsList.get(37);
      WebElementDetails option15WebElementObj = webElementsList.get(38);
      WebElementDetails option16WebElementObj = webElementsList.get(39);
      WebElementDetails option17WebElementObj = webElementsList.get(40);
      WebElementDetails option18WebElementObj = webElementsList.get(41);
      WebElementDetails option19WebElementObj = webElementsList.get(42);
      WebElementDetails option20WebElementObj = webElementsList.get(43);

      String[] strs = { option1WebElementObj.getData(), option2WebElementObj.getData(),
          option3WebElementObj.getData(), option4WebElementObj.getData(), option5WebElementObj.getData(),
          option6WebElementObj.getData(), option7WebElementObj.getData(), option8WebElementObj.getData(),
          option9WebElementObj.getData(), option10WebElementObj.getData(), option11WebElementObj.getData(),
          option12WebElementObj.getData(), option13WebElementObj.getData(), option14WebElementObj.getData(),
          option15WebElementObj.getData(), option16WebElementObj.getData(), option17WebElementObj.getData(),
          option18WebElementObj.getData(), option19WebElementObj.getData(), option20WebElementObj.getData() };

      List<String> optionsdata = new ArrayList<>();
      for (int i = 0; i < 20; i++) {
        optionsdata.add(strs[i]);
      }

      WebElement[] ideasOptions = { pbi.option1Txtbox(option1WebElementObj),
          pbi.option2Txtbox(option2WebElementObj), pbi.option3Txtbox(option3WebElementObj),
          pbi.option4Txtbox(option4WebElementObj), pbi.option5Txtbox(option5WebElementObj),
          pbi.option6Txtbox(option6WebElementObj), pbi.option7Txtbox(option7WebElementObj),
          pbi.option8Txtbox(option8WebElementObj), pbi.option9Txtbox(option9WebElementObj),
          pbi.option10Txtbox(option10WebElementObj), pbi.option11Txtbox(option11WebElementObj),
          pbi.option12Txtbox(option12WebElementObj), pbi.option13Txtbox(option13WebElementObj),
          pbi.option14Txtbox(option14WebElementObj), pbi.option15Txtbox(option15WebElementObj),
          pbi.option16Txtbox(option16WebElementObj), pbi.option17Txtbox(option17WebElementObj),
          pbi.option18Txtbox(option18WebElementObj), pbi.option19Txtbox(option19WebElementObj),
          pbi.option20Txtbox(option20WebElementObj) };
      List<WebElement> ideasOption = new ArrayList<>(Arrays.asList(ideasOptions));
      for (int i = 0; i < optionsdata.size(); i++) {
        if (!optionsdata.get(i).equals("")) {
          if (!ideasOption.get(i).getText().isEmpty()) {
            log.info("idea options clear check");
            ideasOption.get(i).clear();
          }
          ideasOption.get(i).sendKeys(optionsdata.get(i));
        }
      }
      customMessage = "Clicking on third Next button";
      WebElementDetails thirdNxtWebElementObj = webElementsList.get(44);
      appsetup.driverwait(5000);
      ((JavascriptExecutor) driver).executeScript("scroll(0,150)");
      pbi.thirdNxtBtn(thirdNxtWebElementObj).click();
      appsetup.driverwait(5000);
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }
  }

  // ==================================================================================

  @And("^evaluate your Options$")
  public void evaluate_your_Options() throws Throwable {
    try {
      try {
        int j = 0, k = 0;

        customMessage = "Select and Enter the data into barriers";
        WebElementDetails barrier1WebElementObj = webElementsList.get(65);
        WebElementDetails barrier2WebElementObj = webElementsList.get(66);
        WebElementDetails barrier3WebElementObj = webElementsList.get(67);
        WebElementDetails barrier4WebElementObj = webElementsList.get(68);
        WebElementDetails barrier5WebElementObj = webElementsList.get(69);
        WebElementDetails barrier6WebElementObj = webElementsList.get(70);
        WebElementDetails barrier7WebElementObj = webElementsList.get(71);
        WebElementDetails barrier8WebElementObj = webElementsList.get(72);
        WebElementDetails barrier9WebElementObj = webElementsList.get(73);
        WebElementDetails barrier10WebElementObj = webElementsList.get(74);
        WebElementDetails barrier11WebElementObj = webElementsList.get(75);
        WebElementDetails barrier12WebElementObj = webElementsList.get(76);
        WebElementDetails barrier13WebElementObj = webElementsList.get(77);
        WebElementDetails barrier14WebElementObj = webElementsList.get(78);
        WebElementDetails barrier15WebElementObj = webElementsList.get(79);
        WebElementDetails barrier16WebElementObj = webElementsList.get(80);
        WebElementDetails barrier17WebElementObj = webElementsList.get(81);
        WebElementDetails barrier18WebElementObj = webElementsList.get(82);
        WebElementDetails barrier19WebElementObj = webElementsList.get(83);
        WebElementDetails barrier20WebElementObj = webElementsList.get(84);

        String[] strs = { barrier1WebElementObj.getData(), barrier2WebElementObj.getData(),
            barrier3WebElementObj.getData(), barrier4WebElementObj.getData(),
            barrier5WebElementObj.getData(), barrier6WebElementObj.getData(),
            barrier7WebElementObj.getData(), barrier8WebElementObj.getData(),
            barrier9WebElementObj.getData(), barrier10WebElementObj.getData(),
            barrier11WebElementObj.getData(), barrier12WebElementObj.getData(),
            barrier13WebElementObj.getData(), barrier14WebElementObj.getData(),
            barrier15WebElementObj.getData(), barrier16WebElementObj.getData(),
            barrier17WebElementObj.getData(), barrier18WebElementObj.getData(),
            barrier19WebElementObj.getData(), barrier20WebElementObj.getData() };
        List<String> optionsdata = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
          optionsdata.add(strs[i]);
          if (!strs[i].equals("") && j == 0) {
            k = i + 1;
            j = 1;
          }
        }

        WebElementDetails[] bestOptions = { barrier1WebElementObj, barrier2WebElementObj, barrier3WebElementObj,
            barrier4WebElementObj, barrier5WebElementObj, barrier6WebElementObj, barrier7WebElementObj,
            barrier8WebElementObj, barrier9WebElementObj, barrier10WebElementObj, barrier11WebElementObj,
            barrier12WebElementObj, barrier13WebElementObj, barrier14WebElementObj, barrier15WebElementObj,
            barrier16WebElementObj, barrier17WebElementObj, barrier18WebElementObj, barrier19WebElementObj,
            barrier20WebElementObj };
        pbi.barrier11Txtbox(bestOptions[k - 1]).click();

      } catch (Exception e) {
      }

      customMessage = "Clicking on Evaluate next button";
      WebElementDetails evaluNxtWebElementObj = webElementsList.get(85);
      pbi.evaluateNxtBtn(evaluNxtWebElementObj).click();
      appsetup.driverwait(5000);
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }
  }

  // ==================================================================================

  @And("^enter what to do and select \"([^\"]*)\" rating button$")
  public void enter_what_to_do_and_select_rating_button(String rating) throws Throwable {
    try {
      customMessage = "Enter data into What text field";
      WebElementDetails whatTxtWebElementObj = webElementsList.get(86);
      pbi.whatToDoTxt(whatTxtWebElementObj).sendKeys(whatTxtWebElementObj.getData());

      customMessage = "Clicking on Act button";
      WebElementDetails actBtnWebElementObj = webElementsList.get(87);
      pbi.actBtn(actBtnWebElementObj).click();

      customMessage = "Select a rating";
      WebElementDetails lastRating1BtnWebElementObj = webElementsList.get(88);
      WebElementDetails lastRating2BtnWebElementObj = webElementsList.get(89);
      WebElementDetails lastRating3BtnWebElementObj = webElementsList.get(90);
      WebElementDetails lastRating4BtnWebElementObj = webElementsList.get(91);
      WebElementDetails lastRating5BtnWebElementObj = webElementsList.get(92);

      switch (rating) {
      case "1":
        pbi.lastrating1Btn(lastRating1BtnWebElementObj).click();
        break;
      case "2":
        pbi.lastrating2Btn(lastRating2BtnWebElementObj).click();
        break;
      case "3":
        pbi.lastrating3Btn(lastRating3BtnWebElementObj).click();
        break;
      case "4":
        pbi.lastrating4Btn(lastRating4BtnWebElementObj).click();
        break;
      case "5":
        pbi.lastrating5Btn(lastRating5BtnWebElementObj).click();
        break;
      default:
        log.info("Incorrect final rating number given in string");
        break;
      }

      customMessage = "Clicking on submit button";
      WebElementDetails submitWebElementObj = webElementsList.get(93);
      pbi.submitBtn(submitWebElementObj).click();
      appsetup.driverwait(3000);
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }
  }

  // ==================================================================================

  @Then("^describe WHAT is the problem without rating$")
  public void describe_what_is_the_problem_without_rating() throws Throwable {
    try {
      customMessage = "Enter Describe the problem";
      WebElementDetails descPrbmWebElementObj = webElementsList.get(10);
      pbi.problemTxtbox(descPrbmWebElementObj).sendKeys(descPrbmWebElementObj.getData());
      appsetup.driverwait(2000);

      customMessage = "Without rating clicking on next button";
      WebElementDetails nxtBtnWebElementObj = webElementsList.get(16);
      pbi.nextBtn(nxtBtnWebElementObj).click();

      appsetup.driverwait(2000);
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }
  }

  // ==================================================================================

  @Then("^verify the error message and continue problem with \"([^\"]*)\" rating$")
  public void verify_the_error_message_and_continue_the_problem_with_rating(int Starnumber) throws Throwable {
    try {
      customMessage = "Assertion for the error message";
      WebElementDetails errMsgWebElementObj = webElementsList.get(94);
      Assert.assertTrue("Failed to verify error message for problem creation",pbi.errorMsgTxt(errMsgWebElementObj).getText()
          .equals("Please rate,How confident are you that you can solve the problem"));

      customMessage = "Clicking on Rating";
      WebElementDetails firstRatePrbmWebElementObj = webElementsList.get(11);
      WebElementDetails secondRatePrbmWebElementObj = webElementsList.get(12);
      WebElementDetails thirdRatePrbmWebElementObj = webElementsList.get(13);
      WebElementDetails fourthRatePrbmWebElementObj = webElementsList.get(14);
      WebElementDetails fifthRatePrbmWebElementObj = webElementsList.get(15);

      WebElement[] rating = { pbi.rating1Btn(firstRatePrbmWebElementObj),
          pbi.rating2Btn(secondRatePrbmWebElementObj), pbi.rating3Btn(thirdRatePrbmWebElementObj),
          pbi.rating4Btn(fourthRatePrbmWebElementObj), pbi.rating5Btn(fifthRatePrbmWebElementObj) };
      rating[Starnumber - 1].click();
      appsetup.driverwait(1000);

      customMessage = "Clicking on next button";
      WebElementDetails nxtBtnWebElementObj = webElementsList.get(16);
      pbi.nextBtn(nxtBtnWebElementObj).click();
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }
  }

  // ==================================================================================

  @Then("^continue the problem without enter any option$")
  public void continue_the_problem_with_out_enter_any_option() throws Throwable {
	  try {
		  customMessage = "Clicking on third Next button";
    WebElementDetails thirdNxtWebElementObj = webElementsList.get(44);
    pbi.thirdNxtBtn(thirdNxtWebElementObj).click();
	  } catch (Exception e) {
	      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
	    } catch (java.lang.AssertionError e) {
	      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
	    }
  }

  // ==================================================================================

  @Then("^verify the error message and continue the problem$")
  public void verify_the_error_message_and_continue_the_problem() throws Throwable {
    try {
      customMessage = "Assertion error for star";
      WebElementDetails errMsgWebElementObj = webElementsList.get(94);
      Assert.assertTrue("Failed to verify error message for problem creation",pbi.errorMsgTxt(errMsgWebElementObj).getText().equals("* Please list at least one option, but three is better."));
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }
  }

  // ==================================================================================

  @Then("^continue the problem without Select any barrier option$")
  public void continue_the_problem_with_out_Select_any_barrier_option() throws Throwable {
    try {
      customMessage = "Without selection any barrier option";
      WebElementDetails evaluNxtWebElementObj = webElementsList.get(85);
      pbi.evaluateNxtBtn(evaluNxtWebElementObj).click();
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }
  }

  // ==================================================================================

  @Then("^verify the barrier error message and continue the problem$")
  public void verify_the_barrir_error_message_and_continue_the_problem() throws Throwable {
    try {
      customMessage = "Assertion for Best Option";
      WebElementDetails errMsgWebElementObj = webElementsList.get(94);
      Assert.assertTrue("Failed to verify error message for problem creation",pbi.errorMsgTxt(errMsgWebElementObj).getText().equals("Please select Best option from above"));
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }
  }

  // ==================================================================================

  @Then("^continue the problem without enter any data into Act$")
  public void continue_the_problem_with_out_enter_any_data_Action_field() throws Throwable {
    try {
      customMessage = "Clicking on Act button, without enter an data into Act field";
      WebElementDetails actBtnWebElementObj = webElementsList.get(87);
      pbi.actBtn(actBtnWebElementObj).click();
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }
  }

  // ==================================================================================

  @Then("^verify the Act error message and continue problem with act data$")
  public void verify_the_Act_error_message_and_continue_the_problem() throws Throwable {
    try {
      customMessage = "Assertion for WHAT text";
      WebElementDetails errMsgWebElementObj = webElementsList.get(94);
      Assert.assertTrue("Failed to verify error message for problem creation",pbi.errorMsgTxt(errMsgWebElementObj).getText().equals("Please enter what are you going to do"));

      customMessage = "Enter data into WHAT Text field";
      WebElementDetails whatTxtWebElementObj = webElementsList.get(86);
      pbi.whatToDoTxt(whatTxtWebElementObj).sendKeys(whatTxtWebElementObj.getData());

      customMessage = "Clicking on Act button";
      WebElementDetails actBtnWebElementObj = webElementsList.get(87);
      pbi.actBtn(actBtnWebElementObj).click();
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }
  }

  // ==================================================================================

  @And("^complete the problem without rating$")
  public void finish_the_problem_with_out_rating() throws Throwable {
    try {
      customMessage = "Without rating, clicking on submit button";
      WebElementDetails submitWebElementObj = webElementsList.get(93);
      pbi.submitBtn(submitWebElementObj).click();
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }
  }

  @Then("^verify achivement status of Positively Glowing and Brighter than the Sun are unlocked after (\\d+)st and (\\d+)th problem finish$")
  public void verify_achivement_status_of_Positively_Glowing_and_Brighter_than_the_Sun_are_unlocked_after_st_and_th_problem_finish(
      int arg1, int arg2) throws Throwable {
    try {
      appsetup.driverwait(3000);
      customMessage = "Verfying unlocked achievment status for finished problem";
      if (problemNo == 1 || problemNo == 5) {
        WebElementDetails achievmentsWebElementObj = BIHomewebElementsList.get(2);
        BIHome.achivemetsLink(achievmentsWebElementObj).click();
        appsetup.driverwait(3000);
        WebElementDetails UnlockStatusListObj = achivementswebElementsList.get(0);

        boolean flag = false;
        if (problemNo == 1) {
          for (int i = 0; i < achievements.UnlockStatusList(UnlockStatusListObj).size(); i++) {
            String achievement = achievements.UnlockStatusList(UnlockStatusListObj).get(i)
                .findElement(By.cssSelector(".achievement-title")).getText();
            // log.info(achievement);
            if (achievement.equalsIgnoreCase("Positively Glowing")) {
              flag = true;
              log.info("'Positively Glowing' Acheivement unlocked");
            }
          }
        } else {
          for (int i = 0; i < achievements.UnlockStatusList(UnlockStatusListObj).size(); i++) {
            String achievement = achievements.UnlockStatusList(UnlockStatusListObj).get(i)
                .findElement(By.cssSelector(".achievement-title")).getText();
            // log.info(achievement);
            if (achievement.equalsIgnoreCase("Brighter than the Sun")) {
              flag = true;
              log.info("'Brighter than the Sun' Acheivement unlocked");
            }
          }
        }
        Assert.assertTrue("Failed to verify 'Brighter than the Sun' achivement unlock status ", flag);
      }
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }
  }

  // ==================================================================================

  @Then("^verfiy the error message and complete the problem with \"([^\"]*)\" rating$")
  public void verfiy_the_error_message_and_finish_the_problem_with_rating(String rating) throws Throwable {
    try {
      customMessage = "Verifying the completion problem";
      WebElementDetails errMsgWebElementObj = webElementsList.get(94);
      try {
        Assert.assertTrue("Failed to verify error message for problem creation",pbi.errorMsgTxt(errMsgWebElementObj).getText().equals("Please rank your solution and click on Next"));
      } catch (NoSuchElementException e) {
      }
      WebElementDetails lastRating1BtnWebElementObj = webElementsList.get(88);
      WebElementDetails lastRating2BtnWebElementObj = webElementsList.get(89);
      WebElementDetails lastRating3BtnWebElementObj = webElementsList.get(90);
      WebElementDetails lastRating4BtnWebElementObj = webElementsList.get(91);
      WebElementDetails lastRating5BtnWebElementObj = webElementsList.get(92);

      switch (rating) {
      case "1":
        pbi.lastrating1Btn(lastRating1BtnWebElementObj).click();
        break;
      case "2":
        pbi.lastrating2Btn(lastRating2BtnWebElementObj).click();
        break;
      case "3":
        pbi.lastrating3Btn(lastRating3BtnWebElementObj).click();
        break;
      case "4":
        pbi.lastrating4Btn(lastRating4BtnWebElementObj).click();
        break;
      case "5":
        pbi.lastrating5Btn(lastRating5BtnWebElementObj).click();
        break;
      default:
        log.info("Incorrect final rating number given in string");
        break;
      }
      customMessage = "Clicking on submit buttom";
      WebElementDetails submitWebElementObj = webElementsList.get(93);
      pbi.submitBtn(submitWebElementObj).click();
      appsetup.driverwait(3000);
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }
  }

  @And("^copy the selected problem$")
  public void copy_the_selected_problem() throws Throwable {
    try {
      customMessage = "Copying and Continue the problem";
      WebElementDetails finishedProbWebElementObj = webElementsList.get(95);
      if (pbi.finishPrblm(finishedProbWebElementObj).size() == 1) {
        pbi.finishPrblm(finishedProbWebElementObj).get(0).findElement(By.linkText("Copy")).click();
      } else {
        pbi.finishPrblm(finishedProbWebElementObj).get(1).findElement(By.linkText("Copy")).click();
      }
      appsetup.driverwait(2000);
      pbi.finishPrblm(finishedProbWebElementObj).get(0).findElement(By.linkText("Continue")).click();
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }
  }

  @And("^view the selected problem$")
  public void view_the_selected_problem() throws Throwable {
    try {
      customMessage = "View the selected problem";
      WebElementDetails finishedProbWebElementObj = webElementsList.get(95);
      if (pbi.finishPrblm(finishedProbWebElementObj).size() == 1) {
        pbi.finishPrblm(finishedProbWebElementObj).get(0).findElement(By.linkText("View")).click();
      } else {
        pbi.finishPrblm(finishedProbWebElementObj).get(1).findElement(By.linkText("View")).click();
      }
    } catch (Exception e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    } catch (java.lang.AssertionError e) {
      new TestAmigoException().handleException(e, customMessage, AppSetup.getMethodName());
    }
  }
}