package ejemploSelenium;

import static org.junit.Assert.*;


import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;


public class TestEjercicio14 {
	public static WebDriver driver;
	
	@BeforeClass
	public static void setUp(){
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();			
	}
	
	@Test
	public void testCookies() throws IOException {
		driver.get("http://es.wikipedia.org/wiki/Wikipedia:Portada");
		//comprobamos que existe una cookie que se llama geoIp
		assertNotNull(driver.manage().getCookieNamed("GeoIP"));
		//Comprobamos que hay cookies
		assertNotNull(driver.manage().getCookies());
		//Las borramos todas
		driver.manage().deleteAllCookies();
		//Comprobamos que de verdad se han borrado todas
		assertTrue(driver.manage().getCookies().size()==0);

		
	}

}
