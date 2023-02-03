package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.CommonUtil;
import com.crm.qa.util.TestCaseHeaderFooter;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	CommonUtil util = new CommonUtil();
	static TestCaseHeaderFooter testCaseHeaderFooter = new TestCaseHeaderFooter();
	SoftAssert softAssert = new SoftAssert();

	public LoginPageTest() {
		super(); //To call super call constructor
	}
	@BeforeMethod
	public void setUp() {
		inilialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		try {
			System.setProperty("module","<br>"+this.getClass().getSimpleName());
			TestCaseHeaderFooter.startFrameworkReports();
			String title = loginPage.validateLoginPageTitle();
			util.ValidationFor2Fields(title, "#1 Free CRM Software for every business", "Login page", "Title", softAssert);
			Assert.assertEquals(title, "Free CRM Software for every business");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			TestCaseHeaderFooter.endFrameworkReports();
			softAssert.assertAll();
		}
	}


	//	@Test(priority = 2)
	//	public void SelectionOfLoginPage() {
	//		String titleLogin = loginPage.selectLogin();
	//		Assert.assertEquals(titleLogin, "Cogmento CRM");
	//	}

	//@Test(priority = 2)
	public void login() {
		String user = pro.getProperty("username");
		String pass = pro.getProperty("password");
		homePage = loginPage.login(user, pass);
	}




	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
