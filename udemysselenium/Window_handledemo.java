package com.udemysselenium;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Window_handledemo {

	
	public static void window_Handle() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\eclipse-workspace\\interviewpreparation\\drivers\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
	    String parentwindow = driver.getWindowHandle();
	    driver.findElement(By.xpath("//button[@id='newWindowBtn']")).click();
	    Set<String> allwindows = driver.getWindowHandles();
    	
	    Iterator<String> it = allwindows.iterator();
	    while(it.hasNext()) {
	    	if(!allwindows.equals(parentwindow)) {
	    	String newwindow = it.next();
	    	driver.switchTo().window(newwindow);
	    	driver.manage().window().maximize();
	    	}
	    }

	    driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Sasikumar");
	  
	}
	

	public static void demo_Windowhandle2 () throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\eclipse-workspace\\interviewpreparation\\drivers\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
	    String parent_window = driver.getWindowHandle();
	    driver.findElement(By.id("newWindowBtn")).click();
	    Set<String> allwindows = driver.getWindowHandles();
	    Iterator<String> i = allwindows.iterator();
	    while(i.hasNext()) {
			if(!parent_window.equals(allwindows)) {
				String newwindow = i.next();
				driver.switchTo().window(newwindow);
				driver.manage().window().maximize();
				Thread.sleep(5000);	
			}
	    }
	    WebElement type = driver.findElement(By.xpath("//input[@id='firstName']"));
	    JavascriptExecutor jse =(JavascriptExecutor) driver;
	    jse.executeScript("arguments[0].setAttribute('value','sasi')", type);
	    driver.switchTo().window(parent_window);
	    driver.findElement(By.id("newWindowsBtn")).click();
	    Set<String> allwin = driver.getWindowHandles();
	    Iterator<String> it = allwin.iterator();
	    String  strwin = it.next();
	    driver.manage().window().maximize();
	    driver.switchTo().window(strwin);
	    
	}
	public static void interviewwindow() throws InterruptedException {	
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\eclipse-workspace\\interviewpreparation\\drivers\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://demo.automationtesting.in/Windows.html");
			driver.findElement(By.xpath("//li/a[@href='#Multiple']")).click();
			driver.findElement(By.xpath("//button[@onclick='multiwindow()']")).click();
			String parent_window = driver.getWindowHandle();
			Set<String> allwindows = driver.getWindowHandles();
			for (String check : allwindows) {
				driver.switchTo().window(check);
				String tt = driver.getTitle();
				if(tt.equalsIgnoreCase("Selenium")) {
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					driver.findElement(By.xpath("//a[contains(@class,'selenium-button selenium-we')]")).click();
					break;
				}
			}
	}
	
	public static void hytutorial() throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\eclipse-workspace\\interviewpreparation\\drivers\\chromedriver.exe");
		    WebDriver driver = new ChromeDriver();
		    driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		    driver.findElement(By.id("newWindowsBtn")).click();
		    String parent_window = driver.getWindowHandle();
		    Set<String> allwindows = driver.getWindowHandles();
		    for (String windows : allwindows) {
		    	driver.switchTo().window(windows);
		    	driver.manage().window().maximize();
		    	String name = driver.getTitle();
		    	
		    	if(name.equalsIgnoreCase("XPath Practice - H Y R Tutorials")) {
		    		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		    		driver.findElement(By.xpath("//input[@maxlength='10']")).sendKeys("Sasi ");
		    	}
		    	
		    	}
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	//	window_Handle();
		interviewwindow();

		
	    
	}

}
