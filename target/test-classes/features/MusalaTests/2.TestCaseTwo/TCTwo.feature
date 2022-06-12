# Scenario: TEST CASE 2
#------------------------------------------
#  1)	Visit http://www.musala.com/
#  2)	Click ‘Company’ tab from the top
#  3)	Verify that the correct URL (http://www.musala.com/company/) loads
#  4)	Verify that there is ‘Leadership’ section
#  5)	Click the Facebook link from the footer
#  6)	Verify that the correct URL (https://www.facebook.com/MusalaSoft?fref=ts)
#  loads and verify if the Musala Soft profile picture appears on the new page
#------------------------------------------
#  Given: Visit http://www.musala.com/
#------------------------------------------
#1. Preconditions
#2. Visit http://www.musala.com/
#------------------------------------------

Feature: TEST CASE 2

  Background:
    Given The user is at baseUrl

  Scenario Outline: TEST CASE 2
    When Click Company tab from the top
    Then Verify that the correct URL loads
    And Verify that there is "<section>" section
    Then Click the Facebook link from the footer
    Then Verify that the correct URL and profile picture loads

    Examples:
      | section    |
      | Leadership |