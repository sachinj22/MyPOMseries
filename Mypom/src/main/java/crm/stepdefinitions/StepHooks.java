package crm.stepdefinitions;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import crm.utils.BrowserUtils;

public class StepHooks extends BrowserUtils{
	protected Properties prop;
	
	BrowserUtils br;
	@Before
	public void setup()
	{
		System.out.println("Inside Setup Hooks");
		br = new BrowserUtils();
		prop = br.initProp();
		driver = br.launch_browser(prop);
	}
	
	@After
	public void tearDown()
	{	
		System.out.println("Inside Quit hooks");
		driver.quit();
	}

}
