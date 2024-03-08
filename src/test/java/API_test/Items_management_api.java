package API_test;


import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.BrowserUtils;
import Utils.DataReader;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class Items_management_api {
	BrowserUtils utils= new BrowserUtils();
	
	
	String token;
	String baseURL =DataReader.getProperty("crater_url");
	int item_id;
	Response response;
	
	
	//in Rest Assure we send in the text the body of request in given section
	//login test/ function
	
	@Test	
	public void login_test() {
		
		String  payload = "{\r\n"
				+ "    \"username\": \""+DataReader.getProperty("crater_username") +"\",\n"
				+ "    \"password\": \""+DataReader.getProperty("crater_password") +"\",\n"
				+ "    \"device_name\": \"mobile_app\"\r\n"
				+ "}";
		
		 response= 
				given().contentType("application/json").body(payload)
				.when().post(baseURL+"/api/v1/auth/login");
		
		
		response.prettyPrint();
		token= response.jsonPath().get("token");	
		
		
	}	
	
	
	@Test	(dependsOnMethods = {"login_test"})
	public void  lsit_all_items() {
		 response =
		given().auth().oauth2("Bearer " +token).accept("application/json")
		.when().get(baseURL +"/api/v1/items");
		
		response.then().statusCode(200).contentType("application/json");
		response.prettyPrint();
	}
	//create an item and veryfy the item is correct in response
	
	@Test(dependsOnMethods = {"login_test"})
	public void Create_item() {

		Map<String, Object> payload= new HashMap<>();
		payload.put("name", "cool Stuff" +utils.randomNumber());
		payload.put("price", 13400);
		payload.put("unit_id", 8);//1st mistake we found  11 and belowe will be accepted
		payload.put("description", "really cool stuff");
		
		
		 response= 
				given().auth().oauth2("Bearer "+token).body(payload).contentType("application/json")
				.when().post(baseURL+ "/api/v1/items");
//		 response.prettyPrint();
		
		item_id = response.jsonPath().get("data.id");
		String item_name= response.jsonPath().get("data.name");
		System.out.println(" name of the item created is "+ item_name);
		
	}
	@Test(dependsOnMethods = "Create_item")
	
	public void get_item() {
		response= given().auth().oauth2("Bearer " +token).accept("application/json") // we did replace contentType with accept
				.when().get(baseURL+ "/api/v1/items/"+ item_id);
		
		response.then().statusCode(200).contentType("application/json");
		
		int id= response.jsonPath().get("data.id");
		Assert.assertEquals( id, item_id);
		
	}

	
	@Test (dependsOnMethods = "Create_item")
	
	public void update_Item(){
		File payload= new File("./src/test/resources/testFiles/update_item_data.json");
		
		response= 
					given().auth().oauth2("Bearer " +token).contentType("application/json").body(payload)
					.when().put(baseURL+ "/api/v1/items/"+ item_id);
		
		response.prettyPrint();
		response.then().statusCode(200).contentType("application/json");
		
	}
	
	@Test (dependsOnMethods ="update_Item" )
	
	public void delete_item() {
		String payload= "{\n"
					+ "    \"ids\": [ "+item_id+" ]\n"
					+ "}";
				
		response = 	
					given().auth().oauth2("Bearer " +token).contentType("application/json").body(payload)
					.when().post(baseURL+ "/api/v1/items/delete");//we added delete here
		
		response.prettyPrint();
		response.then().statusCode(200).contentType("application/json");
		boolean deleteSuccess =response.jsonPath().get("success");// From capital S to s
		
		Assert.assertTrue(deleteSuccess);
		
		
		
	}
}
