package pack3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pratiquecss {
	@Test
	public void logintest() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.cssSelector("username")).sendKeys("tomsmith");
		driver.findElement(By.cssSelector("password")).sendKeys("superSecretPassword!");
		driver.findElement(By.cssSelector("[type=submit]")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("[href='/logaut']")).click();
		Thread.sleep(5000);
	}

	@Test
	public void forgotPwdtest() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/forgot_password");
		driver.findElement(By.cssSelector("#email")).sendKeys("test@test.com");
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("#form_submit")).click();
	}

	@Test
	public void getAttributeTest() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/forgot_password");
		String attributId = driver.findElement(By.cssSelector("#form_submit")).getAttribute("id");
		System.out.println("la valeur de l'Id est:" + attributId);
	}

	@Test
	public void cssImageTest() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automationpractice.com/");
		String url = driver.findElement(By.cssSelector("a[title='My Store']>img")).getAttribute("src");
		System.out.println("l'url est:" + url);
		// driver.close();
	}

	@Test
	public void cssImageTest2() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automationpractice.com/index.php?controller=authentication&back=my-account");
		boolean display = driver.findElement(By.cssSelector("div[class='submit'] [value='my-account']")).isDisplayed();
		System.out.println("element affiche:" + display);
		// driver.close();
	}

	@Test
	public void cssImageTest3() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://omayo.blogspot.com/");
		boolean actif = driver.findElement(By.cssSelector("#but1]")).isEnabled();
		System.out.println("element actif:" + actif);
		boolean actif2 = driver.findElement(By.cssSelector("#but2]")).isEnabled();
		System.out.println("element actif 2:" + actif2);
		// driver.close();
	}

	@Test
	public void typechecked() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://omayo.blogspot.com/");
		boolean checked = driver.findElement(By.cssSelector("[value='orange']")).isSelected();
		System.out.println("element actif:" + checked);
		//boolean checked2 = driver.findElement(By.cssSelector("[value='blue']")).isSelected();
		//System.out.println("element actif 2:" + checked2);
		driver.findElement(By.cssSelector("[value='orange']")).click();
		// driver.close();
	}
}
