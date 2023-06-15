package org.recircle.test;

import java.awt.AWTException;
import java.io.IOException;

import org.Recircle.page.Admin_Login;
import org.Recircle.page.cp_registration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.org.BaseClass;

public class CP_Registration extends BaseClass {

	WebDriver driver;

	@BeforeClass
	public void beforelaunch() throws IOException {

		browserLaunch(getValidationfile("BrowserName"));
	}

	@AfterClass
	public void afterlaunch() {
//	quit();
	}

	@Test(priority = 1)
	public void Login() throws IOException {
		Admin_Login login = PageFactory.initElements(driver, Admin_Login.class);
		String login2 = login.Login();
		System.out.println(login2);

	}

	@Test(priority = 2)
	private void cp_modulepage() {
		cp_registration CP_module = PageFactory.initElements(driver, cp_registration.class);
		String modulepage = CP_module.modulepage();
		System.out.println(modulepage);
	}

	@Test(priority = 3)
	private void Add_CP_form() {
		cp_registration Add_CP_form = PageFactory.initElements(driver, cp_registration.class);
		String addCP_form_page = Add_CP_form.addCP_form_page();
		System.out.println(addCP_form_page);
	}

	@Test(priority = 4)
	private void CP_PrimaryUser_form() throws AWTException, InterruptedException {
		cp_registration PrimaryUser = PageFactory.initElements(driver, cp_registration.class);
		String primary_Userdetails_form = PrimaryUser.primary_Userdetails_form();
		System.out.println(primary_Userdetails_form);

	}
}
