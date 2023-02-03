package com.crm.qa.util;

import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class CommonUtil extends ExtentReporting{

	public void ValidationFor2Fields(String expectedString, String actualString, String identifier, String validation, SoftAssert softAssert) {
		try {
		if(expectedString.trim().equals(actualString.trim())) {
			logger.log(Status.PASS, validation+" validation passed : "+identifier+" : "+"<b>"+actualString+"</b> validated successfully");
			logger.log(Status.PASS,MarkupHelper.createLabel(validation+" validation passed : "+identifier+" : "+"<b>"+actualString+"</b> validated successfully", ExtentColor.GREEN));
		}
		else {
			logger.log(Status.FAIL, validation+" validation failed : "+identifier+" : "+"<b>"+actualString+"</b> not matched with "+"<b>"+expectedString+"</b>");
			logger.log(Status.FAIL, MarkupHelper.createLabel(validation+" validation failed : "+identifier+" : "+"<b>"+actualString+"</b> not matched with "+"<b>"+expectedString+"</b>",ExtentColor.RED));
			softAssert.fail("Validation failed...");
		}
		}catch (Exception e) {
			e.printStackTrace();
			softAssert.fail("Validation failed...");
		}

	}
}
