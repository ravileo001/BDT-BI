Feature: Settings

  
  As a participant 
  I want access Settings section 
  so that can update profile details


  Background:
    Given user clicks on Account Settings menu link

 
  @BDT-148 @BDT-151 @assignee:admin @version:Version_BDT_1.0 @OPEN @Settings:change_language
  Scenario: Change Language

    Then Choose the Language "spanish"
    Then click on save button
    Then Verify the status message


  @ORPHAN @Settings:change_password_invalid_case @changePasswordInvalidCase @execute
  Scenario: Validate and Verify Change Password section

    Then Enter Invalid Credentials in current,new and confirm password fields
    Then click on save button
    Then Verify the error message


  @ORPHAN @Settings:change_emailid @changeEmailId
  Scenario: Update Email-ID details

    Then Enter Valid Data in current password and Email fields
    Then click on save button
    Then Verify the status message


  @ORPHAN @Settings:change_password
  Scenario: Update Password details

    Then Enter Valid Credentials in current,new and confirm password fields
    Then click on save button
    Then Verify the status message


  @BDT-31 @OPEN @Settings:change_emailid_invalid_case
  Scenario: Validate and Verify Change EmailId section

    Then Enter Invalid Data in current password and Email fields
    Then click on save button
    Then Verify the email error message

