package com.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Testbase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends Testbase{
	
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		 loginPage = new LoginPage();
	}
	
	
	@Test(priority=1)
	public void titlePageTest()
	{
		String title= loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	/*
	@Test(priority=2)
	public void logoImageTest()
	{
		boolean flag = loginPage.validateImage();
		Assert.assertTrue(flag);
	}*/
	
	@Test
	public void LoginTest() throws IOException
	{
		homePage= loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
