package pageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;


public class search {

	private static WebElement element = null;
	
	public static WebElement lnk_Query(WebDriver driver){
		
		element = driver.findElement(By.id("query"));		 	
		 
		return element;
		 
	}		 	

	public static WebElement lnk_Search(WebDriver driver){
		
		element = driver.findElement(By.id("search"));		 	
		 
		return element;
		 
	}	
	
	public static WebElement lnk_Results(WebDriver driver){
		
		element = driver.findElement(By.className("number-of-search-results-and-search-terms"));		 	
		 
		return element;
		 
	}
	
}
