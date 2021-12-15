@smoke
Feature: Add book on api

  Scenario: Add book as a librarian on api

    Given the base_uri and base_path set
    And I logged in as "librarian"
    And I create a random book
    When I send post request to "/add_book" endpoint
    Then I should get status code 200
    Then the field value for "message" path should be equal to "The book has been created."