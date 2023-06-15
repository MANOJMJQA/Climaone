package org.Recircle.page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import baseClass.org.BaseClass;

public class Admin_Login extends BaseClass {

	WebDriver driver;

	public Admin_Login(WebDriver driver) throws IOException {
		this.driver = driver;

	}

//Login Locator
	By UserName = By.xpath("//label[text()='Phone Number']//parent::div//input");
	By PassWord = By.xpath("//input[@id='password']");
	By Login = By.xpath("//button[contains(text(),'Log in')]");
	By dashboard = By.xpath("//h2[text()='Dashboard']");
	
	// Login admin pannel
	public void Login(String value) throws IOException {
		if (value.equals("admin")) {
			this.url(getValidationfile("AdminURL"));
			this.inputText(UserName, getValidationfile("UserName"));
			this.inputText(PassWord, getValidationfile("password"));
			this.buttonClick(Login);
		}

		else if (value.equals("CP")) {

		}

	}

	public String dashboardCheck() {

		String text = this.checkText(dashboard, 10);
		return text;
		

	}

}
