package stepdefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import invocation.BrowserInvoke;

public class Hooks extends BrowserInvoke {
	
	public static Scenario scenario;
	/**
	 * This method is used to open the browser
	 * 
	 * @author meghnak
	 * @param scenario
	 */
	@Before("")
	public void beforeFirst(Scenario scenario) {
		Hooks.scenario = scenario;
		scenario.log("***Open the browser***");
		finalDriver = BrowserInvoke.browserInitialise();
	}

	/**
	 * This method is used to close the browser
	 * scenario
	 *
	 * @author meghnak
	 * @param scenario
	 */
	@After
	public void afterFirst(Scenario scenario) {
		scenario.log("***Close the browser***");
		finalDriver.quit();
	}
}
