package crm.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;


import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BrowserUtils {
	public static WebDriver driver;

	static ChromeOptions options;
	public Properties prop;
	public static Map <Object,Object> globalData = new HashMap<>();
	public static String highlight;
	public OptionsManager optionsManager;
	public WebDriver launch_browser(Properties prop)
	{	
		
		
		String browserName = prop.getProperty("browser").trim();
		System.out.println("Browser name is : " + browserName);
		
		highlight = prop.getProperty("highlight");

		optionsManager = new OptionsManager(prop);
		switch(browserName) {
		case "chrome":

			driver = new ChromeDriver(optionsManager.getChromeOptions());
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", "C:\\Users\\SJO243\\OneDrive - Maersk Group\\Documents\\driversdownload\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();

		default:
			System.out.println("Plz pass the right browser");
			break;
		}
		
		return driver;
		
	}
	public static void open_url(String url) throws Exception {
		System.out.println("Opening the URL"+url);
		if(url==null)
		{
			System.out.println("URL is null");
			throw new Exception("URL entered in null");
		}
		if(url.length()==0)
		{
			System.out.println("URL is blank");
			throw new Exception("URL entered in empty");
		}
		if(url.indexOf("http")!=0&& url.indexOf("https")!=0)
		{
			System.out.println("http(s) is missing in the URL");
			throw new Exception("HTTP(S) is missing");
		}
		driver.get(url);
	}
	public String get_page_title()
	{
		return driver.getTitle();
	}
	
	public Properties initProp() {
		prop = new Properties();
		try {
			String filePath = System.getProperty("user.dir") + "//resources//propertiesfile//testenv.properties";
			FileInputStream ip = new FileInputStream(filePath);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	
	
}

