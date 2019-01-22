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

public class TestEjercicio1Wikipedia {
	//definimos fuera porque se va a usar en varios sitios
		public static WebDriver driver;
		
		//Para cargar el driver antes de iniciar cualquier test
		@BeforeClass
		public static void setUp(){
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://es.wikipedia.org");
			
		}
		//Anotacion para decirle que es un test
		@Test
		public void testObtenEnlances(){
			//obtenemos el titulo de la pagina y lo mostramos en la consola
			System.out.println("Titulo: " +driver.getTitle());	
			WebElement enlace1 = driver.findElement(By.id("n-mainpage-description"));
			WebElement enlace2 = driver.findElement(By.id("n-portal"));
			assertNotNull(enlace1);
			assertEquals(enlace2.getText(),"Portal de la comunidad");
			
		}
		
		@Test
		public void testContarEnlaces() {
			//una vez obtenido un elemento se pueden obtener sus hijos de la manera h1.findElements()...
			List <WebElement> enlaces= driver.findElement(By.id("p-navigation")).findElements(By.tagName("li"));
			assertEquals(enlaces.size(),9);			
		}
		
		@Test
		public void testEncuentraEnlaces() {
			//Buscamos todos los tags a dentro del div con id p-personal
			List <WebElement> enlaces= driver.findElement(By.id("p-personal")).findElements(By.tagName("a"));
			for(WebElement enlace:enlaces) {
				assertNotNull(enlace);				
			}
		}
		
		//Que hacer al acabar el tst (cerrar el driver)
		@AfterClass
		public static void tearDown(){
			//Cierra navegador y la instancia del driver
			driver.quit();		
		}

}
