Feature: Sign-Out

  
  As a participant 
  I want click on LogOut 
  so that i can get back from the application

 
  @ORPHAN @Sign-out:BI @signout
  Scenario: Perform SignOut

    And click on Logout button
    Then verify Login page title

