package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ListenerTests {
	
	@Test(priority = 1)
	public void test1() {
		Assert.assertEquals(true, false);
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(true, true);
	}

}
