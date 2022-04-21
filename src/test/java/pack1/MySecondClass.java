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
		
		//Cr�er un objet du navigateur qu'on veut utiliser
		WebDriver driver = new ChromeDriver();
		
		//Maximiser l'�cran
		driver.manage().window().maximize();
		
		//Aller � la page qu'on veut manipuler/tester
		//driver.get("https://mvnrepository.com/");
		driver.get("https://google.com/");
		
		//Entrer les donn�es (id r�cup�r�s via inspect dans Chrome) AUTOMATIQUEMENT sur la page
		driver.findElement(By.name("q")).sendKeys("Test automation");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		//Simulation
		

	}

}
