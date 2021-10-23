package week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlerts {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leafground.com/pages/Alert.html");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	 //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Click on the alert box;
		
		//SIMPLE ALERT:
		
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		
		Alert alert = driver.switchTo().alert();
		
		String text = alert.getText();
		System.out.println("The simple alert Box:" + text);
		alert.accept();
		
		// Confirmation Alert:
		
		driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		System.out.println("Confirmation Box: " + alert.getText());
		alert.dismiss();
		
		//Prompt Box Alert:
		
		driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
		
		System.out.println("Prompt Box: " + alert.getText());		
		alert.sendKeys("text");
		alert.accept();		

	}

}
