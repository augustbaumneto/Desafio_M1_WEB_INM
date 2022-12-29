/**
 * 
 */
package br.com.inm.saucedemo.e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 *  Classe que representa a página de inventário
 * 
 * @author August Neto
 *
 */
public class InventarioPage extends ObjectPageBase {

	
	private final static String URL_PAGINA_INVENTARIO = "https://www.saucedemo.com/inventory.html";
	
	private final static String CSSSELECTOR_BOTAO_CARRINHOCOMPRAS = "#shopping_cart_container .shopping_cart_link";
	
	/**
	 * Construtor padrão
	 * 
	 * @param driver
	 */
	public InventarioPage(WebDriver driver) {
		super(driver, null);

	}
	
	/**
	 * 
	 * Verifica se a pagina atual é a pagina de inventario
	 * 
	 * @return
	 */
	public boolean estaNaPaginaInventario() {
		
		return ePaginaAtual(URL_PAGINA_INVENTARIO);
	}

	/**
	 * 
	 * Verifica se o botão carrinho de compras esta presente
	 * 
	 * @return
	 */
	public boolean verificaBotaoCarrinhoCompras() {
		
		try {
			driver.findElement(By.cssSelector(CSSSELECTOR_BOTAO_CARRINHOCOMPRAS));
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}


	
}
