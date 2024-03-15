package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.BrowserUtils;
import Utils.DataReader;
import Utils.Driver;

public class CraterLoginPage {
	//Actions act= new Actions(Driver.getDriver());
	BrowserUtils utils = new BrowserUtils();	
	public CraterLoginPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	//username field
	@FindBy (xpath="//input[@name='email']")
	public WebElement loginUserName;
	
	@FindBy (xpath="//div[contains(text(),'Email')]")
	public WebElement emailText;
	
	//password field
	@FindBy (xpath="//input[@name='password']")
	public WebElement loginPass;
	
	@FindBy (xpath="//div[contains(text(),'Password')]")
	public WebElement passwordText;
	
	@FindBy (xpath="//p[contains(text(), 'Copyright')]")
	public WebElement copyrightTetx;
	
	@FindBy (xpath="//h1[text()='Simple Invoicing for Individuals Small Businesses']")
	public WebElement headingSimple;
	
	@FindBy (xpath="//p[contains(text(),'Crater helps ')]")
	public WebElement craterText;
	
	//login button
	@FindBy (xpath="//button[@type='submit']")
	public WebElement loginBTTN;
	
	@FindBy (linkText ="Forgot Password?" )
	public WebElement frgtPassLink;
	
	@FindBy (xpath="//p[text()='Succes!']")
	public WebElement loginSuccsess_message;
	
	@FindBy (xpath="//p[text()='Logged in successfully.']")
	public WebElement loginSuccsessful_message;
	
	@FindBy (xpath="//p[text()='Succes!']")
	public WebElement loginSucces;
	
	@FindBy (xpath="//p[text()='Error']")
	public WebElement Error;		
	
	@FindBy (xpath="//span[text()='Field is required']")
	public WebElement fieldIsRequiered;
	
	@FindBy (xpath="//span[text()='Incorrect Email.']")	
	public WebElement IncorrectEmail;
	
	@FindBy (xpath="//span[text()='']")	
	public WebElement resetErrormsgs;
	
	@FindBy (xpath="//input[@name='email']")
	public WebElement enter_Email_Reset_page;
	
	@FindBy (xpath="//div[text()='Send Reset Link']")
	public WebElement Send_Reset_LinkBTTN;
	
	// user level type     
	public void login(String user_type) {
		
		Driver.getDriver().get(DataReader.getProperty("crater_url"));
		Assert.assertTrue(loginBTTN.isDisplayed());
	    Assert.assertTrue(loginPass.isDisplayed());
	    Assert.assertTrue(loginUserName.isDisplayed());
	    Assert.assertTrue(frgtPassLink.isDisplayed());
	    switch(user_type) {
	    case "level1" :	
	    	utils.sendkeysWithActionsClass(loginUserName, DataReader.getProperty("level1_username"));
	    	utils.sendkeysWithActionsClass(loginPass, DataReader.getProperty("level1_password"));
	    	utils.clickWithActionsClass(loginBTTN);
	    	utils.waituntilURLcontains("dashboard");
	    	String currentUrllvl1= Driver.getDriver().getCurrentUrl();
	    	Assert.assertEquals("http://crater.primetech-apps.com/admin/dashboard", currentUrllvl1);
	 	    Assert.assertTrue(currentUrllvl1.contains("dashboard"));
	 	    break;
	    case "level2" :
	    	utils.sendkeysWithActionsClass(loginUserName, DataReader.getProperty("level2_username"));
	    	utils.sendkeysWithActionsClass(loginPass, DataReader.getProperty("level2_password"));
	    	utils.clickWithActionsClass(loginBTTN);
	    	utils.waituntilURLcontains("dashboard");
	    	String currentUrllvl2= Driver.getDriver().getCurrentUrl();
	    	Assert.assertEquals("http://crater.primetech-apps.com/admin/dashboard", currentUrllvl2);
	 	    Assert.assertTrue(currentUrllvl2.contains("dashboard"));
	 	    break;
	    case "level3" :
	    	utils.sendkeysWithActionsClass(loginUserName, DataReader.getProperty("level3_username"));
	    	utils.sendkeysWithActionsClass(loginPass, DataReader.getProperty("level3_password"));
	    	utils.clickWithActionsClass(loginBTTN);
	    	utils.waituntilURLcontains("dashboard");
	    	String currentUrllvl3= Driver.getDriver().getCurrentUrl();
	    	Assert.assertEquals("https://crater.primetech-apps.com/admin/dashboard", currentUrllvl3);
	    	Assert.assertTrue(currentUrllvl3.contains("dashboard"));
	    	break;
	    	
	 	 
	    }
	   }
	
	public void emailVal(String email) {
		if(email=="") {
			enter_Email_Reset_page.sendKeys(email);
			Send_Reset_LinkBTTN.click();
			Assert.assertTrue(fieldIsRequiered.isDisplayed());
		}else{
			enter_Email_Reset_page.sendKeys(email);
			Assert.assertTrue(IncorrectEmail.isDisplayed());
	}
		
	}
	
	
}
