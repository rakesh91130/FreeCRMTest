package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase {
	LoginPage loginPage;
	ContactsPage contactPage;
	HomePage homePage;
	

	public ContactPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp()  {
		super.inilialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		String userName = pro.getProperty("username");
		String password = pro.getProperty("password");
		loginPage.login(userName, password);
		contactPage =homePage.clickOnContactsLinks();
	}

	//@Test(priority = 1)
	public void verifyContactPage() {
		Assert.assertTrue(contactPage.verifyContactLabel());
	}

	//@Test(priority = 2)
	public void selectSingleContactTest() {
		contactPage.selectContactByName("rakesh");
	}

	//@Test(priority = 3)
	public void selectMultipleContactTest() {
		contactPage.selectContactByName("rakesh kumar");
		contactPage.selectContactByName("UI test");
	}

	@DataProvider(name ="FreeCRMTestData")
	public Object[][] testData(){
		return TestUtil.getTestData("contacts");
	}

	@Test(priority = 4, dataProvider = "FreeCRMTestData" )
	public void validateCreateNewContact(String fName, String lName) {
		homePage.clickOnNewContactsLinks();
		driver.navigate().refresh();
		contactPage.createNewContact(fName, lName);

	}





	@AfterMethod
	public void tearDown() {
		driver.quit();
	}



}
