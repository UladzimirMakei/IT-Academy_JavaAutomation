Feature: As a user, I want to get ability to see the drop-down menu of the "Автобарахолка" section with its content
  when I hover over its link on the "Onliner" main page

  @smoke
  Scenario Outline: Drop-down menu should have <specific> data
    Given the user opens Onliner website
    When the user hovers over "Автобарахолка" section
    Then "Автобарахолка" drop-down menu is displayed
    And "Автобарахолка" drop-down menu contains '<specific>' data
    Examples:
      |specific|
      |Авто до 4000 р.|
      |Минск|
      |Audi|


