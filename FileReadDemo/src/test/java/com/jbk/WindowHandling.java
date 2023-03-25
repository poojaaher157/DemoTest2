package com.jbk;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowHandling {
	@Test
	public void test01() throws Exception
	{
		System.setProperty("webdriver.crome.driver","cromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Admin/Downloads/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
		
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		
		String mainWin = driver.getWindowHandle();   //unique id/handle of main window
		List<WebElement> links= driver.findElements(By.xpath("//a[text()='More info ']"));   //4 elements
		for (WebElement link : links) 
		{
			link.click();
			//5 windows in browser
		}
		Set<String> allWins = driver.getWindowHandles();   // 5 values in a set
		Thread.sleep(3000);
		for (String win : allWins) 
		{
			if(!win.equals(mainWin)){
				System.out.println("handels of window: "+win);
				driver.switchTo().window(win);
				
				System.out.println(driver.getCurrentUrl());
				Thread.sleep(2000);
				driver.close();
			}
		}
	}

}
