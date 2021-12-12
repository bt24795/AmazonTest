package com.amzn.qa.pages;

import java.io.IOException;

import org.jsoup.helper.Validate;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amzn.qa.base.TestBase;

public class LoginPage extends TestBase {

	public LoginPage() throws IOException 
  {
		PageFactory.initElements(driver, this);
  }
  
		@FindBy(id="ap_email")
		WebElement UserName;
		
		@FindBy(id="continue")
		WebElement ContinueBtn;
		
		@FindBy(id="ap_password")
		WebElement Password;
		
		@FindBy(xpath="//a [@class='a-link-nav-icon']")
		WebElement ImgBtn;
		
		@FindBy(xpath="//input [@class='a-button-input']")
		WebElement SignInBtn;
		
	   public String ValidateTitlePage() 
	   {
		   return driver.getTitle();
	   }
		
		public boolean ValidateImgLogo() 
		{
			 return ImgBtn.isDisplayed();
		}
		
		public HomePage login(String un, String pwd) throws IOException
		{
			UserName.sendKeys(un);
			ContinueBtn.click();
			Password.sendKeys(pwd);
			SignInBtn.click();
			return new HomePage();
			
			
		}

		private Object HomePage() {
			// TODO Auto-generated method stub
			return null;
		} 
		
		

 
}

