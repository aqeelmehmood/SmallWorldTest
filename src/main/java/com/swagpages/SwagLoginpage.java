package com.swagpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SwagLoginpage {
	private WebDriver driver;
	
	// Create By locators
	private By username=By.id("user-name");
	private By password=By.id("password");
	private By loginButton=By.id("login-button");
	
	public SwagLoginpage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public String getLoginPageLink() {
		return driver.getCurrentUrl();
	}
	public void enterUsername(String Username) {
		driver.findElement(username).sendKeys(Username);
		
	}
	public void enterPass(String Pass) {
		driver.findElement(password).sendKeys(Pass);
	}
	public void clickOnLoginButton() {
		driver.findElement(loginButton).click();
	}
	//public String getHomePageLink() {
		//return driver.getCurrentUrl();
//	}
	
	
	

}
