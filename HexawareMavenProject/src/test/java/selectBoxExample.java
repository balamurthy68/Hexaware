

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.Select;
public class selectBoxExample {


	public static void main(String[] args) {
		String exePath = "c:\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		driver.get("file:///d://sample.html");


		Select  oSelect = new Select (driver.findElement(By.id("cars")));



		List <WebElement> elementCount = oSelect.getOptions();
		System.out.println(elementCount.size());
		for(int i=0; i < elementCount.size() ; i++ ){



			String sValue = elementCount.get(i).getText();

			System.out.println(sValue);
			// Select the checkbox it the value of the checkbox is same what you are looking for
		}

       String expectedValue="Opel";
		try {
			oSelect.selectByVisibleText(expectedValue);
			oSelect.selectByValue("opel");
		
		}
		
		
		catch(NoSuchElementException e)
		{
			System.out.println("The item " + expectedValue + " is not present in the list");
			
		}
	}
}
