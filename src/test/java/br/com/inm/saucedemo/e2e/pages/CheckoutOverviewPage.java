/**
 * 
 */
package br.com.inm.saucedemo.e2e.pages;

import java.math.BigDecimal;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.inm.saucedemo.modelos.Produto;

/**
 * Classe Page Objects da página de confirmação do checkout
 * @author August Neto
 *
 */
public class CheckoutOverviewPage extends ObjectPageBase {

	//Tamanho máximo de itens possíveis para exibição na tela
	private static final int TAMANHOMAX_LISTAPRODUTOS = 6;
	//Primeira criança no CSS da lista de itens exibidos
	private final static int PRIMEIRO_ITEM_DA_LISTA_CSS = 3;
	
	private final static String URL_PAGINA_CHECKOUTCONFIRMACAO = "https://www.saucedemo.com/checkout-step-two.html";

	private static final String CSS_LABEL_TITULOOVERVIEW = "#header_container .title";
	private static final String CSS_LABEL_SOMATORIOITENS = ".summary_subtotal_label";
	private static final String CSS_LABEL_TAXAS = ".summary_tax_label";
	private static final String CSS_LABEL_SOMATORIOCOMTAXAS = ".summary_total_label";
	private static final String ID_BOTAO_FINALIZAR = "finish";

	//Localizadores da lista de produtos
	private final static String CSS_BASE_ITEMLISTA_PROD = ".cart_item";

	private static final String CSS_SUFIXO_LISTA_PROD_NOME = " .inventory_item_name";
	private static final String CSS_SUFIXO_LISTA_PROD_LINK = " a";
	private static final String CSS_SUFIXO_LISTA_PROD_DESCRICAO = " .inventory_item_desc";
	private static final String CSS_SUFIXO_LISTA_PROD_PRECO = " .inventory_item_price";
		
	
	private static final String MSG_TITULO = "CHECKOUT: OVERVIEW";

	
	private List<Produto> listacompras;
	private List<Produto> produtosexibidos;
	
	/**
	 * Construtor padrão
	 * @param driver
	 * @param listacompras
	 */
	public CheckoutOverviewPage(WebDriver driver, List<Produto> listacompras) {
		super(driver, null);
		this.listacompras=listacompras;
		this.produtosexibidos=constroiListaProdutosExibidos(TAMANHOMAX_LISTAPRODUTOS,PRIMEIRO_ITEM_DA_LISTA_CSS,
				CSS_BASE_ITEMLISTA_PROD, CSS_SUFIXO_LISTA_PROD_NOME, 
				CSS_SUFIXO_LISTA_PROD_LINK, CSS_SUFIXO_LISTA_PROD_DESCRICAO,
				CSS_SUFIXO_LISTA_PROD_PRECO, null);
	}	
	
	
	/**
	 * Verifica se esta na página de checkout de confirmacao de dados da compra
	 * 
	 * @return
	 */
	public boolean ePaginaConfirmacaoCheckout() {
		return ePaginaAtual(URL_PAGINA_CHECKOUTCONFIRMACAO);
	}

	/**
	 * Verifica se o texto no inicio da página é o texto identificando a página corretamente
	 * @return
	 */
	public boolean verificaTextoTituloOverview() {
		By localizadortitulo = By.cssSelector(CSS_LABEL_TITULOOVERVIEW);
		
		return verificaSeMensagemEApresentadaLocalizador(localizadortitulo, MSG_TITULO);
	}

	/**
	 * Verifica se os produtos adicionados são exibidas na tela de confirmação, se estão na ordem correta e 
	 *    se os dados são os mesmos da tela de inventário.
	 * 
	 * @return
	 */
	public boolean verificaItensNoCarrinho() {
		
		if (listacompras.size()!=produtosexibidos.size())
			return false;
		
		for (int i=0; i<produtosexibidos.size();i=i+1) {
			if (!produtosexibidos.get(i).comparaDadosTextoCom(listacompras.get(i))) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Calcula a somatória dos itens
	 * @return
	 */
	private BigDecimal calculaValorTotalItens(List<Produto> produtos) {
		BigDecimal somatoria = BigDecimal.ZERO;
		for(Produto p : produtos) {
			somatoria=somatoria.add(p.getValor());
		} 
		
		return somatoria;
	}
	
	/**
	 * Calcula a somatória dos itens junto com as taxas
	 * @return
	 */
	private BigDecimal calculaValorTotalComTaxas() {
		BigDecimal somatoria = calculaValorTotalItens(produtosexibidos);
		
		WebElement txttaxa = driver.findElement(By.cssSelector(CSS_LABEL_TAXAS));

		somatoria = somatoria.add(new BigDecimal(txttaxa.getText().substring(6)));
		return somatoria;
	}
	
	/**
	 * Verifica se a soma dos valores exibidos é igual ao subtotal exibido na tela
	 * @return
	 */
	public boolean verificaSomatorioValoresItensExibidos() {
		WebElement txtsubtotal = driver.findElement(By.cssSelector(CSS_LABEL_SOMATORIOITENS));
		
		BigDecimal subtotal = new BigDecimal(txtsubtotal.getText().substring(13));
		return subtotal.compareTo(calculaValorTotalItens(produtosexibidos))==0;
	}
	
	/**
	 * Verifica se a soma dos valores exibidos é igual ao total considerando a taxa
	 * @return
	 */
	public boolean verificaSomatorioValoresTotalComTaxasExibido() {
		WebElement txttotalcomtaxas = driver.findElement(By.cssSelector(CSS_LABEL_SOMATORIOCOMTAXAS));
		
		BigDecimal total = new BigDecimal(txttotalcomtaxas.getText().substring(8));
		return total.compareTo(calculaValorTotalComTaxas())==0;
	}


	/**
	 * Finaliza o checkout
	 * @return
	 */
	public CheckoutCompletePage finalizar() {
		WebElement botaofinalizar = driver.findElement(By.id(ID_BOTAO_FINALIZAR));
		botaofinalizar.click();
		
		return new CheckoutCompletePage(driver);
	}
	
}
