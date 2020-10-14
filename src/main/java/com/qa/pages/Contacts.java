package com.qa.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Testbase;

public class Contacts extends Testbase{

	public Contacts() throws IOException {
		super();
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@class='ui header item mb5 light-black' and text()='Contacts']")
	WebElement contacts;
	
	//@FindBy(xpath="//td[text()='Nadia Khan']//preceding-sibling::td//div[@class='ui fitted read-only checkbox']")
	//WebElement Contactcheckbox;
	
	@FindBy(xpath="//button[@class='ui linkedin button']//i[@class='edit icon']")
	WebElement newButton;
	
	
	public boolean verifyContactspage() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);	
		return contacts.isDisplayed();
	}
	
	
	public void clickOnGridCheckbox(String name)
	{
		driver.findElement(By.xpath("//td[text()='"+name+"']//preceding-sibling::td//div[@class='ui fitted read-only checkbox']")).click();
	}
	
	public NewContact clickOnNewButton() throws IOException
	{
		newButton.click();
		return new NewContact();
	}
}
