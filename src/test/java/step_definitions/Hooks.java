package step_definitions;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	// before hook runs before each scenario
	@Before
	public void setup() {
		Utils.Driver.getDriver().manage().window().maximize();
		Utils.Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	//After hooks runs after last step of scenario
	@After
	public void wrapUp(Scenario scenario) {
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) 
					Utils.Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "screenshot");
		}
		Utils.Driver.quitDriver();
		
	}
}
