package org.utilities;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class DDTestUsingJson {

	WebDriver driver;
	
	
	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.MILLISECONDS);
	}
	
	@AfterClass
	void closeBrowser() {
		
	
	}	
	
	@AfterTest
	public void screenShot() throws IOException {
		
		TakesScreenshot tk = (TakesScreenshot)driver;
		File screenshotAs = tk.getScreenshotAs(OutputType.FILE);
		File f=new File("C:\\Users\\ELCOT\\eclipse-workspace\\JsonReaderFile\\screenshot\\.png");
		FileUtils.copyFile(screenshotAs, f);
	}
	
	@Test(dataProvider="dp")
	public void login(String data)
	
	{
		String users[]=data.split(",");
	driver.get("https://www.nopcommerce.com/en/login?returnUrl=%2Fen%2Fdemo");
	driver.findElement(By.id("Username")).sendKeys(users[0]);
	driver.findElement(By.id("Password")).sendKeys(users[1]);
	driver.findElement(By.xpath("(//input[@class='btn blue-button'])[2]")).click();
	
//	String act_title = driver.getTitle();
//	String exp_title="nopCommerce deno store";
//	Assert.assertEquals(act_title, exp_title);
	}
	
	@DataProvider(name="dp")
	 public String[] readJson() throws IOException, ParseException  {
	
	JSONParser jsonParser=new JSONParser();
	
	FileReader reader = new FileReader(".\\jsonfiles\\testdata.json");
	
	Object obj=jsonParser.parse(reader);
	
	JSONObject userloginsJsonobj=(JSONObject)obj;
	
	JSONArray userloginsArray  = (JSONArray) userloginsJsonobj.get("userlogins");
	
	String arr[]=new String[userloginsArray.size()];
	
	for (int i = 0; i < userloginsArray.size(); i++) 
	{
		JSONObject users=(JSONObject)userloginsArray.get(i);
		
		String user =(String)users.get("username");
		
		String pwd =(String)users.get("password");
		
		arr[i]=user+","+pwd;
		
	}
	return arr;
	
	
	}

}