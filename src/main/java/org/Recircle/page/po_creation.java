package org.Recircle.page;

import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.awt.Robot;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import baseClass.org.BaseClass;

public class po_creation extends BaseClass {
	WebDriver driver;

	public po_creation(WebDriver driver) {
		this.driver = driver;
	}

	String BrandNumber = RandomStringUtils.randomNumeric(6);
	By purchaseOrder = By.xpath("//a[contains(text(),'Purchase Orders')]");
	By textPO = By.xpath("//h2[text()='Purchase Order']");
	By AddPO = By.xpath("//div[@id='main-container']//div[1]//div[3]//div[1]//div[2]//button");
	By AddpoText = By.xpath("//div[@id='main-container']//div[2]//div[1]//div[1]//div[1]//h2");
	By CompanyNext = By.xpath("//input[@id='company_details_next']");
	By Spinner = By.xpath("//*[@id='recircle-loader' and contains(@class,'d-none')]");

//From Field Filling

	By CompanyName = By.xpath("//span[@id='select2-brand-container']");
	By CompanyNameList = By.xpath("//ul[@id='select2-brand-results']//li[2]");
	By CertificateName = By.xpath("//input[@id='name_on_certificate']");

	By GSTIN = By.xpath("//input[@id='gstin']");
	By BrandPoNumber = By.xpath("//input[@id='original_po_number']");
	By StartDate = By.id("start_date");
	By EndDate = By.id("end_date");
	By ContactPerson = By.id("contact_person");
	By ContactNumber = By.id("contact_person_number");
	By VendorCode = By.id("supplier_no");
	By Billto = By.id("bill_to");
	By ShipTo = By.id("ship_to");
	By SendInvoiceTo = By.id("send_invoice_to");
	By PaymentTerms = By.id("payment_terms");
	By ShippingTerms = By.id("shipping_terms");
	By ListDocument = By.xpath("//*[@id='667a1a85-b595-44f8-9722-84205bd417ba']//parent::div[1]//child::label");
	By ListCheckbox = By.xpath(
			"//*[@id='667a1a85-b595-44f8-9722-84205bd417ba' and contains(@class,'border-danger')]//parent::div[1]//child::label");

	By UploadPO = By.xpath("//*[@id='upload']//parent::div[@id='upload_button_div_1']//span");
	By UploadPOView = By.xpath("//*[@id='original_po_pdf_filename']");
	By NextButton = By.id("company_details_next");
	By LineItemLabel = By.xpath("//*[@id='line_items_fieldset']/div/h4");

//Line Item
	By Line_Number = By.id("line_item_id");
	By State = By.id("location_state");
	By City = By.id("location_city");
	By Material_Type = By.id("quality_group");
	By Material_Category = By.id("quality_parent");
	By Material_Sub_Type = By.id("quality_child");
	By Quantity = By.id("quantity");
	By Rate_Kg = By.id("price");
	By Save_Line_Item = By.id("savelineitem");
	By Line_Item_Details = By.xpath("//table[@id='lineItemTable']//tbody//tr//td[1]");
	By LinePageNext = By.xpath("//input[@id='polineitem_details_next']");
	By AdditonalDetails = By.xpath("//form[@id='msform']//div[1]//fieldset[3]//h4");

	// Additional details
	By Notes = By.id("notes");
	By SupportingDocuments = By.xpath("//div[@id='upload_button_div_2']//span");
	By SupportingDocumentsCheck = By.xpath("//span[@id='supporting_file_filename']");
	By adddtionalDetailsNext = By.id("add_details_next");

	// Review page
	By AddPurchaseOrder = By.id("add_purchase_order_submit");
    By PopUpTextCheck = By.xpath("//h2[@id='popup_po_head']");
    By PopUpButton = By.xpath("//h2[@id='popup_po_head']//parent::div//following::div[1]//input[@value='Purchase Orders']");
	

	public String addPo() {
		this.buttonClick(purchaseOrder);
		if (!this.conditionCheck(textPO, 10)) {
			do {
				this.buttonClick(purchaseOrder);
			} while (!this.conditionCheck(textPO, 10));
		}
		String checkText = this.checkText(textPO, 5);
		return checkText;

	}

	public String ClickPO() {
		this.buttonClick(AddPO);
		String text = this.checkText(AddpoText, 10);
		return text;

	}

	public void companyDetailsForm() throws AWTException, InterruptedException {

		this.buttonClick(CompanyName);
		this.buttonClick(CompanyNameList);
		this.inputText(CertificateName, "FUllRUN");
		this.inputText(GSTIN, "24AABCU9603R1ZT");
		this.inputText(BrandPoNumber, BrandNumber);
		this.inputText(StartDate, "12/05/2023");
		this.inputText(EndDate, "24/05/2023");
		this.inputText(ContactPerson, "MjAutomation");
		this.inputText(ContactNumber, "9876543210");
//        this.inputText(VendorCode, "8787");
//        this.inputText(Billto, "cxxxxxx");
//        this.inputText(ShipTo, "yyyyyy");
//        this.inputText(SendInvoiceTo, "nungambakkam");
		this.scrollDown1(5);
		this.inputText(PaymentTerms, "test");
		this.inputText(ShippingTerms, "test");
		Thread.sleep(2000);
		this.mouseActionClick(ListDocument, 10);
		if (!this.invisibleConditionCheck(ListCheckbox, 10)) {
			do {
				this.mouseActionClick(ListDocument, 10);
			} while (!this.invisibleConditionCheck(ListCheckbox, 10));
		}
//        this.buttonClick(ListDocument);
//        this.buttonClick(ListDocument);

		this.mouseActionClick(UploadPO, 20);
		Thread.sleep(1500);
		this.attachmentFile(System.getProperty("user.dir") + "\\Attachment_files\\Manoj QA.pdf");
		if (!this.conditionCheck(UploadPOView, 20)) {

			do {
				this.mouseActionClick(UploadPO, 10);
				Thread.sleep(2500);
				this.attachmentFile(System.getProperty("user.dir") + "\\Attachment_files\\Manoj QA.pdf");
			} while (!this.conditionCheck(UploadPOView, 20));
		}
		this.scrollDown1(3);
		this.mouseActionClick(NextButton, 10);
		if (!this.conditionCheck(LineItemLabel, 30)) {
			do {
				this.mouseActionClick(NextButton, 10);
			} while (!this.conditionCheck(LineItemLabel, 30));
		}
	}

	public void lineItemAdd() throws AWTException, InterruptedException {
		this.inputText(Line_Number, BrandNumber);
		this.inputText(State, "Tamil Nadu");
		this.inputText(City, "Any");
		this.dropdown(10, Material_Type, 1);
		this.dropdown(10, Material_Category, 1);
		this.dropdown(10, Material_Sub_Type, 1);
		this.inputText(Quantity, "100000");
		this.inputText(Rate_Kg, "1.2");
		this.mouseActionClick(Save_Line_Item, 10);
		if (!this.conditionCheck(Line_Item_Details, 20)) {
			do {
				this.mouseActionClick(Save_Line_Item, 10);
			} while (!this.conditionCheck(Line_Item_Details, 20));

		}
		this.scrollDown1(200);
		this.mouseActionClick(LinePageNext, 10);
		if (!this.conditionCheck(AdditonalDetails, 20)) {
			do {
				this.mouseActionClick(LinePageNext, 10);

			} while (!this.conditionCheck(AdditonalDetails, 20));

		}

	}

	public void addtionalDetails() throws InterruptedException, AWTException {

		this.inputText(Notes, "testingAutomation");
		this.scrollDown1(15);
		Thread.sleep(1500);
		this.mouseActionClick(SupportingDocuments, 10);
		Thread.sleep(1500);
		this.attachmentFile(System.getProperty("user.dir") + "\\Attachment_files\\Manoj QA.pdf");

		if (!this.conditionCheck(SupportingDocumentsCheck, 10)) {
			do {
				this.mouseActionClick(SupportingDocuments, 10);
				Thread.sleep(2000);
				this.attachmentFile(System.getProperty("user.dir") + "\\Attachment_files\\Manoj QA.pdf");

			} while (!this.conditionCheck(SupportingDocumentsCheck, 10));

		}
		this.buttonClick(adddtionalDetailsNext);

	}

	public void Review() throws AWTException, InterruptedException {
		this.conditionCheck(Spinner, 20);
		this.scrollDown1(1000);
		this.mouseActionClick(AddPurchaseOrder, 10);

	}
	
	public String PopupText() {
		String checkText = this.checkText(PopUpTextCheck, 10);
		return checkText;

	}
	
	public void PopupButtonClick() {
		this.buttonClick(PopUpButton);

	}

}
