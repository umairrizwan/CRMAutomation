package com.qa.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Testbase;

public class HomePage extends Testbase{
	
	
	
	
	@FindBy(xpath="//span[contains(@class, 'ABC XUZ')]")
	WebElement LoginName; 
	
	//@FindBy(xpath="//span[text()='Contacts']")
	@FindBy(xpath="//span[@class='item-text' and text()='Contacts']")
	WebElement contacts;
	
	//@FindBy(xpath="//div[contains(text(), 'ABC XUZ')]")
	@FindBy(xpath="//span[text()='ABC XUZ']")
	//@FindBy(xpath="//span[@class='user-display']")
	WebElement userNameDisplayed;

	
	
	
	public HomePage () throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateHomepageTitle()
	{
		return driver.getTitle();
	}
	
	
	public Contacts clickOnContacts() throws IOException
	{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		contacts.click();
		
		return new Contacts();
			
	}
	
	public boolean userDisplayed() throws InterruptedException
	{
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);	
		return userNameDisplayed.isDisplayed();
	}
	

}
