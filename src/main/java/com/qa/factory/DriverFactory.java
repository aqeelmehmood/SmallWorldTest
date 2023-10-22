package com.qa.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
    private Properties properties;

	
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	// this method is used to initialize the thread local driver on the basis of given browser
	public WebDriver init_driver(String browser) throws IOException { 
		System.out.println("Browser value is "+browser);
	
	if(browser.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		tlDriver.set(new ChromeDriver());
		
	}
	else if(browser.equals("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		tlDriver.set(new FirefoxDriver());
	}
	else if(browser.equals("safari")) {
		//WebDriverManager.safariDriver().setup();
		tlDriver.set(new SafariDriver());
	}
	else {
		System.out.println("Please pass the correct browser"+browser);
	}
	getDriver().manage().deleteAllCookies();
	getDriver().manage().window().maximize();
	return getDriver();

	}
	// this is used to get the driver with thread local
	public static synchronized  WebDriver getDriver() {
		return tlDriver.get();
	}
}
