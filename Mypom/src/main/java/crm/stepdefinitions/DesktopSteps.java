package crm.stepdefinitions;


import org.testng.Assert;

import crm.pages.DesktopPage;
import crm.pages.Homepage;
import crm.utils.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DesktopSteps extends BrowserUtils {
	
	Homepage hp; 
	DesktopPage dp = new DesktopPage(driver);;
	@Given("User opens opencart")
	public void user_opens_opencart() {
	
	    // Write code here that turns the phrase above into concrete actions
		try {
			BrowserUtils.open_url("https://naveenautomationlabs.com/opencart/");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("User opens open cart");
	}

	@Then("Desktops tab should be displayed")
	public void desktops_tab_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
		hp = new Homepage(driver);
		Assert.assertEquals(hp.check_desktops_visible(), true);
	    System.out.println("Desktops tab displayed");
	}

	@When("User clicks on Show all Desktops")
	public void user_clicks_on_show_all_desktops() {
	    // Write code here that turns the phrase above into concrete actions
		hp.hover_and_click_all_desktops();
	    System.out.println("Clicked Show all desktops");
	}

	@Then("All desktops are displayed")
	public void all_desktops_are_displayed() {
	    // Write code here that turns the phrase above into concrete actions
		
		Assert.assertEquals(dp.check_desktops_window(), true);
		System.out.println("All Desktop are displayed");
	}
	
	@Then("User clicks {string}")
	public void click_desktop(String desktop_name)
	{
		switch (desktop_name) {
		case "Apple Cinema":
			dp.click_desktop(desktop_name);
			break;
		case "HP LP3065":
			dp.click_desktop(desktop_name);
			break;
		default:
			break;
		}
	}
	@And("User can see the product opened {string}")
	public void user_views_product(String product_name)
	{
		dp.check_product_opened(product_name);
	}
	@Then("User can see desktop in cart")
	public void check_Desktop()
	{
		
	}

}
