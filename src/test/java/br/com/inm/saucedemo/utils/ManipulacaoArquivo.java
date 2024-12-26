/**
 * 
 */
package br.com.inm.saucedemo.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * Classe responsável por manipular arquivos
 * 
 * @author August Neto
 *
 */
public class ManipulacaoArquivo {

	private File arquivobase;
 
	/**
	 * Construtor que recebe a pasta do arquivo
	 * @param pasta
	 */
	public ManipulacaoArquivo(String pasta) {
		arquivobase = new File(pasta);
	}
	
	/**
	 * Método que apaga todos os arquivos de uma determinada pasta
	 */
	public void limpaPasta() {
		File[] listaarquivos = arquivobase.listFiles();
    	if (listaarquivos !=null) {
    		
    		for (File tmp : listaarquivos) {
    			String nome = tmp.getAbsolutePath();
    		
    		
    			if (tmp.isDirectory()) {
    				try {
    					FileUtils.cleanDirectory(tmp);
    					FileUtils.deleteDirectory(tmp);
    				} catch(IOException e) {
    				}
    			} else {
    				tmp.delete();
    			}
    		}
    		
    	}
	}
	
	/**
	 * Método que cria uma pasta
	 */
	public static void criaPasta(String caminhodapasta) {
		File pasta = new File(caminhodapasta);
		
		if(pasta.exists()) {
		}else {
			//Se não existir cria a pasta
			try{
                pasta.mkdir();
            } catch (SecurityException e) {
            }
		}
		
	}
	
	/**
	 * Método que renomeia uma pasta
	 */
	public static void renomeiaPasta(String nomeantigo, String nomenovo) {
		File pasta = new File(nomeantigo);
		
		if(pasta.exists()) {
			pasta.renameTo(new File(nomenovo));
		}else {
            } 
		}
		
	
}
