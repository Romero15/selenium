package ejemploSelenium;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Interacciones {
	public static WebDriver driver;
	
	//Para cargar el driver antes de iniciar cualquier test
	@BeforeClass
	public static void setUp(){
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
				
	}
	
	//@Test
	public void testCampotexto() {
		driver.get("https://www.google.es");
		WebElement input = driver.findElement(By.name("q"));
		input.sendKeys("Angular");
		input.clear();
		input.sendKeys("Selenium");
		input.submit();		
		WebElement enlace1 = driver.findElement(By.className("LC20lb"));
		enlace1.click();
	}
	
	
	//@Test
	public void testCssValue() {
		driver.get("http://localhost:8080");
		WebElement enlace =driver.findElement(By.tagName("a"));
		String propiedad = enlace.getCssValue("text-decoration-line");
		assertEquals(propiedad,"none");
	}
	
	//@Test
	public void testDesplegables() {
		//Seleccionamos una opcion el combo de select y validamos que es la correcta
		driver.get("http://localhost:8080");
		Select selectCoches =new Select (driver.findElement(By.id("coches")));
		//Por indice
		selectCoches.selectByIndex(1);
		assertEquals(selectCoches.getFirstSelectedOption().getText(),"BMW");
		//Por texto visible
		selectCoches.selectByVisibleText("Tesla");
		assertEquals(selectCoches.getFirstSelectedOption().getText(),"Tesla");
		//Por value
		selectCoches.selectByValue("a");
		assertEquals(selectCoches.getFirstSelectedOption().getText(),"Audi");
	}
	
	//@Test
	public void testDesplegablesMultiple() {
		driver.get("http://localhost:8080");
		Select selectColores =new Select (driver.findElement(By.id("colores")));
		//Comprobamos que permite hacer selección multiple
		assertTrue(selectColores.isMultiple());
		//Por indice
		selectColores.selectByIndex(1);
		assertEquals(selectColores.getAllSelectedOptions().size(),1);
		//Por texto visible
		selectColores.selectByVisibleText("Blanco");
		assertEquals(selectColores.getAllSelectedOptions().size(),2);
		//Por value
		selectColores.selectByValue("n");
		assertEquals(selectColores.getAllSelectedOptions().size(),3);
		//Deseleccionamos una
		selectColores.deselectByIndex(0);
		assertEquals(selectColores.getAllSelectedOptions().size(),2);
		//Deseleccionamos todas
		selectColores.deselectAll();
		assertEquals(selectColores.getAllSelectedOptions().size(),0);
	}
	
	@Test
	public void testRadios() {
		driver.get("http://localhost:8080");
		WebElement radio1 = driver.findElement(By.id("si"));
		WebElement radio2 = driver.findElement(By.id("no"));		
		
		radio1.click();
		assertTrue(radio1.isSelected());
		assertFalse(radio2.isSelected());
		
		radio2.click();
		assertTrue(radio2.isSelected());
		assertFalse(radio1.isSelected());
	}
	
	
	
	@AfterClass
	public static void tearDown(){
		//Cierra navegador y la instancia del driver
		driver.quit();		
	}

}
