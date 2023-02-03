package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactPage;
	DealsPage dealsPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		inilialization();
		loginPage = new LoginPage();
		String user = pro.getProperty("username");
		String pass = pro.getProperty("password");
		homePage = loginPage.login(user, pass);
	}


	@Test(priority = 1)
			//, retryAnalyzer = analyzer.RetryAnalyzer.class)
	public void verifyHomePageTitleTest() {
		String homeTitle = homePage.getHomePageTitle();
		Assert.assertEquals(homeTitle, "Cogmento CRM","Home page title not matched");
	}

	@Test(priority = 0)
	public void verifyUserNameTest() {
		Assert.assertTrue(homePage.verifyUserName());
	}

	@Test(priority = 3)
	public void verifyContactsLinksTest() throws InterruptedException {
		contactPage = homePage.clickOnContactsLinks();
	}

	@Test
	public void verifyDealsLinksTest() {
		dealsPage = homePage.clickOnDealsLinks();
	}



	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
