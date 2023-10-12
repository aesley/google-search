package page_objects;

import base_class.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PesquisaGooglePage extends BasePage {
    private String url = "https:/www.google.com.br";
    private By cliqueGoogleImagens = By.cssSelector("#gb > div > div:nth-child(1) > div > div:nth-child(2) > a");
    private By inputPesquisa = By.id("APjFqb");
    private By optionsPesquisar = By.cssSelector("ul[role='listbox'] > li:nth-child(1)");
    private By btnpesquisar = By.xpath("(//input[@name='btnK'])[2]");
    private By btnPesquisarGoogleImagens = By.cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.RNNXgb > button");
    private By txtResultadosPesquisa = By.id("result-stats");

    public PesquisaGooglePage(WebDriver navegador) {
        super(navegador);
    }

    public void abrirPagina() {
        driver.get(url);
    }

    public void preencherPesquisa(String texto) {
        waitElementVisible(inputPesquisa, 5);
        driver.findElement(inputPesquisa).sendKeys(texto);
        waitElementVisible(optionsPesquisar, 5);
        actions.sendKeys(Keys.ESCAPE).perform();
    }

    public void clicarBtnPesquisar() {
        waitElementVisible(btnpesquisar, 5);
        driver.findElement(btnpesquisar).click();
    }

    public void abrirPaginaGoogleImagens(){
        waitElementVisible(cliqueGoogleImagens, 5);
        driver.findElement(cliqueGoogleImagens).click();
    }

    public void clicarBtnGoogleImagens(){
        waitElementVisible(btnPesquisarGoogleImagens, 5);
        driver.findElement(btnPesquisarGoogleImagens).click();
    }
}
