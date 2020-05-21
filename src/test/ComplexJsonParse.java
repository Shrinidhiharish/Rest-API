package test;

import files.PayLoad;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {
	static JsonPath js;
	public static void main(String[] args) {
		
		//Testcase 1 
		 js=new JsonPath(PayLoad.CoursePrice());
		int count = js.getInt("courses.size()");//can be applied only on the array.
		System.out.println(count);
	int totalAmount=js.getInt("dashboard.purchaseAmount");
		System.out.println(totalAmount);
		
		
		//Testcase 2 
		for(int i=0;i<count;i++)
		{
			String title=js.get("courses["+i+"].title");
			System.out.println(title);
			System.out.println(js.get("courses["+i+"].price").toString());
		}
		
		//testcase 3 
		
		System.out.println("Print no of copies sold in RPA");
		for(int i=0;i<count;i++)
		{
			String title=js.get("courses["+i+"].title");
			if(title.equalsIgnoreCase("RPA"))
			{
				int noOfCopies=js.get("courses["+i+"].copies");
				System.out.println(noOfCopies);
				break;
			}
			
	} 
		

	}
}


