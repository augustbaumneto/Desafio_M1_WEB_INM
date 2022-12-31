/**
 * 
 */
package br.com.inm.saucedemo.acceptance.steps;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import br.com.inm.saucedemo.e2e.pages.CartPage;
import br.com.inm.saucedemo.e2e.pages.InventarioPage;
import br.com.inm.saucedemo.e2e.pages.LoginPage;
import br.com.inm.saucedemo.massatestes.MassaUiBase;
import br.com.inm.saucedemo.massatestes.MassaUiLogin;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

/**
 * 
 * Classe que contem os steps da feature adicionar produtos. Alguns steps de login estão armazenados na classe loginsteps
 * 
 * @author August Neto
 *
 */
public class AdicionarProdutosSteps {

	private LoginPage paginalogin;
	private InventarioPage paginainventario;
	private CartPage paginacarrinho;
	
	private String navegador = MassaUiBase.NAVEGADOR_INTERNO;
	
	private String usuario = MassaUiLogin.USUARIO_OK_USERNAME;
	private String senha = MassaUiLogin.SENHA_OK;
	
	private List<String> itensadicionados = new ArrayList<>();
	
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
	    //Guarda os itens adicionados
	    itensadicionados.add(produto);
	}
	
	@Entao("botão clicado deve ser alterado para remover")
	public void botão_clicado_deve_ser_alterado_para_remover() {
	    assertTrue(paginainventario.verificaBotaoRemoverProduto(itensadicionados.get(0)));
	}
	
	@Entao("carrinho deve indicar que possui um produto adicionado")
	public void carrinho_deve_indicar_que_possui_um_produto_adicionado() {
		assertTrue(paginainventario.quantidadeItensCarrinhoE(1));
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
	
	@Entao("deve ser exibido o item selecionado com os mesmos dados da página anterior")
	public void deve_ser_exibido_o_item_selecionado_com_os_mesmos_dados_da_página_anterior() {
		assertTrue(paginacarrinho.verificaItens(itensadicionados));

	}
	
}
