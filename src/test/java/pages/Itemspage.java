package pages;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.Driver;

public class Itemspage {
	
	

	public Itemspage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	@FindBy (xpath = "//h3[text()='New Item']")
    public WebElement New_Item_text;
    
    @FindBy (xpath = "//div[@class='relative rounded-md shadow-sm font-base']/input")
    public WebElement items_input_page_name_box;
    
    @FindBy (xpath = "//input[@id='0']")
    public WebElement items_input_page_price_box;
    
    @FindBy (xpath = "//div[@tabindex='-1']/input")
    public WebElement items_input_page_unit_dropdown;
    
    @FindBy (xpath = "//span[text()='pc']")
    public WebElement items_input_page_unit_pc_option;
    
    @FindBy (name = "description")
    public WebElement items_input_page_description;
    
    @FindBy (xpath = "//button[text()=' Save Item']")
    public WebElement items_page_saveItem_btn;
  
    @FindBy (xpath = "//button[text()='Filter ']")
    public WebElement items_page_filter_btn;
    
    @FindBy (xpath = "//input[@name='name']")
    public WebElement items_page_filter_name_box;
    
    @FindBy (xpath = "(//td[contains(@class,'px-6 py-4 text-sm text-gray-500')]//button")
    public WebElement items_page_3dot_menu;
    
    @FindBy (xpath = "//a[text()=' Edit']")
    public WebElement items_page_3dot_edit_option;
    
    @FindBy (xpath = "//a[text()=' Delete']")
    public WebElement items_page_3dot_delete_option;
    
    @FindBy (xpath = "//h3[text()='Are you sure?']")
    public WebElement items_Input_delete_youSure_text;
    
    @FindBy (xpath = "//button[text()='Ok']")
    public WebElement items_page_delete_ok_btn;
    
    @FindBy (xpath = "//button[text()='Cancel']")
    public WebElement items_page_delete_cancel_btn;
    
    @FindBy (xpath = "//span[text()='No Results Found']")
    public WebElement items_Input_noResultFound_text;
    
    @FindBy (xpath = "//h3[text()='Edit Item']")
    public WebElement items_page_edit_item_headerText;
    
    @FindBy (xpath = "//button[text()=' Update Item']")
    public WebElement items_page_update_item_btn;
    
    @FindBy (xpath = "//h3[text()='Items']")
	public WebElement items_items_text;

    @FindBy (xpath="//p[text()='Succes!']")
	public WebElement itemsPageSuccessmsg;
    
    @FindBy (xpath ="//nav[1]//ol")
    public WebElement home_Itemtext;
    
    @FindBy (xpath="//button[text()=' Add Item']")
    public WebElement AddItemBTTN;
    
    @FindBy (xpath="//th[text()='Unit ']")
    public  WebElement TableUnit;
    
    @FindBy (xpath="//th[text()='Name ']")
    public  WebElement TableName;
    
    @FindBy (xpath="//th[text()='Price ']")
    public  WebElement TablePrice;
    
    @FindBy (xpath="//th[text()='Added On ']")
    public  WebElement Table_Add_On;
    
    @FindBy (xpath="//div[@variant='primary']")
    public  WebElement Table_Check_All_box;
    
    @FindBy (xpath="//button[@id='headlessui-menu-button-5']//*[name()='svg']")
    public WebElement Table_3Dot;
    
    @FindBy (xpath="//p[@class='text-sm text-gray-700']")
    public WebElement PaginationTxt;
    
    @FindBy (xpath="//span[normalize-space()='Next']")
    public WebElement Pagination_Next_BTTN;
    
    @FindBy (xpath="//a[contains(@class,'bg-white border-gray-300 text-gray-500 hover:bg-gray-50 relative inline-flex items-center px-4 py-2 text-sm font-medium border')]")
    public WebElement Pagination_last_numberBTTN;
    
    @FindBy (xpath="//span[text()='Previous']")
    public WebElement Pagination_Previous;
    
    @FindBy (xpath="//span[text()='1']")
    public WebElement Pagination_1stpage;
    
    @FindBy (xpath="//a[contains(@class,'disabled cursor')]//span")
    public WebElement Pagination_DisLeft;
    
    @FindBy (xpath="//nav")
    public WebElement newItemHoTeNewIt;
    
    @FindBy (xpath="//a[text()='Home']")
    public WebElement newItemHOMEtxt;
    
    @FindBy (xpath="//a[text()='Items']")
    public WebElement newItemITEMtxt;
    
    @FindBy (xpath="//a[text()='New Item']")
    public WebElement newItemNEWItemtxt;
    
    @FindBy (xpath="//div[contains(text(),'Name ')]")
    public WebElement newItemNameTab;
    
    @FindBy (xpath="//div[contains(text(),'Price')]")
    public WebElement newItemPriceTab;
    
    @FindBy (xpath="//div[contains(text(),'Description ')]")
    public WebElement newItemDescriptionTab;
        
    @FindBy (xpath="//div[contains(text(),'Unit')]")
    public WebElement newItemPriceUnit;
    
    
  
      
     
    
    
    
    
    
    
    
    
}



