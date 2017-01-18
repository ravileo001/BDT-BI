Feature: Messages

  
  As a participant 
  I want access Message section 
  so that I can send messages to the Consellor

 
  @ORPHAN @Deletemessages @Messages:deletemsg
  Scenario: Delete sent messages

    Given user is on Message Section
    Then Select the message and delete the message
    Then validate the message status


  @BDT-30 @BDT-43 @assignee:chandu.aleti @OPEN @Messages
  Scenario: Send messages to the Consellor

    Given user is on Contact My Trainer
    Then send a message with subject "" and message ""
    Then verify the message status

