

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class checkBoxExample {
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
		
		List<WebElement> chkbox_color= driver.findElements(By.name("color"));
		
		
		driver.findElement(By.xpath("//*[contains(@value,\"orange\")]")).click();
		
		
		//print how many vehicles are there in the page
		System.out.println(chkbox_color.size());
		
		
		// Create a boolean variable which will hold the value (True/False)
				
		chkbox_color.get(0).click();
		chkbox_color.get(2).click();
		
		String colors = "I like ";
		for(int i=0;i<chkbox_color.size(); i++)
		{
			
		
			if (chkbox_color.get(i).isSelected())
			{
				
			     colors = colors + " " +chkbox_color.get(i).getAttribute("Value") + ", ";
				
				
			}
			
		}
		System.out.println(colors);
		
		
		
		}

}

