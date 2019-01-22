package ejemploSelenium;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class SeleniumAPI {
	public static WebDriver driver;
	
	@BeforeClass
	public static void setUp(){
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();			
	}
	//@Test
	public void testDobleClick() {
		driver.get("http:\\cookbook.seleniumacademy.com/DoubleClickDemo.html");
		
		WebElement parrafo = driver.findElement(By.id("message"));
		//se van añadiendo "acciones" al builder y se ejecutan con perform
		Actions builder = new Actions(driver);
		builder.doubleClick(parrafo).perform();
		
		assertEquals(parrafo.getCssValue("background-color"),"rgba(255, 255, 0, 1)");
		
	}
	//@Test
	public void testDragAndDrop() {
		driver.get("http:\\cookbook.seleniumacademy.com/DragDropDemo.html");
		
		WebElement arrastrar = driver.findElement(By.id("draggable"));
		WebElement soltar = driver.findElement(By.id("droppable"));
		
		Actions builder = new Actions(driver);
		//se van añadiendo "acciones" al builder y se ejecutan con perform
		builder.dragAndDrop(arrastrar, soltar).perform();
		
		assertEquals(soltar.getText(),"Dropped!");
		
	}
	
	//@Test
	public void testJavascript() {
		driver.get("http://localhost:8080");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("saludar();");
		//El alert es una nueva ventana la cual no podemos inspeccionar , por lo que 
		//se debe crear una instancia Alert, con la cual ya podemos interactuar
		Alert miAlert= driver.switchTo().alert();
		//Comprobamos que el texto es el correcto
		assertEquals(miAlert.getText(),"Hola a todos");
		//Cerramos el alert pulsando el botón de ok
		miAlert.accept();
	}
	
	//@Test
	public void testPantallazoAlert() throws IOException {
		driver.get("http://localhost:8080");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("saludar();");
		
		//El alert es una nueva ventana la cual no podemos inspeccionar , por lo que 
		//se debe crear una instancia Alert, con la cual ya podemos interactuar
		Alert miAlert= driver.switchTo().alert();
		
		//Comprobamos que el texto es el correcto
		assertEquals(miAlert.getText(),"Hola a todos");
		
		//Cerramos el alert pulsando el botón de ok
		miAlert.accept();
		
		//Para que nos cree la imagen como un archivo
		File srcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("src/test/resources/screenshots/ScreenshotAlert.png"));		
	}
	
	@Test
	public void testEventos() {
		driver.get("http://localhost:8080");
		//Cargamos este driver ya que los normales no emiten eventos
		EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
		NuestroListener listener = new NuestroListener();
		//registramos el listener en el driver
		eventDriver.register(listener);
		eventDriver.findElement(By.id("no-existe"));
	}
	
	
	//@AfterClass
	public static void tearDown(){
		//Cierra navegador y la instancia del driver
		driver.quit();		
	}

}
