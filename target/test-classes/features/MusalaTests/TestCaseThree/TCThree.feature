# Scenario: TEST CASE 3
#------------------------------------------
# 1)	Visit http://www.musala.com/
# 2)	Navigate to Careers menu (from the top)
# 3)	Click ‘Check our open positions’ button
# 4)	Verify that  ‘Join Us’ page is opened (can verify that URL is correct:
# http://www.musala.com/careers/join-us/
# 5)	From the dropdown ‘Select location’ select ‘Anywhere’
# 6)	Choose open position by name (e.g. Experienced Automation QA Engineer)
# 7)	Verify that 4 main sections are shown: General Description, Requirements,
# Responsibilities, What we offer
# 8)	Verify that ‘Apply’ button is present at the bottom
# 9)	Click ‘Apply’ button
# 10)	Prepare a few sets of negative data (e.g. leave required field(s) empty,
# enter e-mail with invalid format etc)
# 11)	Upload a CV document, and click ‘Send’ button
# 12)	Verify shown error messages (e.g. The field is required,
# The e-mail address entered is invalid etc.)
#------------------------------------------
#  Given: Visit http://www.musala.com/
#------------------------------------------
#1. Preconditions
#2. Visit http://www.musala.com/
#------------------------------------------

Feature: TEST CASE 3

  Background:
    Given The user is at baseUrl

  Scenario Outline: TEST CASE 3
    When Click Careers tab from the top
    Then Click Check our open positions button
    And Verify that Join Us page is opened
    Then From the dropdown Select location select "<location>"
    And Choose open position by "<name>"
    Then Verify that main sections are shown
    And Verify that 'Apply' button is present
    Then Click 'Apply' button
    Then Prepare a few sets of negative data

    Examples:
      | location | name                   |
      | Anywhere | Automation QA Engineer |