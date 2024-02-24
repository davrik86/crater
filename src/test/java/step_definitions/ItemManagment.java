package step_definitions;

import static org.junit.Assert.assertTrue;

import java.awt.RenderingHints.Key;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

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
	
	CraterLoginPage clp = new CraterLoginPage();
	Dashboard dashPage =  new Dashboard();
	BrowserUtils utils = new BrowserUtils();
	CraterItems itemsPage=  new CraterItems();
	Itemspage itPage= new Itemspage();
	String itemname="";
	@Given("As a {string} user, I am loged in")
	public void as_a_user_i_am_loged_in(String user_type) {
	    clp.login(user_type);
	}
	@Given("I navigate to Items page")
	public void i_navigate_to_items_page() {
		dashPage.itemTab.isDisplayed();
		dashPage.itemTab.click();
		//utils.waituntilURLcontains("Items");
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
	}

	@When("I provide item name {string} price {string} unit {string} and description {string}")
	public void i_provide_item_name_price_unit_and_description(String item_name, String item_price, String item_unit, String item_des) {
		itemname=item_name +utils.randomNumber();
		
		utils.waitForElementToBeVisible(itPage.items_input_page_price_box);
	    utils.sendkeysWithActionsClass(itemsPage.itemName, itemname);
	    utils.sendkeysWithActionsClass(itemsPage.itemPrice, item_price);
	    
	    utils.sendkeysWithActionsClass(itemsPage.itemUnit, item_unit+ Keys.ENTER);
	    utils.sendkeysWithActionsClass(itemsPage.itemDiscription, item_des);

	}

	@When("I click on Save item button")
	public void i_click_on_save_item_button() {
		itemsPage.itemSaveBttn.click();
		utils.waituntilURLcontains("items");
	}

	@Then("the item is added the list table")
	public void the_item_is_added_the_list_table() {
		
		utils.waitUntilElementVisibleWithLocator(By.xpath("//a[text()='"+itemname+"']"));
		Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//a[text()='"+itemname+"']")).isDisplayed());
	}

	@Then("I delete the created item")
	public void i_delete_the_created_item() {
		itemsPage.item3Dots.click();	
		itemsPage.deliteBtn.click();
		itemsPage.alertOkBtn.click();
		
	}



}
