Feature: Search Wikipedia

  Scenario: Look up API on Wikipedia
    Given I am on Wikipedia
    And The default language is "English"
    When I search for "API"
    Then Relevant content is displayed
    And There is languages section displayed
    When I select "French"
    Then Search results are displayed in the chosen language
    And I see an option to view results in "English"
