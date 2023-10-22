package stepdefinitions;



import org.junit.Assert;

import com.qa.factory.DriverFactory;
import com.swagpages.SwagLoginpage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	private static String link;
	private static String currentUrl;
	private SwagLoginpage loginPage = new SwagLoginpage(DriverFactory.getDriver());
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get("https://www.saucedemo.com/");
		
	    
	}

	@When("user get the link of the page")
	public void user_get_the_link_of_the_page() {
		 link = loginPage.getLoginPageLink();
		System.out.println("Login page link is "+ link);
		
	
	}

	@Then("Login page link should be {string}")
	public void login_page_link_should_be(String expectedLink) {
		Assert.assertTrue(link.contains(expectedLink));
	   
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
		loginPage.enterUsername(username);
	    
	}

	@When("user enters password {string}")
	public void user_enters_password(String pass) {
		loginPage.enterPass(pass);
	 
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
	    loginPage.clickOnLoginButton();
	}
	@Then("user gets the link of the home page")
	public void user_gets_the_link_of_the_home_page() {
		currentUrl =DriverFactory.getDriver().getCurrentUrl();
		
		//DriverFactory.getDriver().get("https://www.saucedemo.com/inventory.html");
		
	   
	}

	@Then("Home page link should be {string}")
	public void home_page_link_should_be(String expectedHomePageLink) {
		String expectedHomePageURL = "https://www.saucedemo.com/inventory.html"; // Replace with your expected home page URL
        Assert.assertEquals(expectedHomePageURL, currentUrl);
        // Compare the actual link to the expected link
      //  Assert.assertTrue(link.contains(expectedHomePageLink));
	   
	}



	



	

}
