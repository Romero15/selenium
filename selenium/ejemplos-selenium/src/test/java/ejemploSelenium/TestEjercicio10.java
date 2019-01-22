package ejemploSelenium;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestEjercicio10 {
	public static WebDriver driver;
	
	@BeforeClass
	public static void setUp(){
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();				
	}
	
	//@Test
	public void compruebaRadioButons() {
		//Ejercicio10
		driver.get("https://es.wikipedia.org/wiki/Especial:Contribuciones");
		
		WebElement radio1 = driver.findElement(By.id("newbie"));
		WebElement radio2 = driver.findElement(By.id("user"));
		
		assertTrue(radio2.isSelected());
		assertFalse(radio1.isSelected());
		
		radio1.click();
		
		assertTrue(radio1.isSelected());
		assertFalse(radio2.isSelected());		
	}
	
	@Test
	public void compruebaCheckBoxes() {
		//Ejercicio11
		driver.get("https://es.wikipedia.org/w/index.php?title=Especial:Buscar&search=&fulltext=Buscar&profile=advanced");
		//Buscamos el primer checkbox marcado(como finElement te trae la primera coincidencia, ya lo tendriamos
		WebElement primerCheck = driver.findElement(By.cssSelector("input[type='checkbox']:checked"));		
		assertTrue(primerCheck.isSelected());
		//Buscamos todos los checkBoxes
		/**List<WebElement> checkBoxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
		//Los marcamos todos
		//Sería así pero no funciona porque han cambiado la página y ahora hay checks ocultos los cuales no detecta pero no puede seleccionar
		/**for(WebElement check: checkBoxes) {
			if(!check.isSelected()) {
				check.click();				
			}
		}
		for(WebElement check: checkBoxes) {
			assertTrue(check.isSelected());
		}*/
		WebElement checkTodo = driver.findElement(By.xpath("//input[@value='all']"));
		checkTodo.click();
	}
	
	
}
