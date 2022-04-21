package pack_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MySecondTEST {
	@Test
	public void navigateURL() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://test.salesforce.com");
		driver.findElement(By.className("username")).sendKeys("hello");
		driver.findElement(By.className("password")).sendKeys("123");
		driver.findElement(By.id("Login")).click();
		//System.out.println("text erreur"+ driver.findElement(By.id("error"));
		WebElement textError = driver.findElement(By.id("error"));
		String ereur = textError.getText();
		System.out.println("message d'erreur est:" + ereur);
		Thread.sleep(3000);
		driver.close();
	}
	@Test
	  public void montest() throws Exception {
		  WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://test.salesforce.com");
			driver.findElement(By.className("username")).sendKeys("hello");
			driver.findElement(By.className("password")).sendKeys("123");
			driver.findElement( By.linkText("Forgot Your Password?")).click();
			String monURL = driver.getCurrentUrl();
			System.out.println("L'url est:" + monURL);
			String titre =driver.getTitle();
			System.out.println("Le titre de ma page est:" + titre);
			Thread.sleep(3000);
			driver.close();
	  }
	@Test
	  public void forgotpasword()  throws Exception {
		  WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://test.salesforce.com");
			driver.findElement(By.className("username")).sendKeys("test");
			Thread.sleep(3000);
			driver.findElement(By.className("username")).clear();
			Thread.sleep(3000);
			driver.findElement(By.className("username")).sendKeys("test");
			driver.findElement(By.className("password")).sendKeys("123");
			Thread.sleep(3000);
			driver.findElement( By.linkText("Forgot Your Password?")).click();
			String monURL = driver.getCurrentUrl();
			System.out.println("L'url est:" + monURL);
			String titre =driver.getTitle();
			System.out.println("Le titre de ma page est:" + titre);
			Thread.sleep(3000);
			String monHTMLCodeSource = driver.getPageSource();
			System.out.println(monHTMLCodeSource);
			driver.close();
	  }
	@Test
	  public void driverQuit()  throws Exception {
		  WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("http://omayo.blogspot.com/");
			driver.findElement( By.partialLinkText("Open a popup window")).click();
			Thread.sleep(3000);
			driver.quit();
	  }
}