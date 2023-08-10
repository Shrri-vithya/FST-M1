package Activities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class Activity3 {
    // Declare request specification
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;

    @BeforeClass
    public void setUp() {
        // Create request specification
        requestSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://petstore.swagger.io/v2/pet")
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType("application/json")
                .expectBody("status", equalTo("alive"))
                .build();
    }
    @DataProvider
    public Object[][] petInfoProvider() {
        // Setting parameters to pass to test case
        Object[][] testData = new Object[][] {
                { 1236, "Tiger", "alive" },
                { 1237, "Mekla", "alive" }
        };
        return testData;
    }

    @Test(priority=1)
    public void AddNewPet() {
        String reqBody ="{\"id\": 1236, \"name\": \"Tiger\", \"status\": \"alive\"}";
        Response response = given().spec(requestSpec).body(reqBody).when().post();

         reqBody ="{\"id\": 1237, \"name\": \"Mekla\", \"status\": \"alive\"}";
        response = given().spec(requestSpec).body(reqBody).when().post();
        response.then().spec(responseSpec);
    }

    @Test(dataProvider = "petInfoProvider",priority = 2)
    public void getPets(int id, String name, String status) {
        Response response = given().spec(requestSpec) // Use requestSpec
                .pathParam("petId", id) // Add path parameter
                .when().get("/{petId}"); // Send GET request

        System.out.println(response.asPrettyString());
        response.then() .spec(responseSpec).body("name", equalTo(name));
    }

    @Test(dataProvider = "petInfoProvider", priority=3)
    public void deletePets(int id, String name, String status) {
        Response response = given().spec(requestSpec) // Use requestSpec
                .pathParam("petId", id) // Add path parameter
                .when().delete("/{petId}"); // Send GET request
        response.then().body("code", equalTo(200));
    }


}
