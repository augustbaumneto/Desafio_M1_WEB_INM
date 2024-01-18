/**
 * 
 */
package br.com.inm.saucedemo.massatestes;

/**
 * 
 * Classe que guarda os valores possível para o ambiente.
 * 
 */
public class MassaUiAmbiente {

	/**
	 * Representa se a execução será ou não com interface (headless)
	 */
	public static enum tipo_execucao {
		SEM_INTERFACE(true), 
		COM_INTERFACE(false);
		
		private final boolean flagrepresentante;
		
		tipo_execucao(boolean flag){
			this.flagrepresentante=flag;
		}
		
		public boolean getFlag() {
            return this.flagrepresentante;
        }
		
		};

}
