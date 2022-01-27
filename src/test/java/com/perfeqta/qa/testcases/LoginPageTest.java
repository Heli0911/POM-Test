package com.perfeqta.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.perfeqta.qa.base.TestBase;
import com.perfeqta.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
	}
	
	@Test(priority=2)
	public void LoginPageTitleTest() {
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "PERFEQTA");
	}
	
	@Test(priority=1)
	public void LoginTest() {
		loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
