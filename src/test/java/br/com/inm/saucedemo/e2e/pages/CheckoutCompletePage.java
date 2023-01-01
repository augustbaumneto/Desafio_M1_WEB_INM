/**
 * 
 */
package br.com.inm.saucedemo.e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Classe Page Objects da página de finalização
 * 
 * 
 * @author August Neto
 *
 */
public class CheckoutCompletePage extends ObjectPageBase {

	private final static String URL_PAGINA_CHECKOUTCONCLUSAO = "https://www.saucedemo.com/checkout-complete.html";
	
	private static final String CSS_LABEL_TITULOCOMPLETE = "#header_container .title";
	private static final String CSS_LABEL_MENSAGEMCONFIRMACAO = ".complete-text";
	private final static String CSSSELECTOR_LINK_CARRINHOCOMPRAS = "#shopping_cart_container .shopping_cart_link";
	private final static String CSSSELECTOR_CONTEUDO_CARRINHOCOMPRAS = CSSSELECTOR_LINK_CARRINHOCOMPRAS
																	+ " span";
	
	
	private static final String MSG_TITULO = "CHECKOUT: COMPLETE!";
	private static final String MSG_CONFIRMACAO = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
	
	/**
	 * Construtor padrão
	 * 
	 * @param driver
	 */
	public CheckoutCompletePage(WebDriver driver) {
		super(driver, null);

	}

	/**
	 * MEtodo que verifica se estar na paágina de finalização da ordem
	 * 
	 * @return
	 */
	public boolean ePaginaConclusaoCheckout() {
		return ePaginaAtual(URL_PAGINA_CHECKOUTCONCLUSAO);
	}

	/**
	 * Verifica se o texto no inicio da página é o texto identificando a página corretamente
	 * @return
	 */
	public boolean verificaTextoTituloConclusao() {
		By localizadortitulo = By.cssSelector(CSS_LABEL_TITULOCOMPLETE);
		
		return verificaSeMensagemEApresentadaLocalizador(localizadortitulo, MSG_TITULO);
	}

	/**
	 * Verifica se mensagem de confirmação da ordem esta correta
	 * 
	 * @return
	 */
	public boolean verificaMensagemConfirmacaoOrdem() {
		By localizadormensagemconfirmacao = By.cssSelector(CSS_LABEL_MENSAGEMCONFIRMACAO);
		return verificaSeMensagemEApresentadaLocalizador(localizadormensagemconfirmacao, MSG_CONFIRMACAO);
	}
	
	/**
	 * Verifica se carrinho esta vazio
	 * 
	 * @return
	 */
	public boolean verificaCarrinhoVazio() {
		return !elementoEstaPresente(By.cssSelector(CSSSELECTOR_CONTEUDO_CARRINHOCOMPRAS));
	}
}
