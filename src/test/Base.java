package test;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;

import files.PayLoad;

import static io.restassured.RestAssured.*;

public class Base {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String Response =given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(PayLoad.add())
				.when().post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
				.header("Server", "Apache/2.4.18 (Ubuntu)").extract().asString();
		
	}

}
