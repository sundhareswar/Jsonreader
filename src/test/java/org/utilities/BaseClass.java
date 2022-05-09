package org.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	static WebDriver driver;

	public void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	public void windowMaximize() {
		driver.manage().window().maximize();

	}

	public void urlLaunch(String url) {
		driver.get(url);

	}

	public void currentUrl() {
		System.out.println(driver.getCurrentUrl());
	}

	public void currentTitle() {
		driver.getTitle();
		System.out.println(driver.getTitle());
	}

}
