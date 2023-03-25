package com.jbk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FrameHandlingEx {
	@Test
	public void test01()throws Exception{
		System.setProperty("webdriver.chrome.driver", "Chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("i-icon-profile")).click();
		driver.findElement(By.id("signInLink")).click();
		
		//Frame handling code
		WebElement frame= driver.findElement(By.xpath("//iframe[@class='modalIframe']"));
		driver.switchTo().frame(frame);
		
		driver.findElement(By.id("mobileNoInp")).sendKeys("1234567890");
		
		
	}

}
