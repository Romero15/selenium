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

/**
 * 
 * @author Selenium
 * -instalamos node.js para levantar un servidor
 * -Abrimos el node js comand prompt y lanzamos npm install -g http-server
 * -en el comand promp escribimos cd y la ruta hasta el html (en la carpeta)
 * -una vez en la ruta donde está el http lanzamos http-server y levanta el servidor
 * 
 */

public class TestFindElements {
	//definimos fuera porque se va a usar en varios sitios
		public static WebDriver driver;
		
		//Para cargar el driver antes de iniciar cualquier test
		@BeforeClass
		public static void setUp(){
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080");
			
		}
		//Anotacion para decirle que es un test
		@Test
		public void testTextotH1(){
			WebElement h1 = driver.findElement(By.id("titulo"));			
			assertEquals(h1.getText(),"Mi pagina de pruebas");
			
		}
		
		@Test
		public void testFindByName() {
			WebElement input = driver.findElement(By.name("username"));
			assertEquals(input.getAttribute("value"),"santi");
		}
		
		@Test
		public void testFindByClass() {
			WebElement boton = driver.findElement(By.className("btn"));
			assertEquals(boton.getText(),"Enviar");
			assertNotNull(boton);
		}
		
		@Test
		public void testFindByTagName() {
			//Como se va a encontrar varios elementos label tenemos qe usar elementS sino solo devolveria el primero que se encontrara
			List<WebElement> labels = driver.findElements(By.tagName("label"));
			assertEquals(labels.size(),2);
			for(WebElement label :labels){
				System.out.println(label.getText());				
			}
			//assertNotNull(boton);
		}
		
		@Test
		public void testFindLinks() {
			WebElement enlaceGoogle = driver.findElement(By.linkText("Google"));
			WebElement enlaceNetflix = driver.findElement(By.partialLinkText("Net"));
			assertNotNull(enlaceGoogle);
			assertNotNull(enlaceNetflix);
		}
		//Usando xpath se puede encontrar cualquier cosa
		@Test
		public void testFindByXPath() {
			//obtenemos el 2 label dentro de form
			WebElement label2 = driver.findElement(By.xpath("//form/label[2]"));
			assertEquals(label2.getText(),"Email:");
			
			//obtenemos el segundo link
			WebElement enlace2 = driver.findElement(By.xpath("//a[2]"));
			assertEquals(enlace2.getText(),"Mi Netflix");
			
			//el mismo link pero ruta absoluta
			//Ya no funcionaria por haber metido el link dentro de un nav, por eso es mejor el otro metodo.
/**			WebElement enlace2_1 = driver.findElement(By.xpath("/html/body/a[2]"));
*			assertEquals(enlace2.getText(),"Netflix");
*/
		}
		
		@Test
		public void testFindByCssSelector() {
			WebElement selector = driver.findElement(By.cssSelector("nav > a.boton-molon"));
			assertEquals(selector.getText(),"Mi Netflix");
			WebElement selectorFoco = driver.findElement(By.cssSelector("input:focus"));
			assertEquals(selectorFoco.getAttribute("value"),"santi");
		}
		
		
		//Que hacer al acabar el tst (cerrar el driver)
		@AfterClass
		public static void tearDown(){
			//Cierra navegador y la instancia del driver
			driver.quit();		
		}

}
