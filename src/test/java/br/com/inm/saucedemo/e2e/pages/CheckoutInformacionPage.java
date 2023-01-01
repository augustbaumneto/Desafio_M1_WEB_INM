/**
 * 
 */
package br.com.inm.saucedemo.e2e.pages;

import java.util.List;


import br.com.inm.saucedemo.modelos.Produto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Classe Page Objects da página de checkout para inserir dados do usuário
 * 
 * @author August Neto
 *
 */
public class CheckoutInformacionPage extends ObjectPageBase {

	private List<Produto> listacompras;
	
	private final static String URL_PAGINA_CHECKOUTINFORMACOES = "https://www.saucedemo.com/checkout-step-one.html";
	
	private final static String CSS_LABEL_TITULOSUASINFORMACOES = "#header_container .title";
	private final static String ID_CAMPO_PRIMEIRONOME = "first-name";
	private final static String ID_CAMPO_ULTIMONOME = "last-name";
	private final static String ID_CAMPO_CODIGOPOSTAL = "postal-code";
	private final static String ID_BOTAO_CONTINUA = "continue";
	
	private static final String MSG_TITULO = "CHECKOUT: YOUR INFORMATION";
	
	/**
	 * Constutor padrão
	 * 
	 * @param driver
	 * @param produtoscompra
	 */
	public CheckoutInformacionPage(WebDriver driver, List<Produto> produtoscompra) {
		super(driver, null);
		this.listacompras=produtoscompra;
	}

	/**
	 * Verifica se esta na página de checkout para preenchimento das informações do cliente
	 * 
	 * @return
	 */
	public boolean ePaginaInformacaoCliente() {
		
		return ePaginaAtual(URL_PAGINA_CHECKOUTINFORMACOES);
	}

	/**
	 * Verifica se o texto no inicio da página é o texto identificando a página corretamente
	 * @return
	 */
	public boolean verificaTextoSuasInformacoes() {
		By localizadortitulo = By.cssSelector(CSS_LABEL_TITULOSUASINFORMACOES);
		
		return verificaSeMensagemEApresentadaLocalizador(localizadortitulo, MSG_TITULO);
	}

	/**
	 * Preenche os campos com os dados pessoais do cliente
	 * @param nome
	 * @param sobrenome
	 * @param cep
	 */
	public void preencherDadosValidos(String nome, String sobrenome, String cep) {
        WebElement camponome = this.driver.findElement(By.id(ID_CAMPO_PRIMEIRONOME));
        WebElement camposobrenome = this.driver.findElement(By.id(ID_CAMPO_ULTIMONOME));
        WebElement campocep = this.driver.findElement(By.id(ID_CAMPO_CODIGOPOSTAL));
        
        camponome.sendKeys(nome);
        camposobrenome.sendKeys(sobrenome);
        campocep.sendKeys(cep);
		
	}

	/**
	 * Envia os dados preenchidos e direciona para a página de confirmação do checkout
	 * 
	 * @return
	 */
	public CheckoutOverviewPage enviarDadosPessoais() {
		WebElement botaocontinuar = this.driver.findElement(By.id(ID_BOTAO_CONTINUA));
	    botaocontinuar.submit();
		return new CheckoutOverviewPage(driver, listacompras);
	}

}
