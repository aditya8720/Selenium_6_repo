package com.qsp.genericutility;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {
	public void mouseHOver(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element);
	}

	public void scrollToElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.scrollToElement(element).perform();
	}

	public void scrollToXandY(WebDriver driver, int x, int y) {
		Actions act = new Actions(driver);
		act.scrollByAmount(x, y).perform();
	}

	public void rightClick(WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}

	public void rightClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	public void dragAndDrop(WebDriver driver, WebElement sourceElement, WebElement destElement) {
		Actions act = new Actions(driver);
		act.dragAndDrop(sourceElement, destElement).perform();

	}

	public void selectDropdownByIndex(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	public void selectDropdownByValue(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	public void selectDropdownByVisibleTxt(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByValue(text);
	}

	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrame(WebDriver driver, String name) {
		driver.switchTo().frame(name);
	}

	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	public void takeScreenShot(WebDriver driver) throws IOException {
		JavaUtility java = new JavaUtility();
		String time = java.getSystemTime();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/" + time + ".png");
		FileHandler.copy(temp, dest);

	}

	public Alert switchToAlert(WebDriver driver) {
		return driver.switchTo().alert();
	}

	public void switchToAlertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
		;
	}

	public void switchToAlertDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
		;
	}

	public void switchToWindow(WebDriver driver, String url) {

		Set<String> allids = driver.getWindowHandles();
		for (String id : allids) {
			driver.switchTo().window(id);
			String actUrl = driver.getCurrentUrl();
			if (actUrl.contains(url)) {
				break;
			}
		}

	}

	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

}
