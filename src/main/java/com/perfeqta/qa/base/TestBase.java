package com.perfeqta.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.perfeqta.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\Heli Shah\\eclipse-workspace\\POMTest\\src\\main\\java\\com\\perfeqta\\qa\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException IO) {
			IO.printStackTrace();
		}
	}

	public static void initialization() {
		System.out.println(prop.getProperty("browser"));
		String browser = prop.getProperty("browser");

		if (browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Driver\\geckodriver.exe");
			driver= new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
		System.out.println(prop.getProperty("url"));
		driver.get(prop.getProperty("url"));
	
	}
}
