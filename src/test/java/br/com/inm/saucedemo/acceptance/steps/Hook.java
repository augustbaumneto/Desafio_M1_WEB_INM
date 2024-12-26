/**
 * 
 */
package br.com.inm.saucedemo.acceptance.steps;

import br.com.inm.saucedemo.utils.ManipulacaoArquivo;
import io.cucumber.java.BeforeAll;

/**
 * Classe responsável por guardar os métodos hooks
 */
public class Hook {

	/**
	 * Método responsável por fazer as preparações para os reportes
	 */
	@BeforeAll
	public static void setupRelatorios() {
		ManipulacaoArquivo.criaPasta("target/reports");
	}
	
}
