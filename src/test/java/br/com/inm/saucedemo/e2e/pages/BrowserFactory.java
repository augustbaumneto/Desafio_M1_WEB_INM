package br.com.inm.saucedemo.e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import br.com.inm.saucedemo.configuracao.TipoExecucao;

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
	//private static final String FIREFOXDRIVER_PATH = "C:\\Automação_desenvolvimento\\SeleniumDrivers\\geckodriver.exe";

	//Caso seu firefox esteja instalado fora da pasta arquivos de programa, utilizar a linha abaixo para indicar a 
	//localização do executável 
	//private static final String FIREFOX_BINARY_PATH = "C:\\Users\\augustbn\\AppData\\Local\\Mozilla Firefox\\firefox.exe";
	
	/**
	 * 
	 * Método que define qual instância será iniciada
	 * 
	 * @param nomenavegador, pode assumir os valores "chrome", "firefox" ou "unit"
	 * @return o Driver do tipo escolhido
	 * 
	 */
	public WebDriver createWebDriver(String nomenavegador) {
		String navegadorentrada = getParametroNavegadorEntrada();
		String webdriver;

		//Verifica se foi um navegador válido, se não for utiliza o setado no código.
		if (navegadorentrada.equals("empty"))
			webdriver = System.getProperty("browser", nomenavegador);
		else
			webdriver = navegadorentrada; 
		switch (webdriver) {
			case "firefox":
				return initFirefoxDriver();
			case "chrome":
				return initChromeDriver();
			default:
				HtmlUnitDriver driver = new HtmlUnitDriver(true); //True para poder habilitar a execução de javascript
								
				return driver; 
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
		
		ChromeOptions options = new ChromeOptions();
		//Permitir acesso remoto no Chrome
		options.addArguments("--remote-allow-origins=*");
		
		//Se a execução será headless
		options.setHeadless(TipoExecucao.FORMA_EXECUCAO.getFlag());
		return new ChromeDriver(options);
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
		
		FirefoxOptions options = new FirefoxOptions();
		//Fornecer o caminho do executável do Firefox, se estiver no caminho padrão retirar 
		// a linha abaixo
		//options.setBinary(FIREFOX_BINARY_PATH);
		
		// Se será uma execução headless
		options.setHeadless(TipoExecucao.FORMA_EXECUCAO.getFlag());
		return new FirefoxDriver(options);
	}
	
	/**
	 * Método que captura o valor do browser de entrada
	 * 
	 * 
	 * @return String o navegador, ou "empty" se não for informado um navegador válido
	 */
	private String getParametroNavegadorEntrada() {
		String navegador = System.getProperty("navegador");
		
		if (!navegador.equals("firefox") && !navegador.equals("chrome")) {
			navegador = "empty";
		}
		return navegador;
		
	}
}
