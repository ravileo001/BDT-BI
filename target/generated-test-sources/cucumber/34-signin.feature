Feature: SignIn

  
  As a Participant 
  I want Login to Bright Ideas application  
  so that can perform necessary actions

 
  @ORPHAN @Signin:Login_BI @execute
  Scenario: Login to Bright IDEAS application as a participant

    Given user is redirected to Bright Ideas Login page
    And enter valid credentials and click on Login button
    Then verify BrightIDEAS Home page title

