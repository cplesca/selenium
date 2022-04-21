package pack3;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMultiplewindow {
	@Test
	public void displayText() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://omayo.blogspot.com/");
		String idPagel = driver.getWindowHandle();
		driver.findElement(By.linkText("Open a popup window")).click();
		Set<String> windows = driver.getWindowHandles();
		for (String handle : windows) {
			System.out.println("Handle: " + handle);
		}
		System.out.println("idPagel:" + idPagel);
		Iterator<String> iterateur = windows.iterator();
		while (iterateur.hasNext());
		String window = iterateur.next();
		driver.switchTo().window(window);
		if (driver.getTitle().equals("Basic web Page Title")) {
			String text = driver.findElement(By.id("paral")).getText();
			System.out.println("Paragraph text: " + text);
		}
		driver.switchTo().window(idPagel);
		driver.findElement(By.id("checkbox1")).click();
		driver.quit();
	}
	
	@Test
	public void explicitWaitMechanism()  {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.get("http://omayo.blogspot.com/");
		driver.findElement(By.xpath("//button[@class='dropbtn']")).click();
		WebElement facebook = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='myDropdown']/a[@href='http://facebook.com']")));
		facebook.click();
		/*driver.findElement(By.xpath("//div[@id='myDropdown']/a[@href='http://facebook.com']")).click();
		String url = driver.getCurrentUrl();
		System.out.println("url : "+url);
		driver.quit();*/
	}

}
