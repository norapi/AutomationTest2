package pack2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MySecondTestNGClass {

	@Test
	public void navigateURL() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");

		// Entrer les données (id/className récupérés via inspect dans Chrome) AUTOMATIQUEMENT sur la page
		driver.findElement(By.className("username")).sendKeys("Admin");
		driver.findElement(By.className("password")).sendKeys("admin123");
		driver.findElement(By.id("Login")).click();
		// System.out.println(driver.findElement(By.id("error")).getText());
		WebElement textError = driver.findElement(By.id("error"));
		String erreur = textError.getText();
		System.out.println("Le Message d'erreur est: " + erreur);

		Thread.sleep(3000);

		// Fermer le navigateur
		driver.close();
	}
	
	@Test
	public void forgotPWD() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");

		// Entrer les données (id/className récupérés via inspect dans Chrome) AUTOMATIQUEMENT sur la page
		driver.findElement(By.className("username")).sendKeys("Admin");
		Thread.sleep(2000);
		driver.findElement(By.className("username")).clear();
		Thread.sleep(2000);
		driver.findElement(By.className("username")).sendKeys("Admin");
		
		driver.findElement(By.linkText("Forgot Your Password?")).click();
		String monUrl = driver.getCurrentUrl();
		System.out.println("L'URL est: " + monUrl);
		
		//récupérer le title et l'afficher dans console
		System.out.println("Le titre est:" + driver.getTitle());
		
		Thread.sleep(2000);

		//Afficher le code source de la page
		System.out.println(driver.getPageSource());
		
		// Fermer le navigateur
		driver.close();
	}
	
	@Test
	public void claerField() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");

		// Entrer les données (id/className récupérés via inspect dans Chrome) AUTOMATIQUEMENT sur la page
		driver.findElement(By.linkText("Forgot Your Password?")).click();
		String monUrl = driver.getCurrentUrl();
		System.out.println("L'URL est: " + monUrl);
		
		//récupérer le title et l'afficher dans console
		System.out.println("Le titre est:" + driver.getTitle());
		
		Thread.sleep(2000);

		// Fermer le navigateur
		driver.close();
	}

	
	@Test
	public void testDriverQuit() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://omayo.blogspot.com/");

		//ouvrir le pop-up
		//driver.findElement(By.linkText("Open a popup window")).click();
		driver.findElement(By.partialLinkText("Open a popup")).click();
		Thread.sleep(2000);
		
		// Quitter le navigateur; NE FERME PAS LES POP-UPS
		driver.quit(); // FERME TOUT!!!
		//driver.close(); // NE FERME PAS LES POP-UPS
	}
	
}
