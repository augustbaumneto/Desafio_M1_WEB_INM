/**
 * 
 */
package br.com.inm.saucedemo.acceptance.steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import br.com.inm.saucedemo.e2e.pages.CartPage;
import br.com.inm.saucedemo.e2e.pages.CheckoutComplete;
import br.com.inm.saucedemo.e2e.pages.CheckoutInformacionPage;
import br.com.inm.saucedemo.e2e.pages.CheckoutOverviewPage;
import br.com.inm.saucedemo.e2e.pages.InventarioPage;
import br.com.inm.saucedemo.e2e.pages.LoginPage;
import br.com.inm.saucedemo.massatestes.MassaUiBase;
import br.com.inm.saucedemo.massatestes.MassaUiDadosCliente;
import br.com.inm.saucedemo.massatestes.MassaUiLogin;
import br.com.inm.saucedemo.massatestes.MassaUiProdutos;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

/**
 * 
 * Classe que contem os steps da feature checkout.
 * 
 * @author August Neto
 *
 */
public class CheckoutSteps {

	private LoginPage paginalogin;
	private InventarioPage paginainventario;
	private CartPage paginacarrinho;
	private CheckoutInformacionPage paginainformacaocheckout;
	private CheckoutOverviewPage paginaconfirmacaodadoscheckout;
	private CheckoutComplete paginaconclusaocheckout;
	
	//Massas
	private String navegador = MassaUiBase.NAVEGADOR_FIREFOX;
	
	private String usuario = MassaUiLogin.USUARIO_OK_USERNAME;
	private String senha = MassaUiLogin.SENHA_OK;
	
	private String prod1 = MassaUiProdutos.PRODUTO1;
	private String prod2 = MassaUiProdutos.PRODUTO6;
	
	private String nome = MassaUiDadosCliente.NOME_OK;
	private String sobrenome = MassaUiDadosCliente.SOBRENOME_OK;
	private String cep = MassaUiDadosCliente.CEP_OK;
	
	@Dado("um usuario logado na página de carrinho")
	public void um_usuario_logado_na_página_de_carrinho() {
		paginalogin = new LoginPage(navegador);
		paginainventario = paginalogin.efetuarLogin(usuario, senha);
	}
	
	@Dado("existem produtos no carrinho")
	public void existem_produtos_no_carrinho() {
		assertTrue(paginainventario.adicionarProduto(prod1),"Problem na massa!!! Produto inexistente");
		assertTrue(paginainventario.adicionarProduto(prod2),"Problem na massa!!! Produto inexistente");
		paginacarrinho=paginainventario.clicarLinkCarrinhoCompras();
	}
	
	@Quando("clicar no botão de checkout")
	public void clicar_no_botão_de_checkout() {
		paginainformacaocheckout=paginacarrinho.iniciarCheckout();
	}
	
	
	@Entao("deve ser exibido a tela de preenchimento das informações do cliente")
	public void deve_ser_exibido_a_tela_de_prrenchimento_das_informações_do_cliente() {
		assertTrue(paginainformacaocheckout.ePaginaInformacaoCliente());
		assertTrue(paginainformacaocheckout.verificaTextoSuasInformacoes());
	}
	
	@Quando("preencher com dados válidos do cliente")
	public void preencher_com_dados_válidos() {
		paginainformacaocheckout.preencherDadosValidos(nome, sobrenome, cep);
	}
	
	@Quando("clicar em continuar")
	public void clicar_em_continuar() {
		paginaconfirmacaodadoscheckout=paginainformacaocheckout.enviarDadosPessoais();
	}
	
	@Entao("deve ser exibida a tela de confirmação do checkout")
	public void deve_ser_exibida_a_tela_de_confirmação_do_checkout() {
		assertTrue(paginaconfirmacaodadoscheckout.ePaginaConfirmacaoCheckout());
		assertTrue(paginaconfirmacaodadoscheckout.verificaTextoTituloOverview());
	}
	
	@Entao("deve ser exibido os itens do carrinho com os mesmos dados da página de carrinho")
	public void deve_ser_exibido_os_itens_do_carrinho_com_os_mesmos_dados_da_página_de_carrinho() {
		assertTrue(paginaconfirmacaodadoscheckout.verificaItensNoCarrinho());
	}
	
	@Entao("valor total exibido deve ser a soma dos valores de todos os itens mais a taxa exibida")
	public void valor_total_exibido_deve_ser_a_soma_dos_valores_de_todos_os_itens_mais_a_taxa_exibida() {
		assertTrue(paginaconfirmacaodadoscheckout.verificaSomatorioValoresItensExibidos());
		assertTrue(paginaconfirmacaodadoscheckout.verificaSomatorioValoresTotalComTaxasExibido());
	}
	
	@Quando("clicar em finalizar")
	public void clicar_em_finalizar() {
		paginaconclusaocheckout=paginaconfirmacaodadoscheckout.finalizar();
	}
	
	@Entao("deve ser exibida a página de conclusão do checkout")
	public void deve_ser_exibida_a_página_de_conclusão_do_checkout() {
		assertTrue(paginaconclusaocheckout.ePaginaConclusaoCheckout());
	}
	
	@Entao("deve ser exibida mensagem de confimação da ordem")
	public void deve_ser_exibida_mensagem_de_confimação_da_ordem() {

	}

	@Entao("carrinho deve estar vazio")
	public void carrinho_deve_estar_vazio() {
		paginaconfirmacaodadoscheckout.clean();
	}	
	
}
