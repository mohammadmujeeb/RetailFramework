package testRunner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features"},
		glue = {"stepDefinitions"},
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/"
				})

public class TestRunner {

}
//public class TestRunner extends AbstractTestNGCucumberTests {
//
//}


/*
 * Hi there fellow student, encountered this issue try changing your import of CucumberOptions in your TestRunner file from:
 * import io.cucumber.junit.CucumberOptions;  // If you want to run with junit, and import io.cucumber.testng.CucumberOptions; 
 * if you want to run with TestNGCucumber.xml file. More info with this issue on: 
 * https://stackoverflow.com/questions/57924656/io-cucumber-junit-cucumberoptions-vs-io-cucumber-testng-cucumberoptions-vs-cucum
 */