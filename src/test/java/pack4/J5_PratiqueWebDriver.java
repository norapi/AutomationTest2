package pack4;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class J5_PratiqueWebDriver {
	
		
	// Faire un screenshot et un rapport de test (suite du J4)
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
	

	@Test
	public void navigateMethod() throws Exception {

		// Naviguer ver le site avec ... au lieu de driver.get
		// pour avoir la possibilité d'utiliser les controls du browser

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.saucedemo.com/");
		Thread.sleep(2000);
		driver.navigate().to("https://www.google.com");
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.navigate().back(); // simuler la flèche back du navigateur
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);		
		driver.quit();
	}
	

	@Test
	public void findMultipleElementsMethod() throws Exception {

		// 	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.saucedemo.com/");
		
		//driver.findElements(By.tagName("a")); //localisation par tagname
		
		List<WebElement> maListe = driver.findElements(By.cssSelector("input"));
		//System.out.println("maListe="+maListe);
		for (WebElement element:maListe) {
			String monAttribut = element.getAttribute("name");
			System.out.println("monAttribut="+monAttribut);
		}
	
		driver.quit();
	}
	
	// recup les liens "a" et href de ces liens ainsi que les link text et afficher dans le console
	@Test
	public void findMultipleElementsMethod2() throws Exception {

		// 	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.saucedemo.com/");
		
		// Se loger pour pouvoir chercher les tag "a"
		driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
		driver.findElement(By.cssSelector("#login-button")).click();		
		
		List<WebElement> maListe = driver.findElements(By.tagName("a")); //localisation par tagname
		System.out.println("maListe="+maListe);
		int i = 0;
		for (WebElement element:maListe) {
			i++;
			String monAttributHref = element.getAttribute("href");
			String linkText = element.getText();
			System.out.println(i + ") monAttributHref="+monAttributHref + " linkText="+linkText);
		}
	
		driver.quit();
	}
	
	@Test
	public void getDifferentValues() throws Exception {

		// 	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.saucedemo.com/");
		// change backround color
		WebElement element = driver.findElement(By.cssSelector("#login-button"));
		String color = element.getCssValue("background-color");
		System.out.println("MA couleur="+color); // de rgba(226, 35, 26, 1)=rouge à  rgba(26, 202, 226, 1)=bleu
		
	
		driver.quit();
	}
	
	@Test
	public void getDNavigatorClass() throws Exception {

		// 	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.saucedemo.com/");
		// get Navigator class name
		String nomDriver = driver.getClass().getSimpleName();
		System.out.println("Nom Driver="+nomDriver); //"ChromeDriver"
	
		driver.quit();
	}
	
	// 	https://www.browserstack.com/guide/handle-multiple-windows-in-selenium
	@Test
	public void handleMultipleWindows() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://omayo.blogspot.com/");
		
		// get element with link text "Open a popup window"
		/* Cette partie de code ne marche pas sans WindowHandle, car besoin de gérer chq page id unique
		driver.findElement(By.linkText("Open a popup window")).click();
		String text = driver.findElement(By.id("para1")).getText();
		System.out.println("Paragraph 1 text="+text); //texte du 1e paragraph
		*/
		
		String idPage1 = driver.getWindowHandle();
		System.out.println("idPage1="+idPage1); 
		driver.findElement(By.linkText("Open a popup window")).click();
		Set<String> windows = driver.getWindowHandles(); // Dans Set il n'y a pas d'éléments dupliqués par contre ds List oui
		
		for (String handle:windows) {
			System.out.println("Handle:"+handle);
		}
		
		Iterator<String> iterateur = windows.iterator();
		while (iterateur.hasNext()) {
			String window = iterateur.next();
			driver.switchTo().window(window); // à chq boucle basculer vers une autre page
			if (driver.getTitle().equals("Basic Web Page Title")) {
				String text = driver.findElement(By.id("para1")).getText();
				System.out.println("Paragraph 1 text = "+text); //texte du 1e paragraph
			}
		}
		
		driver.switchTo().window(idPage1);
		driver.findElement(By.id("checkbox1")).click();
		
		driver.quit();
		
	}
	
	/*
	 *  XPath example : localiser l'image dans l'extension XPath ds Navigateur
	 *  Syntax: //tagname[@attribut='value']
	 *  /img[@src='https://assets.about.me/background/www.softwaretestingcollege.blogspot.com_1330713399_12.jpg']
	 *  
	 *  /html/body/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div[3]/div/aside/div[1]/div[1]/div[1]/img
	 *  //html/body/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div[3]/div/aside/div[1]/div[1]/div[1]/img
	 *  http://www.tutorialsninja.com/demo/
	 */
	
	
	@Test
	public void implicitlyWaitMechanism () throws Exception {
		/*
		 * The Implicit Wait in Selenium is used to tell the web driver to wait for a certain amount of time 
		 * before it throws a “No Such Element Exception”. The default setting is 0. Once we set the time, 
		 * the web driver will wait for the element for that time before throwing an exception.
		 */
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		// IMPLICIT WAIT: mécanisme d'attente pour toute la page, pas pour un élément spécifique
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); // Deprecated dans Seleniem 4
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		driver.navigate().to("http://omayo.blogspot.com/");
		
	
		driver.findElement(By.xpath("//button[@class='dropbtn']")).click();
		//Thread.sleep(4000);
		//driver.findElement(By.xpath("//a[normalize-space()='Facebook']")).click();
		// Relative XPath: //*[@id="myDropdown"]/a[1]
		// Css Selector: a[href='http://facebook.com']
		driver.findElement(By.xpath("//div[@id='myDropdown']/a[@href='http://facebook.com']")).click();
		String url = driver.getCurrentUrl();
		System.out.println("url : "+ url);
		//Thread.sleep(2000);
		driver.quit();
		
	}

	@Test
	public void explicitWaitMechanism () throws Exception {
		/*
		 * The Explicit Wait in Selenium is used to tell the Web Driver to wait for certain conditions (Expected Conditions) or maximum time 
		 * exceeded before throwing “ElementNotVisibleException” exception. It is an intelligent kind of wait, but it can be applied only for 
		 * specified elements. It gives better options than implicit wait as it waits for dynamically loaded Ajax elements.
		 * Once we declare explicit wait we have to use “ExpectedConditions” or we can configure how frequently we want to check the condition 
		 * using Fluent Wait. These days while implementing we are using Thread.Sleep() generally it is not recommended to use
		 */
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); // mécanisme d'attente pour toute la page
		driver.manage().window().maximize();
		
		//EXPLICIT WAIT : attendre pr un element specific jusqu'à ce que ExpectedConditions arrive
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.navigate().to("http://omayo.blogspot.com/");
		
	
		driver.findElement(By.xpath("//button[@class='dropbtn']")).click();
		//Thread.sleep(4000);
		
		// attendre pr un element specific jusqu'à ExpectedConditions arrive
		//Utiliser xpath
		//WebElement facebook = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='myDropdown']/a[@href='http://facebook.com']")));
		
		//Utiliser le linkText
		//WebElement facebook = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Facebook")));
		
		//Utiliser elementToBeClickable au lieu de visibilityOfElementLocated
		WebElement facebook = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='myDropdown']/a[@href='http://facebook.com']")));

		facebook.click();
		
		//driver.findElement(By.xpath("//div[@id='myDropdown']/a[@href='http://facebook.com']")).click();
		
		String url = driver.getCurrentUrl();
		System.out.println("url : "+ url);
		//Thread.sleep(2000);
		//driver.quit();
		
	}
	
	
}
