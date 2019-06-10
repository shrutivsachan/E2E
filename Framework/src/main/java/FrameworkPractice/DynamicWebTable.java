package FrameworkPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTable {
	WebDriver driver =  null;

	public void handledynamictable(){
		System.setProperty("webdriver.chrome.driver", "C:\\dev\\Tools\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("");
		
	}
}
