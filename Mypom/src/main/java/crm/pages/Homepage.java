package crm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import crm.utils.ElementUtils;

public class Homepage {

	
	private WebDriver driver;
	WebDriverWait wait;
	ElementUtils eleutil;
	
	
	By desktops = By.linkText("Desktops");
	By Show_all_desktops = By.linkText("Show All Desktops");
	
	public Homepage(WebDriver driver) {
		this.driver= driver;
		this.wait= new WebDriverWait(this.driver, Duration.ofSeconds(30));
		this.eleutil = new ElementUtils(this.driver);
	}
	public boolean check_desktops_visible()
	{
		return eleutil.check_if_element_is_displayed(desktops);
	}
	public void hover_and_click_all_desktops()
	{
		eleutil.hover_element(driver.findElement(desktops));
		eleutil.doClick(Show_all_desktops);
	}
}
