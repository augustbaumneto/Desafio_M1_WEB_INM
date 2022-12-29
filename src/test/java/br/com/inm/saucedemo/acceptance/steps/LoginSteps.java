package br.com.inm.saucedemo.acceptance.steps;

import static org.junit.jupiter.api.Assertions.assertTrue;
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
 * Classe que contem os steps da Feature login
 * 
 * @author August Neto
 *
 */
public class LoginSteps {

	private LoginPage paginalogin;
	private InventarioPage paginainventario;
	
	private String navegador = MassaUiBase.NAVEGADOR_FIREFOX;
	
	private String usuario;
	private String senha;
	
	
	@Dado("um usuario valido não bloqueado")
	public void um_usuario_valido_nao_bloqueado() {
	    paginalogin = new LoginPage(navegador);
	    usuario = MassaUiLogin.USUARIO_OK_USERNAME;
	    senha = MassaUiLogin.SENHA_OK;
	}
	
	@Quando("tenta se logar")
	public void tenta_se_logar() {
	    paginainventario=paginalogin.efetuarLogin(usuario, senha);
		
	}
	
	@Entao("é redirecionado para a página de inventário")
	public void é_redirecionado_para_a_página_de_inventário() {
	    
		assertTrue(paginainventario.estaNaPaginaInventario());
		assertFalse(paginalogin.estaNaPaginaDeLogin());
		assertTrue(paginainventario.verificaBotaoCarrinhoCompras());
		
		paginainventario.clean();
	}

	@Dado("um usuario com username {string} e senha {string}")
	public void um_usuario_com_username_e_senha(String dado1, String dado2) {
		paginalogin = new LoginPage(navegador);
		switch (dado1) {
			case "correto":{
				usuario = MassaUiLogin.USUARIO_OK_USERNAME;
				break;
			}
			case "vazio":{
				usuario = "";
				break;
			}
			case "incorreto":{
				usuario = MassaUiLogin.USUARIO_INEXISTENTE_USERNAME;
				break;
			}
			default:{
				usuario = MassaUiLogin.USUARIO_OK_USERNAME;
				break;
			}
		}
		switch (dado2) {
			case "correta":{
				senha = MassaUiLogin.SENHA_OK;
				break;
			}
			case "vazia":{
				senha = "";
				break;
			}
			case "incorreta":{
				senha = MassaUiLogin.SENHA_INCORRETA;
				break;
			}
			default:{
				usuario = MassaUiLogin.USUARIO_OK_USERNAME;
				break;
			}
		}
	}
	
	@Entao("deve continua na pagina de login")
	public void deve_continua_na_pagina_de_login() {
		assertFalse(paginainventario.estaNaPaginaInventario());
		assertTrue(paginalogin.estaNaPaginaDeLogin());
	}
	
	@Entao("mensagem de erro informando que {string} é apresentada")
	public void mensagem_de_erro_informando_que_é_apresentada(String mensagemdeerro) {
		switch (mensagemdeerro) {
			case "usuario é necessário":{
				assertTrue(paginalogin.mensagemErroFaltaUsuarioExibida());
				break;
			}
			case "senha é necessária":{
				assertTrue(paginalogin.mensagemErroFaltaSenhaExibida());
				break;
			}
			case "usuario e senha não combinam":{
				assertTrue(paginalogin.mensagemErroUsuarioESenhaNaoCombinamExibida());
				break;
			}
			default:{
				assertTrue(false,"Mensagem de erro computada não condizente");
				break;
			}
		}
		
		paginalogin.clean();

	}
	
}
