package com.udemysselenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Frames_Demo {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\eclipse-workspace\\interviewpreparation\\drivers\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.get("https://ui.vision/demo/webtest/frames/");
	    driver.manage().window().maximize();
	    driver.switchTo().frame(0);
	    driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Hello Frame");
	    driver.switchTo().defaultContent();
	    driver.switchTo().frame(1);
	    driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Hello second Frame");
	    Thread.sleep(5000);
	    driver.switchTo().defaultContent();
	    driver.switchTo().frame(2);
	    driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Hello Third Frame");
	    Thread.sleep(5000);
	    WebElement frame_name = driver.findElement(By.xpath("//iframe"));
	    driver.switchTo().frame(frame_name);
	    driver.findElement(By.xpath("//div[@class='nWQGrd zwllIb']//label[@for='i5'] //div[@class='AB7Lab Id5V1']")).click();
	    
	    
	}
}