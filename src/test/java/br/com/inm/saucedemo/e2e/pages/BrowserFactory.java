package br.com.inm.saucedemo.e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * 
 *  Classe que inicializa a instância do navegador 
 * 
 * @author August Neto
 *
 */
public class BrowserFactory {

	//Caso seu driver não esteja configurado na variável de ambiente Path do Windows 
	// retire o comentário das linhas de baixo e substitua o caminho pela aonde se localiza seu driver 
	
	//private static final String CHROMEDRIVER_PATH = "C:\\Users\\stepp\\Desktop\\curso-bdd\\workspace\\leilao\\drivers\\chromedriver.exe";
	//private static final String FIREFOXDRIVER_PATH = "C:\\Users\\stepp\\Desktop\\curso-bdd\\workspace\\leilao\\drivers\\geckodriver.exe";

	/**
	 * 
	 * Método que define qual instância será iniciada
	 * 
	 * @param nomenavegador, pode assumir os valores "chrome", "firefox" ou "unit"
	 * @return o Driver do tipo escolhido
	 */
	public WebDriver createWebDriver(String nomenavegador) {
		String webdriver = System.getProperty("browser", nomenavegador);
		switch (webdriver) {
			case "firefox":
				return initFirefoxDriver();
			case "chrome":
				return initChromeDriver();
			default:
				return new HtmlUnitDriver(true); //True para poder habilitar a execução de javascript
		}
	}

	/**
	 * 
	 *  Método que inicializa o Chrome
	 * 
	 * @return o driver do Chrome
	 */
	private  WebDriver initChromeDriver() {

		//Caso seu driver não esteja configurado na variável de ambiente Path do Windows
		// retire o comentário dessa linha
		//System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_PATH);
		return new ChromeDriver();
	}

	/**
	 * 
	 * Método que inicializa o Firefox
	 * 
	 * @return o driver do Firefox
	 */
	private  WebDriver initFirefoxDriver() {
		//Caso seu driver não esteja configurado na variável de ambiente Path do Windows
		// retire o comentário dessa linha
		//System.setProperty("webdriver.gecko.driver", FIREFOXDRIVER_PATH);
		return new FirefoxDriver();
	}
}
