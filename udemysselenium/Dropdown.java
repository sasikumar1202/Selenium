package com.udemysselenium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Dropdown {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the month");
		String return_month = sc.nextLine();
		System.out.println("Enter the Date for ticket booking");
		String return_date = sc.nextLine();

	System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\eclipse-workspace\\interviewpreparation\\drivers\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.spicejet.com/");
    driver.manage().window().maximize();
   
    driver.findElement(By.xpath("//div[contains(@class,'css-1dbjc4n r-18u37iz r-19h5ruw ')]/div[@class='css-1dbjc4n']")).click();
    WebElement clickable = driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']"));
    int i=0;
    while (i<2) {
    clickable.click();
    i++;
    }
    String ddwn="";
    driver.findElement(By.xpath("//div[text()='Currency']")).click();
    List<WebElement> dropdownelement = driver.findElements(By.xpath("//div[contains(@class,' r-u8s1d r-8fdsdq')] //div[contains(@class,' r-11yh6sk r-1rnoaur r-1sncvnh')]"));
    List liststore = new ArrayList();
    for (WebElement ele : dropdownelement) {
		ddwn = ele.getText();
		liststore.add(ddwn);
	}
    List templist = new ArrayList<>();
    templist.addAll(liststore);
    Collections.sort(templist);
    System.out.println(templist);
   
   
    
    driver.findElement(By.xpath("//div[contains(@data-testid,'return-date-dropdown-label-test-id')]/div[contains(@class,' r-1wtj0ep')]")).click();
    List<WebElement> li = driver.findElements(By.xpath("//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79']"));
    for (WebElement webElement : li) {
		String str = webElement.getText();
		if(str.equalsIgnoreCase(return_month)) {
			break;
		}
    }
			List<WebElement> lidate = driver.findElements(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-14lw9ot r-1loqt21 r-eu3ka r-1otgn73 r-1aockid']"));
			for(int j=0;j<lidate.size();j++) {
				String str2 = lidate.get(j).getText();
				if(str2.equalsIgnoreCase(return_date)) {
					lidate.get(j).click();
					break;	
		}
	}
	}

}
