package com.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class PrintAllLinksOnAWebPageThroughSelenium {

	private static final String MY_FIREFOX_EXEC_PATH = "/Applications/Firefox.app/Contents/MacOS/firefox";

	public static void main(String[] args) {
		if (args == null || args.length == 0)
			throw new IllegalArgumentException("Excepted a webpage url and firefox executable path as command line arguments, but none were provided");
		String baseUrl = args[0];
		System.setProperty("webdriver.gecko.driver", "geckodriver");
		FirefoxOptions options = new FirefoxOptions().setBinary(args[1]);
		WebDriver driver = new FirefoxDriver(options);
		try {
			driver.get(baseUrl);
			List<WebElement> list = driver.findElements(By.tagName("a"));
			PrettyTable prettyTable = new PrettyTable("No.", "Name", "Link");
			int index = 1;
			for (WebElement element : list) {
				prettyTable.addRow(Integer.toString(index), element.getText(), element.getAttribute("href"));
				index++;
			}
			System.out.println(prettyTable);
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			driver.quit();
		}
	}

}
