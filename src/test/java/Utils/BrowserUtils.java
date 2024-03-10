package Utils;

import java.awt.datatransfer.StringSelection;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {
	
	
	Alert alert;
	WebDriverWait wait;
	Actions act;
	Select select;
	JavascriptExecutor js;
	
	
	public void waitUntilElementVisibleWithLocator(By locator) {
		wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	
	public void waitForElementToBeVisible(WebElement element) {
		wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementToBeInputed(WebElement element, String text) {
		wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	
	public void waitForAllElementsToBeVisible(List<WebElement> element) {
		wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	
	//This method tells the driver to wait until an element is clickable
	public void waitUntilElementClickable(WebElement element) {
		wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(7));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		}
	public void waituntilURLcontains(String url) {
		wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(7));
		wait.until(ExpectedConditions.urlContains(url));
	}
	public void waitUntilElementClickableWithLocator(By locator) {
		wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(7));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		}
	
	public void sendkeysWithActionsClass(WebElement element, String input) {
		act = new Actions(Driver.getDriver());
		act.sendKeys(element, input).build().perform();
	}
	
	public void moveToWithActionsClass(WebElement element) {
		act = new Actions(Driver.getDriver());
		act.moveToElement(element).build().perform();
	}
	
	public void clickWithActionsClass(WebElement element) {
		act = new Actions(Driver.getDriver());
		act.click(element).build().perform();
	}
	public void selectWithVisibleText(WebElement x, String value) {
		select = new Select(x);
		select.selectByVisibleText(value);
	}
	//this method works to get dropdown options to a List array
	public  List<String> addWebEltoList(WebElement dropdown, WebElement the_list) {
		dropdown.click();
		
        List<WebElement> options = select.getOptions();
        List<String> values = new ArrayList<>();
        for (WebElement option : options) {
            values.add(option.getText());
        }
        return values;
		
		
	}
	// this method generate 3 digit random number
	public int randomNumber() {
			Random rand = new Random();
			int randomNum = rand.nextInt((999 - 100) + 1) + 100;
			return randomNum;
		}
	//this method for creating random characters
	public String randomString(int numberof_charecters) {
		// Create a new Random object
        Random random = new Random();

        // Create a new StringBuilder object
        StringBuilder sb = new StringBuilder();

        // Generate 50 random characters and append them to the StringBuilder object
        for (int i = 0; i < numberof_charecters; i++) {
            int randomInt = random.nextInt(numberof_charecters); // Generate a random number between 0 and 25
            char randomChar = (char) (randomInt + 'a'); // Convert the random number to a character
            sb.append(randomChar);
        }

        // Convert the StringBuilder object to a String object
        String randomString = sb.toString();
        return  randomString;
	}
		
	
	
	
	
	
		// js executer highlight 
	public void highlightElement(WebElement element) throws InterruptedException {
		js=(JavascriptExecutor)Driver.getDriver();
		for (int i = 0; i < 3; i++) {
			js.executeScript("arguments[0].style.border='3px dotted red'", element);
			Thread.sleep(2000);
		}
	}
		//JS executed scroll to vire
	public void jsScrolltoView(WebElement element) {
		js = (JavascriptExecutor) Driver.getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public  void acceptAlert(WebDriver driver) {
		Alert alert= driver.switchTo().alert();
		alert.accept();
	}
	public  void canceltAlert(WebDriver driver) {
		Alert alert= driver.switchTo().alert();
		alert.dismiss();	
		
}
	public  void SendKeystAlert(WebDriver driver, String  input) {
		Alert alert= driver.switchTo().alert();
		alert.sendKeys(input);
	
	
}
	public  String GetMsgALert(WebDriver driver) {
		alert= driver.switchTo().alert();
		return alert.getText();
	}
	//you must click on web element before	

	public int dropdown_items_size(String path) {
	
		WebElement optionsCont= Driver.getDriver().findElement(By.xpath(path));
		List<WebElement> names= optionsCont.findElements(By.tagName("li"));
		int size= names.size();
		System.out.println("The number of options in dropdown is " + size);
	
	return size;
	}
	//compare values of two elements
	
	
}


