package com.perfeqta.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.perfeqta.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory (Object Repositories) :

	@FindBy(xpath = "//input[@name='username']")
	WebElement username;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//button[@class='pull-left login-btn']")
	WebElement signin;

	// Intializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();

	}

	public void Login(String Un, String PWD) {

		username.sendKeys(Un);
		password.sendKeys(PWD);
		signin.click();

	}
}
