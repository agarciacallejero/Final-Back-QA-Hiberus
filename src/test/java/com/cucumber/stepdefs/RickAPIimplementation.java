package com.cucumber.stepdefs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasKey;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class RickAPIimplementation {


    private RequestSpecification request;

    private Response response;




    //---------------------------------------------------------------
    @Before
    public void before() {
        RestAssured.baseURI = "https://rickandmortyapi.com/api";
    }


    @When("I make a GET request to the Rick and Morty API to search for a character by name {string}")
    public void iMakeAGETRequestToTheRickAndMortyAPIToSearchForACharacterByName(String name) {
        response = given().get("https://rickandmortyapi.com/api/character/?name=" + name);
    }

    @Then("the response should be successful")
    public void theResponseShouldBeSuccessful() {
        response.then().statusCode(200);
    }

    @Then("the character's name should be {string}")
    public void theCharacterSNameShouldBe(String expectedName) {
        response.then().body("results[0].name", equalTo(expectedName));
    }

    @Then("the response should include character details such as status, location, image, and episodes")
    public void theResponseShouldIncludeCharacterDetailsSuchAsStatusLocationImageAndEpisodes() {
        response.then().body("results[0]", hasKey("status"));
        response.then().body("results[0]", hasKey("location"));
        response.then().body("results[0]", hasKey("image"));
        response.then().body("results[0]", hasKey("episode"));
    }

//-----------------------------------------------------------------------------------------------------------
    @Given("I prepare a GET request to the Rick and Morty API to search for a character by name {string}")
    public void iPrepareAGETRequestToTheRickAndMortyAPIToSearchForACharacterByName(String name) {
        request = given().param("name", name);
    }

    @When("I make the GET request to the Rick and Morty API by using name")
    public void iMakeTheGETRequestToTheRickAndMortyAPIbyName() {
        response = request.when().get("https://rickandmortyapi.com/api/character");
    }



    @Then("the response should include character suggestions with names similar to {string}")
    public void theResponseShouldIncludeCharacterSuggestionsWithNamesSimilarTo(String partialName) {
        response.then().body("results.name", hasItems(containsString(partialName)));
    }


    @Given("I prepare a GET request to the Rick and Morty API to get a character by id {int}")
    public void iPrepareAGETRequestToTheRickAndMortyAPIToGetACharacterById(int id) {
        request = given().pathParam("id", id);
    }

    @When("I make the GET request to the Rick and Morty API by using id")
    public void iMakeTheGETRequestToTheRickAndMortyAPIbyID() {
        response = request.when().get("https://rickandmortyapi.com/api/character/{id}");
    }



    @Then("the response should include the character's details such as name, status, species, gender, origin, location, image, and episodes")
    public void theResponseShouldIncludeTheCharacterSDetailsSuchAsNameStatusSpeciesGenderOriginLocationImageAndEpisodes() {
        response.then().body("", hasKey("name"));
        response.then().body("", hasKey("status"));
        response.then().body("", hasKey("species"));
        response.then().body("", hasKey("gender"));
        response.then().body("", hasKey("origin"));
        response.then().body("", hasKey("location"));
        response.then().body("", hasKey("image"));
        response.then().body("", hasKey("episode"));
    }



}



















