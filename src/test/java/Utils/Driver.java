package Utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

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
			case "saucelabs":
				ChromeOptions browserOptions = new ChromeOptions();
				browserOptions.setPlatformName("Windows 11");
				browserOptions.setBrowserVersion("latest");
				Map<String, Object> sauceOptions = new HashMap<>();
				sauceOptions.put("username", "oauth-davron.muminov-ca8b3");
				sauceOptions.put("accessKey", "7158a7d3-c976-44d8-b639-90b3d901c166");
				sauceOptions.put("build", "131313");
				sauceOptions.put("name", "Windows_11_chrome12");
				browserOptions.setCapability("sauce:options", sauceOptions);
				
				URL url;
				try {
					url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
					driver = new RemoteWebDriver(url, browserOptions);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
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
