# Scenario: TEST CASE 2
#------------------------------------------
#  1)	Visit http://www.musala.com/
#  2)	Click ‘Company’ tap from the top
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

  Scenario: TEST CASE 2
    When Click Company tap from the top
    # Then Fill all required fields except email
    # Then Under email field enter string with wrong "<wrongEmail>" format
    # When Click Send button
    # Then Verify that error message 'The e-mail address entered is invalid.' appears

    # Examples:
      # | pageAnchor | wrongEmail    |
      # | ContactUs  | badEmailOne   |
      # | ContactUs  | badEmailOne   |
      # | ContactUs  | badEmailOne   |
      # | ContactUs  | badEmailOne   |
      # | ContactUs  | badEmailOne   |
      # | ContactUs  | badEmailTwo   |
      # | ContactUs  | badEmailThree |
      # | ContactUs  | badEmailFour  |
      # | ContactUs  | badEmailFive  |