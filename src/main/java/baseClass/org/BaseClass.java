package baseClass.org;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.JavascriptLogEntry;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(element)).sendKeys(value, Keys.TAB);

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

	public Boolean invisibleConditionCheck(By element, int value) {
		Boolean check = false;
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(value));
			check = wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
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

	public String checkText(By element, int value) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(value));
		String until = wait.until(ExpectedConditions.visibilityOfElementLocated(element)).getText();
		return until;

	}

	public void attachmentFile(String location) throws AWTException {
		StringSelection selection = new StringSelection(location);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void scrollDown(By element, int value) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(value));
		WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		Actions actions = new Actions(driver);
		actions.moveToElement(element2).release().perform();

	}

	public void dropdown(int value, By WebElement, int num) {
		wait = new WebDriverWait(driver, Duration.ofMinutes(value));
		org.openqa.selenium.WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(WebElement));
		Select select = new Select(until);
		select.selectByIndex(num);
	}

	public void mouseActionClick(By element, int value) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(value));
		WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		Actions action = new Actions(driver);
		action.moveToElement(element2).click().perform();

	}

	public void scrollDown1(int value) throws AWTException {
		for (int i = 0; i < value; i++) {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
		}
	}

	public void scrollUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");

	}
	
}
