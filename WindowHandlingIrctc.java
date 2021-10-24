package week4.day1;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlingIrctc {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);

		driver.get(" https://www.irctc.co.in/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//button[text()='OK']")).click();
		driver.findElement(By.partialLinkText("FLIGHTS")).click();

		// step 1:

		// driver.getWindowHandles(); and then ctrl2 ; L

		Set<String> winSet = driver.getWindowHandles();

		// step 2: converting set to array

		ArrayList<String> WinListHandles = new ArrayList<String>(winSet);

		// step 3:go to the 2nd window

		driver.switchTo().window(WinListHandles.get(1));

		// step 4: print customer care email id:

		String email = driver.findElement(By.xpath("(//div[@class='block-nav-right d-none d-md-block'])[2]")).getText();

		System.out.println("The Given Email is :" + email);

		// step 5: First tab(Train ticket booking) alone

		driver.switchTo().window(WinListHandles.get(0));

		String Title = driver.getTitle();
		System.out.println("The First Window Title  is :" + Title);

		// close pnly the first window

		driver.close();
	}

}
