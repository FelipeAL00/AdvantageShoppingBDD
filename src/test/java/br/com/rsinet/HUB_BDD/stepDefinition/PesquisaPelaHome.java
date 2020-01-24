package br.com.rsinet.HUB_BDD.stepDefinition;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import br.com.rsinet.HUB_BDD.pageFactory.HomePage;
import br.com.rsinet.HUB_BDD.picoContainer.ContextoTeste;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class PesquisaPelaHome {
	private WebDriver driver;
	private HomePage homePage;
	private ContextoTeste testeContexto;

	public PesquisaPelaHome(ContextoTeste contexto) {
		testeContexto = contexto;
		homePage = testeContexto.getPageObjectManager().getHomePage();
		driver = testeContexto.getWebDriverManager().getDriver();
	}

	@Quando("^clico em speakers$")
	public void clicoEmSpeakers() throws Throwable {
		homePage.clicarComponentSpeakers();
	}

	@Entao("^nao encontrarei produto$")
	public void naoEncontrareiProduto() throws Throwable {
		assertEquals("https://www.advantageonlineshopping.com/#/category/Speakers/4", driver.getCurrentUrl());
	}
}
