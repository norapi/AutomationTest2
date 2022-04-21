package pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MySecondClass {

	public static void main(String[] args) {
		//Prendre le controle de Chrome
		WebDriverManager.chromedriver().setup(); //ici on utilise MavenDependencies
		
		//Créer un objet du navigateur qu'on veut utiliser
		WebDriver driver = new ChromeDriver();
		
		//Maximiser l'écran
		driver.manage().window().maximize();
		
		//Aller à la page qu'on veut manipuler/tester
		//driver.get("https://mvnrepository.com/");
		driver.get("https://google.com/");
		
		//Entrer les données (id récupérés via inspect dans Chrome) AUTOMATIQUEMENT sur la page
		driver.findElement(By.name("q")).sendKeys("Test automation");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		//Simulation
		

	}

}
