package crm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import crm.utils.ElementUtils;

public class DesktopPage {

	
	private WebDriver driver;
	WebDriverWait wait;
	ElementUtils eleutil;
	
	
	By hp_lp = By.xpath("//a[contains(text(),'HP LP3065')]");
	By apple_add_cart = By.xpath("//a[contains(text(),'Apple Cinema 30\"')]");
	By cart = By.xpath("//div[@id='cart']");
	By view_cart = By.xpath("//strong[contains(text(),'View Cart')]");
	By add_to_cart = By.xpath("//button[@id='button-cart']");
	
	public DesktopPage(WebDriver driver) {
		this.driver= driver;
		this.wait= new WebDriverWait(this.driver, Duration.ofSeconds(30));
		this.eleutil = new ElementUtils(this.driver);
	}
	
	public boolean check_desktops_window()
	{
		return eleutil.check_for_window_title("Desktops");
	}
	public void click_desktop(String desktop_name)
	{
		switch (desktop_name) {
		case "Apple Cinema":
			eleutil.doClick(apple_add_cart);
			break;
		case "HP LP3065":
			eleutil.doClick(hp_lp);
			break;
		default:
			break;
		}
		
	}
	public boolean check_product_opened(String product_name)
	{
		return eleutil.check_for_window_title(product_name);
	}
	public void click_add_to_cart()
	{
		
		eleutil.doClick(add_to_cart);
	}
}
