package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement contactLable;
	@FindBy(name = "first_name")
	WebElement firstName;
	@FindBy(name = "last_name")
	WebElement lastname;
	@FindBy(xpath = "//button[@class='ui linkedin button']")
	WebElement saveBtn;



	public boolean verifyContactLabel() {
		return contactLable.isDisplayed();
	}

	public void selectContactByName(String name) {
		driver.navigate().refresh();
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]//parent::td//preceding-sibling::td//div")).click();
	}

	public void createNewContact(String fName, String lName) {
		firstName.sendKeys(fName);
		lastname.sendKeys(lName);
		saveBtn.click();
	}


}
