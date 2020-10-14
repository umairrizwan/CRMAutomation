package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Testbase;

public class LoginPage extends Testbase{
	
	

	
	//Page Objects - OR[Object Repository
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	//@FindBy(xpath="//input[@type='submit']")
	//@FindBy(xpath="//a[contains(text(), 'Log In')]")
	@FindBy(xpath="//div[contains(text(), 'Login')]")
	WebElement loginBtn;
	
	//@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	@FindBy(xpath="//font[contains(text(),'crm')]")
	WebElement CRMimage;
	
	
	public LoginPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		
		//Initializing Page Objects
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateImage() 
	{
		return CRMimage.isDisplayed();
	}
	
	public HomePage validateLogin(String un, String pwd) throws IOException
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}

}
