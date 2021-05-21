package appHooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import core.Base;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class AppHooks extends Base {
	
	@After(order = 2)
	public void screenshotFail(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		} 
	}
	
	@After(order = 1) 
	public void screenshotPass (Scenario scenario) {
		if(scenario.getStatus().name().equalsIgnoreCase("PASSED")) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
		System.out.println(scenario.getStatus());
	}
	
	@After(order = 0)
	public void closeBrowser() {
		tearDown();
	}
}
