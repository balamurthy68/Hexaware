import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class tc_loginSuccess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver;

		//System.setProperty("webdriver.chrome.driver", "C:\\HWTemp\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/login");
		
		//Check if Elemental Selenium link is there in the page
		try {
			driver.findElement(By.linkText("Elemental Selenium"));
			System.out.println("Link was found! Success");
		}
		catch (NoSuchElementException e) {
			System.out.println("Link not found. Error was :" + e.getRawMessage());
		}
		
		
		
		//identify username and Password textboxes
		
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		
		WebElement pwd = driver.findElement(By.id("password"));
		
		pwd.sendKeys("SuperSecretPassword!");
		
		//Check if password is masked
		
		String typeOfPasswordField = pwd.getAttribute("type");
		
		if (typeOfPasswordField.equals("password"))
		{
			System.out.println("Yes Password is masked.Pass");
		}
		else {
			System.out.println("Yes Password is NOT masked.FAIL!Security issue*****");
		}
			
			
		
		//click on submit button
		WebElement subBtn;
		
		subBtn=driver.findElement(By.cssSelector("#login > button"));
		subBtn.click();
		
		//check if logout button exists to confirm login was successful
		
		try {
			driver.findElement(By.cssSelector("#content > div > a"));	
			System.out.println("Login Successful");
			
			//Check if success message is displayed
			//*[@id="flash"]/text()
			try {
				WebElement msgElement = driver.findElement(By.xpath("//*[contains(text(),\"secure\")]"));
				
				System.out.println("Message displayed for success" + " " + msgElement.getText());
			}
			catch (NoSuchElementException e)
			{
				System.out.println("Success message not displayed upon successful login");
				
			}
			
		}
		catch (NoSuchElementException e)
		{
			System.out.println("Login unsuccessful");
			
		}
	driver.close();
	}
	
}
