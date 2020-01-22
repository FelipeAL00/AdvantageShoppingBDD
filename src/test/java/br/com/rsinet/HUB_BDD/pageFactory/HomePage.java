package br.com.rsinet.HUB_BDD.pageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.HUB_BDD.util.DriverFactory;


public class HomePage {

	private WebDriverWait wait = new WebDriverWait(DriverFactory.getdriver(), 10);
	private JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getdriver();

	@FindBy(how = How.ID, using = "menuUser")
	private static WebElement btnLogar;

	@FindBy(how = How.XPATH, using = "//*[@id=\"menuUserLink\"]/span")
	private static WebElement UserLog;

	@FindBy(how = How.ID, using = "speakersImg")
	private static WebElement componentSpeakers;

	@FindBy(how = How.XPATH, using = "/html/body/login-modal/div/div/div[3]/a[2]")
	private static WebElement btnCriarConta;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[3]/footer/div/h3")
	private WebElement followUS;

	public void clickBtnLogar() {
		wait.until(ExpectedConditions.visibilityOf(btnLogar));
		btnLogar.click();
	}

	public void clickCriarConta() {
		wait.until(ExpectedConditions.visibilityOf(btnCriarConta));
		js.executeScript("arguments[0].click()", btnCriarConta);
	}

	public void clicarComponentSpeakers() {
		wait.until(ExpectedConditions.visibilityOf(componentSpeakers));	
		js.executeScript("arguments[0].click()", componentSpeakers);
	}

	public String getUserLog() {
		wait.until(ExpectedConditions.urlToBe("https://www.advantageonlineshopping.com/#/"));
		if (UserLog.isEnabled()) {
			wait.until(ExpectedConditions.visibilityOf(UserLog));
			return UserLog.getText();
		}
		return "Não está ativo";
	}

	public WebElement getBtnLogar() {
		return btnLogar;
	}


	public WebElement getComponentSpeakers() {
		return componentSpeakers;
	}

	public WebElement getBtnCriarConta() {
		return btnCriarConta;
	}

}
