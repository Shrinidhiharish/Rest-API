package test;

import static io.restassured.RestAssured.given;

import io.restassured.path.json.JsonPath;

public class OauthApi {

	public static void main(String[] args) {

		//System.setProperty("webdriver.chrome.driver",
		//		"E:\\Eclipse_Projects\\RestassuredDemo\\Chrome\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		//driver.get(
				//"https://accounts.google.com/signin/oauth/oauthchooseaccount?scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&auth_url=https%3A%2F%2Faccounts.google.com%2Fo%2Foauth2%2Fv2%2Fauth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https%3A%2F%2Frahulshettyacademy.com%2FgetCourse.php&state=abcdefg&o2v=2&as=uXlAOgjlzFtmPIXNY-lXFg&flowName=GeneralOAuthFlow");
		//driver.findElement(By.xpath("//div[@data-item-index='1']")).click();
		//String URL=driver.getCurrentUrl();
		//System.out.println(URL);
		String URL="https://rahulshettyacademy.com/getCourse.php?state=abcdefg&code=4%2F0AE9G_rPNxa1T8sN70jMiiig3pWzeXvMBNR_pDEH3kn9j7xHjN9J_muQNmJqtPgY2kNC0lmTTcX0qXUCjtdKFys&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=1&prompt=consent#";
		String partialurl=URL.split("code=")[1];
		String code=partialurl.split("&scope")[0];
		System.out.println(code);
		
		String GetAccessTokenRequest = given().urlEncodingEnabled(false)
				.queryParam("code",code)
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
