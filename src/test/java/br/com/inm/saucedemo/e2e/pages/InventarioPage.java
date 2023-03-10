/**
 * 
 */
package br.com.inm.saucedemo.e2e.pages;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.inm.saucedemo.modelos.Produto;

/**
 * 
 *  Classe que representa a página de inventário
 * 
 * @author August Neto
 *
 */
public class InventarioPage extends ObjectPageBase {

	
    private List<Produto> produtoscarrinho = new ArrayList<>();
	
	private Map<String,Produto> mapaprodutos;
	
	private final static String URL_PAGINA_INVENTARIO = "https://www.saucedemo.com/inventory.html";
	
	private final static String CSSSELECTOR_LINK_CARRINHOCOMPRAS = "#shopping_cart_container .shopping_cart_link";
	private final static String CSSSELECTOR_CONTEUDO_CARRINHOCOMPRAS = CSSSELECTOR_LINK_CARRINHOCOMPRAS
																	+ " span";
	private static final String CSS_LABEL_TITULOINVENTARIO = "#header_container .title";
	
	private static final String BASE_PRODS="#inventory_container.inventory_container .inventory_item:nth-child";
	//Dados produto 1
	
	private static final String ID_LINK_PROD1_BACKPACK = "item_4_title_link"; // Link do produto
	private static final String CSS_LABEL_PROD1_TITULOBACKPACK = "#"+ID_LINK_PROD1_BACKPACK+ " div"; //Titulo do produto
	private final static String ID_BOTAO_PROD1_BACKPACK="add-to-cart-sauce-labs-backpack";//Localizador botao adicionar
	private static final String ID_BOTAO_PROD1_REMOVERBACKPACK = "remove-sauce-labs-backpack"; //Localizador botão remover
	private static final String BASE_PROD1_BACKPACK =BASE_PRODS+"(1)";
	private static final String CSS_LABEL_PROD1_DESCRICAOBACKPACK= BASE_PROD1_BACKPACK+ " .inventory_item_desc";
	private static final String CSS_LABEL_PROD1_PRECOBACKPACK = BASE_PROD1_BACKPACK+ " .inventory_item_price";
	
	//Dados produto 2
	
	private static final String ID_LINK_PROD2_BIKELIGHT = "item_0_title_link";
	private static final String CSS_LABEL_PROD2_TITULOBIKELIGHT = "#"+ID_LINK_PROD2_BIKELIGHT+ " div";	
	private final static String ID_BOTAO_PROD2_BIKELIGHT="add-to-cart-sauce-labs-bike-light";
	private static final String ID_BOTAO_PROD2_REMOVERBIKELIGHT = "remove-sauce-labs-bike-light";
	private static final String BASE_PROD2_BIKELIGHT =BASE_PRODS+"(2)";
	private static final String CSS_LABEL_PROD2_DESCRICAOBIKELIGHT= BASE_PROD2_BIKELIGHT+ " .inventory_item_desc";
	private static final String CSS_LABEL_PROD2_PRECOBIKELIGHT = BASE_PROD2_BIKELIGHT+ " .inventory_item_price";
	
	//Dados produto 3
	
	private static final String ID_LINK_PROD3_BOLTTSHIRT = "item_1_title_link";
	private static final String CSS_LABEL_PROD3_TITULOBOLTTSHIRT = "#"+ID_LINK_PROD3_BOLTTSHIRT+ " div";			
	private final static String ID_BOTAO_PROD3_BOLTTSHIRT="add-to-cart-sauce-labs-bolt-t-shirt";
	private static final String ID_BOTAO_PROD3_REMOVERBOLTTSHIRT = "remove-sauce-labs-bolt-t-shirt";
	private static final String BASE_PROD3_BOLTTSHIRT =BASE_PRODS+"(3)";
	private static final String CSS_LABEL_PROD3_DESCRICAOBOLTTSHIRT= BASE_PROD3_BOLTTSHIRT+ " .inventory_item_desc";
	private static final String CSS_LABEL_PROD3_PRECOBOLTTSHIRT = BASE_PROD3_BOLTTSHIRT+ " .inventory_item_price";

	//Dados produto 4
	
	private static final String ID_LINK_PROD4_FLEECEJACKET = "item_5_title_link";
	private static final String CSS_LABEL_PROD4_TITULOFLEECEJACKET = "#"+ID_LINK_PROD4_FLEECEJACKET+ " div";				
	private final static String ID_BOTAO_PROD4_FLEECEJACKET="add-to-cart-sauce-labs-fleece-jacket";
	private static final String ID_BOTAO_PROD4_REMOVERFLEECEJACKET = "remove-sauce-labs-fleece-jacket";
	private static final String BASE_PROD4_FLEECEJACKET =BASE_PRODS+"(4)";
	private static final String CSS_LABEL_PROD4_DESCRICAOFLEECEJACKET= BASE_PROD4_FLEECEJACKET+ " .inventory_item_desc";
	private static final String CSS_LABEL_PROD4_PRECOFLEECEJACKET = BASE_PROD4_FLEECEJACKET+ " .inventory_item_price";
	
	//Dados produto 5
	
	private static final String ID_LINK_PROD5_ONESIE = "item_2_title_link";
	private static final String CSS_LABEL_PROD5_TITULOONESIE = "#"+ID_LINK_PROD5_ONESIE+ " div";					
	private final static String ID_BOTAO_PROD5_ONESIE="add-to-cart-sauce-labs-onesie";
	private static final String ID_BOTAO_PROD5_REMOVERONESIE = "remove-sauce-labs-onesie";
	private static final String BASE_PROD5_ONESIE =BASE_PRODS+"(5)";
	private static final String CSS_LABEL_PROD5_DESCRICAOONESIE= BASE_PROD5_ONESIE+ " .inventory_item_desc";
	private static final String CSS_LABEL_PROD5_PRECOONESIE = BASE_PROD5_ONESIE+ " .inventory_item_price";
	
	//Dados produto 6
	
	private static final String ID_LINK_PROD6_TSHIRTRED = "item_3_title_link";
	private static final String CSS_LABEL_PROD6_TITULOTSHIRTRED = "#"+ID_LINK_PROD6_TSHIRTRED+ " div";					
	private final static String ID_BOTAO_PROD6_TSHIRTRED="add-to-cart-test.allthethings()-t-shirt-(red)";
	private static final String ID_BOTAO_PROD6_REMOVERTSHIRTRED = "remove-test.allthethings()-t-shirt-(red)";
	private static final String BASE_PROD6_TSHIRTRED =BASE_PRODS+"(6)";
	private static final String CSS_LABEL_PROD6_DESCRICAOTSHIRTRED= BASE_PROD6_TSHIRTRED+ " .inventory_item_desc";
	private static final String CSS_LABEL_PROD6_PRECOTSHIRTRED = BASE_PROD6_TSHIRTRED+ " .inventory_item_price";

	

	private static final String MSG_TITULO = "PRODUCTS";
	
	/**
	 * Construtor padrão
	 * 
	 * @param driver
	 */
	public InventarioPage(WebDriver driver) {
		super(driver, null);
		if (ePaginaInventario())
			constroiMapa();
	}
	
	/**
	 * Monta o mapa de botões para adicionar itens no carrinho
	 * 
	 */
	private void constroiMapa() {
		mapaprodutos = new HashMap<>();
		
		mapaprodutos.put(GHERKIN_PROD1_BACKPACK, new Produto(CSS_LABEL_PROD1_TITULOBACKPACK, 
				ID_LINK_PROD1_BACKPACK, CSS_LABEL_PROD1_DESCRICAOBACKPACK, 
				CSS_LABEL_PROD1_PRECOBACKPACK, ID_BOTAO_PROD1_BACKPACK,ID_BOTAO_PROD1_REMOVERBACKPACK));
		
		mapaprodutos.put(GHERKIN_PROD2_BIKELIGHT,new Produto(CSS_LABEL_PROD2_TITULOBIKELIGHT, 
				ID_LINK_PROD2_BIKELIGHT, CSS_LABEL_PROD2_DESCRICAOBIKELIGHT, 
				CSS_LABEL_PROD2_PRECOBIKELIGHT, ID_BOTAO_PROD2_BIKELIGHT, ID_BOTAO_PROD2_REMOVERBIKELIGHT));
		
		mapaprodutos.put(GHERKIN_PROD3_BOLTTSHIRT,new Produto(CSS_LABEL_PROD3_TITULOBOLTTSHIRT, 
				ID_LINK_PROD3_BOLTTSHIRT, CSS_LABEL_PROD3_DESCRICAOBOLTTSHIRT, 
				CSS_LABEL_PROD3_PRECOBOLTTSHIRT, ID_BOTAO_PROD3_BOLTTSHIRT, ID_BOTAO_PROD3_REMOVERBOLTTSHIRT));
		
		mapaprodutos.put(GHERKIN_PROD4_FLEECEJACKET,new Produto(CSS_LABEL_PROD4_TITULOFLEECEJACKET, 
				ID_LINK_PROD4_FLEECEJACKET, CSS_LABEL_PROD4_DESCRICAOFLEECEJACKET, 
				CSS_LABEL_PROD4_PRECOFLEECEJACKET, ID_BOTAO_PROD4_FLEECEJACKET, ID_BOTAO_PROD4_REMOVERFLEECEJACKET));
		
		mapaprodutos.put(GHERKIN_PROD5_ONESIE,new Produto(CSS_LABEL_PROD5_TITULOONESIE, 
				ID_LINK_PROD5_ONESIE, CSS_LABEL_PROD5_DESCRICAOONESIE,
				CSS_LABEL_PROD5_PRECOONESIE, ID_BOTAO_PROD5_ONESIE, ID_BOTAO_PROD5_REMOVERONESIE));
		
		mapaprodutos.put(GHERKIN_PROD6_TSHIRTRED,new Produto(CSS_LABEL_PROD6_TITULOTSHIRTRED, 
				ID_LINK_PROD6_TSHIRTRED, CSS_LABEL_PROD6_DESCRICAOTSHIRTRED, 
				CSS_LABEL_PROD6_PRECOTSHIRTRED, ID_BOTAO_PROD6_TSHIRTRED, ID_BOTAO_PROD6_REMOVERTSHIRTRED));
		
		capturaDadosValidacao();
	}

	/**
	 * Classe responsável por captura dos da página que podem ser utilizados 
	 *   para validações futuras e armazena dentro mapa
	 */
	private void capturaDadosValidacao() {
		Iterator<Map.Entry<String,Produto>> itr = mapaprodutos.entrySet().iterator();
		WebElement txtnome; 
		WebElement txtdescricao; 
		WebElement txtpreco;
		
		while (itr.hasNext()) {
			Map.Entry<String, Produto> item = itr.next();
			if (item.getValue().getLocalizador_nome_produto()!=null) {
				txtnome= driver.findElement(By.cssSelector(item.getValue().getLocalizador_nome_produto()));
				item.getValue().setNome_produto(txtnome.getText());
			}
			if (item.getValue().getLocalizador_descricao()!=null) {
				txtdescricao= driver.findElement(By.cssSelector(item.getValue().getLocalizador_descricao()));
				item.getValue().setDescricao_produto(txtdescricao.getText());
			}
			if (item.getValue().getLocalizador_valor()!=null) {
				txtpreco= driver.findElement(By.cssSelector(item.getValue().getLocalizador_valor()));
				item.getValue().setValor(txtpreco.getText());
			}
		}
		
		
	}
	
	
	/**
	 * 
	 * Verifica se a pagina atual é a pagina de inventario
	 * 
	 * @return
	 */
	public boolean ePaginaInventario() {
		
		return ePaginaAtual(URL_PAGINA_INVENTARIO);
	}

	/**
	 * 
	 * Verifica se o botão carrinho de compras esta presente
	 * 
	 * @return
	 */
	public boolean verificaBotaoCarrinhoCompras() {
		
		return elementoEstaPresente(By.cssSelector(CSSSELECTOR_LINK_CARRINHOCOMPRAS));
		
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

	/**
	 * Adiciona o produto informado no carrinho. Retornando falso se o produto não existir
	 * @param produto Aceita os valores: "Sauce Labs Backpack", "Sauce Labs Bike Light",
	 * 					"Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", 
	 * 					"Sauce Labs Onesie" ou "T-Shirt (Red)";
	 * @return
	 */
	public boolean adicionarProduto(String produto) {
		
		Produto produtoadicionar = mapaprodutos.get(produto);
		
		if (produtoadicionar!=null) {
			WebElement botaoadicionar = driver.findElement(By.id(produtoadicionar.getLocalizador_botao()));
			botaoadicionar.click();
			produtoscarrinho.add(produtoadicionar);
			return true;
		} else {
			return false;
		}
		
	}

	/**
	 * Verifica se o botão remover esta presenta na tela. Se a lista recebida for vazia retorna falso também
	 * @return
	 */
	public boolean verificaBotaoRemoverProduto() {
		
		for (Produto produtoadicionar : produtoscarrinho) {
		
			if (produtoadicionar!=null) {
				return elementoEstaPresente(By.id(produtoadicionar.getLocalizador_botao_remover()));
			} else {
		
				return false;
			}
		}
		return false;
	}

	/**
	 * 
	 * Verifica quantidade de itens no carrinho
	 * 
	 * @param numero Quantidade de itens no carrinho.
	 * 
	 * @return
	 */
	public boolean quantidadeItensCarrinhoE(int numero) {
		
		if (elementoEstaPresente(By.cssSelector(CSSSELECTOR_CONTEUDO_CARRINHOCOMPRAS))) {
			WebElement carrinhocompra = driver.findElement(By.cssSelector(CSSSELECTOR_CONTEUDO_CARRINHOCOMPRAS));
			return (numero == Integer.parseInt(carrinhocompra.getText()));
		} else {
			return (numero==0);
		}
	}

	public CartPage clicarLinkCarrinhoCompras() {
		
		WebElement linkcarrinho = driver.findElement(By.cssSelector(CSSSELECTOR_LINK_CARRINHOCOMPRAS));
		linkcarrinho.click();
		
		return new CartPage (driver,produtoscarrinho);
	}
	
	/**
	 * Verifica se o texto no inicio da página é o texto identificando a página corretamente
	 * @return
	 */
	public boolean verificaTextoTituloInventario() {
		By localizadortitulo = By.cssSelector(CSS_LABEL_TITULOINVENTARIO);
		
		return verificaSeMensagemEApresentadaLocalizador(localizadortitulo, MSG_TITULO);
	}
	
}
