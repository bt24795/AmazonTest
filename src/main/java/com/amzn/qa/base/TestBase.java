package com.amzn.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.amzn.qa.util.TestUtil;





public class TestBase {
	
	public static WebDriver driver;
	public static Properties p;
	public static DesiredCapabilities ch;
	

	
	public TestBase() throws IOException
	{
		FileInputStream f = new FileInputStream("D:\\Selenium_Class\\Selenium_WorkSpace\\AmazonTest\\src\\main\\java\\com\\amzn\\qa\\config\\config.properties");
		p = new Properties();
		p.load(f);		
	}
	
	public static void initialization() throws IOException
	{
		String browser= p.getProperty("browser");
		
		if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium_Class\\SeleniumJars\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		else if(browser.equals("chrome"))
		{
			//SSl certificates
			//Desired capabilities=
			//general chrome profile
			ch=DesiredCapabilities.chrome();
			//ch.acceptInsecureCerts();
			ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			driver = new ChromeDriver();	
		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		//driver.get(System.getProperty("url"));
		driver.get(p.getProperty("url"));
	}
}