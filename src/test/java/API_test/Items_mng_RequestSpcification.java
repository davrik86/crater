package API_test;



import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.BrowserUtils;
import Utils.DataReader;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Items_mng_RequestSpcification {	
		BrowserUtils utils= new BrowserUtils();
		
		
		String token;
		String baseURL =DataReader.getProperty("crater_url");
		int item_id;
		Response response;
		RequestSpecification specs;//we have diclared specs as an RequestSpecification
		

		
		//in Rest Assure we send in the text the body of request in given section
		//login test/ function
		
		@Test(groups = {"regression", "smoke_test"})
		public void login_test() {
			
			
			String  payload = "{\r\n"// response body you get form Postman
					+ "    \"username\": \""+DataReader.getProperty("crater_username") +"\",\n"
					+ "    \"password\": \""+DataReader.getProperty("crater_password") +"\",\n"
					+ "    \"device_name\": \"mobile_app\"\r\n"
					+ "}";
			//using RequestSpecification
			specs= RestAssured.given();
			specs.baseUri(baseURL);//now we have base url spesified dynamic
			specs.contentType("application/json").body(payload);		
			response= specs.post("/api/v1/auth/login");	
			
			response.prettyPrint();
			token= response.jsonPath().get("token");	
			
			
		}	
		
		
		@Test	(dependsOnMethods = {"login_test"},groups= {"smoke_test"})
		public void  lsit_all_items() {
			specs.baseUri(baseURL).accept("application/json").auth().oauth2("Bearer " +token);
			response= specs.get("/api/v1/items");
			
			
			response.then().statusCode(200).contentType("application/json");
			response.prettyPrint();
		}
		//create an item and veryfy the item is correct in response
		
		@Test(dependsOnMethods = {"login_test"},groups= {"smoke_test"})
		public void Create_item() {// in order to create an item, what do we need?  
			// we need headers, authorization, and body
			
			Map<String, Object> payload = new HashMap<>();
			payload.put("name", "Backpack" + utils.randomNumber());
			payload.put("price", 3800);
			payload.put("unit_id", 11);
			payload.put("description", "nice backpack");
			
			response = given().auth().oauth2("Bearer " + token).body(payload).contentType("application/json")
					.when().post(baseURL + "/api/v1/items");
			
			item_id = response.jsonPath().get("data.id");
			
			String item_name = response.jsonPath().get("data.name");

			System.out.println(" Name of the item created is: " + item_name);
		}
		@Test(dependsOnMethods = "Create_item",groups= {"smoke_test"})
		
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
		
	//Swagger using the querry prams	
		@Test
		public void Swager_findBy_Status() {
			response=given().
			accept("application/json").
			queryParam("status", "available").
			when().get("https://petstore.swagger.io/v2/pet/findByStatus");
			
			response.prettyPrint();
			
			response.then().statusCode(200);
			
		}
		@Test
		public void Swager_findBy_Status_chain_VAL() {
			given().
			accept("application/json").
			queryParam("status", "available").
			when().
			get("https://petstore.swagger.io/v2/pet/findByStatus").
			then().
			assertThat().statusCode(200).
			and().assertThat().contentType("application/json").
			and().assertThat().body("[0].name", Matchers.equalTo("Lion 3"));
						
		}
		
		//Invalid API test case demo
		
		@Test
		public void invalid_end_point() {
			response= given().
			accept("application/json").
			when().get("https://petstore.swagger.io/v2/pet/"+7);
			
			response.prettyPrint();
			response.
			then().assertThat().statusCode(404).
			and().assertThat().contentType("application/json").
			and().assertThat().body("message", Matchers.equalTo("Pet not found"));
			
			
		}
		
		
		
	}


