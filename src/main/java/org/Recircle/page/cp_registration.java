package org.Recircle.page;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import baseClass.org.BaseClass;

public class cp_registration extends BaseClass {

	WebDriver driver;

	public cp_registration(WebDriver driver) {
		this.driver = driver;
	}

//CP module navigation
	By CP_Module = By.xpath("//aside[@id='sidebar']//li[7]");
	By Partner_submodule = By.xpath("//aside[@id='sidebar']//li[7]//ul//li[1]//a");
	By Partners_label = By.xpath("//div[@id='main-container']//div[1]//div[2]//div[1]//div[1]//h2");
//Add CP form navigation
	By Add_CP_Button = By.xpath("//div[@id='main-container']//div[1]//div[2]//div[1]//div[2]//button");
	By popup_close_btn = By.xpath(
			"//h5[@id='exampleModalLgLabel']//ancestor::div[@id='addcollectionpartnerinitial']//div[1]//div[1]//div//button[1]");
	By Add_CP_Text = By.xpath("//h2[text()='Add Collection Partner ']");
//Primary user details form
	By First_name = By.id("first_name");
	By Middle_name = By.id("middle_name");
	By Last_Name = By.id("last_name");
	By Contact_No = By.id("phone_number");
	By Alternate_Contact_No = By.id("alternate_phone_number");
	By Email = By.id("email");
	By Aadhar_frontview_image = By.xpath("//div[@id='addprimaryuserContainer']//div[5]//div[1]//div[1]//div[1]//span");
	By Aadhar_frontview_image_visible = By
			.xpath("//*[@id='addprimaryuserContainer']/div[5]/div[1]/div/div[2]/p/div/span");
	By Aadhar_backview_image = By.xpath("//input[@name='aadhar_card_image_back_view_field']//parent::div//span");
	By Aadhar_backview_image_visible = By
			.xpath("//*[@id='addprimaryuserContainer']/div[5]/div[2]/div/div[2]/p/div/span");
	By Aadhar_No = By.id("aadhaar_number");
	By Designation = By.id("designation");
	By Next_btn = By.id("primaryuser_details_next");
	By IllustrationImage = By.xpath("//*[@id='for_form']//div//img");
	By Org_details_label = By.xpath("//h4[text()='Organisation Details']");

	public String modulepage() {

		this.buttonClick(CP_Module);
		this.buttonClick(Partner_submodule);
		String checkText = this.checkText(Partners_label, 10);
		return checkText;
	}

	public String addCP_form_page() {
		this.buttonClick(Add_CP_Button);
		this.buttonClick(popup_close_btn);
		String checkText = this.checkText(Add_CP_Text, 10);
		return checkText;
	}

	public String primary_Userdetails_form() throws AWTException, InterruptedException {
		this.inputText(First_name, "Ram");
		this.inputText(Middle_name, " ");
		this.inputText(Last_Name, "sita");
		this.inputText(Contact_No, "8888822222");
		this.inputText(Alternate_Contact_No, "8374738738");
		this.inputText(Email, "berlin@yahoo.com");
		this.scrollDown(Designation, 10);
		this.inputText(Aadhar_No, "747473838838");
		this.inputText(Designation, "CEO");
		this.mouseActionClick(Aadhar_frontview_image, 4);
		this.mouseActionClick(Aadhar_frontview_image, 4);
		Thread.sleep(2500);
		this.attachmentFile(System.getProperty("user.dir") + "\\Attachment_files\\tree-736885__480.jpg");
		if (this.conditionCheck(Aadhar_frontview_image_visible, 3)) {

		} else {
			do {
				this.mouseActionClick(Aadhar_frontview_image, 5);
				this.attachmentFile(System.getProperty("user.dir") + "\\Attachment_files\\tree-736885__480.jpg");
			} while (!this.conditionCheck(Aadhar_frontview_image_visible, 3));
		}
		Thread.sleep(1500);
		this.mouseActionClick(Aadhar_backview_image, 5);
		Thread.sleep(1500);
		this.attachmentFile(System.getProperty("user.dir") + "\\Attachment_files\\tree-736885__480.jpg");
		if (this.conditionCheck(Aadhar_backview_image_visible, 3)) {

		} else {
			do {
				this.buttonClick(Aadhar_backview_image);
				this.attachmentFile(System.getProperty("user.dir") + "\\Attachment_files\\tree-736885__480.jpg");
			} while (!this.conditionCheck(Aadhar_backview_image_visible, 3));
		}
		this.scrollDown(IllustrationImage, 10);
		this.mouseActionClick(Next_btn, 5);
		String checkText = this.checkText(Org_details_label, 10);
		return checkText;

	}

}
