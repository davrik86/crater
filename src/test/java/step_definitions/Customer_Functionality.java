package step_definitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import Utils.BrowserUtils;
import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.CraterItems;
import pages.CraterLoginPage;
import pages.Customers_Page;
import pages.Dashboard;
import pages.Itemspage;

public class Customer_Functionality {

	CraterLoginPage clp = new CraterLoginPage();
	Dashboard dashPage = new Dashboard();
	BrowserUtils utils = new BrowserUtils();
	CraterItems itemsPage = new CraterItems();
	Itemspage itPage = new Itemspage();
	Customers_Page cp= new Customers_Page();
	
	

	@Given("I click on Customers page and navigate to page")
	public void i_click_on_customers_page_and_navigate_to_page() {
		Assert.assertTrue(cp.dashboard_CUSTOMER_tab.isDisplayed());
		cp.dashboard_CUSTOMER_tab.click();
		
	}
	@Then("I should be directed to the page to validate Basic Info UI components")
	public void i_should_be_directed_to_the_page_to_validate_basic_info_ui_components() throws InterruptedException {
		
	   utils.waitForElementToBeVisible(itPage.items_page_3dot_menu);
	   Assert.assertTrue(cp.customer_Customer_title.isDisplayed());
	   Assert.assertTrue(cp.customer_Home_navgation_path.isDisplayed());
	   Assert.assertTrue(cp.customer_Customer_navgation_path.isDisplayed());
	   Assert.assertTrue(cp.customer_table_Name_cl.isDisplayed());
	   Assert.assertTrue(cp.customer_New_Customer_BTTN.isDisplayed());
	   Assert.assertTrue(cp.customer_table_AddedOn_cl.isDisplayed());
	   Assert.assertTrue(itPage.items_page_3dot_menu.isDisplayed());
	   Assert.assertTrue(cp.customer_table_AmountDue_cl.isDisplayed());
	   Assert.assertTrue(cp.customer_table_Phone_cl.isDisplayed());
	   Assert.assertTrue(itPage.items_page_filter_btn.isDisplayed());
	   itPage.items_page_3dot_menu.click();
	   utils.waitForElementToBeVisible(cp.customer_table_3dot_View_BTTN);
	   Assert.assertTrue(itPage.items_page_3dot_delete_option.isDisplayed());
	   Assert.assertTrue(itPage.items_page_3dot_edit_option .isDisplayed());
	   Assert.assertTrue(cp.customer_table_3dot_View_BTTN.isDisplayed());
	   	   
	}
	@Given("I click to +NewCustomer button")
	public void i_click_to_new_customer_button() {
		cp.customer_New_Customer_BTTN.click();
		utils.waitForElementToBeVisible(cp.new_customer_SaveCust_BTTN);
		Assert.assertTrue(cp.new_customer_SaveCust_BTTN.isDisplayed());
	    
	}
	@Then("Validate Basic informatio address UI components with {string}, {string} {string} {string} {string}")
	public void validate_basic_informatio_address_ui_components_with(String Name, String email, String zip , String phone, String primary) throws InterruptedException {
		Assert.assertTrue(cp.new_customer_title.isDisplayed());
		Assert.assertTrue(cp.new_customerBasic_Curency.isDisplayed());
		Assert.assertTrue(cp.new_customerBasic_DISP_name.isDisplayed());
		Assert.assertTrue(cp.new_customerBasic_Email.isDisplayed());
		Assert.assertTrue(cp.new_customerBasic_Prefix.isDisplayed());
		Assert.assertTrue(cp.new_customerBasic_Phone.isDisplayed());
		Assert.assertTrue(cp.new_customerBasic_Primary_Cont_Name.isDisplayed());
		Assert.assertTrue(cp.new_customerBasic_Website.isDisplayed());
		cp.String_Lenght_Error_val(cp.new_customerBasic_DISP_name, Name);
		cp.String_Lenght_Error_val(cp.new_customerBasic_Email, email);
		cp.String_Lenght_Error_val(cp.new_customerBasic_Phone, phone );
		cp.String_Lenght_Error_val(cp.new_customerBasic_Website, email);
		cp.String_Lenght_Error_val(cp.new_customerBasic_Prefix, Name);
		cp.String_Lenght_Error_val(cp.new_customerBasic_Primary_Cont_Name, Name);
		cp.new_customerBasic_Curency.click();
		utils.waitForElementToBeVisible(cp.new_customer_Basic_CurencyLS1);
		int size =utils.dropdown_items_size("(//div[@class='w-full overflow-y-auto'])[1]");
		Assert.assertEquals(72, size);

	


	}
	@Then("Validate Shipping and Billing address UI components {string}, {string} {string} {string}")
	public void validate_shipping_and_billing_address_ui_components(String Name, String Address, String zip, String phone) {
	
		Assert.assertTrue(cp.new_customer_titleBill_Name.isDisplayed());
		Assert.assertTrue(cp.new_customer_titleBill_zip.isDisplayed());
		Assert.assertTrue(cp.new_customer_titleBil_Country.isDisplayed());
		Assert.assertTrue(cp.new_customer_titleBill_billStreet1.isDisplayed());
		Assert.assertTrue(cp.new_customer_titleBill_billStreet2.isDisplayed());
		Assert.assertTrue(cp.new_customer_titleBill_city.isDisplayed());
		Assert.assertTrue(cp.new_customer_titleBill_State.isDisplayed());
		Assert.assertTrue(cp.new_customer_titleBill_Phone.isDisplayed());
		
		cp.String_Lenght_Error_val(cp.new_customer_titleBill_Name, Name);		
		cp.String_Lenght_Error_val(cp.new_customer_titleBill_zip, zip);
		cp.String_Lenght_Error_val(cp.new_customer_titleBill_billStreet1, Address);
		cp.String_Lenght_Error_val(cp.new_customer_titleBill_billStreet2, Address);
		cp.String_Lenght_Error_val(cp.new_customer_titleBill_State, Name);
		cp.String_Lenght_Error_val(cp.new_customer_titleBill_city, Name);
		cp.String_Lenght_Error_val(cp.new_customer_titleBill_Phone, phone);
		cp.new_customer_Bill_Copy.click();
		Assert.assertTrue(cp.new_customer_titleBill_Name.getText().contains(cp.new_customer_titleShipp_Name.getText()));
		Assert.assertTrue(cp.new_customer_titleBill_zip.getText().contains(cp.new_customer_titleShip_zip.getText()));
		Assert.assertTrue(cp.new_customer_titleBil_Country.isDisplayed());
		Assert.assertTrue(cp.new_customer_titleBill_billStreet1.getText().contains(cp.new_customer_titleShip_billStreet1.getText()));
		Assert.assertTrue(cp.new_customer_titleBill_billStreet2.getText().contains(cp.new_customer_titleShip_billStreet2.getText()));
		Assert.assertTrue(cp.new_customer_titleBill_city.getText().contains(cp.new_customer_titleShip_city.getText()));
		Assert.assertTrue(cp.new_customer_titleBill_State.getText().contains(cp.new_customer_titleShip_State.getText()));
		Assert.assertTrue(cp.new_customer_titleBill_Phone.getText().contains(cp.new_customer_titleShip_phone.getText()));
		
		Assert.assertTrue(cp.new_customer_titleShipp_Name.isDisplayed());
		Assert.assertTrue(cp.new_customer_titleShip_zip.isDisplayed());
		Assert.assertTrue(cp.new_customer_titleShip_State.isDisplayed());
		Assert.assertTrue(cp.new_customer_titleShip_phone.isDisplayed());
		Assert.assertTrue(cp.new_customer_titleShip_Country.isDisplayed());
		Assert.assertTrue(cp.new_customer_titleShip_city.isDisplayed());
		Assert.assertTrue(cp.new_customer_titleShip_billStreet1.isDisplayed());
		Assert.assertTrue(cp.new_customer_titleShip_billStreet2.isDisplayed());
		

		cp.new_customer_titleBil_Country.click();
		utils.waitForElementToBeVisible(cp.new_customer_titleBil_Country);
		int sizeBill =utils.dropdown_items_size("(//div[@class='w-full overflow-y-auto'])[2]");
		Assert.assertEquals(246, sizeBill);
	}
	//Toggle function
	@Given("I click toggle button to validate all components")
	public void i_click_toggle_button_to_validate_all_components() {
	    utils.waitForElementToBeVisible(cp.Toggle_Off_BTTN);
	    Assert.assertTrue(cp.Toggle_Off_BTTN.isDisplayed());
	    Assert.assertTrue(cp.Toggle_Switch_txt.isDisplayed());
	    cp.Toggle_On_BTTN.click();
	    utils.waitForElementToBeVisible(cp.Toggle_On_text);
	    Assert.assertTrue(cp.Toggle_On_text.isDisplayed());
	    Assert.assertTrue(cp.Toggle_txt_beloweURL.isDisplayed());
	    SoftAssert softAssert = new SoftAssert();
	    String ExpUrlTxt="http://crater.primetech-apps.com/xyz/customer/login";
	    softAssert.assertEquals(cp.Toggle_URL.getText(), ExpUrlTxt);
	    cp.Toggle_URL_copy_BTTN.click();
	    utils.waitForElementToBeVisible(cp.Toggle_Clip_copy_successmsg);
	    Assert.assertTrue(cp.Toggle_Clip_copy_successmsg.isDisplayed());
	    Assert.assertTrue(cp.Toggle_txt_beloweURL.isDisplayed());
	  
	    
	    
	}

//	@Then("I would validate {string} tabs and errors")
//	public void i_would_validate_tabs_and_errors(String pass) {
//	   cp.String_Lenght_Error_valNO_BTTN(cp.Toggle_Password_field, pass);
////	   cp.S
//	}

	//Sales page
	
	@Then("As user I should be navigated to Sales page")
	public void as_user_i_should_be_navigated_to_sales_page() {	    
		
	}
	@Then("User should see entered data and Success message")
	public void user_should_see_entered_data_and_success_message() {
	    
	}
	@Then("User data can be viewd using filter")
	public void user_data_can_be_viewd_using_filter() {
	    
	}
}
