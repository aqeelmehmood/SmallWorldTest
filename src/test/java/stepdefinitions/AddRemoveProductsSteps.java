package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.swagpages.AddRemoveProductCart;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddRemoveProductsSteps {
	
	private WebDriver driver;
    private AddRemoveProductCart addRemoveProductcart;
   // private Swag loginPage = new SwagLoginpage(DriverFactory.getDriver());
 //   private AddRemoveProductCart = new AddRemoveProductCart(DriverFactory.getDriver());
    
    public AddRemoveProductsSteps() {
        this.driver=DriverFactory.getDriver();
    	this.addRemoveProductcart = new AddRemoveProductCart(driver);
    	
    }
	
	
	
	@Given("the user is on the homepage")
	public void the_user_is_on_the_homepage() {
		addRemoveProductcart.visit();
	    
	}

	@When("the user adds a product to the cart")
	public void the_user_adds_a_product_to_the_cart() {
		addRemoveProductcart.addItem1ToCart();
		addRemoveProductcart.addItem2ToCart();
	    
	}

	@Then("the product should be in the cart")
	public void the_product_should_be_in_the_cart() {
		Assert.assertFalse(addRemoveProductcart.isCartEmpty());
		
	    
	}

	@When("the user removes the item from the cart")
    public void theUserRemovesTheItemFromTheCart() {
        addRemoveProductcart.removeItem();
    }

    @Then("the cart should be empty")
    public void theCartShouldBeEmpty() {
        Assert.assertTrue(addRemoveProductcart.isCartEmpty());
    }

}
