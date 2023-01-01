/**
 * 
 */
package br.com.inm.saucedemo.e2e.pages;

import java.util.function.BooleanSupplier;

import org.openqa.selenium.WebDriver;

/**
 * Classe Page Objects da página de finalização
 * 
 * 
 * @author August Neto
 *
 */
public class CheckoutComplete extends ObjectPageBase {

	private final static String URL_PAGINA_CHECKOUTCONCLUSAO = "https://www.saucedemo.com/checkout-complete.html";
	
	/**
	 * Construtor padrão
	 * 
	 * @param driver
	 */
	public CheckoutComplete(WebDriver driver) {
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

}
