package org.recircle.test;

import java.awt.AWTException;
import java.io.IOException;

import org.Recircle.page.Admin_Login;
import org.Recircle.page.po_creation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.org.BaseClass;

public class PurchaseOrderCreation extends BaseClass {
	
	WebDriver driver;

	@BeforeClass
	public void beforelaunch() throws IOException {

		browserLaunch(getValidationfile("BrowserName"));
	}

	@AfterClass
	public void afterlaunch() {
//		quit();

	}

	@Test(priority = 1)
	public void Login() throws IOException {
		Admin_Login login = PageFactory.initElements(driver, Admin_Login.class);
		login.Login("admin");
		String dashboardCheck = login.dashboardCheck();
		System.out.println(dashboardCheck);
	}
    @Test(priority=2)
	public void AddPo() {
		po_creation po = PageFactory.initElements(driver, po_creation.class);
		String addPo = po.addPo();
		System.out.println(addPo);

	}
    @Test(priority=3)
	public void ClickPo() {
		po_creation po = PageFactory.initElements(driver, po_creation.class);
		String clickPO = po.ClickPO();
		System.out.println(clickPO);

	}
    @Test(priority=4)
    public void resgistration() throws AWTException {
	    po_creation regis = PageFactory.initElements(driver, po_creation.class);
	    regis.poRegistration();
    	

	}
    
	
}
