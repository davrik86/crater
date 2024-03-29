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
	
	@FindBy (xpath="//button[text()=' Save Customer']")
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
	
	@FindBy (xpath="//p[text()='Would you like to allow this customer to login to the Customer Portal?']")
	public WebElement Toggle_Switch_txt;
	
	@FindBy (xpath="//div[text()='Customer Portal Login URL ']")
	public WebElement Toggle_On_text;
	
	@FindBy (xpath="//span[text()='http://crater.primetech-apps.com/xyz/customer/login']")
	public WebElement Toggle_URL;
	
	@FindBy (xpath="//p[text()='Copied url to clipboard!']")
	public WebElement Toggle_Clip_copy_successmsg;
	
	@FindBy (xpath="//span[contains(text(),'Please copy & forward the ')]")
	public WebElement Toggle_txt_beloweURL;
	
	@FindBy (xpath="//input[@name='password']")
	public WebElement Toggle_Password_field;
	
	@FindBy (xpath="//input[@name='confirm_password']")
	public WebElement Toggle_Password_Conf_field;
	
	@FindBy (xpath="//input[@name='password' and @type='text']")
	public WebElement Toogle_Pass_TXT;
	
	@FindBy (xpath="//input[@name='confirm_password' and @type='text']")
	public WebElement Toogle_Pass__ConfTXT;
	
	@FindBy (xpath="//span[text()='Passwords must be identical']")
	public WebElement Toogle_Pass__ERR_notmatch;
	
	@FindBy (xpath="//span[text()='Password must contain 8 characters']")
	public WebElement Toogle_Pass__ERR_musthave8Char;	
	
	@FindBy (xpath="(//div[@class='absolute inset-y-0 right-0 flex items-center pr-3'])[2]")
	public WebElement Toogle_Pass__EyeBTTN;
	
	@FindBy (xpath="(//div[@class='absolute inset-y-0 right-0 flex items-center pr-3'])[3]")
	public WebElement Toogle_Pass_Confrm__EyeBTTN;	
	
	@FindBy (xpath="//*[name()='rect' and contains(@width,'37')]")
	public WebElement Toggle_URL_copy_BTTN;
	
	@FindBy (xpath="//button[@modelvalue='false']")
	public WebElement Toggle_Off_BTTN;
	
	@FindBy (xpath="//button[@role='switch']")
	public WebElement Toggle_On_BTTN;
	
	@FindBy (xpath="//span[text()='Field is required']")
	public WebElement Error_fieldIsRequiered;
	
	@FindBy (xpath="//span[text()='Name must have at least 3 letters.']")
    public WebElement Error_field_Name_must;
	
	@FindBy (xpath="(//div[@class='w-full overflow-y-auto'])[1]")
    public WebElement new_customer_Basic_CurencyLS1;
	
	@FindBy (xpath="//h6[text()=' Sales & Expenses']")
	public WebElement Sales_expense_title;
	
	@FindBy (xpath="//h6[text()='Basic Info']")
	public WebElement Sales_expense_BasicInfo;
	
	@FindBy (xpath="//label[text()='Display Name']")
	public WebElement Sales_expense_BasicInfo_DisplayName;
	
	@FindBy (xpath="//label[text()='Primary Contact Name']")
	public WebElement Sales_expense_BasicInfo_PrimConName;
	
	@FindBy (xpath="//label[text()='Email']")
	public WebElement Sales_expense_BasicInfo_Email;
	
	@FindBy (xpath="//label[text()='Currency']")
	public WebElement Sales_expense_BasicInfo_Curency;
	
	@FindBy (xpath="//label[text()='Phone Number']")
	public WebElement Sales_expense_BasicInfo_Phone;
	
	@FindBy (xpath="//label[text()='Website']")
	public WebElement Sales_expense_BasicInfo_Website;
	
	
	
	
	
	
	
	//this method for validating the Web elimet to a string lenght error
		public void String_Lenght_Error_val(WebElement tgtEliment, String juststring) {
			int scenario_variable= Integer.valueOf(juststring);
			if(scenario_variable==0) {
				new_customer_SaveCust_BTTN.click();
				utils.waitForElementToBeVisible(Error_fieldIsRequiered);
				Assert.assertTrue(Error_fieldIsRequiered.isDisplayed());	
			}else if (scenario_variable>0 &&scenario_variable<3){
				String  message= utils.RandomStringGen(scenario_variable);
//				new_customer_SaveCust_BTTN.click();
				tgtEliment.sendKeys(message);
				utils.waitForElementToBeVisible(Error_field_Name_must);
				Assert.assertTrue(Error_field_Name_must.isDisplayed());			
			}else if(scenario_variable>50) {
				String  message= utils.RandomStringGen(scenario_variable);		
				tgtEliment.sendKeys(message);				
				System.out.println("Name must be less than 50 characters");
			}else if(scenario_variable<50) {
				String  message= utils.RandomStringGen(scenario_variable);			
				tgtEliment.sendKeys(message);		
			}
		}
	
		public void String_Lenght_Error_valNO_BTTN(WebElement tgtEliment, String juststring) {
			int scenario_variable= Integer.valueOf(juststring);
			if(scenario_variable==0) {				
				utils.waitForElementToBeVisible(Error_fieldIsRequiered);
				Assert.assertTrue(Error_fieldIsRequiered.isDisplayed());	
			}else if (scenario_variable>0 &&scenario_variable<8){
				String  message= utils.RandomStringGen(scenario_variable);				
				tgtEliment.sendKeys(message);
				utils.waitForElementToBeVisible(Toogle_Pass__ERR_musthave8Char);
				Assert.assertTrue(Toogle_Pass__ERR_musthave8Char.isDisplayed());			
			}else if(scenario_variable>8) {
				String  message= utils.RandomStringGen(scenario_variable);		
				tgtEliment.sendKeys(message);				
						
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
		}}
