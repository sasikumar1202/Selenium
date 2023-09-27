package com.udemysselenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.internal.invokers.AbstractParallelWorker.Arguments;

public class Javascript_demo {

    @Test
	public static void demo_Java() throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\eclipse-workspace\\interviewpreparation\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.location = 'https://www.youtube.com/'");
		jse.executeScript("window.scrollBy(0,7000)");
		WebElement search = driver.findElement(By.xpath("//input[@id='search']"));
		jse.executeScript("arguments[0].setAttribute('value','peralai')", search);
		Object o = jse.executeScript("return arguments[0].getAttribute('value')", search);
		String s = (String)o;
		System.out.println(s);
		WebElement button = driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));
		jse.executeScript("arguments[0].click();", button);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("C://Users//USER//Desktop//Resumes//screenshot.png");
		FileUtils.copyFile(source, destination);
		
		
		
		
	
	}
	
	
}
