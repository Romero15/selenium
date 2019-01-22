package ejemploSelenium;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestEjercicio8CSS {
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
		//Comprobar que el placeholder tiene el texto correcto
		WebElement busca= driver.findElement(By.name("search"));
		String placeholder= busca.getAttribute("placeholder");
		assertEquals(placeholder,"Buscar en Wikipedia");
		//Comprobar que el tamño de la letra en el input es el correcto
		String tamañoLetra= busca.getCssValue("font-size");
		assertEquals(tamañoLetra,"13px");		
		busca.clear();
		//Buscamos selenium y comprobamos que vamos a la pagina correcta
		busca.sendKeys("Selenium");
		busca.submit();
		assertEquals(driver.getTitle(),"Selenium - Wikipedia, la enciclopedia libre");
		
	}
	
	@AfterClass
	public static void tearDown(){
		//Cierra navegador y la instancia del driver
		driver.quit();		
	}

}
