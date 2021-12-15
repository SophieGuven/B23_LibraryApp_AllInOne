@smoke
Feature: Dashboard Page
  Background:
    Given the user on the login page

  @db @ui
  Scenario Outline: Verfiy amount of <module> numbers with UI
    Given the user logged in as "librarian"
    When user gets number of  "<module>"
    Then the information should be same with database  "<module>"

    Examples:
      | module         |
      | Users          |
      | Books          |
      | Borrowed Books |



  @db @ui
  Scenario: Verfiy amount of users numbers with three layers
    Given the user logged in as "librarian"
    When user gets number of  "Users"
    And the base_uri and base_path set
    And I logged in as "librarian"
    And I send get request to "/dashboard_stats" endpoint
    Then I get the field value for  "Users" path
    Then the informations should be same with database  "Users"
