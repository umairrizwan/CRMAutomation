package com.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.Testbase;
import com.qa.pages.Contacts;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.NewContact;
import com.qa.util.TestUtil;

public class NewContactTest extends Testbase{
    LoginPage loginpage;
    HomePage homepage;
    Contacts contactpage;
    NewContact newcontactpage = new NewContact();
    String Sheetname = "Contacts";
	
	public NewContactTest() throws IOException {
		super();
	
	}
	
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
		loginpage = new LoginPage();
		homepage = new HomePage();
		contactpage = new Contacts();
		
		homepage= loginpage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactpage= homepage.clickOnContacts();
		newcontactpage= contactpage.clickOnNewButton();
		
	}
	
	@DataProvider
	public Object[][] AddtestdatafromExcel()
	{
		Object[][] data = TestUtil.getTestData(Sheetname);
		return data;
	}
	
	@Test(priority=1, dataProvider = "AddtestdatafromExcel")
	public void addNewContact(String category, String firstname, String lastname, String email)
	{
		newcontactpage.createNewContact(category, firstname, lastname, email);
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
