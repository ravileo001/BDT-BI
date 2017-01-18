Feature: LearnBrightIDEAS

  
  As a participant
  I want access Learn Bright IDEAS section 
  so that can play Practice Activities and Sessions


  Background:
    Given user navigate to LEARN BRIGHT IDEAS section

 
  @BDT-54 @assignee:admin @version:Version_BDT_1.0 @OPEN @LearnBrightIdeas:play_video
  Scenario Outline: Play videos

    
    Then click on video <VideoNumber>
    And verify achivement status is unlocked for 7th video
    Examples:
      | VideoNumber |
      | 7           |


  @BDT-54 @assignee:admin @version:Version_BDT_1.0 @OPEN @LearnBrightIdeas:play_session
  Scenario Outline: View Practice Sessions

    Then click on session <SessionNumber>
    And verify achivement status is unlocked for  2nd and 4th Sessions
    Examples:
      | SessionNumber |
      | 1             |

