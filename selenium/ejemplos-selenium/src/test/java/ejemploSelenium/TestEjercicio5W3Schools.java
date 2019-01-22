package ejemploSelenium;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestEjercicio5W3Schools {

	//definimos fuera porque se va a usar en varios sitios
			public static WebDriver driver;
			
			//Para cargar el driver antes de iniciar cualquier test
			@BeforeClass
			public static void setUp(){
				System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
				driver = new ChromeDriver();
				driver.get("https://www.w3schools.com/html/html_tables.asp");
				
			}
			//Anotacion para decirle que es un test			
			@Test
			public void testEncuentraPrimeratabla() {
				//encontramos la tabla que se llama customers
				WebElement tabla= driver.findElement(By.xpath("//table[@id='customers']"));
				System.out.println(tabla.getText());	
				assertNotNull(tabla);
			}
			
			@Test
			public void testCuentaFilasTabla() {
				//curnta las filas de la tabla
				List<WebElement> tabla= driver.findElement(By.xpath("//table[@id='customers']")).findElements(By.xpath(".//tr"));
				System.out.println(tabla.size());	
				assertEquals(tabla.size(),7);
			}
			
			@Test
			public void testCuentaCeldasUltimaFila() {
				//ucontamos las celdas de la última fila
				List<WebElement> tabla= driver.findElement(By.xpath("//table[@id='customers']")).findElements(By.xpath(".//tr[last()]/td"));
				System.out.println(tabla.size());	
				assertEquals(tabla.size(),3);
			}
			
			@Test
			public void testDosFilasDespuesDeQuinta() {
				//validamos que despues de la quinta fila tenga dos mas
				List<WebElement> tabla= driver.findElement(By.xpath("//table[@id='customers']")).findElements(By.xpath(".//tr[position() >5]"));
				System.out.println(tabla.size());	
				assertEquals(tabla.size(),2);
			}
			
			@Test
			public void testValidaCeldasNoVacias() {
				//validamos que no tnga ninguna celda vacia
				List<WebElement> tabla= driver.findElement(By.xpath("//table[@id='customers']")).findElements(By.xpath(".//td"));
				for(WebElement celda : tabla) {
					assertNotEquals(celda.getText(),"");
				}
			}			
			
			//Que hacer al acabar el tst (cerrar el driver)
			@AfterClass
			public static void tearDown(){
				//Cierra navegador y la instancia del driver
				driver.quit();		
			}

}
