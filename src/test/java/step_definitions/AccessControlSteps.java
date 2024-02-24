package step_definitions;

import static org.junit.Assert.assertTrue;


import org.junit.Assert;
import org.openqa.selenium.By;

import Utils.BrowserUtils;
import Utils.DataReader;
import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterLoginPage;
import pages.Dashboard;


public class AccessControlSteps {

	CraterLoginPage acp =new CraterLoginPage();
	Dashboard dash = new Dashboard();
	BrowserUtils utils = new BrowserUtils();	
	@Given("I am on the login page")
	public void i_am_on_the_login_page() {
	    Driver.getDriver().get(DataReader.getProperty("crater_url"));
	}
	@Given("Login page components exists")
	public void login_page_components_exists() {
	    Assert.assertTrue(acp.loginBTTN.isDisplayed());
	    Assert.assertTrue(acp.loginPass.isDisplayed());
	    Assert.assertTrue(acp.loginUserName.isDisplayed());
	    Assert.assertTrue(acp.frgtPassLink.isDisplayed());
	}
	@When("I enter valid username and valid password")
	public void i_enter_valid_username_and_valid_password() {
	    acp.loginUserName.sendKeys(DataReader.getProperty("crater_username"));
	    acp.loginPass.sendKeys(DataReader.getProperty("crater_password"));
	}
	@When("I click on login button")
	public void i_click_on_login_button() {
		acp.loginBTTN.click();
	}
	@Then("I should be on the Dashboard page")
	public void i_should_be_on_the_dashboard_page() {
		utils.waituntilURLcontains("dashboard");
		String curretnURL= Driver.getDriver().getCurrentUrl();
	    Assert.assertEquals("http://crater.primetech-apps.com/admin/dashboard", curretnURL);
	    Assert.assertTrue(curretnURL.contains("dashboard"));
	   
	}
	@Then("sucess message displays")
	public void sucess_message_displays() {
	    Assert.assertTrue(acp.loginSuccsessful_message.isDisplayed());
	}

	@Then("I should be on the {string} page")
	public void i_should_be_on_the_page(String menu_Item) {
		String classValues= Driver.getDriver().findElement(By.xpath("//a[text()='"+menu_Item+"']")).getAttribute("class");
			Assert.assertTrue(classValues.contains("active"));
}
	@Then("{string} message displays")
	public void message_displays(String successMessage) {
		Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//p[text()='" +successMessage+ "']")).isDisplayed());	
		
}
	
	@When("I enter invalid {string} and invalid {string}")
	public void i_enter_invalid_and_invalid(String username, String password) {
		acp.loginUserName.sendKeys(username);
		acp.loginPass.sendKeys(password);
	}
	@Then("I should not be loged in")
	public void i_should_not_be_loged_in() {
		utils.waituntilURLcontains("login");
		String curretnURL= Driver.getDriver().getCurrentUrl();
		Assert.assertTrue(curretnURL.contains("login"));
		
	}
	
	}
