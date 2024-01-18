package br.com.inm.saucedemo.e2e.pages;





import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



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
	private static String MSG_ERRO_USUARIOBLOQUEADO = "Epic sadface: Sorry, this user has been locked out.";
	/**
	 * 
	 * Construtor do primeiro acesso
	 * 
	 * @param navegador
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
	public boolean ePaginaDeLogin() {
		
		return ePaginaAtual(URL_LOGIN_PAGE);
	}


	/**
	 * 
	 * Verifica se a mensagem de erro de usuario e senha não combinam é exibida
	 * 
	 * @return
	 */
	public boolean mensagemErroUsuarioESenhaNaoCombinamExibida() {
		By localizadormenserro = By.cssSelector(CSSSELECTOR_LABEL_MENSAGEMERROLOGIN);
		
		return verificaSeMensagemEApresentadaLocalizador(localizadormenserro, MSG_ERRO_USUARIOEOUSENHAERRADOS);
	}
	
	/**
	 * 
	 * Verifica se a mensagem de erro de senha faltando é exibida
	 * 
	 * @return
	 */
	public boolean mensagemErroFaltaSenhaExibida() {
		By localizadormenserro = By.cssSelector(CSSSELECTOR_LABEL_MENSAGEMERROLOGIN);
		
		return verificaSeMensagemEApresentadaLocalizador(localizadormenserro, MSG_ERRO_SENHAFALTANDO);
	}
	
	/**
	 * 
	 * Verifica se a mensagem de erro de usuario faltando é exibida
	 * 
	 * @return
	 */
	public boolean mensagemErroFaltaUsuarioExibida() {
		By localizadormenserro = By.cssSelector(CSSSELECTOR_LABEL_MENSAGEMERROLOGIN);
		
		return verificaSeMensagemEApresentadaLocalizador(localizadormenserro, MSG_ERRO_USUARIOFALTANDO);
	}

	/**
	 * 
	 * Verifica se a mensagem de erro de usuario bloqueado é exibida
	 * 
	 * @return
	 */
	public boolean mensagemErroUsuarioBloqueadoExibida() {
		By localizadormenserro = By.cssSelector(CSSSELECTOR_LABEL_MENSAGEMERROLOGIN);
		
		return verificaSeMensagemEApresentadaLocalizador(localizadormenserro, MSG_ERRO_USUARIOBLOQUEADO);
	}
	
}
