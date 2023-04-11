package crm.utils;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;

public class OptionsManager {

	
	private Properties prop;
	private ChromeOptions co;
	
	public OptionsManager(Properties prop) {
		this.prop = prop;
	}
	
	public ChromeOptions getChromeOptions() {
		co = new ChromeOptions();
		
		
		

		if (Boolean.parseBoolean(prop.getProperty("--Execute--Remote"))) {
			System.out.println(".....Fetching setting to run the tests remotely.......");
			co.addArguments("--no-sandbox");
			System.out.println("Setting No Sandbox env");
			co.addArguments("--window-size=1920,1080");
			System.out.println("Setting window size 1920 by 1080");
			co.addArguments("--disable-gpu");
			System.out.println("Setting Disable GPU option");
			co.addArguments("--disable-extensions");
			System.out.println("Disable extensions");
			co.setExperimentalOption("useAutomationExtension", false);
			System.out.println("Setting Automation extension as false");
			co.addArguments("--proxy-server='direct://'");
			System.out.println("Setting proxy direct");
			co.addArguments("--proxy-bypass-list=*");
			System.out.println("Setting proxy bypass list");
			co.addArguments("--headless");
			System.out.println("Setting headless");
			co.addArguments("--remote-allow-origins=*");
			System.out.println(".....Running the test by allowing remote origins.......");
		}
		if (Boolean.parseBoolean(prop.getProperty("incognito"))) {
			System.out.println(".....Running the test in Incognito mode.......");
			co.addArguments("--incognito");
		}
		if (Boolean.parseBoolean(prop.getProperty("--remote--allow-origins"))) {
			System.out.println(".....Running the test by allowing remote origins.......");
			co.addArguments("--remote-allow-origins=*");
		}
		if (Boolean.parseBoolean(prop.getProperty("dev-shm-usage"))) {
			System.out.println(".....Disabling dev shm usage.......");
			co.addArguments("--disable-dev-shm-usage");
		}
		
		if (Boolean.parseBoolean(prop.getProperty("maximize"))) {
			System.out.println(".....Running the test in maximized mode.......");
			co.addArguments("start-maximized");
		}
		if (Boolean.parseBoolean(prop.getProperty("ignore-cert-errors"))) {
			System.out.println(".....Running the test by ignoring cert errors.......");
			co.addArguments("--ignore-certificate-errors");
		}
		return co;
	}
}
