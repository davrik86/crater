package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.BrowserUtils;
import Utils.Driver;

public class Customers_Page {
	BrowserUtils utils = new BrowserUtils();
	public Customers_Page(){
		PageFactory.initElements(Driver.getDriver(), this);
		
	}
	@FindBy (xpath="//a[text()=' Customers']")
	public WebElement dashboard_CUSTOMER_tab;
	
	@FindBy (xpath="//h3[text()='Customers']")
	public WebElement customer_Customer_title;
	
	@FindBy (xpath="//a[text()='Customers']")
	public WebElement customer_Customer_navgation_path;
	
	@FindBy (xpath="//a[text()='Home']")
	public WebElement customer_Home_navgation_path;
	
	@FindBy (xpath="//button[text()=' New Customer']")
	public WebElement customer_New_Customer_BTTN;
	
	@FindBy (xpath="//th[text()='Name ']")
	public WebElement customer_table_Name_cl;
	
	@FindBy (xpath="//th[text()='Phone ']")
	public WebElement customer_table_Phone_cl;
	
	@FindBy (xpath="//th[text()='Amount Due ']")
	public WebElement customer_table_AmountDue_cl;
	
	@FindBy (xpath="//th[text()='Added On ']")
	public WebElement customer_table_AddedOn_cl;
	
	@FindBy (xpath="//a[text()=' View']")
	public WebElement customer_table_3dot_View_BTTN;
	
	@FindBy (xpath="//h3[(text()='New Customer')]")
	public WebElement new_customer_title;
	
	@FindBy (xpath="//button[(text()=' Save Customer')]")
	public WebElement new_customer_SaveCust_BTTN;
	
	@FindBy (xpath="(//input[@name='name'])[1]")
	public WebElement new_customerBasic_DISP_name;
	
	@FindBy (xpath="(//div[@class='relative rounded-md shadow-sm font-base'])[2]/input")
	public WebElement new_customerBasic_Primary_Cont_Name;
		
	@FindBy (xpath="(//div[@class='relative rounded-md shadow-sm font-base'])[3]/input")
	public WebElement new_customerBasic_Email;
	
	@FindBy (xpath="(//div[@class='relative rounded-md shadow-sm font-base'])[4]/input")
	public WebElement new_customerBasic_Phone;
	
	@FindBy (xpath="(//div[@class='relative rounded-md shadow-sm font-base'])[5]/input")
	public WebElement new_customerBasic_Website;
	
	@FindBy (xpath="(//div[@class='relative rounded-md shadow-sm font-base'])[6]/input")
	public WebElement new_customerBasic_Prefix;
	
	@FindBy (xpath="(//input[@type='text'])[6]")//Need to check if it works
	public WebElement new_customerBasic_Curency;
	
	@FindBy (xpath="(//div[@class='w-full overflow-y-auto'])[1]")
	public WebElement new_customer_Basic_CurencyLS;
	
	@FindBy (xpath="(//div[@class='w-full overflow-y-auto'])[2]")// must be clicked before appearing
	public WebElement new_customer_Bil_CountryLS;
	
	@FindBy (xpath="//button[text()=' Copy from Billing']")
	public WebElement new_customer_Bill_Copy;
	
	
	@FindBy (xpath="(//div[@class='w-full overflow-y-auto'])[3]")// must be clicked before appearing
	public WebElement new_customer_Ship_CountryLS;
	
	@FindBy (xpath="(//div[@name='address_name']/input)[1]")
	public WebElement new_customer_titleBill_Name;	
	
	@FindBy (xpath="(//div[@name='address_name']/input)[2]")
	public WebElement new_customer_titleShipp_Name;	
	
	@FindBy (xpath="(//input[@type='text'])[9]")
	public WebElement new_customer_titleBil_Country;
	
	@FindBy (xpath="(//input[@type='text'])[15]")
	public WebElement new_customer_titleShip_Country;	 
	
	@FindBy (xpath="(//input[@name='billing.state'])[1]")
	public WebElement new_customer_titleBill_State;
	
	@FindBy (xpath="(//input[@name='shipping.state'])[1]")
	public WebElement new_customer_titleShip_State;
	
	@FindBy (xpath="(//input[@name='shipping.city'])[1]")
	public WebElement new_customer_titleShip_city;
	
	@FindBy (xpath="(//input[@name='billing.city'])[1]")
	public WebElement new_customer_titleBill_city;
	
	@FindBy (xpath="(//input[@name='phone'])[2]")
	public WebElement new_customer_titleBill_Phone;
	
	@FindBy (xpath="(//input[@name='phone'])[3]")
	public WebElement new_customer_titleShip_phone;
	
	@FindBy (xpath="(//input[@name='zip'])[1]")
	public WebElement new_customer_titleBill_zip;
	
	@FindBy (xpath="(//input[@name='zip'])[2]")
	public WebElement new_customer_titleShip_zip;
	
	@FindBy (xpath="//textarea[@name='billing_street1']")
	public WebElement new_customer_titleBill_billStreet1;
	
	@FindBy (xpath="//textarea[@name='billing_street2']")
	public WebElement new_customer_titleBill_billStreet2;
	
	@FindBy (xpath="//textarea[@name='shipping_street2']")
	public WebElement new_customer_titleShip_billStreet2;
	
	@FindBy (xpath="//textarea[@name='shipping_street1']")
	public WebElement new_customer_titleShip_billStreet1;
	
	@FindBy (xpath="//button[text()=' Copy from Billing']")
	public WebElement new_customer_title_Copy_fromBTTN;
	
	@FindBy (xpath="//span[text()='Field is required']")
	public WebElement Error_fieldIsRequiered;
	
	@FindBy (xpath="//span[text()='Name must have at least 3 letters.']")
    public WebElement Error_field_Name_must;
	
	@FindBy (xpath="(//div[@class='w-full overflow-y-auto'])[1]")
    public WebElement new_customer_Basic_CurencyLS1;
	
	
	//this method for validating the Web elimet to a string lenght error
		public void String_Lenght_Error_val(WebElement tgtEliment, String juststring) {
			int scenario_variable= Integer.valueOf(juststring);
			if(scenario_variable==0) {
				new_customer_SaveCust_BTTN.click();
				utils.waitForElementToBeVisible(Error_fieldIsRequiered);
				Assert.assertTrue(Error_fieldIsRequiered.isDisplayed());	
			}else if (scenario_variable>0 &&scenario_variable<3){
				String  message= utils.randomString(scenario_variable);
				new_customer_SaveCust_BTTN.click();
				tgtEliment.sendKeys(message);
				utils.waitForElementToBeVisible(Error_field_Name_must);
				Assert.assertTrue(Error_field_Name_must.isDisplayed());			
			}else if(scenario_variable>50) {
				String  message= utils.randomString(scenario_variable);				
				tgtEliment.sendKeys(message);				
				System.out.println("Name must be less than 50 characters");
			}else if(scenario_variable<50) {
				String  message= utils.randomString(scenario_variable);				
				tgtEliment.sendKeys(message);		
			}
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
} 
