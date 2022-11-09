package com.flipkart.mobile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mobile {
	static WebDriver driver;
	@BeforeClass
	public static void beforeClass() {
		//System.out.println("before Class");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
	}	
	@AfterClass
	public static void afterClass() {
		//System.out.println("AfterClass");
	}
	@Before
	public void beforeTest() {
		//System.out.println("Before test");
	}
	@After
	public void afterTest() {
		//System.out.println("After Test");
	}
	@Test
	public void test1() {
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		//System.out.println("Login");
	}
	
	
	
	@Test
	public void test2() {
		WebElement search = driver.findElement(By.xpath("//input[@type='text']"));
		search.sendKeys("Realme Mobiles");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//System.out.println("search");
	}
	@Test
	public void test3() throws IOException {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(200));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_4rR01T']")));
		
		File f = new File("F:\\Java\\project\\Mobiles.xlsx");
		FileOutputStream s= new FileOutputStream(f);
		Workbook w1= new XSSFWorkbook();
		Sheet s1= w1.createSheet("RealmeNames");
		
		List<WebElement> fe = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		for(int i=0; i<fe.size(); i++) {
			Row r1 = s1.createRow(i);
			WebElement mobiles = fe.get(i);
			String text = mobiles.getText();
			
			Cell c1 = r1.createCell(0);
			c1.setCellValue(text);
			
			//System.out.println(text);
		}
		w1.write(s);
		
	}
	@Test
	public void test4() throws IOException {
		FileWriter f2 = new FileWriter("F:\\Java\\project\\Task1.txt");	
		driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]")).click();	
		Set<String> wh = driver.getWindowHandles();
		List<String> wh2= new ArrayList(wh);
		driver.switchTo().window(wh2.get(1));
		String text3 = driver.findElement(By.xpath("//span[@class='B_NuCI']")).getText();
//		System.out.println(text3);
		f2.write(text3);
		f2.close();	
		//System.out.println("window");
	}
	@Test
	public void test5() throws IOException {
		File f = new File("F:\\Java\\project\\Mobiles.xlsx");
		FileInputStream s = new FileInputStream(f);
		Workbook w1 = new XSSFWorkbook(s);
		Sheet s1 = w1.getSheet("RealmeNames");
		Row r2 = s1.getRow(0);
		Cell ce = r2.getCell(0);
		
		String sc = ce.getStringCellValue();
		System.out.println(sc);
		System.out.println("Notepad Mobile is : ");
		FileReader f3= new FileReader("F:\\Java\\project\\Task1.txt");
		BufferedReader br= new BufferedReader(f3);
		 String val;
		 while ((val = br.readLine())!= null) {
			 System.out.println(val); 	 			 
		 }
		 if(sc.equals(val)){
			 System.out.println("Matched");
		 }
		 else {
			 System.out.println("not Matched");
		 }
		 Assert.assertEquals(sc, val);
		
		
		
		//System.out.println("add to cart");
	}


}
