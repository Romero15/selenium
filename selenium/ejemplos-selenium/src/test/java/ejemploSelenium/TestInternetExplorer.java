package ejemploSelenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * 
 * @author Selenium
 *Lo mismo que el de chrome
 */

public class TestInternetExplorer {
	
	//definimos fuera porque se va a usar en varios sitios
		public static WebDriver driver;
		
		//Para cargar el driver antes de iniciar cualquier test
		@BeforeClass
		public static void setUp(){
			System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.get("http://www.google.es");
			
		}
		//Anotacion para decirle que es un test
		@Test
		public void testMuestraTitulo(){
			//obtenemos el titulo de la pagina y lo mostramos en la consola
			System.out.println("Titulo: " +driver.getTitle());		
			
		}
		//Que hacer al acabar el tst (cerrar el driver)
		@AfterClass
		public static void tearDown(){
			//Cierra navegador y la instancia del driver
			driver.quit();		
		}

}
