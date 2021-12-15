@smoke
Feature: Smoke test

  Scenario Outline: user can login api with valid credentials
    Given the base_uri and base_path set
    And get token  with "<username>" "<password>"
    When I send get request to "/get_book_categories" endpoint
    Then I should get status code 200
    Then the field value for "name[2]" path should be equal to "Classic"
    Then the field size for "name" path should be equal to 20

    Examples:
      | username          | password  |
      | student16@library | Sdet2022* |
      | student34@library | Sdet2022* |


    # HOMEWORK
    # Get categories from DB and verify against UI/API