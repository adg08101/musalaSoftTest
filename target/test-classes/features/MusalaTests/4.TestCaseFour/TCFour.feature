# Scenario: TEST CASE 4
#------------------------------------------
# 1)	Visit http://www.musala.com/
# 2)	Go to Careers
# 3)	Click ‘Check our open positions’ button
# 4)	Filter the available positions by available cities in the dropdown ‘Select location’ (Sofia and Skopje)
# 5)	Get the open positions by city
# 6)	Print in the console the list with available positions by city in the following format:
# Example:
# Sofia
# Position: Database Administrator
# More info: http://www.musala.com/job/database-administrator/
# Position: OS and Application Administrator
# More info: http://www.musala.com/job/os-and-application-administrator/
# Position: ………………
# More info: ………………
#------------------------------------------
#  Given: Visit http://www.musala.com/
#------------------------------------------
#1. Preconditions
#2. Visit http://www.musala.com/
#------------------------------------------

Feature: TEST CASE 4

  Background:
    Given The user is at baseUrl

  Scenario Outline: TEST CASE 4
    When Click Careers tab from the top
    Then Click Check our open positions button
    And Verify that Join Us page is opened
    Then From the dropdown Select location select "<location>"
    And Get the open positions by "<location>"
    Then From the dropdown Select location select "<locationTwo>"
    And Get the open positions by "<locationTwo>"
    Then Print in the console the list with available positions

    Examples:
      | location | locationTwo |
      | Sofia    | Skopje      |