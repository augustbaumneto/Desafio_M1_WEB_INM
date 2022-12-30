/**
 * 
 */
package br.com.inm.saucedemo.acceptance.steps;

import static org.junit.jupiter.api.Assertions.assertFalse;

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
	
	private String navegador = MassaUiBase.NAVEGADOR_INTERNO;
	
	private String usuario = MassaUiLogin.USUARIO_OK_USERNAME;
	private String senha = MassaUiLogin.SENHA_OK;
	
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
	    paginainventario.adicionarProduto(produto);
	}
	
	@Entao("botão clicado deve ser alterado para remover")
	public void botão_clicado_deve_ser_alterado_para_remover() {
	    
	}
	
	@Entao("carrinho deve indicar que possui um produto adicionado")
	public void carrinho_deve_indicar_que_possui_um_produto_adicionado() {
	    
	}
	
	@Quando("clicar no carrinho")
	public void clicar_no_carrinho() {
	    
	}
	
	@Entao("deve ser direcionado para a página do carrinho")
	public void deve_ser_direcionado_para_a_página_do_carrinho() {
	   
	}
	
	@Entao("deve ser exibido o item selecionado com os mesmos dados da página anterior")
	public void deve_ser_exibido_o_item_selecionado_com_os_mesmos_dados_da_página_anterior() {


	}

	
}
