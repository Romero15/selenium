package ejemploSelenium;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Grid1 {
	public static WebDriver driver;
	
	@BeforeClass
	public static void setUp() throws MalformedURLException{		
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");		
		ChromeOptions opciones = new ChromeOptions();
		opciones.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),opciones);		
		driver.get("http://localhost:8080");		
	}
	
	@Test
	public void testGrid1() {
		assertEquals(driver.getTitle(),"Mi pagina");
	}
	
	@AfterClass
	public static void tearDown(){
		//Cierra navegador y la instancia del driver
		driver.quit();		
	}

}
