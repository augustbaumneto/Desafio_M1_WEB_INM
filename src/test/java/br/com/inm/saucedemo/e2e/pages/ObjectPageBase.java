package br.com.inm.saucedemo.e2e.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ObjectPageBase {

	//Timeout padrão de espera do selenium em segundos
	private static final long TIMEOUT_PADRAO = 2;

	//Timeout para espera de algum elemento em tela
	private static final long TIMEOUT_ESPERAELEMENTO = 5;
	
	protected WebDriver driver;
	
	
	/**
	 * 
	 * Construtor que recebe o driver para montar a página, 
	 *  caso seja null, utiliza o navegador para criar um novo drivar
	 * 
	 * @param driver
	 * @param navegador Pode ser "chrome", "firefox" ou "unit"
	 */
	public ObjectPageBase (WebDriver driver, String navegador) {
		
		if (driver==null) {
			criaDriver(navegador);

		} else {
			this.driver = driver;
		
		}

	}
	
	/**
	 * 
	 * Método de espera de elemento na tela
	 * 
	 * @param By identificadorelemento 
	 */
	protected void esperaElemento (By identificadorelemento) {
		
		new WebDriverWait(driver,Duration.ofSeconds(TIMEOUT_ESPERAELEMENTO)).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.presenceOfElementLocated(identificadorelemento));
		
	}

	/**
	 * 
	 * Cria o driver para teste
	 * 
	 * @param nomenavegador nome do navegador para teste
	 */
	private void criaDriver(String nomenavegador) {
		driver = new BrowserFactory().createWebDriver(nomenavegador);
		
		//Configura um timeout padrão no selenium
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT_PADRAO));
		
		driver.manage().window().maximize();
	}
	
	/**
	 * 
	 * Limpa o cache e fecha a janela do navegador
	 * 
	 */
	public void clean() {
		driver.manage().deleteAllCookies();
		driver.close();
	}

	/**
	 * Verifica se a pagina atual é a url recebida.
	 * 
	 * @param urlcomparacao
	 * @return
	 */
	protected boolean ePaginaAtual(String urlcomparacao) {
		
		return (driver.getCurrentUrl().equals(urlcomparacao));
	}
	
}
