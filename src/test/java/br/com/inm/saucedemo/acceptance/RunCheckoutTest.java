package br.com.inm.saucedemo.acceptance;

//import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PUBLISH_QUIET_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

/**
 * 
 * Classe responsável pela execução dos testes da feature checkout
 * 
 * @author August Neto
 *
 */

@Suite
@SuiteDisplayName("Testes: Checkout Sauce Demo")	//Nome da suite para exibição
@IncludeEngines("cucumber")						//Motor Executor
@SelectClasspathResource("features")			//Caminho das features
@IncludeTags("checkout")							//Tags executadas
@ConfigurationParameter(key = PLUGIN_PUBLISH_QUIET_PROPERTY_NAME, value = "true") //Configura para não exibir o quadro do cucumber no console
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty,html:target/reports/cucumbercheckout.html,json:target/reports/cucumbercheckout.json") //Configura para o Gherkin de cada step sair no console.
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "br.com.inm.saucedemo.acceptance.steps") //Configura o caminho das classes com os steps
public class RunCheckoutTest {
}
