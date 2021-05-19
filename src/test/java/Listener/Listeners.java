//package Listener;
//
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//
//import core.Base;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
//
//
//
//
//public class Listeners extends Base implements ITestListener {
//
//	Date date = new Date();
//	SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss");
//	String reportName = " " + sdf.format(date).toString();
//	
//	ExtentReports extent = getExtentReports("Retail Website Test" + reportName);
//	ExtentTest test;
//	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
// 
////	String testName = scenarioName;
////
////	@Before
////	public String before(Scenario scenario) {
////		this.scenario = scenario;
////		String name = scenario.getName();
////		System.out.println("SCENARIO STARTED: " + name);
////		return name;
////	}
//	
//	@Override
//	public void onTestStart(ITestResult result) {
////		String testName = result.getMethod().getMethodName();
//		String testName = result.getTestClass().getName();
//
//		test = extent.createTest(testName);
//		extentTest.set(test);
//	}
//	
//	
//	@Override
//	public void onTestSuccess(ITestResult result) {
//		extentTest.get().log(Status.PASS, "Test Passed");
//	}
//	
//	
//	@Override
//	public void onTestFailure(ITestResult result) {
//
//		extentTest.get().fail(result.getThrowable());
//		
//		String testName = result.getMethod().getMethodName() + "." + new Date().toString();
//		try {
//			extentTest.get().addScreenCaptureFromPath(getTestScreenshot(testName), testName);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	
//	@Override
//	public void onFinish(ITestContext context) {
//		extent.flush();
//	}
//}
