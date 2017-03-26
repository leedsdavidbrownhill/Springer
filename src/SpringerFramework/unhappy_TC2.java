package SpringerFramework;

import java.util.concurrent.TimeUnit;

import org.junit.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageObjects.search;
import utility.Constant;
import utility.ExcelUtils;

public class unhappy_TC2 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get(Constant.URL);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		System.out.println("Successfully opened the website link.springer.com");		
		
		String Title = driver.getTitle();
		System.out.println("Title of the page is : " + Title);
		
		String input_query = ExcelUtils.getCellData(2, 1);		
		
		//String input_query = "Harry Potter";
		System.out.println("Input Query: " + input_query);			
		search.lnk_Query(driver).sendKeys(input_query);
				
		search.lnk_Search(driver).submit();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Boolean result = driver.getPageSource().contains(input_query);
		
		//Test Case 2  - unhappy Path
		//Zero results returned
		//from input query
		
		if (result == false)
		{

		String SearchString = 	search.lnk_Results(driver).getText();
		//String SearchString = driver.findElement(By.className("number-of-search-results-and-search-terms")).getText();
		String[] arrayOfString = SearchString.split("\\s+");
		
		String s = arrayOfString[0];
		  StringBuilder t = new StringBuilder();
		  for ( int i = 0; i < s.length(); i++ ) {
		    char ch = s.charAt(i);
		    if ( Character.isDigit(ch)) {
		      t.append(ch);
		    }
		  }		
		String TotalString = t.toString();
		int search_total = Integer.parseInt(TotalString);
		
		double Strexpected_result = ExcelUtils.getCellDataInt(2, 2);
		System.out.println("Expected Result: " + Double.toString(Strexpected_result));
		int expected_result = (int)Strexpected_result;
		
		if (search_total == expected_result)
		{
			System.out.println("PASS: " + input_query + " Search Total: " + search_total);
			ExcelUtils.setCellData("Pass", 2, 3);
		}
		}
		
		driver.quit();
		
	}
		

}
