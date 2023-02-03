package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	//Iniatilzation of pageObject
	
	public LoginPage() {
		PageFactory.initElements(driver, this);

	}


	@FindBy(xpath = "/html/body/div[1]/header/div/nav/div[2]/div/div[2]/a")
	WebElement loginBtn;


	@FindBy(linkText = "Sign Up")
	WebElement signpBtn;
	
	
	@FindBy(name = "email")
	WebElement userName;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//div[contains(text(),'Login')]")
	WebElement submitBtn;
	
	
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();		
	}
	
	
	public String selectLogin() {
		loginBtn.click();
		String title =validateLoginPageTitle();
		return title;
	}
	
	public HomePage login(String uname, String pass) {
		loginBtn.click();
		userName.sendKeys(uname);
		password.sendKeys(pass);
		submitBtn.click();
		
		return new HomePage();//Landing page for login page will be home page
	}
	

}
