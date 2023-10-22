package com.swagpages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AddRemoveProductCart {
	private WebDriver driver;
	
	private By addCartProduct1=By.id("add-to-cart-sauce-labs-backpack");
	private By addCartProduct2=By.id("add-to-cart-sauce-labs-bike-light");
	private By cart=By.xpath("//a[@class='shopping_cart_link']");
	private By removeProduct1=By.id("remove-sauce-labs-backpack");
	private By removeProduct2=By.id("remove-sauce-labs-bike-light");
	
	
	public AddRemoveProductCart(WebDriver driver) {
		this.driver=driver;
	}
	public void visit() {
        driver.get("https://www.saucedemo.com/inventory.html");
    }
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	public void addItem1ToCart() {
        driver.findElement(addCartProduct1).click();
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(addCartProduct1));
        element.click();
        

}
	public void addItem2ToCart() {
		 driver.findElement(addCartProduct2).click();
		
	}
	public boolean isCartEmpty() {
        try
        {
            driver.findElement(cart);
            return false;
        }
        catch (NoSuchElementException e) {
            return true;
        }
	
}
	public void removeItem() {
        WebElement itemInCart = driver.findElement(removeProduct1);
        WebElement removeButton = itemInCart.findElement(removeProduct2);
        removeButton.click();
    }
}
