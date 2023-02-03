package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.NewWebElementListener;
import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebElementListener;

public class TestBase {
	public static Properties pro;
	public static WebDriver driver;
	@SuppressWarnings("deprecation")
	static EventFiringWebDriver e_driver;
	static WebElementListener listener;
	static NewWebElementListener listenerNew;

	public TestBase() {
		try {
			FileInputStream file = new FileInputStream(".\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			pro = new Properties();
			pro.load(file);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			// TODO: handle exception
		}catch (IOException e) {
			e.printStackTrace();
		}


	}

	public static void inilialization()
	{
		String browserName = pro.getProperty("browser");
		if(browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}

		/*
		 * With use of WebDriverEventListener interface
		 */

		e_driver = new EventFiringWebDriver(driver);
		//Now create object of eventListener class
		listener = new WebElementListener();
		e_driver.register(listener);
		driver = e_driver;

		/*
		 * With use of WebDriverListener interface
		 * uncomment to use it and comment above line with use of WebDriverEventListener
		 */

		//		listenerNew = new NewWebElementListener();
		//		driver = new EventFiringDecorator(listenerNew).decorate(driver);


		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));

		driver.get(pro.getProperty("url"));


	}
	//	
	//	public static void main(String[] args) {
	//		TestBase t=new TestBase();
	//		
	//	}

}
