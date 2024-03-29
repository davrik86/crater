package step_definitions;

import static org.junit.Assert.assertTrue;

import java.awt.RenderingHints.Key;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.testng.asserts.SoftAssert;

import Utils.BrowserUtils;
import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterItems;
import pages.CraterLoginPage;
import pages.Dashboard;
import pages.Itemspage;

public class ItemManagment {
	ScriptEngineManager manager = new ScriptEngineManager();
	ScriptEngine engine = manager.getEngineByName("JavaScript");

	CraterLoginPage clp = new CraterLoginPage();
	Dashboard dashPage = new Dashboard();
	BrowserUtils utils = new BrowserUtils();
	CraterItems itemsPage = new CraterItems();
	Itemspage itPage = new Itemspage();
	String itemname = "";
	String itemPrice = "";
	String item_des = "";
	String itemunit = "";

	@Given("As a {string} user, I am loged in")
	public void as_a_user_i_am_loged_in(String user_type) {
		clp.login(user_type);
	}

	@Given("I navigate to Items page")
	public void i_navigate_to_items_page() throws InterruptedException {
		dashPage.itemTab.isDisplayed();
		dashPage.itemTab.click();
		Assert.assertTrue(itPage.home_Itemtext.isDisplayed());

	}

	@Then("I should be able to see  page titled “Items” and menu navigation path as “Home \\/ Items”")
	public void i_should_be_able_to_see_page_titled_items_and_menu_navigation_path_as_home_items() {
		Assert.assertTrue(itPage.home_Itemtext.isDisplayed());

	}

	@Then("there should be two buttons with Filter and + AddItem sign on them")
	public void there_should_be_two_buttons_with_filter_and_add_item_sign_on_them() {
		utils.waitForElementToBeVisible(itPage.items_page_filter_btn);
		Assert.assertTrue(itPage.items_page_filter_btn.isDisplayed());
		Assert.assertTrue(itPage.AddItemBTTN.isDisplayed());
	}

	@Then("table with Select All checkbox, NAME, UNIT, PRICE,ADDED ON")
	public void table_with_select_all_checkbox_name_unit_price_added_on() {
		Assert.assertTrue(itPage.Table_3Dot.isDisplayed());
		Assert.assertTrue(itPage.Table_Check_All_box.isDisplayed());
		Assert.assertTrue(itPage.TableName.isDisplayed());
		Assert.assertTrue(itPage.Table_Add_On.isDisplayed());
		Assert.assertTrue(itPage.TablePrice.isDisplayed());
		Assert.assertTrue(itPage.TableUnit.isDisplayed());

	}

	@Then("A link icon showing three dots with the following options: Edit with an edit icon, Delete with a delete icon.")
	public void a_link_icon_showing_three_dots_with_the_following_options_edit_with_an_edit_icon_delete_with_a_delete_icon()
			throws InterruptedException {
		itPage.Table_3Dot.click();
		Thread.sleep(4000);
		utils.waitForElementToBeVisible(itPage.items_page_3dot_delete_option);
		Assert.assertTrue(itPage.items_page_3dot_edit_option.isDisplayed());
		Assert.assertTrue(itPage.items_page_3dot_delete_option.isDisplayed());
	}

	@Then("I should see Pagination navigation with the following controls")
	public void i_should_see_pagination_navigation_with_the_following_controls() {
		utils.jsScrolltoView(itPage.Pagination_Next_BTTN);
		Assert.assertTrue(itPage.PaginationTxt.getText().contains("Showing 1 to"));
		System.out.println(itPage.PaginationTxt.getText());
		Assert.assertTrue(itPage.Pagination_Previous.isDisplayed());
		utils.waitForElementToBeVisible(itPage.Pagination_1stpage);
		utils.clickWithActionsClass(itPage.Pagination_Next_BTTN);
		utils.waitForElementToBeVisible(itPage.Pagination_Previous);
		Assert.assertTrue(itPage.PaginationTxt.getText().contains("11"));
		utils.clickWithActionsClass(itPage.Pagination_Next_BTTN);
		Assert.assertTrue(itPage.Pagination_Next_BTTN.isEnabled());
	}

	@When("I click on Add Item button")
	public void i_click_on_add_item_button() {
		itemsPage.addItem.click();
		utils.waituntilURLcontains("create");
		Assert.assertTrue(itPage.New_Item_text.isDisplayed());

	}

	@Then("I should be on New Item page")
	public void i_should_be_on_new_item_page() {
		Assert.assertTrue(itPage.New_Item_text.isDisplayed());
		Assert.assertTrue(itPage.newItemHOMEtxt.getText().contains("Home"));
		System.out.println(itPage.newItemHOMEtxt.getText());
		Assert.assertTrue(itPage.newItemNameTab.isDisplayed());
		Assert.assertTrue(itPage.newItemPriceTab.isDisplayed());
		Assert.assertTrue(itPage.newItemPriceUnit.isDisplayed());
		Assert.assertTrue(itPage.newItemDescriptionTab.isDisplayed());
		Assert.assertTrue(itPage.items_page_saveItem_btn.getText().contains("Save"));

	}/// BUG was found Item name and description booth exceed the number of accepted

	@When("I provide item name {string} price {string} unit {string} and description {string}")
	public void i_provide_item_name_price_unit_and_description(String item_name, String item_price, String item_unit,
			String item_des) {
		itemname = item_name;
		itemPrice = item_price;
		itemunit = item_unit;
		item_des = utils.randomString(200);
		utils.waitForElementToBeVisible(itPage.items_input_page_price_box);
		utils.sendkeysWithActionsClass(itemsPage.itemName, item_name);
		utils.sendkeysWithActionsClass(itemsPage.itemPrice, item_price);
		System.out.println(item_des);
		utils.sendkeysWithActionsClass(itemsPage.itemUnit, item_unit + Keys.ENTER);
		utils.sendkeysWithActionsClass(itemsPage.itemDiscription, item_des);

	}

	@When("I click on Save item button")
	public void i_click_on_save_item_button() {
		itemsPage.itemSaveBttn.click();
		utils.waituntilURLcontains("items");
	}
	@Then("I validate error messages")
	public void i_validate_error_messages() {
	    if (itemname=="") {
	    	Assert.assertTrue(clp.fieldIsRequiered.isDisplayed());
	    }
	    else if(itemname.length()<3) {
	    	Assert.assertTrue(itPage.new_item_name_field_Name_must.isDisplayed());
	    }
	    else if(itemname.length()>50){
	    	SoftAssert softAssert= new SoftAssert();
	    	softAssert.assertTrue(itPage.new_item_name_field_Name_Item_Name_incorrect.isDisplayed());
	    }
	}

	@Then("an item is added to the item list table")
	public void an_item_is_added_to_the_item_list_table() throws InterruptedException {
		utils.waitUntilElementClickable(itPage.items_page_filter_btn);
		Thread.sleep(2000);
		itPage.items_page_filter_btn.click();
		utils.waitForElementToBeVisible(itPage.items_page_filter_name_box);
		itPage.items_page_filter_name_box.sendKeys(itemname);
		System.out.println(itemname);
		System.out.println(itPage.items_input_page_name_box.getText());
		utils.waitUntilElementVisibleWithLocator(By.xpath("//a[text()='" + itemname + "']"));
		utils.waituntilURLcontains("items");
		Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//a[text()='" + itemname + "']")).isDisplayed());
	}

	@When("I update the item price with {string}")
	public void i_update_the_item_price_with(String newPrice) {
		itemPrice = newPrice;

		utils.clickWithActionsClass(itemsPage.item3Dots);
		utils.waitForElementToBeVisible(itemsPage.dot3EditBttn);
		itemsPage.dot3EditBttn.click();
		utils.waitForElementToBeVisible(itemsPage.editPage);
		Assert.assertTrue(itemsPage.editPage.isDisplayed());
		itemsPage.itemPrice.clear();
		itemsPage.itemPrice.sendKeys(newPrice);
		utils.clickWithActionsClass(itemsPage.itemSaveBttn);

		utils.waituntilURLcontains("items");

		Assert.assertTrue(itPage.items_items_text.isDisplayed());

	}

	@When("I should see Success message")
	public void i_should_see_success_message() {
		utils.waitForElementToBeVisible(itPage.item_created_Succ);
		Assert.assertTrue(itPage.item_created_Succ.isDisplayed());
	}

	@Then("an items {string} price {string} unit {string} and description {string} should appear in table")
	public void an_items_price_unit_and_description_should_appear_in_table(String item_name, String item_price,
			String item_unit, String item_des) {
		System.out.println(itemPrice);
		utils.waitForElementToBeVisible(itemsPage.item3Dots);
		Assert.assertTrue(itPage.items_table_name.getText().contains(itemname));
		Assert.assertTrue(itPage.items_table_price.getText().contains(itemPrice.subSequence(0, 2)));
		Assert.assertTrue(itPage.items_table_unit.getText().contains(itemunit));
	}

	@Then("I delete the created item")
	public void i_delete_the_created_item() throws InterruptedException {

		Thread.sleep(2000);
		utils.waitUntilElementVisibleWithLocator(By.xpath("//a[text()='" + itemname + "']"));
		itemsPage.item3Dots.click();
		itemsPage.deliteBtn.click();
		itemsPage.alertOkBtn.click();

	}
	@When("I click on 1st item checkbox")
	public void i_click_on_1st_item_checkbox() {
	 utils.clickWithActionsClass(itPage.items_table_single_Checkbox);
		
	}
	@When("I click on all item checkbox")
	public void i_click_on_all_item_checkbox() {
		utils.clickWithActionsClass(itPage.items_table_single_Checkbox);
		utils.clickWithActionsClass(itPage.items_table_ALL_Checkbox);
		utils.waitForElementToBeVisible(itPage.Acctions_BTTN);
	}
	@When("I click on Action button I select delete")
	public void i_click_on_action_button_i_select_delete() {
	    itPage.Acctions_BTTN.click();
	    itemsPage.deliteBtn.click();
	   
	}
	
	@Then("I veryfy the Alert text and click ok")
	public void i_veryfy_the_alert_text_and_click_ok() {
		Assert.assertTrue(itPage.Delite_message_Are_you_sure.isDisplayed());  
		Assert.assertTrue(itPage.Delite_message_You_Will_not_be.isDisplayed());  
		
		itemsPage.alertOkBtn.click();
	}
}
