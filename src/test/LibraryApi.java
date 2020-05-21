package test;

import static io.restassured.RestAssured.given;

import files.PayLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class LibraryApi {

	public static void main(String[] args) {

		String response = RestAssured.baseURI = "http://216.10.245.166";
		given().log().all().header("Content-Type", "application/json").body(PayLoad.addBook()).when()
				.post("/Library/Addbook.php").then().log().all().assertThat().statusCode(200).extract().response()
				.asString();
		JsonPath js = new JsonPath(response);
		String id = js.get("ID");
		System.out.println(id);

	}

}
