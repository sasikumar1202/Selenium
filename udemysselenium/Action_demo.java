package com.udemysselenium;

import java.awt.RenderingHints.Key;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.KeyDownAction;

public class Action_demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\eclipse-workspace\\interviewpreparation\\drivers\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    String name = "redmi";
	    driver.manage().window().maximize();
	    driver.get("https://www.flipkart.com/");
	    driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
	    Actions ac = new Actions(driver);
	    ac.moveToElement(driver.findElement(By.xpath("//div[@class='_1mkliO']/div/img[@alt='Fashion']"))).build().perform();
	    ac.moveToElement(driver.findElement(By.xpath("//div[@class='_3XS_gI _7qr1OC']/a[@class='_6WOcW9 _2-k99T']"))).build().perform();
	    List<WebElement> li = driver.findElements(By.xpath("//div[@class='_3XS_gI']/span[@class='xtXmba']/following-sibling::a"));
	    List store_element = new ArrayList<>();
	    for(int i=0;i<li.size();i++) {
	    	 store_element.add(li.get(i).getText());
	    }
	    System.out.println("Before Sorting : " + store_element);
	    
	    Collections.sort(store_element);
	    System.out.println("After Sorting :" +  store_element);
	    
	    ac.moveToElement(driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")))
	    .click().keyDown(Keys.SHIFT).sendKeys(name).keyDown(Keys.CONTROL).sendKeys("a")
	    .keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).sendKeys("africa").build().perform();
	    
	   
	  
	    

	    
	   
	}

}