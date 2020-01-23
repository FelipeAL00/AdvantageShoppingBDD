package br.com.rsinet.HUB_BDD.stepDefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.HUB_BDD.manager.PageObjectManager;
import br.com.rsinet.HUB_BDD.manager.WebDriverManager;
import br.com.rsinet.HUB_BDD.pageFactory.SearchPage;
import cucumber.api.DataTable;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class PesquisaPelaBarra {
	private WebDriver driver;
	private SearchPage	searchPage;
	private PageObjectManager pageObjectManager;
	private WebDriverManager webDriver;
	
	@Dado("^em que estou na tela inicial$")
	public void em_que_estou_na_tela_inicial() throws Throwable {
		webDriver = new WebDriverManager();
		driver = webDriver.getDriver();
		pageObjectManager = new PageObjectManager(driver);
		searchPage = pageObjectManager.getSearchPage();

	}

	@Quando("^clico na lupa de pesquisa$")
	public void clico_na_lupa_de_pesquisa() throws Throwable {
	    searchPage.lupaPesquisa();
	}

	@Quando("^escrevo o produto no qual quero pesquisar$")
	public void escrevo_o_produto_no_qual_quero_pesquisar(DataTable dados) throws Throwable {
		for (Map<String, String> dado : dados.asMaps(String.class, String.class)) {
			searchPage.barraPesquisa(dado.get("produto"));
			searchPage.barraPesquisa(Keys.ENTER);
		}
	}

	@Quando("^clico no produto$")
	public void clico_no_produto(DataTable dados) throws Throwable {
		for (Map<String, String> dado : dados.asMaps(String.class, String.class)) {
			try {
				searchPage.clicarMassaDados(dado.get("produto"));
			}catch(Exception e) {
				break;
			}
		}
	}

	@Entao("^estarei na tela do produto \"([^\"]*)\"$")
	public void estarei_na_tela_do_produto(String produto) throws Throwable {
	   assertEquals("https://www.advantageonlineshopping.com/#/product/29?viewAll=HP%20USB%203%20Button%20Optical%20Mouse", driver.getCurrentUrl());
	   assertTrue(driver.getPageSource().contains(produto));
	}

	@Entao("^o produto nao sera encontrado \"([^\"]*)\"$")
	public void o_produto_nao_sera_encontrado(String produto) throws Throwable {
		String produtoNaoEncontrado = "No results for \"" + produto + "\"";
		assertTrue(driver.getPageSource().contains(produtoNaoEncontrado));
	}
}
