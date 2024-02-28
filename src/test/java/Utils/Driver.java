package Utils;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;



public class Driver {
		public static WebDriver driver;
		static ChromeOptions chromeOPtions;
		
		public static WebDriver getDriver() {
			String browserType = System.getProperty("browser");
			if (browserType == null) {
				browserType = DataReader.getProperty("browser_type");
		}
		if (driver==null || ((RemoteWebDriver)driver).getSessionId()==null) {
			switch(browserType) {
			case "chrome-headless" :
				chromeOPtions = new ChromeOptions();
				chromeOPtions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
				chromeOPtions.addArguments("--headless");
				driver= new ChromeDriver();
				break;
			case "chrome":
				driver= new ChromeDriver();
				break;
			case "firefox":
				driver= new FirefoxDriver();
				break;
			case "firefox-headless":
				FirefoxOptions firefoxOptions= new FirefoxOptions();
				firefoxOptions.addArguments("--headless");
				firefoxOptions.addArguments("--window-size=3840,2400");
				driver=new FirefoxDriver(firefoxOptions);
				break;
			case "safari":
				driver= new SafariDriver();
				break;
			case "edge":
				driver= new EdgeDriver();
				break;
			default:
				ChromeOptions Options= new ChromeOptions();
				Options.addArguments("--headless");
				driver= new ChromeDriver();
				break;
			}
		}
		return driver;
	}
		public static void quitDriver() {
			if(driver!=null) {
			driver.quit();
			driver=null;
		}
		}
}
