package ejemploSelenium;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestEjercicio13 {
	
	public static WebDriver driver;
	
	@BeforeClass
	public static void setUp(){
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();			
	}
	
	@Test
	public void testDragAndDrop() throws IOException {
		driver.get("http:\\cookbook.seleniumacademy.com/DragDropDemo.html");
		
		WebElement arrastrar = driver.findElement(By.id("draggable"));
		WebElement soltar = driver.findElement(By.id("droppable"));
		
		Actions builder = new Actions(driver);
		//se van añadiendo "acciones" al builder y se ejecutan con perform
		//Para que nos cree la imagen como un archivo
		File srcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("src/test/resources/screenshots/ScreenshotAntes.png"));
		builder.dragAndDrop(arrastrar, soltar).perform();
		File srcFile2 =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile2, new File("src/test/resources/screenshots/ScreenshotDespues.png"));
		
		assertEquals(soltar.getText(),"Dropped!");
		
	}
	

}
