Feature: Verify the Homepage functionality
  @SmokeTest
  Scenario: Verify I am able to launch browser using Selenium

    Given User launch the Chrome browser

    When I enter the url "https://alphabetaops.com/"

    Then I should be able to access the homepage

