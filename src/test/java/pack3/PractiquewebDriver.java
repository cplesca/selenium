package pack3;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class PractiquewebDriver {

	private File screen;

	public void logintest() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://omayo.blogspot.com/");
		screen= driver.findElement(By.cssSelector("[value='orange']")).getScreenshotAs(OutputType.FILE);
		File toFile = new File("screenshot\\image.png");
		FileHandler.copy(screen, toFile);

	}

	public void screenshotimg() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://omayo.blogspot.com/");
		screen = driver.findElement(By.cssSelector("[src='https://assets.about.me/background/www.softwaretestingcollege.blogspot.com_1330713399_12.jpg']")).getScreenshotAs(OutputType.FILE);
		File toFile = new File("screenshot\\image2.png");
		FileHandler.copy(screen, toFile);

	}
	public void takeFullScreenshot() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demoga.com/");
		File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File toFile = new File("screenshot\\image3.png");
		FileHandler.copy(screen, toFile);

	}
	@Test
	public void screenshotAndReport() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		Reporter.log("Ouverture de la login page");
		driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("#password")).sendKeys("secret_souce");
		Reporter.log("remplir le formulere de login");
		driver.findElement(By.cssSelector("#login-button")).click();
		Thread.sleep(3000);
		Reporter.log("affichage le homepage");
		driver.findElement(By.cssSelector("#react-burger-menu-btn")).click();
		File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File toFile = new File("scrennshot\\image4.png");
		FileHandler.copy(screen, toFile);
		Reporter.log("fermeture de navigateure");
		Reporter.log("<a target=\"_blank\" href=\"C:\\Automatisation\\selenium_maven\\screenshot\\image4.png\">screenshot</a>");
		driver.quit();
	}
	@Test
	public void findMultipleElementsMethod2() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("#password")).sendKeys("secret_souce");
		driver.findElement(By.cssSelector("#login-button")).click();
		List<WebElement> myElements = driver.findElements(By.cssSelector("a"));
		for(WebElement element: myElements) {
			String href = element.getAttribute("href");
			System.out.println("href= " +href);
			String linkText = element.getText();
			System.out.println("linkText= " +linkText);
		}
		driver.quit();
	}
	
	@Test
	public void getDifferentValue() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		WebElement element = driver.findElement(By.cssSelector("#login-button"));
		String color = element.getCssValue("background-color");
		System.out.println("ma couleur = " +color);
		driver.quit();
	}
	
	@Test
	public void getNavigatorClass() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		String nomDriver = driver.getClass().getSimpleName();
		System.out.println("nom driver: " +nomDriver);
		driver.quit();
	}
	
}