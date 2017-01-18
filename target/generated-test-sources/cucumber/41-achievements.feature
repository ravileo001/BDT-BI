Feature: Achievements

 
  @BDT-59 @assignee:admin @version:Version_BDT_1.0 @OPEN
  Scenario: View Achievments

    Given user navigate to Achievments section
    Then user can view the list of achievments
    And verify achivement status is unlocked

