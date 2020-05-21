package test;

import org.testng.Assert;

import files.PayLoad;
import io.restassured.path.json.JsonPath;

public class SumValidation {
	public static void main(String[] args) {
int sum=0;
		JsonPath js = new JsonPath(PayLoad.CoursePrice());
		int count = js.getInt("courses.size()");// can be applied only on the array.
		for (int i = 0; i < count; i++) {

			int price = js.get("courses[" + i + "].price");
			int noOfCopies = js.get("courses[" + i + "].copies");
			int amount = price * noOfCopies;
			System.out.println(amount);
			sum=sum+amount;
			System.out.println(sum);
		}
		int purchaseamount = js.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(sum, purchaseamount);
	}

}