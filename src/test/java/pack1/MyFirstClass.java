package pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyFirstClass {

	public static void main(String[] args) {
		//Prendre le controle de Chrome
		//System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe"); // mettre le chemin où se trouve notre driver
		WebDriverManager.chromedriver().setup(); // remplace la ligne précédente; ici on utilise MavenDependencies
		
		//Créer un objet du navigateur qu'on veut utiliser
		//ChromeDriver driver = new ChromeDriver();
		WebDriver driver = new ChromeDriver(); // utiliser WebDriver qui englobe tous les navigateurs
		
		//Maximiser l'écran
		driver.manage().window().maximize();
		
		//Aller à la page qu'on veut manipuler/tester
		driver.get("https://google.com");
		
	}

}
