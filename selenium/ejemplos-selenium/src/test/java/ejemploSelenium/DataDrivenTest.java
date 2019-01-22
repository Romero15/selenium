package ejemploSelenium;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)
public class DataDrivenTest {
	public static WebDriver driver;
	public String num1;
	public String num2;
	public String res;
	
	//Para cargar el driver antes de iniciar cualquier test
	@BeforeClass
	public static void setUp(){
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080");		
	}
	
	@Parameters
	public static List<String[]> testdata(){
		return Arrays.asList(new String[][]{
			{"1","2","3"},{"10","22","32"},{"3","4","7"}
		});		
	}
	
	public DataDrivenTest(String n1,String n2, String r) {
		this.num1=n1;
		this.num2=n2;
		this.res=r;
	}
	
	@Test
	public void testSuma() {
		WebElement n1 = driver.findElement(By.id("num1"));
		WebElement n2 = driver.findElement(By.id("num2"));
		n1.clear();
		n2.clear();
		n1.sendKeys(num1);
		n2.sendKeys(num2);
		
		WebElement boton = driver.findElement(By.id("suma"));
		boton.click();
		
		WebElement resultado = driver.findElement(By.id("resultado"));
		assertEquals(res, resultado.getAttribute("value"));
	}
	
	@AfterClass
	public static void tearDown(){
		//Cierra navegador y la instancia del driver
		driver.quit();		
	}

}
