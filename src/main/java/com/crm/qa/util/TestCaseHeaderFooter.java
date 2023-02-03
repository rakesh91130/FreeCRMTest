package com.crm.qa.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestCaseHeaderFooter extends ExtentReporting{

	public static ExtentTest startFrameworkReports() {
		String reportPath = "Reports/ExtentReports";
		ExtentHtmlReporter hmtlReporter = null;
		try {
			String session  = System.getProperty("session");
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("dd_MM_YY");
			String sysDate = format.format(date);

			//extend logging file path setting

			File reportDir = new File(reportPath);
			System.out.println(reportDir.toString());
			if(!reportDir.exists()) {
				Boolean success = reportDir.mkdirs();
				System.out.println("create dir "+success);
			}

			
			//extentReports = new ExtentReports(reportDir+"Extent_Report_"+sysDate+"_.html");
			extentReports = new ExtentReports();

			if (session==null) {
				System.out.println(reportDir+"//Extent_Report_"+sysDate+"_.html");
				hmtlReporter = new ExtentHtmlReporter(reportDir+"//Extent_Report_"+sysDate+".html");	
			}
			else {
				System.out.println(reportDir+"//Extent_Report_"+sysDate+"_"+session+"_.html");
				hmtlReporter = new ExtentHtmlReporter(reportDir+"//Extent_Report_"+sysDate+"_"+session+".html");	
			}
			hmtlReporter.setAppendExisting(true);
			//ExtentSparkReporter spark  = new ExtentSparkReporter(reportDir+"//Extent_Report_"+sysDate+"_.html");


			extentReports.attachReporter(hmtlReporter);
			extentReports.setSystemInfo("userName", "rakesh kumar");
			extentReports.setSystemInfo("Company","Test");

			System.out.println(System.getProperty("module"));
			logger = extentReports.createTest(System.getProperty("module"));


		} catch (Exception e) {
			//throw new FlexFrameworkRuntimeException(e);
			e.printStackTrace();
		}

		return logger;
	}



	/***Method end extent reporting***/
	public static  void endFrameworkReports() {


		try {
			//			System.out.println(logger.getDescription());
			//			System.out.println(logger.getStartedTime().toString());
			//			System.out.println("project name "+extentReports.getProjectName());
			//	extentReports.endTest(logger);
			System.out.println("reached here");
			extentReports.flush();
			System.out.println("reached here1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



}
