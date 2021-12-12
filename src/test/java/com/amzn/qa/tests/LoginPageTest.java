package com.amzn.qa.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amzn.qa.base.TestBase;
import com.amzn.qa.pages.HomePage;
import com.amzn.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage  lp; 
	HomePage hp;
	public LoginPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void Setup() throws IOException 
	{
		initialization();
		lp= new LoginPage();
		
	}
	
	@Test(priority=1)
	public void LoginPageTitleTest()
	{
		String title = lp.ValidateTitlePage();
		Assert.assertEquals(title, "Amazon Sign In");
	}
	
	@Test(priority=2)
	public void ValidateImgTest()
	{
		boolean flag = lp.ValidateImgLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void LogInTest() throws IOException
	{
		
		hp= lp.login(p.getProperty("username"),p.getProperty("password"));
	}
	
	
	 
	@AfterMethod
	public void TearDown() 
	{
		driver.quit();
	}
	
	

}
