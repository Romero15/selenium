package ejemploSelenium;

import static org.junit.Assert.*;


import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestEjercicio6Wiki {
	//definimos fuera porque se va a usar en varios sitios
	public static WebDriver driver;
	
	//Para cargar el driver antes de iniciar cualquier test
	@BeforeClass
	public static void setUp(){
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://es.wikipedia.org/w/index.php?title=Especial:Buscar&search=&fulltext=Buscar&profile=advanced");
		
	}
	//Anotacion para decirle que es un test			
	@Test
	public void testEncuentraCheckBoxes() {
		//encontramos la tabla que se llama customers
		List<WebElement> checks= driver.findElements(By.cssSelector("input[type='checkbox']:checked"));
		System.out.println(checks.size());	
		assertEquals(checks.size(),36);
	}
		
	
	//Que hacer al acabar el tst (cerrar el driver)
	@AfterClass
	public static void tearDown(){
		//Cierra navegador y la instancia del driver
		driver.quit();		
	}
}
