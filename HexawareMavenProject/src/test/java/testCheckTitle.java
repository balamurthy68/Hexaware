
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testCheckTitle {

	static WebDriver driver;
	
	
	@AfterClass
	public void close()
	{
		driver.close();

	}
	@BeforeClass
	public void init()
	{
		

		System.setProperty("webdriver.chrome.driver", "C:\\HWTemp\\chromedriver.exe");
		driver=new ChromeDriver();

		driver.get("http://www.google.com");

	}
	@Test
	public void checkTitle()
	
	{
		// TODO Auto-generated method stub
		
		String title = driver.getTitle();
		System.out.println("The title value is :" + title);

		String expectedTitle = "Google";

		//comparing the expected title to actual title in browser
	
		Assert.assertEquals(title, expectedTitle);
		
		
	}

}
