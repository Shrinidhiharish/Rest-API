package test;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.PayLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class LibraryApi {

	public static void main(String[] args) throws IOException {
//@Test(dataProvider="addbookdata")
//public void AddBook(String isbn, String aisle ) throws IOException
//{
		String response = RestAssured.baseURI = "http://216.10.245.166";
//		given().log().all().header("Content-Type", "application/json").body(PayLoad.addBook(isbn,aisle)).when()
//				.post("/Library/Addbook.php").then().log().all().assertThat().statusCode(200).extract().response()
//				.asString();
		
		
		given().log().all().header("Content-Type", "application/json")
		.body(GenerateFromresource("C:\\Users\\Admin\\Desktop\\addbook.json")).when()
	.post("/Library/Addbook.php").then().log().all().assertThat().statusCode(200).extract().response()
	.asString();
		
		JsonPath js = new JsonPath(response);
		String id = js.get("ID");
		System.out.println(id);

	}

//@DataProvider(name="addbookdata")
//public Object[][] getdata()
//{
//	return new Object[][] {{"heho","12345"},{"hi","6789"},{"okbye","000000"}};
//}
//	
//	
	public static String GenerateFromresource(String path) throws IOException {
		
		return new String(Files.readAllBytes(Paths.get(path)));
		
	}
	
}

