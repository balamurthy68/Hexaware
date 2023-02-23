

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class radioButtonExample {
    static WebDriver driver;
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// Create a new instance of the FireFox driver
		String exePath = "c://chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();
		
		// Put an Implicit wait, 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Launch the URL
		driver.get("https://selenium08.blogspot.com/2019/07/check-box-and-radio-buttons.html");
		
		List<WebElement> radio_browser= driver.findElements(By.name("browser"));
		
		//print how many vehicles are there in the page
		System.out.println(radio_browser.size());
		
		
		// Create a boolean variable which will hold the value (True/False)
				
		
		for(int i=0;i<radio_browser.size(); i++)
		{
			
		
			if (radio_browser.get(i).getAttribute("Value").equals("Opera"))
			{
				
				radio_browser.get(i).click();
				System.out.println(radio_browser.get(i).getAttribute("Value") +"-----" + radio_browser.get(i).isSelected());
			}
			
		}
		
		
		
		}

}

