package com.cydeo.step_defs;

import com.cydeo.utility.ConfigReader;
import com.cydeo.utility.LibraryAPI_Util;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class APIStepDefs {
    RequestSpecification givenPart;
    Response response;
    ValidatableResponse thenPart;

    public static String actualAPINumber;


    @Given("the base_uri and base_path set")
    public void the_base_uri_and_base_path_set() {
        baseURI= ConfigReader.read("library.baseUri");

        givenPart=given().log().uri();

    }
    @Given("I logged in as {string}")
    public void i_logged_in_as(String user) {
        givenPart.header("x-library-token", LibraryAPI_Util.getToken(user));
    }
    @Given("I create a random book")
    public void i_create_a_random_book() {
        givenPart.formParams(LibraryAPI_Util.getRandomBookMap());
    }
    @When("I send post request to {string} endpoint")
    public void i_send_post_request_to_endpoint(String endpoint) {
         response = givenPart.when().post(endpoint);

         thenPart= response.then();
    }
    @Then("I should get status code {int}")
    public void i_should_get_status_code(Integer expectedStatusCode) {
        thenPart.statusCode(expectedStatusCode);
    }
    @Then("the field value for {string} path should be equal to {string}")
    public void the_field_value_for_path_should_be_equal_to(String path, String expectedResult) {

        thenPart.body(path, is(expectedResult));

    }

    /**
     * Thre Point
     */
    @When("I send get request to {string} endpoint")
    public void i_send_get_request_to_endpoint(String endpoint) {
        response = givenPart.when().get(endpoint);

        thenPart= response.then();
    }
    @Then("I get the field value for  {string} path")
    public void i_get_the_field_value_for_path(String path) {
         actualAPINumber = response.jsonPath().getString(path.toLowerCase());
        System.out.println("actualAPINumber = " + actualAPINumber);
    }
}
