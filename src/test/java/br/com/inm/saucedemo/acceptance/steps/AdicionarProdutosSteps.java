/**
 * 
 */
package br.com.inm.saucedemo.acceptance.steps;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import br.com.inm.saucedemo.e2e.pages.CartPage;
import br.com.inm.saucedemo.e2e.pages.InventarioPage;
import br.com.inm.saucedemo.e2e.pages.LoginPage;
import br.com.inm.saucedemo.massatestes.MassaUiBase;
import br.com.inm.saucedemo.massatestes.MassaUiLogin;
import br.com.inm.saucedemo.massatestes.MassaUiProdutos;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

/**
 * 
 * Classe que contem os steps da feature adicionar produtos.
 * 
 * @author August Neto
 *
 */
public class AdicionarProdutosSteps {

	private LoginPage paginalogin;
	private InventarioPage paginainventario;
	private CartPage paginacarrinho;
	
	//Massas
	private String navegador = MassaUiBase.NAVEGADOR_FIREFOX;
	
	private String usuario = MassaUiLogin.USUARIO_OK_USERNAME;
	private String senha = MassaUiLogin.SENHA_OK;
	
	private String prod1 = MassaUiProdutos.PRODUTO1;
	private String prod2 = MassaUiProdutos.PRODUTO5;
	
	
	
	@Dado("um usuario logado na página de inventário")
	public void um_usuario_logado_na_página_de_inventário() {
		paginalogin = new LoginPage(navegador);
		
		paginainventario = paginalogin.efetuarLogin(usuario, senha);
		
	}

	@Dado("carrinho esta vazio")
	public void carrinho_esta_vazio() {
		assertFalse(paginainventario.carrinhoComItens(),"Problema na massa!!! Carrinho já possui item");
	}
	
	@Quando("escolho o produto {string} e clico no botao adicionar no carrinho equivalente")
	public void escolho_o_produto_e_clico_no_botao_adicionar_no_carrinho_equivalente(String produto) {
	    assertTrue(paginainventario.adicionarProduto(produto),"Problem na massa!!! Produto inexistente");
	}
	
	@Entao("botão\\(s) clicado\\(s) deve\\(m) ser alterado\\(s) para remover")
	public void botãos_clicados_devem_ser_alterados_para_remover() {
	    assertTrue(paginainventario.verificaBotaoRemoverProduto());
	}
	
	@Entao("carrinho deve indicar que possui {int} produtos adicionados")
	public void carrinho_deve_indicar_que_possui_um_produto_adicionado(int quantidade) {
		assertTrue(paginainventario.quantidadeItensCarrinhoE(quantidade));
	}
	
	@Quando("clicar no carrinho")
	public void clicar_no_carrinho() {
		paginacarrinho=paginainventario.clicarLinkCarrinhoCompras();
	}
	
	@Entao("deve ser direcionado para a página do carrinho")
	public void deve_ser_direcionado_para_a_página_do_carrinho() {
		assertTrue(paginacarrinho.ePaginaCarrinho());
		assertTrue(paginacarrinho.verificaTextoSeuCarrinho());
	}
	
	@Entao("deve ser exibido os itens selecionados com os mesmos dados da página anterior")
	public void deve_ser_exibido_os_itens_selecionados_com_os_mesmos_dados_da_página_anterior() {
		assertTrue(paginacarrinho.verificaItensNoCarrinho());
		paginacarrinho.clean();
	}
	
	@Quando("escolho dois produtos e clico no botao adicionar no carrinho equivalente de ambos")
	public void escolho_dois_produtos_e_clico_no_botao_adicionar_no_carrinho_equivalente_de_ambos() {
		assertTrue(paginainventario.adicionarProduto(prod1),"Problem na massa!!! Produto inexistente");
		assertTrue(paginainventario.adicionarProduto(prod2),"Problem na massa!!! Produto inexistente");

	}
	
	@Entao("não deve ser apresentado itens na tela")
	public void não_deve_ser_apresentado_itens_na_tela() {
		assertTrue(paginacarrinho.verificaItensNoCarrinho());
		paginacarrinho.clean();
	}
	
}
