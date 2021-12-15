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

