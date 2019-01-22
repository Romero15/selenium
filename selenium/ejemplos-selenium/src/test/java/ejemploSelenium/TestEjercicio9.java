package ejemploSelenium;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestEjercicio9 {
	
	public static WebDriver driver;
	
	@BeforeClass
	public static void setUp(){
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://es.wikipedia.org/wiki/Especial:Contribuciones");		
	}
	
	@Test
	public void testDesplegables() {
		//Comprobar que el placeholder tiene el texto correcto
		Select desplegable= new Select( driver.findElement(By.id("namespace")));
		assertFalse(desplegable.isMultiple());
		//Por texto visible
		desplegable.selectByVisibleText("Usuario");
		assertEquals(desplegable.getFirstSelectedOption().getText(),"Usuario");
		
		desplegable.selectByVisibleText("MediaWiki");
		assertEquals(desplegable.getFirstSelectedOption().getText(),"MediaWiki");
		
		desplegable.selectByVisibleText("Ayuda");
		assertEquals(desplegable.getFirstSelectedOption().getText(),"Ayuda");
		

		
	}
	
}
