Feature: As a user, I want to get ability to use the drop-down menu of the "Дома и квартиры" section
  when I hover over its link on the "Onliner" main page

  @smoke
  Scenario Outline: Drop-down menu should have <specific> data
    Given the user opens Onliner website
    When the user hovers over "Дома и квартиры" section
    Then "Дома и квартиры" drop-down menu is displayed
    Then "Дома и квартиры" drop-down menu contains '<specific>' data
    Examples:
      |specific|
      |Минск|
      |1-комнатные|
      |До 30 000 $|