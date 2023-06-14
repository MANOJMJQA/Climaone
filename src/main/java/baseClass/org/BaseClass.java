package baseClass.org;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	WebDriverWait wait;

	public void browserLaunch(String value) {
		if (value.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (value.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} else if (value.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}

		driver.manage().window().maximize();
	}

	public void quit() {
		driver.quit();

	}

	public void url(String value) {
		driver.get(value);

	}

	public String getValidationfile(String key) throws IOException {
		Properties properties = new Properties();
		FileInputStream stream = new FileInputStream(
				System.getProperty("user.dir") + "\\credentials\\validation.properties");
		properties.load(stream);
		String object = (String) properties.get(key);
		return object;

	}

	public void inputText(By element, String value) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element)).sendKeys(value);

	}

	public void inputText(WebElement element, String value) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(value);

	}

	public void buttonClick(By element) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element)).click();

	}

	public void buttonClick(WebElement element, int value) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(value));
		wait.until(ExpectedConditions.visibilityOf(element)).click();

	}

	public Boolean conditionCheck(By element, int value) {
		Boolean check = false;
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(value));
			check = wait.until(ExpectedConditions.visibilityOfElementLocated(element)).isEnabled();
			return check;
		} catch (Exception e) {
			return check;
		}

	}

	public String checktext(int value, WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(value));
		String text = wait.until(ExpectedConditions.visibilityOf(element)).getText();
		return text;

	}
	
	public String checkText(By element,int value) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(value));
		String until = wait.until(ExpectedConditions.visibilityOfElementLocated(element)).getText();
        return until;		

	}
}
