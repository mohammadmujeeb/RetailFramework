package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;
	public static Properties properties;
	public Logger logger = LogManager.getLogger(this.getClass().getSimpleName());
	private static String log4JFilePath = System.getProperty("user.dir")
			+ "/src/test/resources/inputData/log4j.properties";
//	public ExtentSparkReporter reporter;
	//public ExtentReports extent;

	
	
	
	
	
//	public Scenario scenario;
//
//	public static String scenarioName;
//	
//	Date date = new Date();
//	SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss");
//	String reportName = " " + sdf.format(date).toString();
//	
//	public ExtentReports extent = getExtentReports("Retail Website Test" + reportName);
//	public ExtentTest test;
//	public ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
 
	
	
	
	
	
	
	
	public static void initializeDriver() throws IOException {
		properties = new Properties();
		String path = System.getProperty("user.dir") + "/src/test/resources/inputData/projectProperties.properties";

		FileInputStream fis = new FileInputStream(path);
		properties.load(fis);

		String browserName = properties.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

//		PropertyConfigurator.configure(log4JFilePath);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(getWaitTime(), TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(getPageLoadTime(), TimeUnit.SECONDS);

		driver.get(getURL());

	}

	public static String getURL() {
		String url = properties.getProperty("url");
		return url;
	}

	public static int getWaitTime() {
		int i = Integer.valueOf(properties.getProperty("implicitlyWait"));
		return i;
	}

	public static int getPageLoadTime() {
		int i = Integer.valueOf(properties.getProperty("pageLoadTimeOut"));
		return i;
	}

	public static void tearDown() {
		driver.close();
		driver.quit();
	}

	public static String getTestScreenshot(String methodName) throws IOException {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");

		String folderName = " " + sdf.format(date).toString();

		String destinationPath = System.getProperty("user.dir") + "/reports/" + "screenshots" + folderName + "/"
				+ methodName + ".png";
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(destinationPath);
		FileUtils.copyFile(sourceFile, destinationFile);

		return destinationPath;
	}

//	public ExtentReports getExtentReports(String methodName) {
//
//		Date date = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");
//		String folderName = " " + sdf.format(date).toString();
//
//		String path = System.getProperty("user.dir") + "/reports/" + "extentReports" + folderName + "/" + methodName
//				+ ".html";
//
//		reporter = new ExtentSparkReporter(path);
//		reporter.config().setReportName("Web Automation Results");
//		reporter.config().setDocumentTitle("Retail Website Test");
//
//		extent = new ExtentReports();
//		extent.attachReporter(reporter);
//		extent.setSystemInfo("Tester", "Mohammad Mujeeb");
//
//		return extent;
//	}
}
