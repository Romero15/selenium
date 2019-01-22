package ejemploSelenium;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestEjercicio7 {
	
	public static WebDriver driver;
	//Para cargar el driver antes de iniciar cualquier test
	@BeforeClass
	public static void setUp(){
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");		
	}
	
	@Test
	public void testBuscaSeleniumWikipedia() {
		WebElement busca= driver.findElement(By.name("search"));
		busca.clear();
		busca.sendKeys("Selenium");
		busca.submit();
		assertEquals(driver.getTitle(),"Selenium - Wikipedia, la enciclopedia libre");
		
	}

}
