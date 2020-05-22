package test;

import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;

public class OauthApi {

	public static void main(String[] args) {

		String GetAccessTokenRequest = given().queryParam("code", "")
				.queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
				.queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
				.queryParam("grant_type", "authorization_code").when().log().all()
				.post("https://www.googleapis.com/oauth2/v4/token").asString();
		JsonPath js = new JsonPath(GetAccessTokenRequest);

		String access_Token = js.getString("access_token");

		String response = given().queryParam("access_token ", access_Token).when().log().all()
				.get("https://rahulshettyacademy.com/getCourse.php").asString();

		System.out.println(response);

	}

}
