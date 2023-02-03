package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[contains(text(),'Rakesh  kumar')]")
	WebElement userNameLabel;

	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement contactsLinks;

	@FindBy(xpath = "//span[contains(text(),'Deals')]")
	WebElement dealsLinks;

	@FindBy(xpath = "//span[contains(text(),'Tasks')]")
	WebElement tasksLinks;
	
	@FindBy(xpath = "//div[3]//button[@class='ui mini basic icon button']")
	WebElement newContactLink;




	//Actions

	public String getHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifyUserName() {
		return userNameLabel.isDisplayed();
	}

	public ContactsPage clickOnContactsLinks() {
		contactsLinks.click();
		return new ContactsPage();
	}

	public DealsPage clickOnDealsLinks() {
		dealsLinks.click();
		return new DealsPage();
	}

	public TasksPage clickOnTasksLinks() {
		tasksLinks.click();
		return new TasksPage();
	}

	public void clickOnNewContactsLinks() {
		Actions act = new Actions(driver);
		act.moveToElement(contactsLinks).perform();
		//act.moveToElement(newContactLink).click().perform();
		newContactLink.click();
		//driver.navigate().refresh();
	}






}
