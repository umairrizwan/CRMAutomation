package com.qa.testcases;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Testbase;
import com.qa.pages.Contacts;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class HomePageTest extends Testbase{
	
	LoginPage loginpage;
	HomePage homepage;
	Contacts contactpage;

	public HomePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	@BeforeMethod
	public void setUp() throws IOException
	{
	  initialization();
	  loginpage = new LoginPage();
	  contactpage = new Contacts();
	  homepage= loginpage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void validateHomepageTitle()
	{
		String homepagetitle= homepage.validateHomepageTitle();
		Assert.assertEquals(homepagetitle, "Cogmento CRM","ERROR: Home page title is not matched");
	}
	
	 @Test(priority=2)
	 public void validateUserDisplayed() throws InterruptedException
	 {
		boolean flag= homepage.userDisplayed();
		Assert.assertTrue(flag);
	 }
	@Test(priority=3)
	public void clickonContacts() throws IOException
	{
	
		contactpage= homepage.clickOnContacts();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
