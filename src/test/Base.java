package test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.PayLoad;

import static io.restassured.RestAssured.*;

public class Base {
//Addplace
	public static void main(String[] args) {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String Response =given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(PayLoad.add())
				.when().post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
				.header("Server", "Apache/2.4.18 (Ubuntu)").extract().asString();
		System.out.println(Response);
		JsonPath js = new JsonPath(Response);
		String placeholder = js.get("place_id");
		System.out.println(placeholder);
		
		//Update place
		String Newaddress="70 winter walk, USA";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body("{\r\n" + 
				"\"place_id\":\""+placeholder+"\",\r\n" + 
				"\"address\":\""+Newaddress+"\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}").when().put("/maps/api/place/update/json").then().log().all().assertThat().statusCode(200).
		body("msg", equalTo("Address successfully updated"));
		
		//GetPlace
		String GetPlace=given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeholder).when()
				.get("/maps/api/place/get/json").
		then().log().all().assertThat().statusCode(200).extract().response().asString();
		JsonPath js1 = new JsonPath(GetPlace);
		String ActualAddress= js1.get("address");
		System.out.println(ActualAddress);
		Assert.assertEquals(Newaddress, ActualAddress);
		
	}

}
