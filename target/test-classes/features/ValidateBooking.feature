Feature: Booking functionality

  Scenario: Validate booking price filter works
    Given user is on the booking site home page
    When user searches for "Goa"
    And user selects check-in "2026-03-10" and check-out "2026-03-12"
    And user applies price filter "1000" to "3000"
    Then results should display only items within "1000" to "3000"