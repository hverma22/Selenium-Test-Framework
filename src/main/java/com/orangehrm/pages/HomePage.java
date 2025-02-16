package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangehrm.actiondriver.ActionDriver;
import com.orangehrm.base.BaseClass;

public class HomePage {

	private ActionDriver actionDriver;

	// Define locators using By class
	private By adminTab = By.xpath("//span[text()='Admin']");
	private By userIDButton = By.className("oxd-userdropdown-name");
	private By logoutButton = By.xpath("//a[text()='Logout']");
	private By oranageHRMlogo = By.xpath("//div[@class='oxd-brand-banner']//img");
	
	private By pimTab = By.xpath("//span[text()='PIM']");
	private By employeeSearch = By.xpath("//label[text()='Employee Name']/parent::div/following-sibling::div/div/div/input");
	private By searchButton = By.xpath("//button[@type='submit']");
	private By emplFirstAndMiddleName = By.xpath("//div[@class='oxd-table-card']/div/div[3]");
	private By emplLastName = By.xpath("//div[@class='oxd-table-card']/div/div[4]");

	// Initialize the ActionDriver object by passing WebDriver instance
	/*
	 * public HomePage(WebDriver driver) { this.actionDriver= new
	 * ActionDriver(driver); }
	 */

	public HomePage(WebDriver driver) {
		this.actionDriver = BaseClass.getActionDriver();
	}

	// Method to verify if Admin tab is visible
	public boolean isAdminTabVisible() {
		return actionDriver.isDisplayed(adminTab);
	}

	public boolean verifyOrangeHRMlogo() {
		return actionDriver.isDisplayed(oranageHRMlogo);
	}
	
	//Method to Navigate to PIM tab
	public void clickOnPIMTab() {
		actionDriver.click(pimTab);
	}
	
	//Employee Search
	public void employeeSearch(String value) {
		actionDriver.enterText(employeeSearch, value);
		actionDriver.click(searchButton);
		actionDriver.scrollToElement(emplFirstAndMiddleName);
	}
	
	//Verify employee first and middle name
	public boolean verifyEmployeeFirstAndMiddleName(String emplFirstAndMiddleNameFromDB) {
		return  actionDriver.compareText(emplFirstAndMiddleName, emplFirstAndMiddleNameFromDB);
	}
	
	//Verify employee first and middle name
	public boolean verifyEmployeeLastName(String emplLastFromDB) {
		return  actionDriver.compareText(emplLastName, emplLastFromDB);
	}

	// Method to perform logout operation
	public void logout() {
		actionDriver.click(userIDButton);
		actionDriver.click(logoutButton);
	}
}
