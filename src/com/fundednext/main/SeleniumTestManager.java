package com.fundednext.main;

import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.Set;
import org.testng.Assert;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fundednext.report.ExtentReportsWithTestNG;

    public class SeleniumTestManager {
    	
    	ExtentReports extent = new ExtentReports();
    	ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport.html");
    	//	static WebDriver driver;
    	//	static ExtentReports report;
    	//	static ExtentTest test;
    	//static WebDriver driver = null;
    	WebDriver driver; 
    	
    @BeforeTest
	public static void main(String[] args) throws InterruptedException{
    	
    WebDriver driver = new ChromeDriver();		
	final String SERVER_URL = "https://lander.fundednext.com/";
	driver.get(SERVER_URL); 
	 
	//WebDriver driver = getFirefoxDriver(SERVER_URL); 
     
	//HistoryTest.updateHistoryTest(driver);
	//HomeTest.updateHomeTest(driver);
	//EmployeeTest.createEmployee(driver);
	//EmployeeTest.updateEmployee(driver);

	//login(driver);
	//ExtentReportsWithTestNG.createExtentReportsWithTestNG(driver);
  
	}

	private static void login(WebDriver driver) {
		try {
			Thread.sleep(2000);
			driver.findElement(By.id("email")).sendKeys("rubaet@bs.com");
			Thread.sleep(2000);
			driver.findElement(By.id("password")).sendKeys("rubaet1@R");
			Thread.sleep(2000);
			
			//driver.findElement(By.id("rc-anchor-container")).click();
			//Thread.sleep(2000);
			
			driver.findElement(By.className("bigger-110")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.className("user-info")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//span[contains(.,'Logout')]")).click();
			Thread.sleep(2000);
		    }
		    catch(Exception e) {
			e.printStackTrace();
			driver.quit();
		}
	}
	
	@Test
	private static WebDriver getChromeDriver(String serverUrl) throws InterruptedException {
		
			final String DRIVER_NAME = "webdriver.chrome.driver";
			System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
			//final String DRIVER_URL =  "F:\\My Work\\Work Tools\\Selenium\\selenium-java-3.141.59\\chromedriver_win32\\chromedriver.exe";
			
			//System.setProperty(DRIVER_NAME, DRIVER_URL);
			WebDriver driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(serverUrl);
		    
			System.out.println("Chrome driver found");
		    return driver;
	}
	
    private static WebDriver getFirefoxDriver(String serverUrl) {
		
			final String DRIVER_NAME = "webdriver.gecko.driver";
			//System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
			//final String DRIVER_URL = "F:\\My Work\\Selenium\\selenium-java-3.141.59\\chromedriver_win32\\geckodriver.exe";
			
			//System.setProperty(DRIVER_NAME, DRIVER_URL);
			WebDriver driver = new FirefoxDriver();
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(serverUrl);
		
		return driver;		
		
	}
    
    @AfterTest
	public void tearDownTest() {
		//close browser
		driver.close();
		driver.quit();
		System.out.println("Test Completed Successfully");
	}
	
}

    