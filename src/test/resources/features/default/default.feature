#Author: adavila86@gmail.com
#Keywords Summary : MUSALA SOFT TESTS
#Feature: SAMPLE FEATURE TEST CASE 1
#Scenario: TEST CASE 1
#------------------------------------------
#1	Visit http://www.musala.com/
#2	Scroll down and go to ‘Contact Us’
#3  Fill all required fields except email
#4  Under email field enter string with wrong email format (e.g. test@test)
#5  Click ‘Send’ button
#6  Verify that error message ‘The e-mail address entered is invalid.’ appears
#------------------------------------------
#  Given: Visit http://www.musala.com/
#------------------------------------------
#1. Preconditions
#2. Visit http://www.musala.com/
#------------------------------------------

Feature: TEST CASE 1

  Background:
    Given The user is at baseUrl

  Scenario Outline: Main Default Scenario
    Given The user scrolls down to "<pageAnchor>"
    Then Fill all required fields except email
    Then Under email field enter string with wrong email format
    When Click Send button
    Then Verify that error message 'The e-mail address entered is invalid.' appears

    Examples:
      | pageAnchor |
      | ContactUs  |
