@smoke
Feature: Login
  As I user, I should be able to login

  Background:
    Given the user on the login page

  @ui
  Scenario: Login as a librarian
    When the user logged in as "librarian"
    Then "dashboard" should be displayed

  @ui
  Scenario: Login as a student
    When the user logged in as "student"
    Then "books" should be displayed