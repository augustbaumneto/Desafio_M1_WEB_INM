package br.com.inm.saucedemo.e2e.pages;

import java.util.function.BooleanSupplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * 
 * PageObject da página de login
 * 
 * @author August Neto
 *
 */
public class LoginPage extends ObjectPageBase {

	private static String URL_LOGIN_PAGE = "https://www.saucedemo.com/";

	private static String ID_CAMPO_USERNAME = "user-name";
	private static String ID_CAMPO_PASSWORD = "password";
	private static String ID_BOTAO_LOGIN = "login-button";
	private static String CSSSELECTOR_LABEL_MENSAGEMERROLOGIN = "#login_button_container h3";
	
	private static String MSG_ERRO_USUARIOFALTANDO ="Epic sadface: Username is required";
	private static String MSG_ERRO_SENHAFALTANDO ="Epic sadface: Password is required";
	private static String MSG_ERRO_USUARIOEOUSENHAERRADOS ="Epic sadface: Username and password do not match any user in this service";
	
	/**
	 * 
	 * Construtor do primeiro acesso
	 * 
	 * @param driver
	 */
    public LoginPage(String navegador) {
        super(null,navegador);
        driver.get(URL_LOGIN_PAGE);
    }
    
    /**
     * 
     * Construtor da pagina ao acessar de uma outra página
     * 
     * @param driver
     */
    protected LoginPage(WebDriver driver) {
    	super(driver,null);
    }

    /**
     * 
     * Preenche os campos login e senha
     * 
     * @param nome
     * @param senha
     */
    public void preencheDadosLogin(String nome, String senha) {
    	

        WebElement camponome = this.driver.findElement(By.id(ID_CAMPO_USERNAME));
        WebElement camposenha = this.driver.findElement(By.id(ID_CAMPO_PASSWORD));

        camponome.sendKeys(nome);
        camposenha.sendKeys(senha);

    }
    
    /**
     * 
     * Efetuar login
     * 
     * @param nome
     * @param senha
     */
    public InventarioPage efetuarLogin(String nome, String senha) {
    	

        preencheDadosLogin(nome, senha);

        WebElement botaologin = this.driver.findElement(By.id(ID_BOTAO_LOGIN));
        botaologin.submit();

        return new InventarioPage(this.driver);
    }
    
    /**
     * 
     * Verifica se a pagina atual é a de login
     * 
     * @return
     */
	public boolean estaNaPaginaDeLogin() {
		
		return ePaginaAtual(URL_LOGIN_PAGE);
	}
/*	
	public void esperaCarregarPaginaDeLeiloes() {
		WebDriverWait wait = new WebDriverWait(driver,2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Todos leilões')]")));
	}

*/

	/**
	 * 
	 * Verifica se a mensagem de erro de usuario e senha não combinam é exibida
	 * 
	 * @return
	 */
	public boolean mensagemErroUsuarioESenhaNaoCombinamExibida() {
		WebElement labelerro = driver.findElement(By.cssSelector(CSSSELECTOR_LABEL_MENSAGEMERROLOGIN));
		System.out.println(labelerro.getText());
		return labelerro.getText().equals(MSG_ERRO_USUARIOEOUSENHAERRADOS);
	}
	
	/**
	 * 
	 * Verifica se a mensagem de erro de senha faltando é exibida
	 * 
	 * @return
	 */
	public boolean mensagemErroFaltaSenhaExibida() {
		WebElement labelerro = driver.findElement(By.cssSelector(CSSSELECTOR_LABEL_MENSAGEMERROLOGIN));
		System.out.println(labelerro.getText());
		return labelerro.getText().equals(MSG_ERRO_SENHAFALTANDO);
	}
	
	/**
	 * 
	 * Verifica se a mensagem de erro de usuario faltando é exibida
	 * 
	 * @return
	 */
	public boolean mensagemErroFaltaUsuarioExibida() {
		WebElement labelerro = driver.findElement(By.cssSelector(CSSSELECTOR_LABEL_MENSAGEMERROLOGIN));
		System.out.println(labelerro.getText());
		return labelerro.getText().equals(MSG_ERRO_USUARIOFALTANDO);
	}
	
}
