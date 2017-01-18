Feature: PracticeBrightIDEAS

  
  As a participant 
  I want access Practice Bright IDEAS section 
  so that can create problems


  Background:
    Given user is on Practice Bright IDEAS section

 
  @ORPHAN @PracticeBrightIdeas:validate_create_problem
  Scenario Outline: Validate & verify a new problem

    And start a New Problem
    Then choose different type of Problem "<Problem>"
    And describe WHAT is the problem without rating
    Then verify the error message and continue problem with "<Star>" rating
    And different questions like Where, When, Who, Why, How fields
    And continue the problem without enter any option
    Then verify the error message and continue the problem
    And define your Ideas
    And continue the problem without Select any barrier option
    Then verify the barrier error message and continue the problem
    And evaluate your Options
    And continue the problem without enter any data into Act
    Then verify the Act error message and continue problem with act data
    And complete the problem without rating
    Then verfiy the error message and complete the problem with "<HowItWorkedRating>" rating
    Examples:
      | Problem | Star | HowItWorkedRating |
      | 3       | 3    | 5                 |


  @ORPHAN @PracticeBrightIdeas:create_finish_problem @execute
  Scenario Outline: Create and finish a problem

    And start a New Problem
    Then choose different type of Problem "<Problem>"
    And describe WHAT is the problem with "<Star>" rating
    And different questions like Where, When, Who, Why, How fields
    Then verify achivement status of Basic Bulb and Power Switch are unlocked after 1st and 5th problem creation
    And define your Ideas
    And evaluate your Options
    #enter barrier data corresponding idea fields only
    And enter what to do and select "<HowItWorkedRating>" rating button
    Then verify achivement status of Positively Glowing and Brighter than the Sun are unlocked after 1st and 5th problem finish
    Examples:
      | Problem | Star | HowItWorkedRating |
      | 3       | 2    | 5                 |


  @ORPHAN
  Scenario Outline: Copy and finish an existing problem

    And copy the selected problem
        And define your Ideas
        And evaluate your Options
        #enter barrier data corresponding idea fields only
        And enter what to do and select "<HowItWorkedRating>" rating button
    
        Examples: 
          | HowItWorkedRating |
          |                 5 |


  @ORPHAN
  Scenario: View a finished problem

    And view the selected problem

