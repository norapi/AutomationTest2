package pack3;

import java.io.File;
import java.io.IOException;
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
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class J4_PratiqueWebDriver {
	
	@Test
	public void takeScreenShot() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com/");
		
		// Localiser l'élément dont on veu prendre un screenshot
		// On veut que l'OutputType soit un fichier
		File screen = driver.findElement(By.cssSelector("[value='orange']")).getScreenshotAs(OutputType.FILE);
		File toFile = new File ("screenshot\\image1.png");
		FileHandler.copy(screen, toFile);
		//FileUtils.copyFile(screenshot, new File("G:\\\\Downloads\\\\selenium\\image.png"));
		
		System.out.println("Le screenshot va être sauvegardé dans un fichier");

	}
	
	// Faire un screenshot d'une image
	@Test
	public void takeScreenShot2() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com/");
		
		// Localiser l'élément dont on veut prendre un screenshot
		// On veut que l'OutputType soit un fichier
		File screen = driver.findElement(By.cssSelector("[src='https://assets.about.me/background/www.softwaretestingcollege.blogspot.com_1330713399_12.jpg']")).getScreenshotAs(OutputType.FILE);
		File toFile = new File ("screenshot\\image2.png");
		FileHandler.copy(screen, toFile);
		
		System.out.println("Le screenshot va être sauvegardé dans un fichier");

	}

	// X Faire un screenshot de toute la page
	@Test
	public void takeScreenShot3() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().window().fullscreen();
		driver.get("https://omayo.blogspot.com/");

		//
				
		//File screen = driver.findElement(By.cssSelector("html")).getScreenshotAs(OutputType.FILE);
		File screen = driver.findElement(By.cssSelector("body")).getScreenshotAs(OutputType.FILE);
		
		File toFile = new File ("screenshot\\image3.png");
		FileHandler.copy(screen, toFile);
		
		System.out.println("Le screenshot va être sauvegardé dans un fichier");

	}
	
	
	// Faire un screenshot de toute la page
	@Test
	public void takeFullScreenShot() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");

		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File toFile = new File ("screenshot\\image4.png");
		FileHandler.copy(screen, toFile);
		
		System.out.println("Le screenshot va être sauvegardé dans un fichier");

	}
	
	// Faire un screenshot et un rapport de test (suite dans J5
	@Test
	public void takeScreenShotandReport() throws Exception {

		// Sauvegarder le rapport avec Reporter.log
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		
		//System.out.println("Ouverture de la Homepage");
		Reporter.log("Ouverture de la Homepage");

		// Se loger
		driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
		Reporter.log("Remplir le formulaire de Login");
		//Thread.sleep(1000);
		driver.findElement(By.cssSelector("#login-button")).click();
		Reporter.log("Affichage du Homepage");
		//Thread.sleep(1000);
		
		// Ajouter un element #add-to-cart-sauce-labs-backpack
		driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click();
		//Thread.sleep(1000);
		
		//Logout
		driver.findElement(By.cssSelector("#react-burger-menu-btn")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#logout_sidebar_link")).click();
		
		
		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File toFile = new File ("screenshot\\image5.png");
		FileHandler.copy(screen, toFile);

		// target est utilisé pour que le link s'ouvre dans un nv écran
		//Reporter.log("<a target=\"_blank\" href=\"C:\\Users\\npilo\\eclipse-auto1\\J3_Selenium_maven\\screenshot\\image5.png\">screenshot</a>");
		Reporter.log("<a target=\"_blank\" href=\"..\\screenshot\\image5.png\">screenshot </a>");

		Reporter.log("Fermeture du Navigateur");
		driver.quit();
	}
	

}
