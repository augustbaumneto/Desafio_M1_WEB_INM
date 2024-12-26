package br.com.inm.saucedemo.configuracao;

/**
 * 
 * Classe que armazena os enderecos configurados.
 * 
 * @author August Neto
 *
 */
public class EnderecosConfiguracao {

	private static String caminhorelatorios = "target/reports";
	
	
	/**
	 * Método que retorna o caminho da pasta que deverá armazenar os relatórios
	 * 
	 * @return String caminho
	 */
	public static String getcaminhorelatorios() {
		return caminhorelatorios;
	}

}
