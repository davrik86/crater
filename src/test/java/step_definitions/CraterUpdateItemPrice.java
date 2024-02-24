package step_definitions;

import Utils.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterItems;
import pages.CraterLoginPage;

public class CraterUpdateItemPrice {
	CraterLoginPage loginPage= new CraterLoginPage();
	CraterItems item= new CraterItems();
	BrowserUtils utils= new BrowserUtils();
	
	@When("I select the item {string}")
	public void i_select_the_item(String string) {
	    utils.waitForElementToBeVisible(item.itemCheckbox);
	    item.itemBook.click();
	}
	@When("I should be on item details page")
	public void i_should_be_on_item_details_page() {
	    System.out.println("this is 'Item Details' page :"+ item.itemPage.getText().contains("Item Details") +item.itemPage.getText() );
	}
	@When("I update the item price to {int} dollars")
	public void i_update_the_item_price_to_dollars(Integer int1) {
	    item.itemPrice.sendKeys(String.valueOf(int1*100));
	    
	}
	@When("I click Update Item button")
	public void i_click_update_item_button() {
		item.itemSaveBttn.click();
	}
	@Then("The Item price is updated to {int} dollars")
	public void the_item_price_is_updated_to_dollars(Integer int1) {
	   
	}



}
