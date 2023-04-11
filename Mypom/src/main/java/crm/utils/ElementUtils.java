package crm.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * A Class that holds all the Element Utilities that can used to perform
 * Operations on a WebPage The User needs to pass a instance of the WebDriver to
 * initialize it #Author: Sachin Joshi
 */
public class ElementUtils {
	private WebDriver driver;
	static WebDriverWait wait;
	
	public ElementUtils(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
		
	}

	public WebElement getElement(By locator) {

		/**
		 * Function to get the Webelement
		 * 
		 * @param By locator for the element returns the WebELement
		 */
		return driver.findElement(locator);
	}

	public WebElement getElementtobevisible(By locator) {

		/**
		 * Function to get the WebElement to be visible
		 * 
		 * @param By locator for the element returns the WebELement after waiting for
		 *           the element to be visible
		 */
		
		
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public Boolean wait_for_element_tobe_Invisible(By locator) {

		/**
		 * Function to get the WebElement to be Invisible
		 * 
		 * @param By locator for the element returns the WebELement after waiting for
		 *           the element to be visible
		 */
		
		
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public WebElement getElementtobeclickable(By locator) {

		/**
		 * Function to get the Webelement to be clickable
		 * 
		 * @param By locator for the element returns the WebELement to be clickable
		 */
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static List<WebElement> getallvisibleElements(By locator) {

		/**
		 * Function to get all the visible elements on the page
		 * 
		 * @param By locator for all the elements returns a list of webelements that are
		 *           visible on the webpage
		 */
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	public int total_elements_located(By locator) {

		/**
		 * Function to get all number of visible elements based on a locator
		 * @returns the number of elements visible
		 * 
		 * @param By locator for all the elements returns a list of webelements that are
		 *           visible on the webpage
		 */
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator)).size();
	}

	public boolean check_if_element_is_displayed(By locator) {

		/**
		 * Function to check if element is displayed or not
		 * 
		 * @param By locator for the element returns True or false to indicate if the
		 *           element is displayed or not
		 */
		return getElementtobevisible(locator).isDisplayed();
	}

	public boolean check_if_element_is_clickable(By locator) {

		/**
		 * Function to check if element is clickable or not
		 * 
		 * @param By locator for the element returns True or false to indicate if the
		 *           element is clickable or not
		 */
		return getElementtobeclickable(locator).isDisplayed();
	}

	public boolean check_for_text_in_element(By locator, String expected_value) {

		/**
		 * Function to do type on a webelement
		 * 
		 * @param By     locator for the element
		 * @param String expected_value , the string to expect on the WebElement returns
		 *               true or false indicating if the text is present in the Element
		 */
		return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, expected_value));
	}

	public void doSendKeys(By locator, String value) {
		/**
		 * Function to do type on a webelement
		 * 
		 * @param By     locator for the element
		 * @param String value , the string to be typed on the WebElement
		 */
		getElementtobeclickable(locator).clear();
		getElementtobeclickable(locator).sendKeys(value);
	}

	public void doClick(By locator) {

		/**
		 * Function to perform click on the element
		 * 
		 * @param By locator for the element
		 */
		getElementtobeclickable(locator).click();
	}
	public void doClear(By locator) {

		/**
		 * Function to perform clear on the element
		 * 
		 * @param By locator for the element
		 */
		getElementtobeclickable(locator).clear();
	}

	public String doGetElementText(By locator) {

		/**
		 * Function to get the text from the element
		 * 
		 * @param By locator for the element
		 */
		return getElementtobeclickable(locator).getText();
	}

	public String doGetAttributeValue(By locator, String attrName) {

		/**
		 * Function to get a attribute from the Webelement
		 * 
		 * @param By     locator for the element
		 * @param String attrName name of the attribute ex: name class text
		 */
		return getElement(locator).getAttribute(attrName);
	}

	public void doSelectDropdownByVisibleText(By locator, String text) {
		/**
		 * Function to select the element from the dropdown
		 * 
		 * @param By     locator for the element
		 * @param String text , Text of the element to be selected
		 */
		Select sel = new Select(getElementtobeclickable(locator));
		sel.selectByVisibleText(text);
	}

	public void doSelectDropdownByIndex(By locator, int index) {
		/**
		 * Function to select the element from the dropdown
		 * 
		 * @param By  locator for the element
		 * @param int index , index of the element to be selected from dropdown
		 */
		Select sel = new Select(getElementtobeclickable(locator));
		sel.selectByIndex(index);
	}

	public static List<String> getElementsTextList(By locator) {

		/**
		 * Function to get text of all the webelements matching the locator
		 * 
		 * @param By locator for all the elements returns a list of String of all the
		 *           Webelements located
		 */
		List<WebElement> elelist = getallvisibleElements(locator);
		List<String> eletextlist = new ArrayList<String>();
		for (WebElement e : elelist) {
			String text = e.getText();
			eletextlist.add(text);
		}
		return eletextlist;
	}
	
	public static boolean check_for_text_in_elements(By locator , String expected_text) {

		/**
		 * Function to get text of all the webelements matching the locator
		 * 
		 * @param By locator for all the elements returns a list of String of all the
		 *           Webelements located
		 */
		List<WebElement> elelist = getallvisibleElements(locator);
		List<String> eletextlist = new ArrayList<String>();
		for (WebElement e : elelist) {
			String text = e.getText();
			if(text.equals(expected_text))
			{
				return true;
				
			}
		}
		return false;
	}
	
	public static void click_element_with_matching_text(By locator , String expected_text) {

		/**
		 * Function to click on the element which has matching text compared to all List of elements
		 * 
		 * @param By locator for all the elements returns a list of String of all the
		 *           Webelements located
		 */
		List<WebElement> elelist = getallvisibleElements(locator);
		List<String> eletextlist = new ArrayList<String>();
		for (WebElement e : elelist) {
			String text = e.getText();
			System.out.println(text);
			if(text.equals(expected_text))
			{
				e.click();
				break;
			}
		}
	
	}
	public String dogetInstanceOfParentWindow() {
		/**
		 * Function to get instance of Parent window returns a String of active instance
		 * of window
		 */
		return driver.getWindowHandle();

	}
	public void hover_element(WebElement ele1)
	{
		/**
		 * function to hover on element 
		 */
		Actions act = new Actions(driver);
		act.moveToElement(ele1).perform();
		
		
	}
	public void doswitchToNewWindow(String new_window_instance) {
		/**
		 * Function to Switch to new window instance 
		 */
		
		Set<String> all_windows=driver.getWindowHandles();
		for(String winHandle : driver.getWindowHandles()){
		    if(driver.switchTo().window(winHandle).getTitle().equals(new_window_instance))
		    {
		    	System.out.println("Switched to window"+new_window_instance);
		    	break;
		    }
		}

		
	}
	
	/**
	 * function to get the page source
	 * @return
	 */
	public String dogetCurrentpagesource()
	{
		return driver.getPageSource();
	}
	
	/**
	 * Function to get title of active window/tab
	 */
	public String doGetWindoworTabTitle() {
		return driver.getTitle();
	}
	
	/**
	 * Function to get url of active window/tab
	 */
	public String doGetWindoworTabURL() {
		return driver.getCurrentUrl();
	}
	
	
	public boolean check_new_window_title(String expected_window_title) {
		/**
		 * Function to Switch to the newly opened window and check
		 * if the expected title matches to the current title 
		 */
		Set<String> all_windows=driver.getWindowHandles();
		if(all_windows.size()>1)
		{
			System.out.println("New window opened");
		}
		else
		{
			System.out.println("New window has not opened");
			return false;
		}
		for(String win:all_windows)
		{
			if(driver.switchTo().window(win).getTitle().equals(expected_window_title))
			{
				System.out.println("New window has the title "+expected_window_title);
				return true;
			}
		}
		return false;
	}

	/**
	 * Function to Switch back to parent/main window
	 */
	public void doswitchToParentWindow(String parent_window_instance) {

		driver.switchTo().window(parent_window_instance);
	}
	
	public boolean check_for_window_title(String expected_title)
	{
		/**
		 * Function to check for the window title to be equal to a expected title
		 * @params expected_title The expected title to wait for 
		 * @returns true if title is as expected
		 */
		return wait.until(ExpectedConditions.titleContains(expected_title));
	}

	/**
	 * Function to get instance of new child windows 
	 */
	public Set<String> dogetInstanceOfChildWindows() {

		Set<String> childWindows = driver.getWindowHandles();

		return childWindows;

	}
	
	/**
	 * Function to close child window
	 */
	public void docloseChildWindow() {
		driver.close();
	}

	/**
	 * Function to close all active browser window
	 */
	public void docloseAllWindow() {
		driver.quit();
	}
	
	
	/**
	 * Function to hard wait thread in milliseconds
	 * @param i in millisecond
	 */
	public void doWaitFor(int i) throws InterruptedException {
		Thread.sleep(i);
	}
	
	/**
	 * Function to accept or click Ok on pop up message
	 *  @author SJA433
	 *  
	 */
	public void doAcceptAlert() {
		waitForAlertPresentAndSwitch().accept();
	}
	
	/**
	 * Function to cancel or click cancel on pop up message
	 *  @author SJA433
	 *  
	 */
	public void doACancelAlert() {
		waitForAlertPresentAndSwitch().dismiss();
	}
	

	public List<WebElement> dogetElements(By locator) {

		/**
		 * Function to return list of WebElements
		 *  @param By  locator for the element
		 *  return list of WebElements
		 */
		List<WebElement> allLinks = driver.findElements(locator);

		return allLinks;
	}
	
	public String waitForUrlIs(String urlValue) {
		
		if(wait.until(ExpectedConditions.urlToBe(urlValue))) {
			return driver.getCurrentUrl();
		}
		else {
			System.out.println("expected url is not visible...");
			return null;
		}
	}
	
	/**
	 * Waits for the alert element to be present and 
	 * @returns the alert element
	 */
	public Alert waitForAlertPresentAndSwitch() {
		
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	/** Function to return text of the alert element
	 * @returns the text of the alert element
	 */
	
	public String getAlertText() {
		return waitForAlertPresentAndSwitch().getText();
	}
	
	/**
	 * Function to accept the alert element
	 */
	public void acceptAlert() {
		waitForAlertPresentAndSwitch().accept();
	}
	
	/**
	 * Function to dismiss the alert
	 */
	public void dismissAlert() {
		waitForAlertPresentAndSwitch().dismiss();
	}
	
	/**
	 * Function to type on alert
	 * @param value
	 */
	public void alertSendKeys(String value) {
		waitForAlertPresentAndSwitch().sendKeys(value);
	}
	
	

}
