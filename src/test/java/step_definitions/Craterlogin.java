package step_definitions;

import java.util.ArrayList;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Utils.BrowserUtils;
import Utils.DataReader;
import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterItems;
import pages.CraterLoginPage;

public class Craterlogin {
	CraterLoginPage loginPage= new CraterLoginPage();
	CraterItems item= new CraterItems();
	BrowserUtils utils= new BrowserUtils();
	
	Actions act= new Actions(Driver.getDriver());
	@Given("As an entity user, I am logged in")
	public void as_an_entity_user_i_am_logged_in() {
		
	    Driver.getDriver().get(DataReader.getProperty("crater_url"));
	    utils.waitForElementToBeVisible(loginPage.loginUserName);
	    act.sendKeys(loginPage.loginUserName, DataReader.getProperty("crater_username")).build().perform();;
	    act.sendKeys(loginPage.loginPass, DataReader.getProperty("crater_password")).build().perform();;
	    loginPage.loginBTTN.click();
	    
	}

	@Given("I navigate to Items tab")
	public void i_navigate_to_items_tab() {	
	
		utils.waitUntilElementVisibleWithLocator(By.xpath("//a[@href=\"/admin/items\"]"));
		
		act.click(item.ItemSection).build().perform();
		
		
	}	

	@When("I click on the Add Item button")
	public void i_click_on_the_add_item_button() {
		utils.waitForElementToBeVisible(item.addItem);
		item.addItem.click();
	}

	@Then("I should be on item input page")
	public void i_should_be_on_item_input_page() throws InterruptedException {
		utils.waitForElementToBeVisible(item.itemName);
		//Thread.sleep(4000);
		System.out.println("THIS IS THE TITIEL : "+ item.itemPage.getText());
	}

	@When("I provide item information name {string}, price {string}, unit {string}, and description {string}")
	public void i_provide_item_information_name_price_unit_and_description(String name, String price, String unit, String description) throws InterruptedException {
		
		utils.waitUntilElementVisibleWithLocator(By.xpath("//div[contains(@text(),\"\")][4]"));
		item.itemName.sendKeys(name);
		
		item.itemUnit.sendKeys(unit);
	//	Thread.sleep(500);
		item.itemUnit.sendKeys(Keys.ENTER);
		item.itemPrice.sendKeys(price);
		item.itemDiscription.sendKeys(description);
		
		
	}

	@When("I click Save Item button")
	public void i_click_save_item_button() {
	    item.itemSaveBttn.click();
	}

	@Then("The Item is added to the Item list table")
	public void the_item_is_added_to_the_item_list_table() {
	    item.itemName.isDisplayed();
	}

	@Then("I delete the item")
	public void i_delete_the_item() throws InterruptedException {
	//	Thread.sleep(2000);
		utils.waitForElementToBeVisible(item.itemCheckbox);
//		
//		List<WebElement> tableEleme= Driver.getDriver().findElements(By.xpath("//div[contains(@class,\"relative table-container\")]"));
//		WebElement singleItem =Driver.getDriver().findElement(By.xpath("//a[text()=\"White Coffee\"]"));
//		for ( WebElement items: tableEleme) {
//		while(items.getText().contains("White Coffee")) {
			//if (items.getText().contains("White Coffee")) {
			//	System.out.println(items.getText());
				item.item3Dots.click();
				utils.waitForElementToBeVisible(item.deliteBtn);
				act.moveToElement(item.deliteBtn).perform();
				item.deliteBtn.click();
				utils.waitForElementToBeVisible(item.alertOkBtn);
				item.alertOkBtn.click();
			}
		//else {
				//System.out.println("No more match found");
//			}
//		}
		
//		List<WebElement> rows= item.table.findElements(By.tagName("tr"));
//		for (WebElement row: rows) {
//		WebElement cell = row.findElement(By.linkText("itemName"));
//		if (cell.getText().contains("itemName")) {
//			WebElement Elbutton= row.findElement(By.xpath("//button[contains(@id,\"headlessui-menu-button-5\")]"));
//			Elbutton.click();
//			utils.waitForElementToBeVisible(item.deliteBtn);
//			act.moveToElement(item.deliteBtn).perform();
//			item.deliteBtn.click();
//			utils.waitForElementToBeVisible(item.alertOkBtn);
//			item.alertOkBtn.click();
//		}
//	
//		
//		}
	}
		
//		}


