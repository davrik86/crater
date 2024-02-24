package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.Driver;

public class Dashboard {
public Dashboard() {
	PageFactory.initElements(Driver.getDriver(), this);
}

	@FindBy(linkText="//span[text()=]")
	public WebElement sometext;

	@FindBy (xpath="//span[text()='Amount Due']")
	public WebElement dashbordAmountDue;
	
	@FindBy (xpath="//a[@href='/admin/items']")
	public WebElement itemTab;



	
}
