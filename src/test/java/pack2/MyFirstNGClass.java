package pack2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyFirstNGClass {

	@Test
	public void demo1() {
		// Prendre le controle de Chrome
		WebDriverManager.chromedriver().setup(); // ici on utilise MavenDependencies

		// Créer un objet du navigateur qu'on veut utiliser
		WebDriver driver = new ChromeDriver();

		// Maximiser l'écran
		driver.manage().window().maximize();

		// Aller à la page qu'on veut manipuler/tester
		driver.get("https://google.ca/");
	}
	
	@Test
	public void demo2() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://lapresse.ca/");
	}

	@Test
	public void demo3() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ebay.com/");
	}

}
