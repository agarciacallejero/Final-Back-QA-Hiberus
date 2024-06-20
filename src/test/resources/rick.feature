# features/search_characters.feature

Feature: Search for Rick and Morty characters
  As a user
  I want to be able to search for Rick and Morty characters by name
  So that I can get detailed information about them, including their name, status, location, image, and the episodes they appear in

  Scenario: Successful search for a character by name
    When I make a GET request to the Rick and Morty API to search for a character by name "Rick Sanchez"
    Then the response should be successful
    And the character's name should be "Rick Sanchez"
    And the response should include character details such as status, location, image, and episodes


  Scenario: Successful search for a character by partial name
    Given I prepare a GET request to the Rick and Morty API to search for a character by name "Mort"
    When I make the GET request to the Rick and Morty API by using name
    Then the response should be successful
    And the response should include character suggestions with names similar to "Mort"



  Scenario: Successful retrieval of a character's details by id
    Given I prepare a GET request to the Rick and Morty API to get a character by id 1
    When I make the GET request to the Rick and Morty API by using id
    Then the response should be successful
    And the response should include the character's details such as name, status, species, gender, origin, location, image, and episodes
