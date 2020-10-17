package com.qa.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.Testbase;

public class NewContact extends Testbase{
/*
 * Hello Hello Mr Adbul Ghani
 * 
 * 
 * */
	public NewContact() throws IOException {
		super();
	
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastname;

	@FindBy(xpath="//input[@placeholder='Email address']")
	WebElement email;
	
	@FindBy(xpath="//input[@class='search']")
	WebElement company;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement button;
	
	public void createNewContact(String category, String fn, String ln, String em)
	{
		//Select select = new Select(driver.findElement(By.name("category")));
		//select.selectByVisibleText(category);
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@name='category']")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@role='option']/span[text()='"+category+"']"));
		
		firstname.sendKeys(fn);
		lastname.sendKeys(ln);
		email.sendKeys(em);
		//company.sendKeys(comp);
		button.click();
	}

}
