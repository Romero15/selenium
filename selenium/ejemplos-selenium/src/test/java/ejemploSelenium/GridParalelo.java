package ejemploSelenium;



import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;


import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GridParalelo {
	public static WebDriver driver;
	
	@BeforeClass
	@Parameters("browser")
	public static void setUp(String browser) throws MalformedURLException{	
		//Esto no es necesario por estar definido en el selenium grid
		//System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		if(browser=="Chrome") {
			ChromeOptions opciones = new ChromeOptions();
			opciones.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),opciones);		
		}else if(browser=="Firefox") {
			FirefoxOptions opciones = new FirefoxOptions();
			opciones.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),opciones);	
		}
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
