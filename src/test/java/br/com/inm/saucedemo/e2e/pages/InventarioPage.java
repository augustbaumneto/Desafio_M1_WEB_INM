/**
 * 
 */
package br.com.inm.saucedemo.e2e.pages;



import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	private final static String CSSSELECTOR_CONTEUDO_CARRINHOCOMPRAS = CSSSELECTOR_BOTAO_CARRINHOCOMPRAS
																	+ " span";
	
	private Map<String,String> mapaprodutos;
	//Localizadores dos produtos na página
	private final static String ID_BOTAO_PROD1_BACKPACK="add-to-cart-sauce-labs-backpack";
	private final static String ID_BOTAO_PROD2_BIKELIGHT="add-to-cart-sauce-labs-bike-light";
	private final static String ID_BOTAO_PROD3_BOLTTSHIRT="add-to-cart-sauce-labs-bolt-t-shirt";
	private final static String ID_BOTAO_PROD4_FLEECEJACKET="add-to-cart-sauce-labs-fleece-jacket";
	private final static String ID_BOTAO_PROD5_ONESIE="add-to-cart-sauce-labs-onesie";
	private final static String ID_BOTAO_PROD6_TSHIRTRED="add-to-cart-test.allthethings()-t-shirt-(red)";
	
	//Gherkin dos produtos na feature
	private final static String GHERKIN_PROD1_BACKPACK="Sauce Labs Backpack";
	private final static String GHERKIN_PROD2_BIKELIGHT="Sauce Labs Bike Light";
	private final static String GHERKIN_PROD3_BOLTTSHIRT="Sauce Labs Bolt T-Shirt";
	private final static String GHERKIN_PROD4_FLEECEJACKET="Sauce Labs Fleece Jacket";
	private final static String GHERKIN_PROD5_ONESIE="Sauce Labs Onesie";
	private final static String GHERKIN_PROD6_TSHIRTRED="T-Shirt (Red)";
	
	/**
	 * Construtor padrão
	 * 
	 * @param driver
	 */
	public InventarioPage(WebDriver driver) {
		super(driver, null);
		constroiMapa();
	}
	
	/**
	 * Monta o mapa de botões para adicionar itens no carrinho
	 * 
	 */
	private void constroiMapa() {
		mapaprodutos = new HashMap<>();
		mapaprodutos.put(GHERKIN_PROD1_BACKPACK,ID_BOTAO_PROD1_BACKPACK);
		mapaprodutos.put(GHERKIN_PROD2_BIKELIGHT,ID_BOTAO_PROD2_BIKELIGHT);
		mapaprodutos.put(GHERKIN_PROD3_BOLTTSHIRT,ID_BOTAO_PROD3_BOLTTSHIRT);
		mapaprodutos.put(GHERKIN_PROD4_FLEECEJACKET,ID_BOTAO_PROD4_FLEECEJACKET);
		mapaprodutos.put(GHERKIN_PROD5_ONESIE,ID_BOTAO_PROD5_ONESIE);
		mapaprodutos.put(GHERKIN_PROD6_TSHIRTRED,ID_BOTAO_PROD6_TSHIRTRED);
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
		
		return elementoEstaPresente(By.cssSelector(CSSSELECTOR_BOTAO_CARRINHOCOMPRAS));
		
	}

	/**
	 * 
	 * Verifica se existe algum item no carrinho já
	 * 
	 * @return
	 */
	public boolean carrinhoComItens() {
		
		return elementoEstaPresente(By.cssSelector(CSSSELECTOR_CONTEUDO_CARRINHOCOMPRAS));
	}

	public void adicionarProduto(String produto) {
		String idproduto = mapaprodutos.get(produto);
		WebElement botaoadicionar = driver.findElement(By.id(idproduto));
		botaoadicionar.click();
		
	}


	
}
