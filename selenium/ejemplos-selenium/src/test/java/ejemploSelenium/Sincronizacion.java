package ejemploSelenium;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class Sincronizacion {
	public static WebDriver driver;
	
	//Para cargar el driver antes de iniciar cualquier test
	@BeforeClass
	public static void setUp(){
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080");
		
	}
	
	//@Test
	public void testSincro1() {
		//Espera el tiempo definido (5 segundos) y hace la evaluación.
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("btn1"));
	}
	
	//@Test
	public void testSincro2() {		
		WebDriverWait wait = new WebDriverWait(driver,10);
		//Le hacemos esperar 10 segundos, pero si aparece antes da el OK y sigue con los test
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btn1")));
	}
	
	@Test
	public void testSincro3() {
		//Lo mismo que tetSincro 2 pero de manera "manual" definiendo la duracion de los timeouts, los tiempos de reintento etc...
		FluentWait<WebDriver> wait =new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofMillis(300))
				.ignoring(Exception.class);
		
		wait.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver arg0) {
				WebElement boton = arg0.findElement(By.id("btn1"));
				if(boton!=null) {
					return boton;
				}else {
					return null;
				}

			}
			
		});
		
	}
	
	@AfterClass
	public static void tearDown(){
		//Cierra navegador y la instancia del driver
		driver.quit();		
	}

}
