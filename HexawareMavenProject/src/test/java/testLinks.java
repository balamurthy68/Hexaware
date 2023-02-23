
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testLinks {

	static WebDriver driver;
	
	
	@AfterClass
	public void close()
	{
		driver.close();

	}
	@BeforeClass
	public void init()
	{
		

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver=new ChromeDriver();

		driver.get("file:///D:/sample.html");

	}
	@Test
	public void checkBrokenLinks() {
		
		
		List <WebElement> l =driver.findElements(By.tagName("a"));
		int s = l.size();
		int i;
		for (i=0;i < s;i++)
		{
			System.out.println(l.get(i).getAttribute("href"));
			String url = l.get(i).getAttribute("href");
			validateLink(url);
			
		}
		
		
				
	}


	//The below function validateLink(String urlLink) verifies any broken links and return the server status. 
		public static void validateLink(String urlLink) {
	     //Sometimes we may face exception "java.net.MalformedURLException". Keep the code in try catch block to continue the broken link analysis
	     try {
				//Use URL Class - Create object of the URL Class and pass the urlLink as parameter 
				URL link = new URL(urlLink);
				// Create a connection using URL object (i.e., link)
				HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();
			
				//Set the timeout for 2 seconds
				httpConn.setConnectTimeout(2000);
				//connect using connect method
				
				httpConn.connect();
				//use getResponseCode() to get the response code. 
					if(httpConn.getResponseCode()== 200) {	
						System.out.println("Ok for " + urlLink+" - "+httpConn.getResponseMessage());
					}
					if(httpConn.getResponseCode()== 404) {
						System.out.println("Broken link " + urlLink+" - "+httpConn.getResponseMessage());
					}
				}
				//getResponseCode method returns = IOException - if an error occurred connecting to the server. 
			catch (Exception e) {
				//e.printStackTrace();
				System.err.println("Broken link " + urlLink+ " " + e.getCause());
				
			}
	 } 

	
	
	
	
}
