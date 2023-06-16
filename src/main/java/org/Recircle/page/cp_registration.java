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
	By Next_btn = By.xpath("//input[@id='primaryuser_details_next']");
	By IllustrationImage = By.xpath("//*[@id='for_form']//div//img");
	By Org_details_label = By.xpath("//h4[text()='Organisation Details']");

// Org details form
	By Registered_comp_name = By.xpath("//input[@id='name']");
	By DateofEstablishment = By.xpath("//input[@id='date_of_establishment']");
	By TypeofOrg = By.xpath("//span[@id='select2-organization_type-container']");
	By TypeofOrg_Partnership = By.xpath("//ul[@id='select2-organization_type-results']//li[6]");
	By GST_Img = By.xpath("//label[text()='GST Image']//parent::div//div[1]//span[1]");
	By GST_No = By.xpath("//input[@id='gst_number']");
	By PAN_Img = By.xpath("//label[text()='PAN Card Image ']//parent::div//div[1]//span[1]");
	By PAN_No = By.xpath("//input[@id='pan_number']");
	By Reg_Off_Address = By.xpath("//input[@id='register_address_field']");
	By Reg_Off_State = By.xpath("//select[@id='register_state_field']");
	By Reg_Off_City = By.xpath("//select[@id='register_city_field']");
	By Reg_Off_Pincode = By.xpath("//input[@id='register_pin_field']");
	By Mailing_Add_CheckBox = By.xpath("//input[@id='same_as_register_address']//parent::div");
	By Mailing_Address = By.xpath("//input[@id='mailing_address_field']");
	By Mailing_Add_State = By.xpath("//select[@id='mailing_state_field']");
	By Mailing_Add_City = By.xpath("//select[@id='mailing_city_field']");
	By Mailing_Add_Pincode = By.xpath("//input[@id='mailing_pin_field']");
	By Cancelled_Checqe_Img = By.xpath("//input[@name='cancelled_cheque_image']");
	By Bank_Name = By.xpath("//input[@id='bank_name_field']");
	By Acc_Holder_Name = By.xpath("//input[@id='acct_holder_name_field']");
	By Acc_No = By.xpath("//input[@id='acct_number_field']");
	By Confirm_Acc_No = By.xpath("//input[@id='confirm_acct_number_field']");
	By IFSC_Code = By.xpath("//input[@id='ifsc_code_field']");
	By Agreement_Img = By.xpath("//input[@name='agreement_image']");
	By Start_Date = By.xpath("//input[@id='start_date']");
	By End_Date = By.xpath("//input[@id='end_date']");
	By Org_Next_Btn = By.xpath("//input[@id='organization_details_next']");
	By Review_text = By.xpath("//h2[text()='Review']");
//1
	public String modulepage() {

		this.buttonClick(CP_Module);
		this.buttonClick(Partner_submodule);
		String checkText = this.checkText(Partners_label, 10);
		return checkText;
	}
//2
	public String addCP_form_page() {
		this.buttonClick(Add_CP_Button);
		this.buttonClick(popup_close_btn);
		String checkText = this.checkText(Add_CP_Text, 10);
		return checkText;
	}
//3
	public String primary_Userdetails_form() throws AWTException, InterruptedException {
		this.inputText(First_name, "Ram");
		this.inputText(Middle_name, " ");
		this.inputText(Last_Name, "sita");
		this.inputText(Contact_No, "8888822222");
		this.inputText(Alternate_Contact_No, "8374738738");
		this.inputText(Email, "berlin@yahoo.com");
		this.scrollDown();
		this.inputText(Designation, "CEO");
		this.inputText(Aadhar_No, "747473838838");
		this.mouseActionClick(Aadhar_frontview_image, 4);
		this.mouseActionClick(Aadhar_frontview_image, 4);
		Thread.sleep(2500);
		this.attachmentFile(System.getProperty("user.dir") + "\\Attachment_files\\tree-736885__480.jpg");
		if (this.conditionCheck(Aadhar_frontview_image_visible, 3)) {

		} else {
			do {
				this.mouseActionClick(Aadhar_frontview_image, 5);
				this.attachmentFile(System.getProperty("user.dir") + "\\Attachment_files\\tree-7	36885__480.jpg");
			} while (!this.conditionCheck(Aadhar_frontview_image_visible, 3));
		}
		Thread.sleep(1500);
		this.mouseActionClick(Aadhar_backview_image, 5);
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
		this.scrollDown();
		this.mouseActionClick(Next_btn, 5);
		if (!this.conditionCheck(Org_details_label, 5)) {
			do {
				this.mouseActionClick(Next_btn, 5);
			} while (!this.conditionCheck(Org_details_label, 5));
		}
		String checkText = this.checkText(Org_details_label, 10);
		return checkText;
	}
//4
	public String Org_Details_form() throws InterruptedException, AWTException {
		this.inputText(Registered_comp_name, "RamCo Cements");
		this.inputText(DateofEstablishment, "10/05/1995");
		this.buttonClick(TypeofOrg);
		this.buttonClick(TypeofOrg_Partnership);
		this.mouseActionClick(GST_Img, 4);
		this.mouseActionClick(GST_Img, 4);
		Thread.sleep(2500);
		this.attachmentFile(System.getProperty("user.dir") + "\\Attachment_files\\tree-736885__480.jpg");
			if (this.conditionCheck(GST_Img, 3)) {

			} else {
				do {
				this.mouseActionClick(GST_Img, 5);
				this.attachmentFile(System.getProperty("user.dir") + "\\Attachment_files\\tree-736885__480.jpg");
			} while (!this.conditionCheck(GST_Img, 3));
			}
			Thread.sleep(1500);
		this.inputText(GST_No, "18AABCU9603R1ZM");
		this.mouseActionClick(PAN_Img, 4);
		this.mouseActionClick(PAN_Img, 4);
		Thread.sleep(2500);
		this.attachmentFile(System.getProperty("user.dir") + "\\Attachment_files\\tree-736885__480.jpg");
			if (this.conditionCheck(PAN_Img, 3)) {

			} else {
				do {
				this.mouseActionClick(PAN_Img, 5);
				this.attachmentFile(System.getProperty("user.dir") + "\\Attachment_files\\tree-736885__480.jpg");
			} while (!this.conditionCheck(PAN_Img, 3));
			}
			Thread.sleep(1500);
			
		this.inputText(PAN_No, "ABCTU1234D");
		this.inputText(Reg_Off_Address, "Choolaimedu, chennai");
		this.dropdown(10, Reg_Off_State, 32);
		this.dropdown(10, Reg_Off_City, 2);
		this.inputText(Reg_Off_Pincode, "873487");
		this.buttonClick(Mailing_Add_CheckBox);
		this.inputText(Mailing_Address, "Egmore, chennai");
		this.dropdown(10,Mailing_Add_State, 32);
		this.dropdown(10,Mailing_Add_City, 2);
		this.inputText(Mailing_Add_Pincode, "737373");
		Thread.sleep(2500);
		this.attachmentFile(System.getProperty("user.dir") + "\\Attachment_files\\tree-736885__480.jpg");
			if (this.conditionCheck(Cancelled_Checqe_Img, 3)) {

			} else {
				do {
				this.mouseActionClick(Cancelled_Checqe_Img, 5);
				this.attachmentFile(System.getProperty("user.dir") + "\\Attachment_files\\tree-736885__480.jpg");
			} while (!this.conditionCheck(Cancelled_Checqe_Img, 3));
			}
		this.inputText(Bank_Name, "City Union Bank");
		this.inputText(Acc_Holder_Name, "Berlin");
		this.inputText(Acc_No, "123123123");
		this.inputText(Confirm_Acc_No, "123123123");
		this.inputText(IFSC_Code, "CUIB0000034");
		Thread.sleep(2500);
		this.attachmentFile(System.getProperty("user.dir") + "\\Attachment_files\\tree-736885__480.jpg");
			if (this.conditionCheck(Agreement_Img, 3)) {

			} else {
				do {
				this.mouseActionClick(Agreement_Img, 5);
				this.attachmentFile(System.getProperty("user.dir") + "\\Attachment_files\\tree-736885__480.jpg");
			} while (!this.conditionCheck(Agreement_Img, 3));
			}
		this.inputText(Start_Date, "16/06/2023");
		this.inputText(End_Date, "16/07/2023");
		this.buttonClick(Org_Next_Btn);
		String checkText = this.checkText(Review_text, 10);
		return checkText;
		}
}
