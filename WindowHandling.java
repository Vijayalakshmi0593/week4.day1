package week4.day1;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/Window.html");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//button[(text()='Open Home Page')]")).click();

		// step 1:

		Set<String> winSet = driver.getWindowHandles();

		// step2; converting set to list

		ArrayList<String> winList = new ArrayList<String>(winSet);

		// to print the total no of windows

		System.out.println("The Total no of the windows : " + winList.size());

		// window 1(0)
		// window 2(1)

		System.out.println("Window1:" + driver.getTitle());

		driver.switchTo().window(winList.get(1));

		System.out.println("Window2:" + driver.getTitle());

		driver.quit();

	}

}