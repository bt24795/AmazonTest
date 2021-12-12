package com.amzn.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amzn.qa.base.TestBase;

public class HomePage extends TestBase{

	public HomePage() throws IOException {
		
		PageFactory.initElements(driver, this);
	}
   @FindBy(xpath="//span[contains(text(), 'Hello, Parth')]")
   WebElement UserInfo;
   
   @FindBy(xpath="//a[contains(text(), 'Customer Service')]")
   WebElement CustomerServiceLink;
   
   @FindBy(xpath="//a[contains(text(), 'Deals Store')]")
   WebElement DealStoreLink;
   
   public String ValidateTitlePage() 
   {
	   return driver.getTitle();
   }
   
   public CustomercarePage clickonCustomerServiceLink() throws IOException
   {
	   CustomerServiceLink.click();
	   return new  CustomercarePage();
   }
   
   public DealStorePage clickonDealsLink() throws IOException
   {
	   DealStoreLink.click();
	   return new  DealStorePage();
   }
   
   
   
   
}
