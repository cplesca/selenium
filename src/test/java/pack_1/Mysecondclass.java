package pack_1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mysecondclass {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.ca");
		driver.findElement(By.name("q")).sendKeys("Test automatization");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

}
