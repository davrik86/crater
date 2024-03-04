	package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.Driver;

public class CraterItems {
	
	public CraterItems() {
		
	//default constructor
		PageFactory.initElements(Driver.getDriver(), this);
	}
	@FindBy (xpath="//a[text()=' Items']")
	public WebElement ItemSection;
	
	@FindBy (xpath="//button[contains(text(), \"\")][2]")
	public WebElement addItem;
	
	@FindBy (xpath="//input[@type='text' and starts-with(@class,'font-base')]")	
	public WebElement itemName;
	
	@FindBy (xpath= "//input[contains(@type,'tel')]")
	public WebElement itemPrice;
	
	@FindBy (xpath="//input[contains(@class,\"w-full absolute\")]")
	public WebElement itemUnit;
	
	@FindBy (xpath="//textarea[contains(@name,\"description\")]")
	public WebElement itemDiscription;
	
	@FindBy (xpath="//button[contains(@type,\"submit\")]")
	public WebElement itemSaveBttn;
	
	@FindBy (xpath="//h3[text()='Items']")
	public WebElement itemPage;
	
	@FindBy (xpath="//input[@type=\"checkbox\"][1]")
	public WebElement itemCheckbox;
	
	@FindBy (xpath="//input[@type=\"checkbox\"][1]")
	public WebElement itemSelectItemName;
	
	@FindBy (xpath="(//button[contains(@id, 'headlessui-menu-button')])[3]")//add 5 after button-
	public WebElement item3Dots;
	
	@FindBy (xpath= "//div[contains(@class,\"relative table-container\")]")
	public WebElement table;
	
	@FindBy (xpath ="//table[@class=\"min-w-full divide-y divide-gray-200\"]")
	public WebElement tablerow;
	
	@FindBy (xpath ="//a[text()=\"itemName\"]")
	public WebElement rowWItemName;
	
	@FindBy (linkText="Delete")
	public WebElement deliteBtn;
	
	@FindBy (xpath="//button[text()=\"Ok\"]")
	public WebElement alertOkBtn;
	
	@FindBy (xpath ="//*[text()='Books']")
	public WebElement itemBook;

	@FindBy (xpath="//a[text()= ' Edit']")
    public WebElement dot3EditBttn;	
	
	@FindBy (xpath="//h3[text()='Edit Item']")
    public WebElement editPage;
	
	@FindBy (xpath ="//nav[1]//ol")
    public WebElement homeItemtext;
    
	
}
