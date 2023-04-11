package crm.utils;

import java.net.URL;
import java.time.Duration;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.deque.axe.AXE;

import io.cucumber.java.en.And;
import crm.utils.ElementUtils;

public class AccessblityUtils {
	/**
	 * A class that will hold the Accessibility testing related modules
	 * This util gives a list of WCAG violations on a given page
	 */
	
	WebDriver driver;
	
	public AccessblityUtils(WebDriver driver) {
		this.driver= driver;
	}
	public static URL scriptURL = AccessblityUtils.class.getResource("/axe.min.js");
	
	public void run_axe()
	{
		JSONObject reponsejson = new AXE.Builder(driver, scriptURL).analyze();
		JSONArray violations = reponsejson.getJSONArray("violations");
		
		if(violations.length()== 0)
		{
			System.out.println("No Accessblity violations found");
		}
		else
		{
			AXE.writeResults("Axe report", reponsejson);
		}
		
	}
}
