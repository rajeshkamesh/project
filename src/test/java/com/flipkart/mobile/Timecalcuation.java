package com.flipkart.mobile;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Timecalcuation {
	static WebDriver driver;
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Beforeclass");
	}	
	@AfterClass
	public static void afterClass() {
		System.out.println("AfterClass");
	}
	@Before
	public void beforeTest() {
		
		System.out.println("Before test");
		
	}
	@After
	public void afterTest() {
		System.out.println("After Test");
	}
	@Test
	public void test1() {
		System.out.println("Login");
	}
	
	

}
