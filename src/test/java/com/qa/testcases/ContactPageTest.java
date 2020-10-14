package com.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Testbase;
import com.qa.pages.Contacts;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class ContactPageTest extends Testbase{

	LoginPage loginpage;
	HomePage homepage;
	Contacts contactpage = new Contacts();
	
	public ContactPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setUp() throws IOException
	{
	  initialization();
	  loginpage = new LoginPage();
	  homepage = new HomePage();
	  
	  
	  homepage= loginpage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
	  contactpage= homepage.clickOnContacts();
	}
	
	
	@Test(priority=1)
	public void verifyContactPage() throws IOException, InterruptedException
	{
		
		boolean flag= contactpage.verifyContactspage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	public void clickOnDropdown()
	{
		contactpage.clickOnGridCheckbox("Nadia Khan");
		contactpage.clickOnGridCheckbox("Jalil Qadir");
		contactpage.clickOnGridCheckbox("Mubarak Ibrahim");
		contactpage.clickOnGridCheckbox("Umair Rizwan");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}


}
