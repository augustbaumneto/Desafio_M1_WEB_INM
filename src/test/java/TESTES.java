/*import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.inm.saucedemo.e2e.pages.BrowserFactory;
import br.com.inm.saucedemo.e2e.pages.InventarioPage;
import br.com.inm.saucedemo.e2e.pages.LoginPage;

public class TESTES {

	
	@Test
	public void teste123() {
		
		WebDriver driver;
		
		LoginPage lp = new LoginPage("chrome");
		
		InventarioPage ip = lp.efetuarLogin("standard_user", "secret_sauce");
		
		driver = ip.getdriver();
		
		driver.findElement(By.id("item_4_title_link")).click();
		
		driver.findElement(By.className("btn btn_primary btn_small btn_inventory")).click();
		//driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
		
	}
	
}
*/