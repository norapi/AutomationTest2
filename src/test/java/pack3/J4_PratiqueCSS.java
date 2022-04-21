package pack3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class J4_PratiqueCSS {
	
	@Test
	public void loginTest() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/login");

		// Tester changement du code au niveau du CSS
		driver.findElement(By.cssSelector("#username")).sendKeys("tomsmith");
		driver.findElement(By.cssSelector("#password")).sendKeys("SuperSecretPassword!");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[type=submit]")).click();
		Thread.sleep(2000);
		//driver.findElement(By.cssSelector("[href='/logout']")).click(); //A1
		driver.findElement(By.cssSelector("[href=\"/logout\"]")).click(); //idem A1
		//driver.close();
	}

	
	@Test
	public void forgotPasswordTest() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/forgot_password");

		// Tester changement du code au niveau du CSS
		driver.findElement(By.cssSelector("#email")).sendKeys("test@test.com");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".icon-signin")).click();
		//driver.findElement(By.cssSelector("#form_submit")).click();
		Thread.sleep(2000);
		//driver.close();
	}

	@Test
	public void getAttributeTest() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/forgot_password");

		System.out.println("La valeur de l'attribut est:"+driver.findElement(By.cssSelector("#form_submit")).getAttribute("id"));
		
		Thread.sleep(2000);
		//driver.close();
	}
	
	@Test
	public void getAttributeImageTest() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com");
		String url = driver.findElement(By.cssSelector("a[title='My Store']>img")).getAttribute("src");

		System.out.println("La valeur de l'attribut src est:"+url);
		
		Thread.sleep(2000);
		//driver.close();
	}
	
	@Test
	public void getAttributeImageTest2() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
		boolean display1 = driver.findElement(By.cssSelector("div[class='submit'] [value='my-account']")).isDisplayed();
		System.out.println("Element 1 affiché:"+display1);
		
		boolean display2 = driver.findElement(By.cssSelector("#SubmitCreate")).isDisplayed();
		System.out.println("Element 2 affiché:"+display2);

		
		Thread.sleep(2000);
		//driver.close();
		//div[class='submit'] [value='my-account']

	}
	
	// Vérifier qu'un bouton est enabled ou disabled
	@Test
	public void getAttributeButtonTest() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://omayo.blogspot.com/");
		
		boolean enabled1 = driver.findElement(By.cssSelector("#but1")).isEnabled();
		System.out.println("Button 1 affiché:"+enabled1);
		
		boolean enabled2 = driver.findElement(By.cssSelector("#but2")).isEnabled();
		System.out.println("Button 2 affiché:"+enabled2);

		
		Thread.sleep(2000);
		//driver.close();

	}
	
	// Vérifier qu'un radio bouton est checked/selected ou non; utiliser value au lieu de id (cette fois-ci)
	@Test
	public void getAttributeRadioButtonTest() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://omayo.blogspot.com/");
		
		boolean selected1 = driver.findElement(By.cssSelector("[value='orange']")).isSelected();
		System.out.println("Le bouton radio ORANGE est-il selectionné?"+selected1);
		
		boolean selected2 = driver.findElement(By.cssSelector("[value='blue']")).isSelected();
		System.out.println("Le bouton radio BLUE est-il selectionné?"+selected2);

		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("[value='orange']")).click();
		System.out.println("FAIT CLICK() sur le bouton radio ORANGE !!!");
		boolean selected3 = driver.findElement(By.cssSelector("[value='orange']")).isSelected();
		System.out.println("Le bouton radio ORANGE est-il selectionné?"+selected3);
		
		
		//driver.close();

	}
}
