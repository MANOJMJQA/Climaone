package org.recircle.test;

import java.io.IOException;

import org.Recircle.page.Admin_Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.org.BaseClass;

public class CollectionPartner extends BaseClass {
	WebDriver driver;

	@BeforeClass
	public void beforelaunch() throws IOException {
		

		browserLaunch(getValidationfile("BrowserName"));
	}

	@AfterClass
	public void afterlaunch() {
//		quit();

	}

	@Test
	public void Login() throws IOException {
		Admin_Login login = PageFactory.initElements(driver, Admin_Login.class);
		login.Login();

	}

	
}
