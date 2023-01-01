package br.com.inm.saucedemo.e2e.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.inm.saucedemo.modelos.Produto;

public class ObjectPageBase {

	//Parâmetros utilizados para identificar produtos
	protected final static String GHERKIN_PROD1_BACKPACK="Sauce Labs Backpack";
	protected final static String GHERKIN_PROD2_BIKELIGHT="Sauce Labs Bike Light";
	protected final static String GHERKIN_PROD3_BOLTTSHIRT="Sauce Labs Bolt T-Shirt";
	protected final static String GHERKIN_PROD4_FLEECEJACKET="Sauce Labs Fleece Jacket";
	protected final static String GHERKIN_PROD5_ONESIE="Sauce Labs Onesie";
	protected final static String GHERKIN_PROD6_TSHIRTRED="T-Shirt (Red)";
	
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
	
	/**
	 * Verifica se o elemento fornecido pelo localizador esta presente na página
	 * 
	 * @param localizador
	 * @return
	 */
	protected boolean elementoEstaPresente(By localizador) {
		try {
			driver.findElement(localizador);
			return true;
		} catch (NoSuchElementException e) {

			return false;
		}
	}
	
	/**
	 *  Captura os dados dos itens exibidos na tela e monta a lista de produtos exibida 
	 * @param tamanholistaexibida (tamanho em tela da lista exibida)
	 * @param posicaoiniciolista (No cssselector em qual posição a partir do localizador base da lista
	 * 								começa o primeiro produto
	 * @param csslocalizadorbasedoitemdalista	CSS Selector que representa um item da lista exibida
	 * @param css_sufixo_localizador_nome
	 * @param css_sufixo_localizador_link
	 * @param css_sufixo_localizador_descricao
	 * @param css_sufixo_localizador_preco
	 * @param css_sufixo_localizador_botaoremover
	 * @return
	 */
	protected List<Produto> constroiListaProdutosExibidos(int tamanholistaexibida, int posicaoiniciolista,
						String csslocalizadorbasedoitemdalista, String css_sufixo_localizador_nome, 
						String css_sufixo_localizador_link, String css_sufixo_localizador_descricao,
						String css_sufixo_localizador_preco, String css_sufixo_localizador_botaoremover) {
		List<Produto> produtosexibidos= new ArrayList<>();
		
		for(int i=posicaoiniciolista; i<=posicaoiniciolista-1+tamanholistaexibida;i=i+1) {
			String localizadoritem = csslocalizadorbasedoitemdalista+":nth-child("+i+")";
			if(elementoEstaPresente(By.cssSelector(localizadoritem))) {
				Produto produto = new Produto(localizadoritem+css_sufixo_localizador_nome,
						localizadoritem+css_sufixo_localizador_link, 
						localizadoritem+css_sufixo_localizador_descricao,
						localizadoritem+css_sufixo_localizador_preco,
						localizadoritem+css_sufixo_localizador_botaoremover);
				//Captura os dados de texto da tela
				String txtnome = driver.findElement(By.cssSelector(produto.getLocalizador_nome_produto())).getText();
				produto.setNome_produto(txtnome);
				String txtdescricao = driver.findElement(By.cssSelector(produto.getLocalizador_descricao())).getText();
				produto.setDescricao_produto(txtdescricao);
				String txtvalor = driver.findElement(By.cssSelector(produto.getLocalizador_valor())).getText();
				produto.setValor(txtvalor);
				
				produtosexibidos.add(produto);
				
			} else {
			
				break;
			}
		}
		return produtosexibidos;
	}
	
}
