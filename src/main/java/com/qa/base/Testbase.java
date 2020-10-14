package com.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.util.WebEventListener;

public class Testbase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver; 
	public static WebEventListener eventListener;
	
	public Testbase() throws IOException
	{
		prop = new Properties();
		FileInputStream inp = new FileInputStream("C:\\Users\\umair.rizwan\\eclipse-workspace\\POM_Project\\src\\main\\java\\com\\qa\\config\\config.properties");
		prop.load(inp);
		
	}

	
	public static void initialization() throws IOException
	{
	  String browser=	prop.getProperty("browser");
	  if(browser.equals("chrome"))
	  {
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\umair.rizwan\\Documents\\Umair Office data\\Selenium Learning\\chromedriver\\chromedriver.exe");
		  driver = new ChromeDriver();
	  }
	  
	  
	  e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
	  
	  driver.manage().window().maximize();
	  driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	  driver.manage().deleteAllCookies();
	  
	  driver.get(prop.getProperty("URL"));
	}
}
