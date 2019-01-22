package ejemploSelenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * 
 * @author Santi
 * 
 * -Primero hay que bajarse el driver de los tres navegadores (el de firefox se llama gecko driver) * 
 * -Creamos una nueva carpeta en test/resurces >> drivers
 * -Metemos dentro de la carpeta los tres drivers(descomprimidos)
 * -Firebug para ver los elementos

 *
 */
public class TestFirefox {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://google.es");
		driver.quit();
	}

}
