import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testHerokuappLoginPage {
  static WebDriver driver;

  @BeforeClass
  public void initDriver()
  {
	  System.setProperty("webdriver.chrome.driver","C:\\HWTemp\\chromedriver.exe");
	  driver= new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.get("https://the-internet.herokuapp.com/login");
	    
  }
  
  @AfterClass
  public void closeDriver()
  {
	  driver.close();
	  
  }
  
  @Test()
  public void LinkCheck() {
	  //checkLinkInFooter
	//Check if Elemental Selenium link is there in the page
	  Reporter.log("Link check");
	  
	  boolean linkfound;
	  
		
	     try {
			
				driver.findElement(By.linkText("Elementlenium"));
				System.out.println("Link was found! Success");
				linkfound=true;
			}
			catch (NoSuchElementException e) {
				System.out.println("Link not found. Error was :" + e.getRawMessage());
			
				linkfound=false;
			}
	  
	     Assert.assertEquals(linkfound, true);
  
  }

  
  @Test 
  public void PasswordFieldCheck() {
	  //checkIfPassword
	  Reporter.log("This is to check if password is masked.");
	   driver.findElement(By.id("username")).sendKeys("tomsmith");
		
		WebElement pwd = driver.findElement(By.id("password"));
		
		pwd.sendKeys("SuperSecretPassword!");
		
		//Check if password is masked
		
		String typeOfPasswordField = pwd.getAttribute("type");
		boolean isPwd;
		
		if (typeOfPasswordField.equals("password"))
		{
			System.out.println("Yes Password is masked.Pass");
			isPwd=true;
			
		}
		else {
			System.out.println("Yes Password is NOT masked.FAIL!Security issue*****");
			isPwd=false;
		}
		Assert.assertEquals(isPwd,true);
  }


}
