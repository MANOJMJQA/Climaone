package org.Recircle.page;

import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import baseClass.org.BaseClass;

public class po_creation extends BaseClass {
	WebDriver driver;

	public po_creation(WebDriver driver) {
		this.driver = driver;

	}

	By purchaseOrder = By.xpath("//a[contains(text(),'Purchase Orders')]");
	By textPO = By.xpath("//h2[text()='Purchase Order']");
	By AddPO = By.xpath("//div[@id='main-container']//div[1]//div[3]//div[1]//div[2]//button");
	By AddpoText = By.xpath("//div[@id='main-container']//div[2]//div[1]//div[1]//div[1]//h2");
	By CompanyNext = By.xpath("//input[@id='company_details_next']");

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

	public String addPo() {
		this.buttonClick(purchaseOrder);
		String checkText = this.checkText(textPO, 5);
		return checkText;

	}

	public String ClickPO() {
		this.buttonClick(AddPO);
		String text = this.checkText(AddpoText, 10);
		return text;

	}

	public void poRegistration() throws AWTException, InterruptedException {

		this.buttonClick(CompanyName);
		this.buttonClick(CompanyNameList);
		this.inputText(CertificateName, "Automation");
		this.inputText(GSTIN, "24AABCU9603R1ZT");
		this.inputText(BrandPoNumber, "787878");
		this.inputText(StartDate, "12/05/2023");
		this.inputText(EndDate, "24/05/202");
		this.inputText(ContactPerson, "ManojAUT");
		this.inputText(ContactNumber, "9876543210");
//        this.inputText(VendorCode, "8787");
//        this.inputText(Billto, "cxxxxxx");
//        this.inputText(ShipTo, "yyyyyy");
//        this.inputText(SendInvoiceTo, "nungambakkam");
		this.inputText(PaymentTerms, "test");
		this.inputText(ShippingTerms, "test");
		this.scrollDown1();
		this.mouseActionClick(ListDocument, 10);
		if (this.invisibleConditionCheck(ListCheckbox, 10)) {
			do {
				this.mouseActionClick(ListDocument, 10);
			} while (this.invisibleConditionCheck(ListCheckbox, 10));
		}
//        this.buttonClick(ListDocument);
//        this.buttonClick(ListDocument);

		this.mouseActionClick(UploadPO, 20);
		Thread.sleep(1500);
		this.attachmentFile(System.getProperty("user.dir") + "\\Attachment_files\\dsc00531 (1).jpg");
		if (!this.conditionCheck(UploadPOView, 20)) {

			do {
				this.mouseActionClick(UploadPO, 10);
				Thread.sleep(2500);
				this.attachmentFile(System.getProperty("user.dir") + "\\Attachment_files\\dsc00531 (1).jpg");
			} while (!this.conditionCheck(UploadPOView, 20));
		}

	}

}
